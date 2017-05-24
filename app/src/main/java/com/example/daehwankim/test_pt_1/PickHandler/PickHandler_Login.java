package com.example.daehwankim.test_pt_1.PickHandler;

import android.graphics.Color;
import android.util.Log;

import com.example.daehwankim.test_pt_1.Scene.Scene_Join;

import org.gearvrf.GVRContext;
import org.gearvrf.GVRPicker;
import org.gearvrf.GVRRenderData;
import org.gearvrf.GVRScene;
import org.gearvrf.GVRSceneObject;
import org.gearvrf.IPickEvents;
import org.gearvrf.scene_objects.GVRTextViewSceneObject;

import java.io.IOException;

/**
 * Created by daehwan.kim on 2017-05-24.
 */

public class PickHandler_Login implements IPickEvents {

    public static GVRSceneObject PickedObject = null;

    GVRContext mGVRContext;
    GVRPicker mPicker;
    public PickHandler_Login(GVRContext gvrContext){
        mGVRContext = gvrContext;
    }

    @Override
    public void onPick(GVRPicker picker) {

    }

    @Override
    public void onNoPick(GVRPicker picker) {

    }

    @Override
    public void onEnter(GVRSceneObject sceneObj, GVRPicker.GVRPickedObject collision) {
        PickedObject = sceneObj;
//        sceneObj.getRenderData().setRenderMask(0);
        Log.e("Login_PickHandler", "ture");
        ((GVRTextViewSceneObject) PickedObject).setBackgroundColor(Color.BLUE);

    }

    @Override
    public void onExit(GVRSceneObject sceneObj) {
        ((GVRTextViewSceneObject) PickedObject).setBackgroundColor(Color.RED);

        PickedObject = null;
//        sceneObj.getRenderData().setRenderMask(GVRRenderData.GVRRenderMaskBit.Left | GVRRenderData.GVRRenderMaskBit.Right);
    }

    @Override
    public void onInside(GVRSceneObject sceneObj, GVRPicker.GVRPickedObject collision) {

    }

}
