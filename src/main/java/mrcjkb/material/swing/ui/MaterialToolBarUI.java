package mrcjkb.material.swing.ui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicToolBarUI;
import java.awt.*;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Marc Jakobi
 */
public class MaterialToolBarUI extends BasicToolBarUI {

    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(JComponent c) {
        return new MaterialToolBarUI();
    }

    public void installUI(JComponent c) {
        super.installUI(c);
        c.setOpaque(false);
    }

    @Override
    protected ContainerListener createToolBarContListener() {
        return new ToolBarContListener() {

            private final Map<Component, Boolean> focusableCache = new HashMap<>();

            @Override
            public void componentAdded(ContainerEvent e) {
                super.componentAdded(e);
                Component c = e.getChild();
                if (c instanceof AbstractButton) {
                    focusableCache.put(c, c.isFocusable());
                    c.setFocusable(false);
                }
            }

            @Override
            public void componentRemoved(ContainerEvent e) {
                super.componentRemoved( e );
                Component c = e.getChild();
                if (c instanceof AbstractButton) {
                    c.setFocusable(focusableCache.get(c));
                }
            }
        };
    }

    @Override
    protected void setBorderToRollover( Component c ) {
    }

    @Override
    protected void setBorderToNonRollover( Component c ) {
    }

    @Override
    protected void setBorderToNormal( Component c ) {
    }

    @Override
    protected void installRolloverBorders( JComponent c ) {
    }

    @Override
    protected void installNonRolloverBorders( JComponent c ) {
    }

    @Override
    protected void installNormalBorders( JComponent c ) {
    }

    @Override
    protected Border createRolloverBorder() {
        return BorderFactory.createEmptyBorder();
    }

    @Override
    protected Border createNonRolloverBorder() {
        return BorderFactory.createEmptyBorder();
    }
}