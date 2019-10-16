package tw.com.atromoby.widgets;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;

public abstract class PopupFragment extends DialogFragment {


    private String strId;
    private Dialog dialog;

    public PopupFragment(){
        strId = getClass().getSimpleName();
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
         //dialog = super.onCreateDialog(savedInstanceState);

        dialog = new Dialog(getContext(), R.style.BottomOptionsDialogTheme);

        //setStyle(DialogFragment.STYLE_NO_TITLE, R.style.BottomOptionsDialogTheme);
         dialogCreated(dialog);
        return dialog;
    }

    public abstract void dialogCreated(Dialog dialog);

    public void setGravity(int gravity){
        assert dialog.getWindow() != null;
        dialog.getWindow().setGravity(gravity);
    }

    public void setLayout(int width, int height){
        assert dialog.getWindow() != null;
        dialog.getWindow().setLayout(width, height);
    }

    public void clicked(int id, final CmdView cd){
        dialog.findViewById(id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cd.exec(v);
            }
        });
    }

    public void clicked(View v, final CmdView cd){
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cd.exec(v);
            }
        });
    }

    public void show(RootActivity activity) {

        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        Fragment prev = activity.getSupportFragmentManager().findFragmentByTag(strId);
        if (prev != null) transaction.remove(prev);
        transaction.addToBackStack(null);
        super.show(transaction, strId);


    }

}