package tw.com.atromoby.widgets;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatEditText;


public class CustomInput extends AppCompatEditText {

    public CustomInput(Context context)
    {
        super(context);
    }

    public CustomInput(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public CustomInput(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void error(String s){
        requestFocus();
        setError(s);
    }

    public String getRawText(){
        Editable editable = getText();
        if(editable != null) return getText().toString().trim();
        return null;
    }
}
