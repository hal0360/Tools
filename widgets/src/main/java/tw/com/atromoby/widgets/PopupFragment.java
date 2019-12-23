package tw.com.atromoby.widgets;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public abstract class PopupFragment extends DialogFragment {

    private String strId;

    public PopupFragment(){
        strId = getClass().getSimpleName();
    }


    String getClassID() {
        return strId;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        assert getContext() != null;
        FragDialog dialog = new FragDialog(getContext(), R.style.BottomOptionsDialogTheme);

         dialogCreated(dialog);
        return dialog;
    }


    public abstract void dialogCreated(FragDialog dialog);

    public abstract void dialogClosed(FragDialog dialog);

    public void dismiss() {
        if (getContext() != null) {
            super.dismiss();
        }
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);

        FragDialog dialogF = (FragDialog) getDialog();
        dialogClosed(dialogF);
    }

}