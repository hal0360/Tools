package tw.com.atromoby.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;

public class RonConstraintLayout extends ConstraintLayout{

    private GradientDrawable shape;

    public RonConstraintLayout(Context context) {super(context);}

    public RonConstraintLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        shape =  new GradientDrawable();
        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.RonConstraintLayout);

        shape.setColor(a.getColor(R.styleable.RonConstraintLayout_fill_color, 0x00000000));
        shape.setStroke(a.getDimensionPixelSize(R.styleable.RonConstraintLayout_stroke_width, 0), a.getColor(R.styleable.RonConstraintLayout_stroke_color, 0x00000000));
        shape.setCornerRadius( a.getDimensionPixelSize(R.styleable.RonConstraintLayout_border_radius, 0) );

        a.recycle();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(shape);
        }

    }

    public void setStroke(int width, int color){
        shape.setStroke(width, color);
    }

    public void setColor(int color){
        shape.setColor(color);
    }

    public void setRadius(int pixel){
        shape.setCornerRadius( pixel);
    }

}
