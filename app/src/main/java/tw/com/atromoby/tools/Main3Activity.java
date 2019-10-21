package tw.com.atromoby.tools;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


//public class Main3Activity extends AppCompatActivity implements CurlView.PageProvider{
public class Main3Activity extends AppCompatActivity {

   // private CurlView mCurlView;
    private ConstraintLayout curryCon;

    private int[] mBitmapIds = { R.drawable.card_back, R.drawable.card_front};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        /*
        int index = 0;
        if (getLastNonConfigurationInstance() != null) {
            index = (Integer) getLastNonConfigurationInstance();
        }
        mCurlView =  findViewById(R.id.curry);
        mCurlView.setPageProvider(this);
        mCurlView.setCurrentIndex(index);
        */


        curryCon = findViewById(R.id.curry_tainer);

       // mCurlView.setBackgroundColor(Color.TRANSPARENT);
        // This is something somewhat experimental. Before uncommenting next
        // line, please see method comments in CurlView.
        // mCurlView.setEnableTouchPressure(true);
    }

    @Override
    public void onPause() {
        super.onPause();
      //  mCurlView.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
      // mCurlView.onResume();
    }

    public void resetCur(View view){
        int index = 0;
        if (getLastNonConfigurationInstance() != null) {
            index = (Integer) getLastNonConfigurationInstance();
        }
        curryCon.setBackgroundResource(0);
      //  mCurlView.setPageProvider(this);
       // mCurlView.setCurrentIndex(index);
    }

    public void flipped(){
        curryCon.setBackgroundResource(R.drawable.card_front);
        Toast.makeText(this,"flipped",Toast.LENGTH_SHORT).show();
    }

    public void notFlipped(){
        Toast.makeText(this,"not flipped",Toast.LENGTH_SHORT).show();
    }

    public int getPageCount() {
        return 1;
    }

    /*
    private Bitmap loadBitmap(int width, int height, int index) {

        Log.e("bitDim","bitWidth: " + width + " viewWidth: " + mCurlView.getWidth() + " bitHeight: " + height + " viewHeght: " + mCurlView.getHeight());

        Bitmap b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        b.eraseColor(Color.TRANSPARENT);
        Canvas c = new Canvas(b);
        Drawable d = getResources().getDrawable(mBitmapIds[index]);

        d.setBounds(0, 0, c.getWidth(), c.getHeight());
        d.draw(c);

        return b;
    }

    public void updatePage(CurlPage page, int width, int height, int index) {

        switch (index) {
            // First case is image on front side, solid colored back.
            case 0: {
                Bitmap front = loadBitmap(width, height, 0);
                Bitmap back = loadBitmap(width, height, 1);
                page.setTexture(front, CurlPage.SIDE_FRONT);
                page.setTexture(back, CurlPage.SIDE_BACK);
               // page.setColor(Color.argb(255, 255, 255, 255), CurlPage.SIDE_FRONT);
                break;
            }
            // Second case is image on back side, solid colored front.

        }
    }*/
}