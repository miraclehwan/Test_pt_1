package com.example.daehwankim.test_pt_1.Scene;

import android.graphics.Color;
import android.view.Gravity;
import android.view.MotionEvent;

import org.gearvrf.GVRAndroidResource;
import org.gearvrf.GVRContext;
import org.gearvrf.GVRMeshCollider;
import org.gearvrf.GVRRenderData;
import org.gearvrf.GVRScene;
import org.gearvrf.GVRSceneObject;
import org.gearvrf.scene_objects.GVRTextViewSceneObject;

import java.io.IOException;

/**
 * Created by daehwan.kim on 2017-05-24.
 */

public class Scene_Join extends GVRScene{



    public Scene_Join(GVRContext gvrContext) throws IOException {
        super(gvrContext);
        GVRSceneObject headTracker = new GVRSceneObject(gvrContext, gvrContext.createQuad(0.1f, 0.1f), gvrContext.loadTexture(new GVRAndroidResource(gvrContext, "headtrackingpointer.png")));
        headTracker.getTransform().setPosition(0.0f, 0.0f, -1.0f);
        headTracker.getRenderData().setDepthTest(false);
        headTracker.getRenderData().setRenderingOrder(10000);
        getMainCameraRig().addChildObject(headTracker);

        GVRSceneObject title = makeTitle(gvrContext, "Join_Join", 4.0f, 2.0f, Color.RED, Color.YELLOW, 0.0f, 0.0f, -3.0f);
        addSceneObject(title);


    }

    private GVRTextViewSceneObject makeTitle(GVRContext context, String text, float objectsizeX, float objectsizeY , int backgroundColor, int TextColor, float positionX, float positionY, float positionZ){
        GVRTextViewSceneObject title = new GVRTextViewSceneObject(context, objectsizeX, objectsizeY, text);
        GVRRenderData renderdata = title.getRenderData();
        renderdata.setAlphaBlend(true);
        title.attachComponent(new GVRMeshCollider(context, true));
        title.getTransform().setPosition(positionX, positionY, positionZ);
        title.setTextColor(TextColor);
        title.setGravity(Gravity.CENTER);
        title.setBackgroundColor(backgroundColor);
        title.setName(text);
        return title;
    }



}
