package tw.com.atromoby.utils;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class RequestTask extends AsyncTask<String,String,Response>
{
    private String url;
    private CmdRes cmdResSuc, cmdResErr, cmdResFail;
    private List<String[]> headers;
    private boolean canceled = false;
    private int timeOut = 6000;
    private String content;

    public RequestTask(String url) {
        this.url = url;
        headers = new ArrayList<>();
    }

    public void onSuccess(CmdRes cmd){
        cmdResSuc = cmd;
    }

    public void onError(CmdRes cmd){
        cmdResErr = cmd;
    }

    public void onFail(CmdRes cmd){
        cmdResFail = cmd;
    }

    public void send(String data){
        content = data;
        execute();
    }

    public void fetch(){
        execute();
    }

    public void setHeader(String key, String value){
        headers.add(new String[]{key,value});
    }

    public void cancel(){
        canceled = true;
        cmdResErr = null;
        cmdResFail = null;
        cmdResSuc = null;
    }

    public void setTimeOut(int milSec){
        timeOut = milSec;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Response doInBackground(String... params) {
        return myHttpConnection(url);
    }

    @Override
    protected void onPostExecute(Response response) {
        if(canceled) {
            return;
        }
        if(response.statusCode >= 200 && response.statusCode < 300){
            if(cmdResSuc != null) cmdResSuc.exec(response);
        }else if(response.statusCode >= 400 && response.statusCode < 500){
            if(cmdResErr != null) cmdResErr.exec(response);
        }else {
            if(cmdResFail != null) cmdResFail.exec(response);
        }
    }

    private Response myHttpConnection(String url){
        HttpURLConnection urlConnection = null;
        String result = "N/A";
        int statusCode = 900;
        try {
            urlConnection = (HttpURLConnection) ((new URL(url).openConnection()));
            if(content != null){
                urlConnection.setDoOutput(true);
                urlConnection.setRequestMethod("POST");
            }
            else {
                urlConnection.setDoOutput(false);
                urlConnection.setRequestMethod("GET");
            }

            for(String[] header: headers){
                urlConnection.setRequestProperty(header[0], header[1]);
            }

            urlConnection.setConnectTimeout(timeOut);
            urlConnection.connect();
            if(content != null){
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8"));
                writer.write(content);
                writer.close();
            }

            try {
                statusCode = urlConnection.getResponseCode();
            } catch (IOException e) {
                statusCode = urlConnection.getResponseCode();
            }

            if (statusCode < 400 ) {
                InputStream is = urlConnection.getInputStream();
                if(is != null){
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    String line;
                    StringBuilder sb = new StringBuilder();
                    while ((line = bufferedReader.readLine()) != null) {
                        sb.append(line);
                    }
                    bufferedReader.close();
                    result = sb.toString();
                }
            }
        } catch (Exception e) {
            result = e.toString();

        }
        finally {
            if (urlConnection != null) urlConnection.disconnect();
        }
        return new Response(result, statusCode);
    }
}
