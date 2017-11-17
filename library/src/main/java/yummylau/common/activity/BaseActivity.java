package yummylau.common.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * baseActivity
 * Created by g8931 on 2017/11/17.
 */

public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(supportHandlerStatusbar()){

        }
    }


    protected boolean supportHandlerStatusbar() {
        return false;
    }

    @ColorInt
    public int getStatusbarColor() {
        return Color.TRANSPARENT;
    }

}
