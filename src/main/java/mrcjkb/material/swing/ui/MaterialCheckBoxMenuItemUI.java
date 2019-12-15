package mrcjkb.material.swing.ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicCheckBoxMenuItemUI;

import mrcjkb.material.swing.icon.checkbox.CheckboxCheckedIcon;
import mrcjkb.material.swing.icon.checkbox.CheckboxDisableIcon;
import mrcjkb.material.swing.icon.checkbox.CheckboxUncheckDisableIcon;
import mrcjkb.material.swing.icon.checkbox.CheckboxUncheckedIcon;
import mrcjkb.material.swing.materialui.util.MaterialDrawingUtils;

public class MaterialCheckBoxMenuItemUI extends BasicCheckBoxMenuItemUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialCheckBoxMenuItemUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		c.setBackground(UIManager.getColor("CheckBoxMenuItem.background"));
		c.setForeground(UIManager.getColor("CheckBoxMenuItem.foreground"));
		c.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
	}

	@Override
	public void uninstallUI(JComponent c) {

		c.setBackground(null);
		c.setForeground(null);
		c.setBorder(null);
		c.setCursor(null);

		super.uninstallUI(c);
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
	}

	@Override
	protected void paintMenuItem(Graphics g, JComponent c, Icon checkIcon, Icon arrowIcon, Color background, Color foreground, int defaultTextIconGap) {
		JCheckBoxMenuItem checkBoxMenuItem = (JCheckBoxMenuItem) c;
		if (checkBoxMenuItem.isSelected()) {
			if (checkBoxMenuItem.isEnabled()) {
				checkIcon = CheckboxCheckedIcon.builder()
						.withBackgroundColor(checkBoxMenuItem.getBackground())
						.withBoxColor(checkBoxMenuItem.getForeground())
						.withCheckColor(UIManager.getColor("MaterialSwing.accent2Color"))
						.withHeight(16)
						.withWidth(16)
						.build();
			} else {
				checkIcon = CheckboxDisableIcon.builder()
						.withBackgroundColor(c.getBackground())
						.withForegroundColor(UIManager.getColor("MaterialSwing.uiDisabledColor"))
						.withHeight(16)
						.withWidth(16)
						.build();
			}
		} else {
			if (checkBoxMenuItem.isEnabled()) {
				checkIcon = CheckboxUncheckedIcon.builder()
						.withBackgroundColor(checkBoxMenuItem.getBackground())
						.withBoxColor(checkBoxMenuItem.getForeground())
						.withHeight(16)
						.withWidth(16)
						.build();
			} else {
				checkIcon = CheckboxUncheckDisableIcon.builder()
						.withBackgroundColor(c.getBackground())
						.withForegroundColor(UIManager.getColor("MaterialSwing.uiDisabledColor"))
						.withHeight(16)
						.withWidth(16)
						.build();
			}
		}
		super.paintMenuItem(MaterialDrawingUtils.getAliasedGraphics(g), checkBoxMenuItem, checkIcon, arrowIcon, background, foreground, defaultTextIconGap);
	}
}
