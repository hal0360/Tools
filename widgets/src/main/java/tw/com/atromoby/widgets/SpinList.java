package tw.com.atromoby.widgets;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatSpinner;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SpinList extends AppCompatSpinner {

    private Context context;
    private ArrayAdapter<String> dataAdapter = null;
    private CmdInt cmdInt;

    public SpinList(Context context) {
        super(context);
        this.context = context;
    }

    public SpinList(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public void selected(CmdInt cmdInt) {
        this.cmdInt = cmdInt;
    }

    public void init(String[] strings){
        dataAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, strings);
        initAdapter();
    }

    public void init(List<String> strings, int rid){
        dataAdapter = new ArrayAdapter<>(context, rid, strings);
        initAdapter();
    }

    public void init(List<String> strings){
        dataAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, strings);
        initAdapter();
    }

    public void init(String[] strings, int rid){
        dataAdapter = new ArrayAdapter<>(context, rid, strings);
        initAdapter();
    }

    private void initAdapter(){
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        setAdapter(dataAdapter);

        setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(cmdInt != null) {
                    cmdInt.exec(i);
                }
                ((TextView) getSelectedView()).setTextColor(Color.parseColor("#FFFFFF"));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }
}
