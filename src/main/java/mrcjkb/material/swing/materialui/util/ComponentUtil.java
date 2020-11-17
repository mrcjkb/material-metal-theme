package mrcjkb.material.swing.materialui.util;

import java.awt.*;

public class ComponentUtil {

    /**
     * @param c the component
     * @param p a point
     * @return {@code true} if the {@link Point} p is within the bounds of the {@link Component} c
     */
    public static boolean isPointWithinComponent(Component c, Point p) {
        if (null == c || !c.isVisible()) {
            return false;
        }
        try {
            Rectangle bounds = c.getBounds();
            bounds.setLocation(c.getLocationOnScreen());
            return bounds.contains(p);
        } catch (Throwable t) {
            return false;
        }
    }

}
