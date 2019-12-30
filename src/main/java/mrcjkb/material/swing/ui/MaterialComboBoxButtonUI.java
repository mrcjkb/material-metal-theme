package mrcjkb.material.swing.ui;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicButtonUI;

import mrcjkb.material.swing.icon.combobox.DownArrowIcon;
import mrcjkb.material.swing.materialui.util.MaterialManagerListener;

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
				.withHeight(16)
				.withWidth(16)
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
