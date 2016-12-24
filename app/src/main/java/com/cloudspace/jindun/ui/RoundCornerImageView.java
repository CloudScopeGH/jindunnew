package com.cloudspace.jindun.ui;

/**
 * User: Cloud(32325596@qq.com)
 * Date: 2016-08-11
 * Time: 10:17
 * project: BudCargo
 * Describe
 */
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundCornerImageView extends ImageView {
    public RoundCornerImageView(Context context) {
        super(context);
    }
    public RoundCornerImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public RoundCornerImageView(Context context, AttributeSet attrs,
                                int defStyle) {
        super(context, attrs, defStyle);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        Path clipPath = new Path();
        int w = this.getWidth();
        int h = this.getHeight();
        clipPath.addRoundRect(new RectF(0, 0, w, h), 30.0f, 30.0f, Path.Direction.CW);
        canvas.clipPath(clipPath);
        super.onDraw(canvas);
    }
}
