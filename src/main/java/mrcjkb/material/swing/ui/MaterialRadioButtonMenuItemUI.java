package mrcjkb.material.swing.ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;

import mrcjkb.material.swing.icon.radiobutton.RadioButtonCheckedIcon;
import mrcjkb.material.swing.icon.radiobutton.RadioButtonUncheckedIcon;
import mrcjkb.material.swing.materialui.util.MaterialDrawingUtils;

public class MaterialRadioButtonMenuItemUI extends BasicRadioButtonMenuItemUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialRadioButtonMenuItemUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		c.setBackground(UIManager.getColor("RadioButtonMenuItem.background"));
		c.setForeground(UIManager.getColor("RadioButtonMenuItem.foreground"));
		c.setBorder(UIManager.getBorder("RadioButtonMenuItem.border"));
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
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics(g), c);
	}

	@Override
	protected void paintMenuItem (Graphics g, JComponent c, Icon checkIcon, Icon arrowIcon, Color background, Color foreground, int defaultTextIconGap) {
		JRadioButtonMenuItem radioButtonMenuItem = (JRadioButtonMenuItem) c;
		if (radioButtonMenuItem.isSelected()) {
			if (radioButtonMenuItem.isEnabled()) {
				checkIcon = RadioButtonCheckedIcon.builder()
						.withBackgroundColor(radioButtonMenuItem.getBackground())
						.withOuterCircleColor(radioButtonMenuItem.getForeground())
						.withInnerCircleColor(UIManager.getColor("MaterialSwing.accent2Color"))
						.withHeight(16)
						.withWidth(16)
						.build();
			} else {
				checkIcon = RadioButtonCheckedIcon.builder()
						.withBackgroundColor(c.getBackground())
						.withOuterCircleColor(UIManager.getColor("MaterialSwing.uiDisabledColor"))
						.withInnerCircleColor(UIManager.getColor("MaterialSwing.uiDisabledColor"))
						.withHeight(16)
						.withWidth(16)
						.build();
			}
		} else {
			if (radioButtonMenuItem.isEnabled()) {
				checkIcon = RadioButtonUncheckedIcon.builder()
						.withBackgroundColor(radioButtonMenuItem.getBackground())
						.withForegroundColor(radioButtonMenuItem.getForeground())
						.withHeight(16)
						.withWidth(16)
						.build();
			} else {
				checkIcon = RadioButtonUncheckedIcon.builder()
						.withBackgroundColor(c.getBackground())
						.withForegroundColor(UIManager.getColor("MaterialSwing.uiDisabledColor"))
						.withHeight(16)
						.withWidth(16)
						.build();
			}
		}
		super.paintMenuItem(MaterialDrawingUtils.getAliasedGraphics(g), c, checkIcon, arrowIcon, background, foreground, defaultTextIconGap);
	}
}