package mrcjkb.material.swing.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicCheckBoxUI;

import mrcjkb.material.swing.icon.checkbox.CheckboxCheckedIcon;
import mrcjkb.material.swing.icon.checkbox.CheckboxDisableIcon;
import mrcjkb.material.swing.icon.checkbox.CheckboxUncheckDisableIcon;
import mrcjkb.material.swing.icon.checkbox.CheckboxUncheckedIcon;
import mrcjkb.material.swing.materialui.util.MaterialDrawingUtils;
import mrcjkb.material.swing.materialui.util.MaterialManagerListener;
import mrcjkb.material.swing.materialui.util.MaterialUIMovement;

public class MaterialCheckBoxUI extends BasicCheckBoxUI {

	public static ComponentUI createUI(JComponent c) {
		return new MaterialCheckBoxUI();
	}

	@Override
	public void installUI(JComponent c) {
		super.installUI(c);

		JCheckBox checkBox = (JCheckBox) c;
		checkBox.setFont(UIManager.getFont("CheckBox.font"));
		checkBox.setBackground(UIManager.getColor("CheckBox.background"));
		checkBox.setForeground(UIManager.getColor("CheckBox.foreground"));
		setDefaultIcons(checkBox);
		checkBox.addMouseListener(MaterialUIMovement.getMovement(checkBox, UIManager.getColor("MaterialSwing.accent2Color")));
	}

	/**
	 * Sets the default Material-Metal-Theme icons.
	 * @param checkBox the checkbox to apply the icons to.
	 */
	public static void setDefaultIcons(JCheckBox checkBox) {
		checkBox.setIcon(CheckboxUncheckedIcon.builder()
				.withBackgroundColor(checkBox.getBackground())
				.withBoxColor(checkBox.getForeground())
				.build());
		checkBox.setSelectedIcon(CheckboxCheckedIcon.builder()
				.withBackgroundColor(checkBox.getBackground())
				.withBoxColor(checkBox.getForeground())
				.withCheckColor(UIManager.getColor("MaterialSwing.accent2Color"))
				.build());
		checkBox.setDisabledIcon(CheckboxUncheckDisableIcon.builder()
				.withBackgroundColor(checkBox.getBackground())
				.withForegroundColor(UIManager.getColor("MaterialSwing.uiDisabledColor"))
				.build());
		checkBox.setDisabledSelectedIcon(CheckboxDisableIcon.builder()
				.withBackgroundColor(checkBox.getBackground())
				.withForegroundColor(UIManager.getColor("MaterialSwing.uiDisabledColor"))
				.build());
	}

	@Override
	public void uninstallUI(JComponent c) {

		JCheckBox checkBox = (JCheckBox) c;
		checkBox.setFont(null);
		checkBox.setBackground(null);
		checkBox.setForeground(null);
		checkBox.setIcon(null);
		checkBox.setSelectedIcon(null);
		checkBox.setCursor(null);
		MaterialManagerListener.removeAllMaterialMouseListener(checkBox);
		
		super.uninstallUI(c);
	}

	@Override
	public void paint(Graphics g, JComponent c) {
		super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
	}

	@Override
	protected void paintFocus(Graphics g, Rectangle textRect, Dimension size) {
	}

}