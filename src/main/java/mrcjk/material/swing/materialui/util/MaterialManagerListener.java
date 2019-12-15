package mrcjk.material.swing.materialui.util;

import javax.swing.*;
import java.awt.event.MouseListener;

public class MaterialManagerListener {

    /*
     * Look this if you would change this function
     * https://bugs.java.com/bugdatabase/view_bug.do?bug_id=4380536
     */
    public static void removeAllMaterialMouseListener(JComponent component){
        if(component == null){
            throw new IllegalArgumentException("Argument is null");
        }
        for(MouseListener mouseListener : component.getListeners(MouseListener.class)){
            if (mouseListener instanceof MaterialUITimer){
                component.removeMouseListener(mouseListener);
            }
        }
    }
}