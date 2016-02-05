/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.material.RenderState.BlendMode;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.queue.RenderQueue.Bucket;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Sphere;

/**
 *
 * @author Theo
 */
public class repelSphere extends Node{
    Sphere sphere; 
    Geometry rs;
    Material m;
    
    public repelSphere(SimpleApplication sa){
       sphere = new Sphere(50,50,2);
       rs = new Geometry("repelSphere", sphere);
       
        m = new Material(sa.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        m.setTexture("ColorMap", sa.getAssetManager().loadTexture("Textures/sphereTexture.png"));
        m.setColor("Color", ColorRGBA.Orange);
        m.getAdditionalRenderState().setBlendMode(BlendMode.Alpha);
        rs.setQueueBucket(Bucket.Transparent);
        rs.setMaterial(m);
        
//       m = new Material(sa.getAssetManager(), "Common/MatDefs/Light/Lighting.j3md");
//       m.setBoolean("UseMaterialColors", true);
//       m.setBoolean("UseAlpha", true);
//       m.setTexture("AlphaMap", sa.getAssetManager().loadTexture("Textures/sphereTexture.png"));
//       m.setFloat("AlphaDiscardThreshold", 0.7f);
//       m.setColor("Diffuse", ColorRGBA.Orange);
//       m.setColor("Ambient", ColorRGBA.White);
//       m.setTransparent(true);
       
       
       rs.setMaterial(m);
       this.attachChild(rs);
    }
    
    
    
}
