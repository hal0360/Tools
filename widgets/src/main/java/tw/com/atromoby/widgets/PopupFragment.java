package tw.com.atromoby.widgets;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public abstract class PopupFragment extends DialogFragment {

    private String strId;

    public PopupFragment(){
        strId = getClass().getSimpleName();
    }


    String getClassID() {
        return strId;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        assert getContext() != null;
        FragDialog dialog = new FragDialog(getContext(), R.style.BottomOptionsDialogTheme);

         dialogCreated(dialog);
        return dialog;
    }

    public abstract void dialogCreated(FragDialog dialog);

    public void dismiss() {
        if (getContext() != null) {
            super.dismiss();
        }
    }

}