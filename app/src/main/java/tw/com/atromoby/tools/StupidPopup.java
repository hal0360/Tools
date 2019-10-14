package tw.com.atromoby.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import tw.com.atromoby.widgets.PopupFragment;

public class StupidPopup extends PopupFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.car_layout, container, false);
        final TextView muh = view.findViewById(R.id.muh_dick);
        muh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                muh.setText("sheBonn");
            }
        });
        return view;
    }

    @Override
    public void onStart()
    {
        super.onStart();

        getDialog().getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.MATCH_PARENT);
        // ... other stuff you want to do in your onStart() method
    }


    @Override
    public void onPause() {
        dismiss();
        super.onPause();
    }
}
