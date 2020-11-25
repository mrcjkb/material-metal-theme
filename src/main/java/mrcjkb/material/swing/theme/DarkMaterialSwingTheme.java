package mrcjkb.material.swing.theme;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

/**
 * Dark material theme for the Swing Metal LAF.
 * @author Marc Jakobi (MAJ)
 */
public class DarkMaterialSwingTheme extends AbstractMaterialSwingTheme {
	
	private static final ColorUIResource PANEL_FOREGROUND = new ColorUIResource(new Color(250, 250, 250));
	private static final ColorUIResource INACTIVE_COLOR = new ColorUIResource(Color.DARK_GRAY.brighter());

	private DarkMaterialSwingTheme(Builder builder) {
		this.primary1 = builder.primary1;
		if (null == this.primary1) {
			this.primary1 = new ColorUIResource(50, 50, 50);
		}
		this.primary2 = builder.primary2;
		if (null == this.primary2) {
			int diff = 14;
			int r = limitRgbRange(this.primary1.getRed() - diff);
			int g = limitRgbRange(this.primary1.getGreen() - diff);
			int b = limitRgbRange(this.primary1.getBlue() - diff);
			this.primary2 = new ColorUIResource(r, g, b);
		}
		this.primary3 = builder.primary3;
		if (null == this.primary3) {
			int diff = 49;
			int r = limitRgbRange(this.primary1.getRed() + diff);
			int g = limitRgbRange(this.primary1.getGreen() + diff);
			int b = limitRgbRange(this.primary1.getBlue() + diff);
			this.primary3 = new ColorUIResource(r, g, b);
		}
		this.secondary1 = builder.secondary1;
		if (null == this.secondary1) {
			this.secondary1 = this.primary1;
		}
		this.secondary2 = builder.secondary2;
		if (null == this.secondary2) {
			this.secondary2 = this.primary1;
		}
		this.secondary3 = builder.secondary3;
		if (null == this.secondary3) {
			this.secondary3 = this.primary1;
		}
		this.accent1 = builder.accent1;
		if (null == this.accent1) {
			this.accent1 = new ColorUIResource(Color.BLUE);
		}
		this.accent2 = builder.accent2;
		if (null == this.accent2) {
			this.accent2 = new ColorUIResource(Color.GREEN);
		}
		this.hoverColor = builder.hoverColor;
		if (null == this.hoverColor) {
			int diff = 150;
			int r = limitRgbRange(this.primary1.getRed() + diff);
			int g = limitRgbRange(this.primary1.getGreen() + diff);
			int b = limitRgbRange(this.primary1.getBlue() + diff);
			this.hoverColor = new ColorUIResource(r, g, b);
		}
		this.autohideScrollBars = builder.autohideScrollBars;
		this.applyIconSet = builder.applyIconSet;
		applyUIManagerConfig();
	}

	protected void applyUIManagerConfig() {
		super.applyUIManagerConfig();
		UIManager.getLookAndFeelDefaults().put("Frame.background", getPrimary2());
		UIManager.getLookAndFeelDefaults().put("Panel.background", getPrimary2());
		UIManager.getLookAndFeelDefaults().put("Panel.foreground", PANEL_FOREGROUND);
		UIManager.getLookAndFeelDefaults().put("Label.foreground", PANEL_FOREGROUND);
		UIManager.put("InternalFrame.background", getPrimary2());
		UIManager.put("TabbedPane.background", getPrimary2());
		UIManager.put("TabbedPane.foreground", PANEL_FOREGROUND);
		UIManager.put("TabbedPane.unselectedBackground", getPrimary2());
		UIManager.put("TabbedPane.unselectedForeground", PANEL_FOREGROUND);
		UIManager.put("ScrollPane.background", getPrimary2());
		UIManager.put("TextField.background", getSecondary3());
		UIManager.put("TextField.foreground", PANEL_FOREGROUND);
		UIManager.put("TextField.selectionForeground", getBlack());
		UIManager.put("TextField.inactiveBackground", getWhite());
		UIManager.put("TextField.inactiveForeground", INACTIVE_COLOR);
		UIManager.put("FormattedTextField.background", getSecondary3());
		UIManager.put("FormattedTextField.foreground", PANEL_FOREGROUND);
		UIManager.put("FormattedTextField.selectionForeground", getBlack());
		UIManager.put("FormattedTextField.inactiveBackground", getWhite());
		UIManager.put("FormattedTextField.inactiveForeground", INACTIVE_COLOR);
		UIManager.put("PasswordField.background", getSecondary3());
		UIManager.put("PasswordField.foreground", PANEL_FOREGROUND);
		UIManager.put("PasswordField.selectionForeground", getBlack());
		UIManager.put("PasswordField.inactiveBackground", getWhite());
		UIManager.put("PasswordField.inactiveForeground", INACTIVE_COLOR);
		UIManager.put("TextArea.background", getSecondary3());
		UIManager.put("TextArea.foreground", PANEL_FOREGROUND);
		UIManager.put("TextArea.selectionForeground", getBlack());
		UIManager.put("TextArea.inactiveBackground", getWhite());
		UIManager.put("TextArea.inactiveForeground", INACTIVE_COLOR);
		UIManager.put("TextPane.background", getSecondary3());
		UIManager.put("TextPane.foreground", PANEL_FOREGROUND);
		UIManager.put("TextPane.selectionForeground", getBlack());
		UIManager.put("TextPane.inactiveBackground", getWhite());
		UIManager.put("TextPane.inactiveForeground", INACTIVE_COLOR);
		UIManager.put("EditorPane.background", getSecondary3());
		UIManager.put("EditorPane.foreground", PANEL_FOREGROUND);
		UIManager.put("EditorPane.inactiveBackground", getWhite());
		UIManager.put("EditorPane.inactiveForeground", INACTIVE_COLOR);
		UIManager.put("ToolBar.background", getPrimary2());
		UIManager.put("SplitPane.background", getPrimary2());
		UIManager.put("MenuItem.background", getPrimary2());
		UIManager.put("MenuItem.selectionForeground", getBlack());
		UIManager.put("CheckBoxMenuItem.background", getPrimary2());
		UIManager.put("CheckBoxMenuItem.selectionForeground", getBlack());
		UIManager.put("RadioButtonMenuItem.background", getPrimary2());
		UIManager.put("RadioButtonMenuItem.selectionForeground", getBlack());
		UIManager.put("Menu.background", getPrimary2());
		UIManager.put("Menu.foreground", PANEL_FOREGROUND);
		UIManager.put("Menu.selectionForeground", getBlack());
		UIManager.put("MenuBar.selectionForeground", getBlack());
		UIManager.put("Menu.opaque", true);
		UIManager.put("MenuBar.opaque", true);
		UIManager.put("MenuBar.background", getPrimary2());
		UIManager.put("PopupMenu.background", getPrimary2());
		UIManager.put("PopupMenu.foreground", PANEL_FOREGROUND);
		UIManager.put("Separator.border", new ColorUIResource(new Color(0, 0, 0, 0)));
		UIManager.put("ComboBox.foreground", PANEL_FOREGROUND);
		UIManager.put("SpinnerButton.foreground", PANEL_FOREGROUND);
		UIManager.put("Tree.background", getSecondary3());
		UIManager.put("Tree.foreground", PANEL_FOREGROUND);
		UIManager.put("Tree.rendererBackgroundNonSelectionColor", getPrimary2());
		UIManager.put("Tree.textBackground", getSecondary3());
		UIManager.put("Tree.textForeground", PANEL_FOREGROUND);
		UIManager.put("Tree.selectionHighlight", getAccent1());
		UIManager.put("Tree.selectionBackground", Color.LIGHT_GRAY);
		UIManager.put("Tree.selectionBackgroundAlpha", 50);
		UIManager.put("CheckBox.background", getPrimary2());
		UIManager.put("CheckBox.foreground", PANEL_FOREGROUND);
		UIManager.put("RadioButton.background", getPrimary2());
		UIManager.put("RadioButton.foreground", PANEL_FOREGROUND);
		UIManager.put("OptionPane.background", getPrimary2());
		UIManager.put("OptionPane.foreground", PANEL_FOREGROUND);
		UIManager.put("OptionPane.messageForeground", PANEL_FOREGROUND);
		UIManager.put("Desktop.background", getPrimary2());
		UIManager.put("Viewport.background", getSecondary3());
		UIManager.put("Table.background", getSecondary3());
		UIManager.put("Table.foreground", Color.WHITE);
		UIManager.put("TableHeader.foreground", PANEL_FOREGROUND);
		UIManager.put("ScrollBar.thumbHighlight", getAccent1());
		UIManager.put("ScrollBar.thumbHighlight", getAccent1());
		UIManager.put("TitledBorder.titleColor", getBlack());
		UIManager.put("TitledBorder.border", BorderFactory.createEmptyBorder());
		UIManager.put("ToggleButton.foreground", Color.WHITE);
		UIManager.put("List.background", getSecondary3());
		UIManager.put("List.foreground", PANEL_FOREGROUND);
		UIManager.put("List.selectionForeground", PANEL_FOREGROUND);
		UIManager.put("ColorChooser.background", getPrimary2());
		UIManager.put("ColorChooser.background", PANEL_FOREGROUND);
		UIManager.put("FileChooser.background", getPrimary2());
		UIManager.put("FileChooser.background", PANEL_FOREGROUND);
		UIManager.put("Slider.background", getPrimary2());
		UIManager.put("MenuItem.acceleratorForeground", PANEL_FOREGROUND);
		UIManager.put("CheckBoxMenuItem.acceleratorForeground", PANEL_FOREGROUND);
		UIManager.put("RadioButtonMenuItem.acceleratorForeground", PANEL_FOREGROUND);
		UIManager.put("ToggleButton.select", getAccent1());
		UIManager.put("MaterialSwing.scrollbarPressedColor", getAccent1());
		UIManager.put("ToolTip.backgroundInactive", Color.DARK_GRAY);
		UIManager.put("ToolTip.foregroundInactive", Color.LIGHT_GRAY);
		UIManager.put("ToolTip.borderInactive", BorderFactory.createLineBorder(Color.DARK_GRAY));
		setInactiveColors(INACTIVE_COLOR);
	}
	

	@Override
	public ColorUIResource getControlTextColor() {
		return getPrimary1();
	}

	@Override
	public ColorUIResource getControlShadow() {
		return getPrimary1();
	}

	@Override
	public ColorUIResource getControlInfo() {
		return getPrimary1();
	}

	@Override
	public ColorUIResource getBlack() {
		return WHITE;
	}

	@Override
	public ColorUIResource getWhite() {
		return getPrimary1();
	}

	/**
	 * Creates builder to build {@link DarkMaterialSwingTheme}.
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link DarkMaterialSwingTheme}.
	 */
	public static final class Builder {
		private ColorUIResource primary1;
		private ColorUIResource primary2;
		private ColorUIResource primary3;
		private ColorUIResource secondary1;
		private ColorUIResource secondary2;
		private ColorUIResource secondary3;
		private ColorUIResource accent1;
		private ColorUIResource accent2;
		private ColorUIResource hoverColor;
		private boolean autohideScrollBars;
		private boolean applyIconSet;
		
		private Builder() {
		}

		public Builder withPrimary1(ColorUIResource primary1) {
			this.primary1 = primary1;
			return this;
		}

		public Builder withPrimary2(ColorUIResource primary2) {
			this.primary2 = primary2;
			return this;
		}

		public Builder withPrimary3(ColorUIResource primary3) {
			this.primary3 = primary3;
			return this;
		}

		public Builder withSecondary1(ColorUIResource secondary1) {
			this.secondary1 = secondary1;
			return this;
		}

		public Builder withSecondary2(ColorUIResource secondary2) {
			this.secondary2 = secondary2;
			return this;
		}

		public Builder withSecondary3(ColorUIResource secondary3) {
			this.secondary3 = secondary3;
			return this;
		}

		public Builder withAccent1(ColorUIResource accent1) {
			this.accent1 = accent1;
			return this;
		}

		public Builder withAccent2(ColorUIResource accent2) {
			this.accent2 = accent2;
			return this;
		}
		
		public Builder withHoverColor(ColorUIResource hoverColor) {
			this.hoverColor = hoverColor;
			return this;
		}
		
		public Builder withAutohideScrollBars(boolean autohideScrollBars) {
			this.autohideScrollBars = autohideScrollBars;
			return this;
		}

		public Builder applyIconSet(boolean applyIconSet) {
			this.applyIconSet = applyIconSet;
			return this;
		}

		public DarkMaterialSwingTheme build() {
			return new DarkMaterialSwingTheme(this);
		}
	}

	@Override
	protected boolean isLightTheme() {
		return false;
	}
}
