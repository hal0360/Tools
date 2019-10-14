package tw.com.atromoby.widgets;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

public abstract class PopupFragment extends DialogFragment {


    private String strId;
    private FragmentTransaction transaction;
    private RootActivity activity;

    public PopupFragment(){
        strId = getClass().getSimpleName();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void show(RootActivity activity) {
        if(this.activity == null) this.activity = activity;
        if(transaction == null){
            transaction = activity.getSupportFragmentManager().beginTransaction();
            Fragment prev = activity.getSupportFragmentManager().findFragmentByTag(strId);
            if (prev != null) transaction.remove(prev);
            transaction.addToBackStack(null);
        }
        super.show(transaction, strId);
    }

}