package mrcjkb.material.swing.ui;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicProgressBarUI;

import mrcjkb.material.swing.materialui.util.MaterialDrawingUtils;

/**
 * Code based on the ProggressBarUIs from the following two projects:
 * - IntelliJ Community: https://github.com/JetBrains/intellij-community
 * - material-ui-swing: https://github.com/atarw/material-ui-swing
 */
public class MaterialProgressBarUI extends BasicProgressBarUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialProgressBarUI();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JProgressBar progressBar = (JProgressBar) c;
		progressBar.setBorder(UIManager.getBorder("ProgressBar.border"));
		progressBar.setBackground(UIManager.getColor("ProgressBar.background"));
		progressBar.setForeground(UIManager.getColor("ProgressBar.foreground"));
	}

	@Override
	public void uninstallUI(JComponent c) {

		c.setFont (null);
		c.setBackground (null);
		c.setForeground (null);
		c.setBorder (null);
		c.setCursor(null);

		super.uninstallUI(c);
	}

	@Override
	protected void installDefaults() {
		super.installDefaults();
		UIManager.put("ProgressBar.repaintInterval", 50);
		UIManager.put("ProgressBar.cycleTime", 800);
	}

	@Override
	protected void paintDeterminate(Graphics g, JComponent c) {
		Graphics2D g2 = (Graphics2D) MaterialDrawingUtils.getAliasedGraphics(g).create();
		g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
		try {
			Rectangle r = new Rectangle(progressBar.getSize());
			if (c.isOpaque() && c.getParent() != null) {
				g2.setColor(c.getParent().getBackground());
				g2.fill(r);
			}

			removeInsets(r);
			Insets i = progressBar.getInsets();
			int amountFull = getAmountFull(i, r.width, r.height);

			Shape fullShape, coloredShape;
			int orientation = progressBar.getOrientation();
			if (orientation == SwingConstants.HORIZONTAL) {
				int pHeight = progressBar.getPreferredSize().height;
				int yOffset = r.y + (r.height - pHeight) / 2;

				fullShape = new RoundRectangle2D.Float(r.x, yOffset, r.width, pHeight, pHeight, pHeight);
				coloredShape = new RoundRectangle2D.Float(r.x, yOffset, amountFull, pHeight, pHeight, pHeight);
			} else {
				int pWidth = progressBar.getPreferredSize().width;
				int xOffset = r.x + (r.width - pWidth) / 2;

				fullShape = new RoundRectangle2D.Float(xOffset, r.y, pWidth, r.height, pWidth, pWidth);
				coloredShape = new RoundRectangle2D.Float(xOffset, r.y, pWidth, amountFull, pWidth, pWidth);
			}
			g2.setColor(progressBar.getBackground());
			g2.fill(fullShape);

			g2.setColor(progressBar.getForeground());
			g2.fill(coloredShape);

			// Paint text
			if (progressBar.isStringPainted()) {
				paintString(g, i.left, i.top, r.width, r.height, amountFull, i);
			}
		}
		finally {
			g2.dispose();
		}
	}

	@Override
	protected void paintIndeterminate(Graphics g, JComponent c) {
		Graphics2D g2 = (Graphics2D) MaterialDrawingUtils.getAliasedGraphics(g).create();
		g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
		try {
			Rectangle r = new Rectangle(progressBar.getSize());
			if (c.isOpaque()) {
				g2.setColor(c.getParent().getBackground());
				g2.fill(r);
			}

			removeInsets(r);
			Insets i = progressBar.getInsets();
			int amountFull = getAmountFull(i, r.width, r.height);


			int orientation = progressBar.getOrientation();

			Color startColor = progressBar.getBackground();
			Color endColor = progressBar.getForeground();

			int pHeight = progressBar.getPreferredSize().height;
			int pWidth = progressBar.getPreferredSize().width;

			int yOffset = r.y + (r.height - pHeight) / 2;
			int xOffset = r.x + (r.width - pWidth) / 2;

			Shape shape;
			int step = 6;
			if (orientation == SwingConstants.HORIZONTAL) {
				shape = new RoundRectangle2D.Float(r.x, yOffset, r.width, pHeight, pHeight, pHeight);
				yOffset = r.y + pHeight / 2;
				g2.setPaint(new GradientPaint(r.x + getAnimationIndex() * step * 2, yOffset, startColor,
						r.x + getFrameCount() * step + getAnimationIndex() * step * 2, yOffset, endColor, true));
			} else {
				shape = new RoundRectangle2D.Float(xOffset, r.y, pWidth, r.height, pWidth, pWidth);
				xOffset = r.x + pWidth / 2;
				g2.setPaint(new GradientPaint(xOffset, r.y + getAnimationIndex() * step * 2, startColor,
						xOffset, r.y + getFrameCount() * step + getAnimationIndex() * step * 2, endColor, true));
			}
			g2.fill(shape);

			// Paint text
			if (progressBar.isStringPainted()) {
				if (progressBar.getOrientation() == SwingConstants.HORIZONTAL) {
					paintString(g, i.left, i.top, r.width, r.height, amountFull, i);
				} else {
					paintString(g, i.left, i.top, r.width, r.height, amountFull, i);
				}
			}
		} finally {
			g2.dispose();
		}
	}

	private void removeInsets(Rectangle r) {
		Insets i = progressBar.getInsets();
		if (null != i) {
			r.x += i.left;
			r.y += i.top;
			r.width -= i.left + i.right;
			r.height -= i.top + i.bottom;
		}
	}
}
