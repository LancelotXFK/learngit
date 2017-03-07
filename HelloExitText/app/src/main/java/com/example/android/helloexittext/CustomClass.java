package com.example.android.helloexittext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2017/3/6.
 */

public class CustomClass extends View {

    public CustomClass(Context context) {
        super(context);
    }

    public CustomClass(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomClass(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


  int mN=3;
    //@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomClass(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private static final String TAG = "CustomClass";
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setAntiAlias(true);
        Log.i(TAG, "onDraw: ");
        drawStar(canvas,paint,Color.RED,getHeight()/2,mN,false);
        canvas.translate(getHeight()/12,0);

        canvas.translate(0,getHeight()/12);




    }
    private void drawStar(Canvas canvas, Paint paint, @ColorInt int color, float radius, int count, boolean isStar){
        canvas.translate(radius,radius);
        if ((!isStar) && count < 3){
            canvas.translate(-radius,-radius);
            return;
        }
        if (isStar && count < 5){
            canvas.translate(-radius,-radius);
            return;
        }
        canvas.rotate(-90);
        if (paint == null){
            paint = new Paint();
        }else{
            paint.reset();
        }
        Path path = new Path();
        float inerRadius = count%2==0?
                (radius*(cos(360/count/2)-sin(360/count/2)*sin(90-360/count)/cos(90-360/count)))
                :(radius*sin(360/count/4)/sin(180-360/count/2-360/count/4));
        for (int i=0;i<count;i++){
            if (i==0){
                path.moveTo(radius*cos(360/count*i),radius*sin(360/count*i));
            }else{
                path.lineTo(radius*cos(360/count*i),radius*sin(360/count*i));
            }
            if (isStar){
                path.lineTo(inerRadius*cos(360/count*i+360/count/2),inerRadius*sin(360/count*i+360/count/2));
            }
        }
        path.close();
        paint.setColor(color);
        canvas.drawPath(path,paint);
        canvas.rotate(90);
        canvas.translate(-radius,-radius);
    }

    /**
     * Math.sin的参数为弧度，使用起来不方便，重新封装一个根据角度求sin的方法
     * @param num 角度
     * @return
     */
    float sin(int num){
        return (float) Math.sin(num*Math.PI/180);
    }

    /**
     * 与sin同理
     */
    float cos(int num){
        return (float) Math.cos(num*Math.PI/180);
    }

    public void setMap(int n){
     mN=n;
        invalidate();


    }



}
