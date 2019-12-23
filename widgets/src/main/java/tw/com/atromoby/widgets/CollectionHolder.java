package tw.com.atromoby.widgets;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.widget.Checkable;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

public class CollectionHolder extends RecyclerView.ViewHolder {

    CollectionHolder(View itemView) {
        super(itemView);
    }

    public final Context getContex() {
        return itemView.getContext();
    }

    public void alert(String mess) {

        Toast.makeText(itemView.getContext(), mess, Toast.LENGTH_LONG).show();
    }

    public final void clicked(int id, final CmdView cd) {
        findViewById(id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cd.exec(v);
            }
        });
    }

    public final boolean isPortrait() {
        int orientation = itemView.getContext().getResources().getConfiguration().orientation;
        return orientation != Configuration.ORIENTATION_LANDSCAPE;
    }


    public final <T extends View & Checkable> T findViewById(int rid) {
        return itemView.findViewById(rid);
    }

    public final void clicked(View v, final CmdView cd) {
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cd.exec(v);
            }
        });
    }
}
