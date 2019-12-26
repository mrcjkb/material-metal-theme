package mrcjkb.material.swing.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicScrollBarUI;

import mrcjkb.material.swing.materialui.util.MaterialDrawingUtils;

public class MaterialScrollBarUI extends BasicScrollBarUI {
	
	private static final int THUMB_THICKNESS = 10;
	private static final int THUMB_MARGIN = 2;
	
	protected Color originalThumbColor;
	private boolean mActive = false;
	private boolean mIdle	= false;
	
	public MaterialScrollBarUI() {
		super();
	}
	
    @Override
	protected JButton createDecreaseButton(int orientation)  {
    	JButton button = super.createDecreaseButton(orientation);
    	JButton blankButton = createBlankButton(orientation, button);
        return blankButton;
    }

    @Override
	protected JButton createIncreaseButton(int orientation)  {
        JButton button = super.createIncreaseButton(orientation);
        JButton blankButton = createBlankButton(orientation, button);
        return blankButton;
    }
    
    private JButton createBlankButton(int orientation, JButton button) {
		JButton blankButton = new JButton();
		int w = (int) button.getPreferredSize().getWidth();
		int h = (int) button.getPreferredSize().getHeight();
    	if (JScrollBar.HORIZONTAL == scrollbar.getOrientation()) {
    		 blankButton.setPreferredSize(new Dimension(0, h));
    	} else {
    		 blankButton.setPreferredSize(new Dimension(w, 0));
    	}
       
        blankButton.setBackground(thumbColor);
        blankButton.setForeground(thumbColor);
        blankButton.setBorder(BorderFactory.createLineBorder(thumbColor));
		return blankButton;
	}
    
    public static ComponentUI createUI(JComponent c) {
		return new MaterialScrollBarUI();
    }
    
    @Override
	protected void layoutVScrollbar(JScrollBar sb) {
    	super.layoutVScrollbar(sb);
    }
    
    @Override
	protected void layoutHScrollbar(JScrollBar sb) {
    	super.layoutHScrollbar(sb);
    }
    
    public void installUI(JComponent c) {
    	super.installUI(c);
    	originalThumbColor = thumbColor;
    	scrollbar.addMouseListener(new MouseAdapter() {
    		
            @Override
            public void mouseEntered(MouseEvent e) {
            	if (!mActive) {
            		thumbColor = UIManager.getColor("MaterialSwing.hoverColor");
            	}
            	mIdle = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	if (mIdle && !mActive) {
            		thumbColor = originalThumbColor;
            	}
            	mIdle = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
            	mActive = true;
            	thumbColor = UIManager.getColor("MaterialSwing.scrollbarPressedColor");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            	if (mIdle) {
            		thumbColor = UIManager.getColor("MaterialSwing.hoverColor");
            	} else {
            		thumbColor = originalThumbColor;
            	}
            	mActive = false;
            }
    	});
    }
    
    @Override
    public void uninstallUI(JComponent c) {
    	super.uninstallUI(c);
    	originalThumbColor = null;
    }
    
    public void paint(Graphics g, JComponent c) {
    	scrollbar.setBackground(((JScrollPane) scrollbar.getParent()).getViewport().getView().getBackground());
    	paintThumb(g, c, getThumbBounds());
    }
    
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
    	int radius = THUMB_THICKNESS >>> 1; // half width
    	
    	int orientation = scrollbar.getOrientation();
    	
    	int x = thumbBounds.x;
        int y = thumbBounds.y;
        int width = thumbBounds.width;
        int height = thumbBounds.height;

        Graphics2D graphics2D = (Graphics2D) MaterialDrawingUtils.getAliasedGraphics(g).create();
        graphics2D.setColor(thumbColor);
        if (orientation == JScrollBar.VERTICAL) {
        	width -= THUMB_MARGIN;
        }
        else {
        	height -= THUMB_MARGIN;
        }

        graphics2D.fillRoundRect(x, y, width, height, radius, radius);
        graphics2D.dispose();
    }
    
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
    	
    }
}