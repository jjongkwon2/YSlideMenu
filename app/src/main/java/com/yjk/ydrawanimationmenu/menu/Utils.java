package com.yjk.ydrawanimationmenu.menu;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.media.Image;
import android.view.Display;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.yjk.ydrawanimationmenu.R;

/**
 * Created by yjk on 2017. 7. 26..
 */

public class Utils {
    Data data;

    public Utils(){
        data = new Data();
    }

    /*
        화면 세로 크기 구하는 메소드
        네비게이션 메뉴의 세로 크기 지정을 위해 사용
     */
    public int getDisplayHeight(Dialog activity){
        Display display = activity.getWindow().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        return size.y;
    }

    /*
        get a bitmap from resource
     */
    public Bitmap getBitmap(Context context, int res){
        return BitmapFactory.decodeResource(context.getResources(), res);
    }

    /*
        original 비트맵을 가로, 세로의 크기로 리사이즈
     */
    public Bitmap resizeBitmap(Bitmap origin, int w, int h){
        Bitmap result = null;

        result = Bitmap.createScaledBitmap(origin, w, h, false);
        if(result != origin){
            origin.recycle();
        }
        return result;
    }

    /*
        이미지로 버튼 생성
     */
    public ImageButton createButton(Context context, int drawable){
        ImageButton button = new ImageButton(context);

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(data.menuButtonWidth, data.menuButtonHeight);

        button.setLayoutParams(params);
        button.setBackgroundColor(Color.parseColor(data.menuBackground));

        //이미지 크기 조절 후 삽입
        int w = data.menuIconWidth;
        int h = data.menuIconHeight;
        Bitmap bitmap = resizeBitmap(getBitmap(context, drawable), w, h);
        button.setImageBitmap(bitmap);

        return button;
    }
}