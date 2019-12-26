package mrcjkb.material.swing.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicRadioButtonUI;

import mrcjkb.material.swing.icon.radiobutton.RadioButtonCheckedIcon;
import mrcjkb.material.swing.icon.radiobutton.RadioButtonUncheckedIcon;
import mrcjkb.material.swing.materialui.util.MaterialDrawingUtils;
import mrcjkb.material.swing.materialui.util.MaterialManagerListener;
import mrcjkb.material.swing.materialui.util.MaterialUIMovement;

public class MaterialRadioButtonUI extends BasicRadioButtonUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialRadioButtonUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);
		JRadioButton radioButton = (JRadioButton) c;
		radioButton.setFont(UIManager.getFont ("RadioButton.font"));
		radioButton.setBackground(UIManager.getColor("RadioButton.background"));
		radioButton.setForeground(UIManager.getColor("RadioButton.foreground"));
		setDefaultIcons(radioButton);
		radioButton.addMouseListener(MaterialUIMovement.getMovement(radioButton, UIManager.getColor("MaterialSwing.accent2Color")));
	}

	/**
	 * Sets the default Material-Metal-Theme icons.
	 * @param radioButton the radio button to apply the icons to.
	 */
	public static void setDefaultIcons(JRadioButton radioButton) {
		radioButton.setIcon(RadioButtonUncheckedIcon.builder()
				.withBackgroundColor(radioButton.getBackground())
				.withForegroundColor(radioButton.getForeground())
				.build());
		radioButton.setSelectedIcon(RadioButtonCheckedIcon.builder()
				.withBackgroundColor(radioButton.getBackground())
				.withOuterCircleColor(radioButton.getForeground())
				.withInnerCircleColor(UIManager.getColor("MaterialSwing.accent2Color"))
				.build());
		radioButton.setDisabledIcon(RadioButtonUncheckedIcon.builder()
				.withBackgroundColor(radioButton.getBackground())
				.withForegroundColor(UIManager.getColor("MaterialSwing.uiDisabledColor"))
				.build());
		radioButton.setDisabledSelectedIcon(RadioButtonCheckedIcon.builder()
				.withBackgroundColor(radioButton.getBackground())
				.withOuterCircleColor(UIManager.getColor("MaterialSwing.uiDisabledColor"))
				.withInnerCircleColor(UIManager.getColor("MaterialSwing.uiDisabledColor"))
				.build());
	}

	@Override
	public void uninstallUI(JComponent c) {

		c.setFont (null);
		c.setBackground (null);
		c.setForeground (null);
		c.setBorder (null);
		c.setCursor(null);

		JRadioButton radioButton = (JRadioButton) c;
		radioButton.setIcon(null);
		radioButton.setSelectedIcon(null);
		MaterialManagerListener.removeAllMaterialMouseListener(radioButton);

		super.uninstallUI(c);
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
	}

	@Override
	protected void paintFocus(Graphics g, Rectangle t, Dimension d) {
	}
}