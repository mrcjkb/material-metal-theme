package mrcjk.material.swing.ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Logger;

import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicScrollPaneUI;


public class MaterialScrollPaneUI extends BasicScrollPaneUI {

	private static Logger sLog = Logger.getLogger(MaterialScrollPaneUI.class.getName());
			
	private static final int SHOW_THRESHOLD = 30;
	
	private Dimension originalVerticalScrollBarSize;
	private Dimension originalHorizontalScrollBarSize;
	private Dimension verticalHiddenSize = new Dimension(0, 0);
	private Dimension horizontalHiddenSize = new Dimension(0, 0);
	MouseAdapter mouseExitedAdapter;
	MouseAdapter mouseMotionAdapter;
	MouseAdapter scrollBarMouseAdapter;
	private boolean scrollingActive;
	
	public static ComponentUI createUI(JComponent c) {
		return new MaterialScrollPaneUI();
    }
	
	public void installUI(JComponent c) {
    	super.installUI(c);
    	
    	originalVerticalScrollBarSize = scrollpane.getVerticalScrollBar().getPreferredSize();
    	originalHorizontalScrollBarSize = scrollpane.getHorizontalScrollBar().getPreferredSize();
    	scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    	scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	scrollpane.getVerticalScrollBar().setPreferredSize(getVerticalHiddenSize());
    	scrollpane.getHorizontalScrollBar().setPreferredSize(getHorizontalHiddenSize());
    	mouseMotionAdapter = new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				boolean showVerticalScrollbar = scrollpane.getLocationOnScreen().getX() + scrollpane.getWidth() - SHOW_THRESHOLD < e.getLocationOnScreen().getX();
				boolean showHorizontalScrollbar = scrollpane.getLocationOnScreen().getY() + scrollpane.getHeight() - SHOW_THRESHOLD < e.getLocationOnScreen().getY();
				if (showVerticalScrollbar) {
					scrollpane.getVerticalScrollBar().setPreferredSize(originalVerticalScrollBarSize);
				} else if (showHorizontalScrollbar) {
					scrollpane.getHorizontalScrollBar().setPreferredSize(originalHorizontalScrollBarSize);
				}
				if (!showVerticalScrollbar && !scrollingActive && !isPointWithinComponent(scrollpane.getVerticalScrollBar(), e.getLocationOnScreen())) {
					scrollpane.getVerticalScrollBar().setPreferredSize(getVerticalHiddenSize());
				}
				if (!showHorizontalScrollbar && !scrollingActive && !isPointWithinComponent(scrollpane.getHorizontalScrollBar(), e.getLocationOnScreen())) {
					scrollpane.getHorizontalScrollBar().setPreferredSize(getHorizontalHiddenSize());
				}
				revalidateScrollBars();
			}
		};
		mouseExitedAdapter = new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				if (!(e.getComponent() instanceof JScrollBar)
					&& (isPointWithinComponent(scrollpane.getVerticalScrollBar(), e.getLocationOnScreen())
							|| isPointWithinComponent(scrollpane.getHorizontalScrollBar(), e.getLocationOnScreen()))) {
					return;
				}
				if (!scrollingActive) {
					scrollpane.getVerticalScrollBar().setPreferredSize(getVerticalHiddenSize());
					scrollpane.getHorizontalScrollBar().setPreferredSize(getHorizontalHiddenSize());
					revalidateScrollBars();
				}
			}
		};
		scrollBarMouseAdapter = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				scrollingActive = true;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				scrollingActive = false;
				if (e.getComponent() instanceof JScrollBar && !isPointWithinComponent(scrollpane.getVerticalScrollBar(), e.getLocationOnScreen())) {
					scrollpane.getVerticalScrollBar().setPreferredSize(getVerticalHiddenSize());
					revalidateScrollBars();
				}
				if (e.getComponent() instanceof JScrollBar && !isPointWithinComponent(scrollpane.getHorizontalScrollBar(), e.getLocationOnScreen())) {
					scrollpane.getHorizontalScrollBar().setPreferredSize(getHorizontalHiddenSize());
					revalidateScrollBars();
				}
			}
		};
    	scrollpane.getViewport().addHierarchyListener(new HierarchyListener() {
			
    		private Component mLastChild;
    		
			@Override
			public void hierarchyChanged(HierarchyEvent aE) {
				Component child = scrollpane.getViewport().getView();
				if (null == child || null == scrollpane.getVerticalScrollBar() || null == scrollpane.getHorizontalScrollBar()) {
					return;
				}
				boolean isComponentReplacement = null != mLastChild && !mLastChild.equals(child);
				if (isComponentReplacement) {
					removeListeners(scrollpane.getViewport());
				}
				if (null != child) {
					addListeners(scrollpane.getViewport());
					if (!isComponentReplacement) {
						scrollpane.getHorizontalScrollBar().addMouseListener(scrollBarMouseAdapter);
						scrollpane.getHorizontalScrollBar().addMouseListener(mouseExitedAdapter);
						scrollpane.getVerticalScrollBar().addMouseListener(scrollBarMouseAdapter);
						scrollpane.getVerticalScrollBar().addMouseListener(mouseExitedAdapter);
					}
				}
				mLastChild = child;
			}
		});
	}

	private void revalidateScrollBars() {
		scrollpane.getVerticalScrollBar().revalidate();
		scrollpane.getHorizontalScrollBar().revalidate();
	}
	
	private static boolean isPointWithinComponent(Component c, Point p) {
	    if (!c.isVisible()) {
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
	
	/**
	 * Recursively add the listeners to {@code aComponent} and its subcomponents.
	 * @param aComponent
	 */
	private void addListeners(Component aComponent) {
		if (aComponent instanceof Container) {
			for (Component child : ((Container) aComponent).getComponents()) {
				addListeners(child);
			}
		}
		aComponent.addMouseMotionListener(mouseMotionAdapter);
		aComponent.addMouseListener(mouseExitedAdapter);
	}
	
	/**
	 * Recursively remove the listeners from {@code aComponent} and its subcomponents.
	 * @param aComponent
	 */
	private void removeListeners(Component aComponent) {
		try {
			if (aComponent instanceof Container) {
				for (Component child : ((Container) aComponent).getComponents()) {
					removeListeners(child);
				}
			}
			aComponent.removeMouseMotionListener(mouseMotionAdapter);
			aComponent.removeMouseListener(mouseExitedAdapter);
		} catch (Throwable t) {
			sLog.warning("Failed to remove SB listeners.");
		}
	}

	private Dimension getVerticalHiddenSize() {
		return UIManager.getBoolean("MaterialSwing.autohideScrollBars") ? verticalHiddenSize : originalVerticalScrollBarSize;
	}

	private Dimension getHorizontalHiddenSize() {
		return UIManager.getBoolean("MaterialSwing.autohideScrollBars") ? horizontalHiddenSize : originalHorizontalScrollBarSize;
	}
}
