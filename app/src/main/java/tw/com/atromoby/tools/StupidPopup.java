package tw.com.atromoby.tools;

import android.app.Dialog;

import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import tw.com.atromoby.widgets.PopupFragment;


public class StupidPopup extends PopupFragment {



    @Override
    public void dialogCreated(Dialog dialog) {
        dialog.setContentView(R.layout.car_layout);

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);

        final TextView muh = dialog.findViewById(R.id.muh_dick);



        muh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                muh.setText("sheeddeed");
            }
        });
    }






}
