package mrcjkb.material.swing.ui;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import mrcjkb.material.swing.materialui.util.MaterialDrawingUtils;
import mrcjkb.material.swing.materialui.util.MaterialUIMovement;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

public class MaterialTabbedPaneUI extends BasicTabbedPaneUI {

	private static final int LINE_HEIGHT = 5;

	protected JTabbedPane component;
	protected ColorUIResource selectedForeground;
	protected ColorUIResource areaContentBackground;
	protected ColorUIResource selectedAreaContentBackground;
	protected ColorUIResource disableAreaContentBackground;
	protected ColorUIResource foreground;
	protected int positionYLine;
	protected int positionXLine;
	protected int widthLine;

	public static ComponentUI createUI(JComponent c) {
		return new MaterialTabbedPaneUI();
	}

	@Override
	public void installUI(JComponent c) {
		super.installUI(c);

		JTabbedPane tabbedPane = (JTabbedPane) c;
		tabbedPane.setOpaque(false);
		tabbedPane.setFont(UIManager.getFont("TabbedPane.font"));
		tabbedPane.setBackground(UIManager.getColor("TabbedPane.background"));
		this.foreground = new ColorUIResource(UIManager.getColor("TabbedPane.foreground"));
		tabbedPane.setForeground(foreground);
		this.selectedForeground = new ColorUIResource(UIManager.getColor("TabbedPane.selectedForeground"));
		this.areaContentBackground = new ColorUIResource(UIManager.getColor("TabbedPane.contentAreaColor"));
		this.disableAreaContentBackground = new ColorUIResource(UIManager.getColor("TabbedPane.disabled"));
		this.selectedAreaContentBackground = new ColorUIResource(UIManager.getColor("TabbedPane.selected"));
		tabbedPane.setBorder(UIManager.getBorder("TabbedPane.border"));
		darkShadow = UIManager.getColor("TabbedPane.darkShadow");
		shadow = UIManager.getColor("TabbedPane.shadow");
		lightHighlight = UIManager.getColor("TabbedPane.highlight");
		this.positionYLine = UIManager.getInt("TabbedPane.linePositionY");
		this.positionXLine = UIManager.getInt("TabbedPane.linePositionX");
		this.widthLine = UIManager.getInt("TabbedPane.lineWidth");
		component = tabbedPane;
	}

	@Override
	public void uninstallUI(JComponent c) {

		JTabbedPane tabbedPane = (JTabbedPane) c;
		tabbedPane.setFont(null);
		tabbedPane.setBackground(null);
		tabbedPane.setForeground(null);
		tabbedPane.setBorder(null);

		darkShadow = null;
		shadow = null;
		lightHighlight = null;

		component = null;

		super.uninstallDefaults();
		super.uninstallUI(c);
	}
	@Override
	protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
		positionYLine = h - 8;
		Graphics2D g2D = (Graphics2D) g;
		int[] xp;
		int[] yp;
		Polygon shape = null;
		Rectangle shapeRect = null;
		if (tabPlacement == TOP) {
			xp = new int[]{x, x, x, x + w, x + w, x + w, x + w, x};
			yp = new int[]{(y + positionYLine + LINE_HEIGHT), y + positionYLine, y + positionYLine, y + positionYLine, y + positionYLine, y + positionYLine, y + positionYLine + LINE_HEIGHT, y + positionYLine + LINE_HEIGHT};
			shape = new Polygon(xp, yp, xp.length);
		} else if (tabPlacement == BOTTOM) {
			y += 20;
			xp = new int[]{x, x, x, x + w, x + w, x + w, x + w, x};
			yp = new int[]{(y + LINE_HEIGHT), y, y, y, y, y, y + LINE_HEIGHT, y + LINE_HEIGHT};
			shape = new Polygon(xp, yp, xp.length);
		} else if (tabPlacement == LEFT) {
			shapeRect = new Rectangle(x + LINE_HEIGHT - 2, y + (LINE_HEIGHT), LINE_HEIGHT, w / (tabPane.getTabCount()));
		} else {
			shapeRect = new Rectangle(x + w - LINE_HEIGHT, y + (LINE_HEIGHT), LINE_HEIGHT, w / (tabPane.getTabCount()));
		}

		if (isSelected) {
			g2D.setColor(selectedAreaContentBackground);
			g2D.setPaint(selectedAreaContentBackground);
			tabPane.setForegroundAt(tabIndex, selectedForeground);
			if (shape != null) {
				g2D.fill(shape);
			} else if (shapeRect != null) {
				g2D.fill(shapeRect);
			}
		} else {
			tabPane.setForegroundAt(tabIndex, foreground);
		}
	}

	@Override
	protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
		if (tabPlacement == LEFT || tabPlacement == RIGHT) {
			return super.calculateTabHeight(tabPlacement, tabIndex, fontHeight);
		} else {
			return 18 + super.calculateTabHeight(tabPlacement, tabIndex, fontHeight);
		}
	}

	@Override
	protected void paintTab(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect) {
		// for some reason tabs aren't painted properly by paint()
		super.paintTab(MaterialDrawingUtils.getAliasedGraphics(g), tabPlacement, rects, tabIndex, iconRect, textRect);
	}

	@Override
	protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) { }

	@Override
	protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) { }

	@Override
	protected void paintContentBorder(Graphics graphics, int i, int i1) { }


	@Override
	protected LayoutManager createLayoutManager() {
		return new MaterialTabbedPaneLayout();
	}

	protected class MaterialTabbedPaneLayout extends BasicTabbedPaneUI.TabbedPaneLayout {

		protected int spacer; // should be non-negative
		protected int indent;

		public MaterialTabbedPaneLayout() {
			this.spacer = UIManager.getInt("TabbedPane.spacer");
			this.indent = UIManager.getInt("TabbedPane.indent");
		}

		@Override
		protected void calculateTabRects(int tabPlacement, int tabCount) {
			if (spacer < 0) {
				throw new IllegalArgumentException("The spacer inside the " +
						this.getClass().getSimpleName() + " must be a not negative value");
			}

			super.calculateTabRects(tabPlacement, tabCount);
			if (tabPlacement == TOP || tabPlacement == BOTTOM) {
				for (int i = 0; i < rects.length; i++) {
					rects[i].x += i * spacer + indent;
				}
			}
		}
	}
}