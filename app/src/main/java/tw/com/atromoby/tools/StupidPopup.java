package tw.com.atromoby.tools;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tw.com.atromoby.widgets.FragDialog;
import tw.com.atromoby.widgets.PopupFragment;
import tw.com.atromoby.widgets.RootActivity;


public class StupidPopup extends PopupFragment {


    @Override
    public void dialogCreated(FragDialog dialog) {
        dialog.setContentView(R.layout.car_layout);

        final TextView muh = dialog.findViewById(R.id.muh_dick);
        dialog.setGravity(Gravity.TOP | Gravity.START);
        dialog.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);

        final RootActivity activity = (RootActivity) getActivity();


        muh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activity.toActivity(MainActivity.class);
            }
        });
    }

    @Override
    public void dialogClosed(FragDialog dialog) {
        dialog.getRootActivity().alert("dick");
    }


}
