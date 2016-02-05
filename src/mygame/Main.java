package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.util.SkyFactory;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {
    Spatial sky;
    repelSphere rs;
    Fly[] flies;
    Vector3f pos, np;
    boolean isFiring = false;

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        initLight();
        initSky();
        initSphere();
        initCam();
        init20Flys();

        //rootNode.attachChild(geom);
    }
    public void initLight(){
        DirectionalLight dl = new DirectionalLight();
        dl.setDirection(new Vector3f(-0.1f, -1f, -1).normalizeLocal());
        rootNode.addLight(dl);
    }
    public void initSky(){
        sky = SkyFactory.createSky(assetManager, "Textures/SKY.JPG", true);
        getRootNode().attachChild(sky);
    }
    public void initSphere(){
        rs = new repelSphere(this);
        rootNode.attachChild(rs);
    }
    public void initCam(){
        flyCam.setEnabled(false);
    }
    public void init20Flys(){
        flies = new Fly[20];
        for(int i = 0;i<20;i++){
            flies[i] = new Fly(this);
            rootNode.attachChild(flies[i]);
        }
    }

    @Override
    public void simpleUpdate(float tpf) {
        
        for(int i = 0; i<20; i++){
            walk(i, tpf);
            if(np.distance(new Vector3f(0,0,0))<2)
                fireLasers();
            
        }
        sky.rotate(tpf, 0, 0);
    }
    
    public void walk(int i, float tpf){
        int l,m,n;
        pos = flies[i].getLocalTranslation();
        l = (int)FastMath.pow(-1,FastMath.nextRandomInt(1, 2));
        m = (int)FastMath.pow(-1,FastMath.nextRandomInt(1, 2));
        n = (int)FastMath.pow(-1,FastMath.nextRandomInt(1, 2));
        np = new Vector3f(pos.x+(l*FastMath.nextRandomFloat())*tpf*4,
                pos.y+(m*FastMath.nextRandomFloat())*tpf*4, 
                pos.z+(n*FastMath.nextRandomFloat())*tpf*4);
        flies[i].setLocalTranslation(np);
    }
    public void fireLasers(){
        
        
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
