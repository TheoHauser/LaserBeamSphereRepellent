/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Ring;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Sphere;

/**
 *
 * @author Theo
 */
public class Fly extends Node{
    Sphere sphere;
    Material m;
    Geometry fly;
    Ring r;
    Vector3f pos;
    
    public Fly(SimpleApplication sa){
        sphere = new Sphere(40,40,0.05f);
        m = new Material(sa.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        m.setColor("Color", ColorRGBA.randomColor());
        
        while(fly==null){
            fly = new Geometry("fly", sphere);
            fly.setMaterial(m);
            this.attachChild(fly);
        
            int i = (int)FastMath.pow(-1,FastMath.nextRandomInt(1,2));
            int j = (int)FastMath.pow(-1,FastMath.nextRandomInt(1,2));
            int k = (int)FastMath.pow(-1,FastMath.nextRandomInt(1,2));
            Vector3f p = new Vector3f(i*FastMath.nextRandomFloat(),j*FastMath.nextRandomFloat(), k*FastMath.nextRandomFloat()) ;
            pos = p.mult(3);
            float dist = pos.distance(new Vector3f(0,0,0));
            if(dist<2||dist>3)
                fly = null;
        }
        this.setLocalTranslation(pos);
    }
    
}
