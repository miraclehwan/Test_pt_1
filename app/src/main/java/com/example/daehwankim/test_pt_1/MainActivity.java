package com.example.daehwankim.test_pt_1;

import android.os.Bundle;
import android.view.MotionEvent;

import org.gearvrf.GVRActivity;


public class MainActivity extends GVRActivity {

    Main main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main = new Main(this);
        setMain(main);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        main.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

}
