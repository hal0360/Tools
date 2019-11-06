package tw.com.atromoby.widgets;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public abstract class PopupFragment extends DialogFragment {


    private String strId;
    private boolean isAssociated = false;
    private RootActivity rootActivity;

    public PopupFragment(){
        strId = getClass().getSimpleName();
    }

    public void initiate(RootActivity activity) {
        rootActivity = activity;
    }

    public RootActivity getRoot() {
        return rootActivity;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
         //dialog = super.onCreateDialog(savedInstanceState);
        assert getContext() != null;
        FragDialog dialog = new FragDialog(getContext(), R.style.BottomOptionsDialogTheme);

        //setStyle(DialogFragment.STYLE_NO_TITLE, R.style.BottomOptionsDialogTheme);
         dialogCreated(dialog);
        return dialog;
    }

    public abstract void dialogCreated(FragDialog dialog);

    public void dismiss() {
        if (isAssociated) {
            super.dismiss();
            isAssociated = false;
        }
    }

    public void show() {
        isAssociated = true;
        FragmentTransaction transaction = rootActivity.getSupportFragmentManager().beginTransaction();
        Fragment prev = rootActivity.getSupportFragmentManager().findFragmentByTag(strId);
        if (prev != null) transaction.remove(prev);
        transaction.addToBackStack(null);
        super.show(transaction, strId);
    }

}