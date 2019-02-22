package tw.com.atromoby.utils;

public class Response {

    public String content;
    public int statusCode;

    public Response(String content, int code){
        this.content = content;
        statusCode = code;
    }
}

