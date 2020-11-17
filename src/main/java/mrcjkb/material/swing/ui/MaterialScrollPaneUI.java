package mrcjkb.material.swing.ui;

import mrcjkb.material.swing.materialui.util.ComponentUtil;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.awt.*;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Logger;


public class MaterialScrollPaneUI extends BasicScrollPaneUI {

	private static final Logger sLog = Logger.getLogger(MaterialScrollPaneUI.class.getName());
			
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
				if (isAutohideScrollbarsDisabled() || !scrollpane.isShowing()) {
					return;
				}
				try {
					boolean showVerticalScrollbar = scrollpane.getLocationOnScreen().getX() + scrollpane.getWidth() - SHOW_THRESHOLD < e.getLocationOnScreen().getX();
					boolean showHorizontalScrollbar = scrollpane.getLocationOnScreen().getY() + scrollpane.getHeight() - SHOW_THRESHOLD < e.getLocationOnScreen().getY();
					if (showVerticalScrollbar && null != scrollpane.getVerticalScrollBar()) {
						scrollpane.getVerticalScrollBar().setPreferredSize(originalVerticalScrollBarSize);
					} else if (showHorizontalScrollbar && null != scrollpane.getHorizontalScrollBar()) {
						scrollpane.getHorizontalScrollBar().setPreferredSize(originalHorizontalScrollBarSize);
					}
					if (!showVerticalScrollbar && !scrollingActive && !isPointWithinComponent(scrollpane.getVerticalScrollBar(), e.getLocationOnScreen()) && null != scrollpane.getVerticalScrollBar()) {
						scrollpane.getVerticalScrollBar().setPreferredSize(getVerticalHiddenSize());
					}
					if (!showHorizontalScrollbar && !scrollingActive && !isPointWithinComponent(scrollpane.getHorizontalScrollBar(), e.getLocationOnScreen()) && null != scrollpane.getHorizontalScrollBar()) {
						scrollpane.getHorizontalScrollBar().setPreferredSize(getHorizontalHiddenSize());
					}
					revalidateScrollBars();
				} catch (Throwable t) {
					sLog.warning("Autohide update failed: " + t.getMessage());
				}
			}
		};
		mouseExitedAdapter = new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				if (isAutohideScrollbarsDisabled()) {
					return;
				}
				try {
					if (!(e.getComponent() instanceof JScrollBar)
							&& (isPointWithinComponent(scrollpane.getVerticalScrollBar(), e.getLocationOnScreen())
							|| isPointWithinComponent(scrollpane.getHorizontalScrollBar(), e.getLocationOnScreen()))) {
						return;
					}
					if (!scrollingActive) {
						setScrollBarSizes();
						revalidateScrollBars();
					}
				} catch (Throwable t) {
					sLog.warning("Revalidate scrollbar failed: " + t.getMessage());
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
				if (isAutohideScrollbarsDisabled()) {
					return;
				}
				try {
					if (e.getComponent() instanceof JScrollBar && !isPointWithinComponent(scrollpane.getVerticalScrollBar(), e.getLocationOnScreen()) && null != scrollpane.getVerticalScrollBar()) {
						scrollpane.getVerticalScrollBar().setPreferredSize(getVerticalHiddenSize());
						revalidateScrollBars();
					}
					if (e.getComponent() instanceof JScrollBar && !isPointWithinComponent(scrollpane.getHorizontalScrollBar(), e.getLocationOnScreen()) && null != scrollpane.getHorizontalScrollBar()) {
						scrollpane.getHorizontalScrollBar().setPreferredSize(getHorizontalHiddenSize());
						revalidateScrollBars();
					}
				} catch (Throwable t) {
					sLog.warning("Revalidate scrollbars failed: " + t.getMessage());
				}
			}
		};
    	scrollpane.getViewport().addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent aE) {
				addListeners(aE.getComponent());
			}
			
			@Override
			public void componentRemoved(ContainerEvent aE) {
				removeListeners(aE.getComponent());
			}
    	});
    	scrollpane.getViewport().addHierarchyListener(aE -> {
			setScrollBarSizes();
			removeListeners(scrollpane.getViewport());
				addListeners(scrollpane.getViewport());
			});
    	if (null != scrollpane.getHorizontalScrollBar()) {
			scrollpane.getHorizontalScrollBar().addMouseListener(scrollBarMouseAdapter);
			scrollpane.getHorizontalScrollBar().addMouseListener(mouseExitedAdapter);
		}
    	if (null != scrollpane.getVerticalScrollBar()) {
			scrollpane.getVerticalScrollBar().addMouseListener(scrollBarMouseAdapter);
			scrollpane.getVerticalScrollBar().addMouseListener(mouseExitedAdapter);
		}
	}

	private void setScrollBarSizes() {
		if (null != scrollpane.getVerticalScrollBar()) {
			scrollpane.getVerticalScrollBar().setPreferredSize(getVerticalHiddenSize());
		}
		if (null != scrollpane.getHorizontalScrollBar()) {
			scrollpane.getHorizontalScrollBar().setPreferredSize(getHorizontalHiddenSize());
		}
	}

	private boolean isAutohideScrollbarsDisabled() {
		return !UIManager.getBoolean("MaterialSwing.autohideScrollBars") || isJFileChooserScrollPane();
	}

	/**
	 * Checks if the scrollpane is used by a JFileChooser.
	 * @return {@code true} if the scrollpane is used by a JFileChooser.
	 */
	private boolean isJFileChooserScrollPane() {
		return scrollpane.getParent() != null && scrollpane.getParent().getParent() != null && scrollpane.getParent().getParent().getParent() instanceof JFileChooser;
	}

	private void revalidateScrollBars() {
		if (null != scrollpane.getVerticalScrollBar()) {
			scrollpane.getVerticalScrollBar().revalidate();
		}
		if (null != scrollpane.getHorizontalScrollBar()) {
			scrollpane.getHorizontalScrollBar().revalidate();
		}
	}
	
	private static boolean isPointWithinComponent(Component c, Point p) {
	    return ComponentUtil.isPointWithinComponent(c, p);
	}
	
	/**
	 * Recursively add the listeners to {@code aComponent} and its subcomponents.
	 * @param aComponent the {@code Component} to add the listeners to
	 */
	private void addListeners(Component aComponent) {
		if (null == aComponent) {
			return;
		}
		try {
			if (aComponent instanceof Container) {
				for (Component child : ((Container) aComponent).getComponents()) {
					addListeners(child);
				}
			}
			aComponent.addMouseMotionListener(mouseMotionAdapter);
			aComponent.addMouseListener(mouseExitedAdapter);
		} catch (Throwable t) {
			sLog.warning("Failed to add listeners to scrollbar: " + t.getMessage());
		}
	}
	
	/**
	 * Recursively remove the listeners from {@code aComponent} and its subcomponents.
	 * @param aComponent the {@code Component} to remove the listeners from
	 */
	private void removeListeners(Component aComponent) {
		if (null == aComponent) {
			return;
		}
		try {
			if (aComponent instanceof Container) {
				for (Component child : ((Container) aComponent).getComponents()) {
					removeListeners(child);
				}
			}
			aComponent.removeMouseMotionListener(mouseMotionAdapter);
			aComponent.removeMouseListener(mouseExitedAdapter);
		} catch (Throwable t) {
			sLog.warning("Failed to remove scrollbar listeners.");
		}
	}

	private Dimension getVerticalHiddenSize() {
		return UIManager.getBoolean("MaterialSwing.autohideScrollBars") && !isJFileChooserScrollPane() ? verticalHiddenSize : originalVerticalScrollBarSize;
	}

	private Dimension getHorizontalHiddenSize() {
		return isAutohideScrollbarsDisabled() ? originalHorizontalScrollBarSize : horizontalHiddenSize;
	}
}
