package mrcjkb.material.swing.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.MetalToggleButtonUI;

import mrcjkb.material.swing.materialui.util.MaterialDrawingUtils;
import mrcjkb.material.swing.materialui.util.MaterialManagerListener;
import mrcjkb.material.swing.materialui.util.MaterialUIMovement;

public class MaterialToggleButtonUI extends MetalToggleButtonUI {
	
	Color mOriginalBackground;
	Color mOriginalForeground;
	Border mOriginalBorder;
	
	public static ComponentUI createUI(JComponent c) {
		return new MaterialToggleButtonUI();
    }
	
	@Override
	public void installUI(JComponent c) {
    	super.installUI(c);
    	AbstractButton button = ((AbstractButton) c);
    	mOriginalBackground = button.getBackground();
    	mOriginalForeground = button.getForeground();
    	mOriginalBorder = button.getBorder();
    	
    	button.addHierarchyListener(new HierarchyListener() {
			
			@Override
			public void hierarchyChanged(HierarchyEvent arg0) {
				MaterialManagerListener.removeAllMaterialMouseListener(button);
				button.addMouseListener(MaterialUIMovement.getMovement(button, UIManager.getColor("MaterialSwing.accent1Color")));
			}
		});

    	button.addMouseListener(new MouseAdapter() {
    		
            @Override
            public void mouseEntered(MouseEvent e) {
            	if (!button.isEnabled()) {
            		resetButton();
            	}
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	resetButton();
            }
            
            private void resetButton() {
				button.setBackground(mOriginalBackground);
				button.setForeground(button.isSelected() ? Color.WHITE : mOriginalForeground);
				button.setBorder(mOriginalBorder);
			}
        });
    	
    	button.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent aE) {
				button.setForeground(button.isSelected() ? Color.WHITE : mOriginalForeground);
			}
		});
	}
	
	@Override
	public void uninstallUI(JComponent c) {
		super.uninstallUI(c);
		AbstractButton button = (AbstractButton) c;
		button.setBorder(null);
		button.setBackground(null);
		button.setForeground(null);
		button.setCursor(null);
		MaterialManagerListener.removeAllMaterialMouseListener(button);
	}
	
	@Override
	public void paint(Graphics g, JComponent c) {
		super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
	}

	@Override
	protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect, Rectangle textRect, Rectangle iconRect) {
		//do nothing
	}
}
