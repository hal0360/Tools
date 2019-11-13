package tw.com.atromoby.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;

import androidx.constraintlayout.widget.ConstraintLayout;

public class RonConstraintLayout extends ConstraintLayout{

    private GradientDrawable shape;

    public RonConstraintLayout(Context context) {super(context);}

    public RonConstraintLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.RonConstraintLayout);
        GradientDrawable.Orientation graDir;
        int direction = a.getInt(R.styleable.RonConstraintLayout_gradient_direction, 0);
        int firstColor = a.getColor(R.styleable.RonConstraintLayout_first_color, 0x00000000);
        int secColor = a.getColor(R.styleable.RonConstraintLayout_second_color, 0x00000000);

        if(direction == 0) {
            shape = new GradientDrawable();
            shape.setColor(firstColor);
        }else{
            if (direction == 1) graDir = GradientDrawable.Orientation.RIGHT_LEFT;
            else if(direction == 2) graDir = GradientDrawable.Orientation.LEFT_RIGHT;
            else if(direction == 3) graDir = GradientDrawable.Orientation.TOP_BOTTOM;
            else graDir = GradientDrawable.Orientation.BOTTOM_TOP;
            shape = new GradientDrawable(graDir, new int[] {firstColor,secColor});
        }
        shape.setStroke(a.getDimensionPixelSize(R.styleable.RonConstraintLayout_stroke_width, 0), a.getColor(R.styleable.RonConstraintLayout_stroke_color, 0x00000000));
        shape.setCornerRadius( a.getDimensionPixelSize(R.styleable.RonConstraintLayout_border_radius, 0) );

        a.recycle();
        setBackground(shape);
    }

    public void setStroke(float width, int color){
        shape.setStroke(RonConstraintLayout.dpToPixel(getContext(), width), color);
    }

    public void setColor(int color){
        shape.setColor(color);
    }

    public void setRadius(float dip){
        shape.setCornerRadius( RonConstraintLayout.dpToPixel(getContext(), dip));
    }


    public static int dpToPixel(Context context, float dp){
        return (int) dp * (context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

}
