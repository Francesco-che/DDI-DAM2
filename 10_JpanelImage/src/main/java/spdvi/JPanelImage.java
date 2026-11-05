/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi;

import java.io.File;
import java.io.Serializable;
import javax.swing.JPanel;

/**
 *
 * @author frand
 */
public class JPanelImage extends JPanel implements Serializable{
    
    private File imgRoute;
    
    public JPanelImage(){
        
    }

    public File getImgRoute() {
        return imgRoute;
    }

    public void setImgRoute(File imgRoute) {
        this.imgRoute = imgRoute;
    }

    
    
}
