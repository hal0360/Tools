package tw.com.atromoby.tools;

import android.app.Dialog;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tw.com.atromoby.widgets.PopupFragment;
import tw.com.atromoby.widgets.RootActivity;


public class StupidPopup extends PopupFragment {


    @Override
    public void dialogCreated(Dialog dialog) {
        dialog.setContentView(R.layout.car_layout);

        final TextView muh = dialog.findViewById(R.id.muh_dick);
setGravity(Gravity.TOP | Gravity.START);
setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);

        final RootActivity activity = (RootActivity) getContext();
        assert activity != null;

        muh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activity.toActivity(MainActivity.class);
            }
        });
    }






}
