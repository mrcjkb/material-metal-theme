package mrcjkb.material.swing.ui;

import mrcjkb.material.swing.icon.combobox.DownArrowIcon;
import mrcjkb.material.swing.materialui.util.MaterialManagerListener;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicButtonUI;

public class MaterialComboBoxButtonUI extends BasicButtonUI {

	public MaterialComboBoxButtonUI() {
		super();
	}
	
	public static ComponentUI createUI(final JComponent c) {
		return new MaterialComboBoxButtonUI();
	}
	
	@Override
	public void installUI(JComponent c) {
		JButton button = (JButton) c;
		MaterialManagerListener.removeAllMaterialMouseListener(button);
		Icon icon = DownArrowIcon.builder()
				.withHeight(12)
				.withWidth(12)
				.withForeground(UIManager.getColor("ComboBox.foreground"))
				.build();
		button.setIcon(icon);
		button.setBackground(UIManager.getColor("MaterialSwing.accent1Color"));
		button.setForeground(UIManager.getColor("MaterialSwing.accent1Color"));
		button.setOpaque(false);
	}
	
	@Override
	public void uninstallUI(JComponent c) {
		super.uninstallUI(c);
		AbstractButton button = (AbstractButton) c;
		button.setBorder(null);
		button.setBackground(null);
		button.setForeground(null);
		button.setCursor(null);
	}

}
