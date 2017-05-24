package com.example.daehwankim.test_pt_1;

import android.util.Log;
import android.view.MotionEvent;

import com.example.daehwankim.test_pt_1.PickHandler.PickHandler_Join;
import com.example.daehwankim.test_pt_1.PickHandler.PickHandler_Login;
import com.example.daehwankim.test_pt_1.Scene.Scene_Join;
import com.example.daehwankim.test_pt_1.Scene.Scene_Login;

import org.gearvrf.GVRActivity;
import org.gearvrf.GVRContext;
import org.gearvrf.GVRMain;
import org.gearvrf.GVRPicker;
import org.gearvrf.GVRScene;
import org.gearvrf.scene_objects.GVRTextViewSceneObject;

import java.io.IOException;

/**
 * Created by daehwan.kim on 2017-05-24.
 */

public class Main extends GVRMain{

    private GVRActivity mGVRActivity;
    private GVRContext mGVRContext;
    private GVRPicker mPicker;

    public Main(GVRActivity gvrActivity){
        mGVRActivity = gvrActivity;
    }

    @Override
    public void onInit(GVRContext gvrContext) throws Throwable {
        mGVRContext = gvrContext;

        Scene_Login scene_login = new Scene_Login(mGVRContext);
        setMainscene(scene_login);

    }

    public void setMainscene(GVRScene newScene){
//        GVRScene oldScene = getGVRContext().getMainScene();
//        oldScene.getEventReceiver().removeListener(mPickHandler);
//        oldScene.getMainCameraRig().getHeadTransformObject().detachComponent(GVRPicker.getComponentType());
        PickHandler_Login mPickHandler = new PickHandler_Login(mGVRContext);
        newScene.getEventReceiver().addListener(mPickHandler);
        mPicker = new GVRPicker(mGVRContext, newScene);
        newScene.getMainCameraRig().getHeadTransformObject().attachComponent(mPicker);
        getGVRContext().setMainScene(newScene);
    }

    public void setJoinscene(GVRScene newScene){
//        GVRScene oldScene = getGVRContext().getMainScene();
//        oldScene.getEventReceiver().removeListener(mPickHandler);
//        oldScene.getMainCameraRig().getHeadTransformObject().detachComponent(GVRPicker.getComponentType());
        PickHandler_Join mPickHandler = new PickHandler_Join(mGVRContext);
        newScene.getEventReceiver().addListener(mPickHandler);
        mPicker = new GVRPicker(mGVRContext, newScene);
        newScene.getMainCameraRig().getHeadTransformObject().attachComponent(mPicker);
        getGVRContext().setMainScene(newScene);
    }


    public void onTouchEvent(MotionEvent event){
        switch (event.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_UP:
                Log.e("Scene status : ", mGVRContext.getMainScene().getClass().toString());
                if (mGVRContext.getMainScene().getClass().equals(Scene_Login.class)){
                    if (PickHandler_Login.PickedObject !=null && PickHandler_Login.PickedObject.getName().equals("Join")){
                        try {
                            PickHandler_Login.PickedObject = null;
                            Scene_Join scene_join = new Scene_Join(mGVRContext);
                            setJoinscene(scene_join);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    Log.e("Scene Login : ", "Login True");
                }else if (mGVRContext.getMainScene().getClass().equals(Scene_Join.class)){
                    Log.e("Scene Join : ", "Join True");
                    if (PickHandler_Join.PickedObject !=null && PickHandler_Join.PickedObject.getName().equals("Join_Join")){
                        try {
                            PickHandler_Join.PickedObject = null;
                            Scene_Login scene_login = new Scene_Login(mGVRContext);
                            setMainscene(scene_login);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            default:
                break;
        }
    }


}
