package mrcjkb.material.swing.ui;


import mrcjkb.material.swing.icon.combobox.DownArrowIcon;
import mrcjkb.material.swing.materialui.util.MaterialDrawingUtils;
import mrcjkb.material.swing.materialui.util.MaterialManagerListener;
import mrcjkb.material.swing.materialui.util.MaterialUIMovement;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MaterialButtonUI extends BasicButtonUI{

	public enum StateButton {
		DISABLE,
		DEFAULT,
		NORMAL
	}

	public static ComponentUI createUI(final JComponent c) {
		return new MaterialButtonUI();
	}

	private AbstractButton button;
	private Color foreground;
	private Color background;
	private Color disabledBackground;
	private Color disabledForeground;
	private Color defaultBackground;
	private Color defaultForeground;
	private Boolean isDefaultButton = null;
	private int arch = 2;
	private PropertyChangeListener enableButton = new EventEnableButton();

	@Override
	public void installUI(JComponent c) {
		super.installUI(c);

		AbstractButton button = (AbstractButton) c;
		disabledBackground = UIManager.getColor("Button.disabledBackground");
		disabledForeground = UIManager.getColor("Button.disabledForeground");
		defaultBackground = UIManager.getColor("Button[Default].background");
		defaultForeground = UIManager.getColor("Button[Default].foreground");
		button.setFocusable(false);

		button.addHierarchyListener(arg0 -> {
			defaultBackground = button.getBackground();
			defaultForeground = button.getForeground();
			JButton b = (JButton) button;
			if (!b.isDefaultButton() && !(b.getIcon() instanceof DownArrowIcon || b instanceof BasicArrowButton)) {
				MaterialManagerListener.removeAllMaterialMouseListener(button);
				button.addMouseListener(MaterialUIMovement.getMovement(button, UIManager.getColor("MaterialSwing.hoverColor")));
			}
		});

		this.button = button;
	}

	@Override
	public void uninstallUI(JComponent c) {
		super.uninstallUI(c);

		AbstractButton button = (AbstractButton) c;
		button.setBorder(null);
		foreground = null;
		background = null;
		disabledBackground = null;
		disabledForeground = null;
		defaultBackground = null;
		defaultForeground = null;
		button.setBackground(null);
		button.setForeground(null);
		button.setCursor(null);

		MaterialManagerListener.removeAllMaterialMouseListener(button);
	}

	@Override
	public void paint(Graphics g, JComponent c) {
		JButton b = (JButton) c;
		if (b.isContentAreaFilled()) {
			paintBackground(g, b);
		}
		if (isDefaultButton == null && b.isEnabled()) {
			isDefaultButton = ((JButton) button).isDefaultButton();
			if (isDefaultButton) {
				paintStateButton(c, g);
			}
		}
		super.paint(g, c);
	}

	@Override
	protected void paintText(Graphics g, AbstractButton b, Rectangle textRect, String text) {
		super.paintText(g, b, textRect, text);
		paintStateButton(b, g, StateButton.DISABLE);
	}

	private void paintBackground(Graphics g, JComponent c) {
		g = MaterialDrawingUtils.getAliasedGraphics(g);
		Graphics2D graphics = (Graphics2D) g.create();
		g.setColor(c.getBackground());
		JButton b = (JButton) c;
		if (!UIManager.getBoolean("Button[border].toAll") && (button.getIcon() != null)) {
			g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), arch, arch);
		} else {
			g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), arch, arch);
			if (isDefaultButton != null && isDefaultButton) {
				g.setColor(UIManager.getColor("Button[Default].background"));
				if(UIManager.getBoolean("Button[Default].shadowEnable")){
					paintShadow(MaterialDrawingUtils.getAliasedGraphics(g), button);
				}
				return;
			}

			if(UIManager.getBoolean("Button[border].enable")){
				paintBorderButton(graphics, b);
			}
		}

		paintStateButton(c, g, StateButton.DISABLE);

	}

	@Override
	protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect, Rectangle textRect, Rectangle iconRect) {
		paintFocusRing(g, (JButton) b);
	}

	@Override
	public void update(Graphics g, JComponent c) {
		super.update(g, c);
	}

	@Override
	protected void paintButtonPressed(Graphics g, AbstractButton b) {
		g.fillRoundRect(0, 0, b.getWidth(), b.getHeight(), arch, arch);
	}

	@Override
	protected BasicButtonListener createButtonListener(AbstractButton b) {
		b.addPropertyChangeListener(enableButton);
		return super.createButtonListener(b);
	}

	@Override
	protected void uninstallListeners(AbstractButton b) {
		b.removePropertyChangeListener(enableButton);
		super.uninstallListeners(b);
	}

	protected void paintFocusRing(Graphics g, JButton b) {
		Stroke dashed = new BasicStroke(1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 10.0f, new float[]{0f, 3f}, 10.0f);
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setStroke(dashed);
		if (isDefaultButton) {
			g2.setColor(UIManager.getColor("MaterialSwing.accent1Color"));
			g2.drawRoundRect(5, 5, b.getWidth() - 10, b.getHeight() - 10, arch, arch);
		}
		g2.dispose();
	}

	protected void paintShadow(Graphics g, JComponent c) {
		int topOpacity = 80;
		int pixels = UIManager.getInt("Button[Default].shadowPixel");
		JButton b = (JButton) c;
		int valueRed = 255;
		int valueGreen = 255;
		int valueBlue = 255;
		for (int i = pixels; i >= 0; i--) {
			if(valueBlue > 70){
				valueRed -= 70;
				valueGreen -= 70;
				valueBlue -= 70;
			}else{
				valueBlue -= valueBlue;
				valueGreen -= valueGreen;
				valueRed -= valueRed;
			}

			Color result = new Color(valueRed, valueGreen, valueBlue, topOpacity);
			g.setColor(result);
			g.drawRoundRect(i, i, b.getWidth() - ((i * 2) + 1), b.getHeight() - ((i * 2) + 1), arch, arch);
		}

	}

	protected void paintBorderButton(Graphics2D graphics, JButton b) {
		if(!b.isEnabled()){
			return;
		}
		graphics.setStroke(new BasicStroke(2f));

		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int w = b.getWidth() - 1;
		int h = b.getHeight() - 1;

		graphics.setColor(UIManager.getColor("Button[border].color"));
		graphics.drawRoundRect(0, 0, w, h, arch + 2, arch + 2);
	}

	protected void paintStateButton(JComponent component, Graphics graphics) {
		if (component == null || graphics == null) {
			throw new IllegalArgumentException("Input null");
		}
		JButton b = (JButton) component;
		if (b.isEnabled() && (isDefaultButton != null && isDefaultButton) && !b.isSelected()) {
			b.setBackground(defaultBackground);
			b.setForeground(defaultForeground);
			return;
		}
		if (!b.isEnabled()) {
			b.setBackground(disabledBackground);
			b.setForeground(disabledForeground);
		}
	}


	protected void paintStateButton(JComponent c, Graphics g, StateButton disable) {
		if (StateButton.DISABLE.equals(disable)) {
			if (!c.isEnabled()) {
				paintStateButton(c, g);
			}
		}
	}

	protected class EventEnableButton implements PropertyChangeListener {

		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			if (evt == null) {
				throw new IllegalArgumentException("Input null");
			}

			String proprietyNameEnableEvent = "enabled";
			String proprietyNameDefaultEvent = "defaultButton";
			if (evt.getPropertyName().equals(proprietyNameEnableEvent) && (boolean) evt.getNewValue()) {
				button.setBackground(background);
				button.setForeground(foreground);
			} else if (evt.getPropertyName().equals(proprietyNameEnableEvent) && !(boolean) evt.getNewValue()) {
				background = button.getBackground();
				foreground = button.getForeground();
			} else if (evt.getPropertyName().equals(proprietyNameDefaultEvent) && (boolean) evt.getNewValue()) {
				background = button.getBackground();
				foreground = button.getForeground();
			}
		}
	}
}