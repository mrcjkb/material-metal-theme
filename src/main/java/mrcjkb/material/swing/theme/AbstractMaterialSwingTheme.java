package mrcjkb.material.swing.theme;


import java.awt.Color;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;

import mrcjkb.material.swing.ui.MaterialButtonUI;
import mrcjkb.material.swing.ui.MaterialCheckBoxMenuItemUI;
import mrcjkb.material.swing.ui.MaterialCheckBoxUI;
import mrcjkb.material.swing.ui.MaterialComboBoxUI;
import mrcjkb.material.swing.ui.MaterialProgressBarUI;
import mrcjkb.material.swing.ui.MaterialRadioButtonMenuItemUI;
import mrcjkb.material.swing.ui.MaterialRadioButtonUI;
import mrcjkb.material.swing.ui.MaterialScrollBarUI;
import mrcjkb.material.swing.ui.MaterialScrollPaneUI;
import mrcjkb.material.swing.ui.MaterialSliderUI;
import mrcjkb.material.swing.ui.MaterialSpinnerUI;
import mrcjkb.material.swing.ui.MaterialTabbedPaneUI;
import mrcjkb.material.swing.ui.MaterialTableHeaderUI;
import mrcjkb.material.swing.ui.MaterialTableUI;
import mrcjkb.material.swing.ui.MaterialToggleButtonUI;

/**
 * Abstract class for the material Metal Theme
 * @author Marc Jakobi (MAJ)
 */
public abstract class AbstractMaterialSwingTheme extends DefaultMetalTheme {

	protected static final ColorUIResource WHITE = new ColorUIResource(Color.WHITE);
	private static final int LINE_BORDER_WIDTH = 2;
	public static final int BUTTON_BORDER_MARGIN = 5;
	
	protected ColorUIResource primary1;
	protected ColorUIResource primary2;
	protected ColorUIResource primary3;
	protected ColorUIResource secondary1;
	protected ColorUIResource secondary2;
	protected ColorUIResource secondary3;
	protected ColorUIResource accent1;
	protected ColorUIResource accent2;
	protected ColorUIResource hoverColor;
	protected boolean autohideScrollBars; // Experimental
	
	
	@Override
	protected ColorUIResource getPrimary1() { return primary1; }
	@Override
	protected ColorUIResource getPrimary2() { return primary2; }
	@Override
	protected ColorUIResource getPrimary3() { return primary3; }

	@Override
	protected ColorUIResource getSecondary1() { return secondary1; }
	@Override
	protected ColorUIResource getSecondary2() { return secondary2; }
	@Override
	protected ColorUIResource getSecondary3() { return secondary3; }
	
	protected ColorUIResource getAccent1() { return accent1; };
	protected ColorUIResource getAccent2() { return accent2; };
	protected ColorUIResource getHoverColor() { return hoverColor; };
	
	protected void applyUIManagerConfig() {
		
		UIManager.put("ButtonUI", MaterialButtonUI.class.getName());
		UIManager.put("Button.foreground", getBlack());
		UIManager.put("Button.background", isLightTheme() ? Color.LIGHT_GRAY : new Color(getPrimary2().getRed(), getPrimary2().getBlue(), getPrimary2().getGreen()));
		UIManager.put("Button.highlight", Color.LIGHT_GRAY);
		UIManager.put("Button.select", new Color(getAccent1().getRed(), getAccent1().getBlue(), getAccent1().getGreen()));
		UIManager.put("Button.disabledText", isLightTheme() ? Color.GRAY : Color.LIGHT_GRAY);
		Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, LINE_BORDER_WIDTH);
		Border margin = new EmptyBorder(BUTTON_BORDER_MARGIN, BUTTON_BORDER_MARGIN, BUTTON_BORDER_MARGIN, BUTTON_BORDER_MARGIN);
		UIManager.put("Button.border", new CompoundBorder(border, margin));
		
		UIManager.put("ToggleButtonUI", MaterialToggleButtonUI.class.getName());
		UIManager.put("ToggleButton.background", isLightTheme() ? Color.LIGHT_GRAY : new Color(getSecondary3().getRed(), getSecondary3().getBlue(), getSecondary3().getGreen()));
		UIManager.put("ToggleButton.highlight", Color.LIGHT_GRAY);
		UIManager.put("Button.disabledText", isLightTheme() ? Color.GRAY : Color.LIGHT_GRAY);
		UIManager.put("ToggleButton.border", new CompoundBorder(border, margin));
		UIManager.put("ToggleButton.disabledText", Color.LIGHT_GRAY);

		UIManager.put("MaterialSwing.accent1Color", getAccent1());
		UIManager.put("MaterialSwing.accent2Color", getAccent2());
		UIManager.put("MaterialSwing.hoverColor", getHoverColor());
		UIManager.put("MaterialSwing.uiDisabledColor", new ColorUIResource(147, 147, 147));
		UIManager.put("MaterialSwing.lineBorderWidth", LINE_BORDER_WIDTH);
		UIManager.put("CheckBoxUI", MaterialCheckBoxUI.class.getName());
		UIManager.put("CheckBoxMenuItemUI", MaterialCheckBoxMenuItemUI.class.getName());
		UIManager.put("RadioButtonUI", MaterialRadioButtonUI.class.getName());
		UIManager.put("RadioButtonMenuItemUI", MaterialRadioButtonMenuItemUI.class.getName());

		UIManager.put("ComboBoxUI", MaterialComboBoxUI.class.getName());
		UIManager.put("ComboBox.buttonBackground", isLightTheme() ? getWhite() : getSecondary3());
		UIManager.put("ComboBox.background", isLightTheme() ? getWhite() : getSecondary3());
		UIManager.put("ComboBox.buttonShadow", isLightTheme() ? Color.LIGHT_GRAY : getSecondary3());
		UIManager.put("ComboBox.buttonDarkShadow", getBlack());
		UIManager.put("ComboBox.buttonHighlight", isLightTheme() ? Color.LIGHT_GRAY : getBlack());
		UIManager.put("ComboBox.disabledBackground", isLightTheme() ? Color.WHITE : getSecondary3());
		UIManager.put("ComboBox.disabledSelectionBackground", isLightTheme() ? Color.LIGHT_GRAY : Color.DARK_GRAY);
		UIManager.put("ComboBox.disabledForeground", Color.LIGHT_GRAY);
		UIManager.put("ComboBox.selectionForeground", getBlack());
		UIManager.put("ComboBox.selectionBackground", getAccent1());
		UIManager.put("control", isLightTheme() ? Color.LIGHT_GRAY : Color.DARK_GRAY);
		UIManager.put("controlShadow", new ColorUIResource(new Color(0, 0, 0, 0)));
		UIManager.put("controlDkShadow", new ColorUIResource(new Color(0, 0, 0, 0)));
		UIManager.put("controlLtHighlight", new ColorUIResource(new Color(0, 0, 0, 0)));

		UIManager.put("ScrollPaneUI", MaterialScrollPaneUI.class.getName());
		UIManager.put("ScrollBarUI", MaterialScrollBarUI.class.getName());
		UIManager.put("ScrollBar.track", getSecondary3());
		UIManager.put("ScrollBar.trackHighlightForeground", Color.LIGHT_GRAY);
		UIManager.put("scrollbar", isLightTheme() ? Color.LIGHT_GRAY : Color.DARK_GRAY);
		UIManager.put("ScrollBar.thumb", getAccent1());
		UIManager.put("ScrollBar.background", getPrimary2());
		UIManager.put("ScrollBar.thumbDarkShadow", new ColorUIResource(Color.LIGHT_GRAY));
		UIManager.put("ScrollBar.thumbShadow", new ColorUIResource(Color.LIGHT_GRAY));
		UIManager.put("ScrollBar.thumbHighlight", new ColorUIResource(Color.LIGHT_GRAY));
		UIManager.put("ScrollBar.trackForeground", new ColorUIResource(Color.LIGHT_GRAY));
		UIManager.put("ScrollBar.trackHighlight", new ColorUIResource(Color.LIGHT_GRAY));
		UIManager.put("ScrollBar.foreground", new ColorUIResource(Color.LIGHT_GRAY));
		UIManager.put("ScrollBar.highlight", new ColorUIResource(Color.LIGHT_GRAY));
		UIManager.put("ScrollBar.width", 10);
		UIManager.put("ScrollBar.border", BorderFactory.createEmptyBorder());

		UIManager.put("TextField.selectionBackground", new ColorUIResource(getAccent1()));
		UIManager.put("FormattedTextField.selectionBackground", isLightTheme() ? Color.LIGHT_GRAY : getAccent1());
		UIManager.put("FormattedTextField.selectionColor", getAccent1());
		UIManager.put("TextArea.selectionBackground", getAccent1());

		UIManager.put("TabbedPane.selectHighlight", new ColorUIResource(isLightTheme() ? Color.LIGHT_GRAY : getAccent1()));
		UIManager.put("TabbedPane.selected", new ColorUIResource(isLightTheme() ? Color.LIGHT_GRAY : getAccent1()));
		UIManager.put("TabbedPane.disabled", getPrimary1());
		UIManager.put("TabbedPane.selectedForeground", getBlack());
		UIManager.put("TabbedPane.borderHightlightColor", new ColorUIResource(new Color(0, 0, 0, 0)));
		Insets insets = UIManager.getInsets("TabbedPane.contentBorderInsets");
		insets.top = -1;
		UIManager.put("TabbedPaneUI", MaterialTabbedPaneUI.class.getName());
		UIManager.put("Separator.foreground", new ColorUIResource(isLightTheme() ? getPrimary1() : getPrimary1()));
		UIManager.put("Separator.background", new ColorUIResource(new Color(0, 0, 0, 0)));
		UIManager.put("Menu.selectionBackground", new ColorUIResource(getAccent1()));
		UIManager.put("Menu.border", BorderFactory.createLineBorder(new ColorUIResource(new Color(0, 0, 0, 0)), LINE_BORDER_WIDTH));
		UIManager.put("MenuItem.border", BorderFactory.createLineBorder(new ColorUIResource(new Color(0, 0, 0, 0)), LINE_BORDER_WIDTH));
		UIManager.put("MenuItem.height", UIManager.getInt("MenuItem.height") + 4);
		UIManager.put("MenuItem.selectionBackground", new ColorUIResource(isLightTheme() ? getPrimary1().brighter() : getAccent1()));
		UIManager.put("MenuItem.foreground", getBlack());
		UIManager.put("MenuItem.acceleratorSelectionForeground", new ColorUIResource(Color.WHITE));
		UIManager.put("CheckBoxMenuItem.selectionBackground", new ColorUIResource(isLightTheme() ? getPrimary1().brighter() : getAccent1()));
		UIManager.put("CheckBoxMenuItem.foreground", getBlack());
		UIManager.put("CheckBoxMenuItem.acceleratorSelectionForeground", new ColorUIResource(Color.WHITE));
		UIManager.put("CheckBoxMenuItem.border", BorderFactory.createLineBorder(new ColorUIResource(new Color(0, 0, 0, 0)), LINE_BORDER_WIDTH));
		UIManager.put("RadioButtonMenuItem.selectionBackground", new ColorUIResource(isLightTheme() ? getPrimary1().brighter() : getAccent1()));
		UIManager.put("RadioButtonMenuItem.foreground", getBlack());
		UIManager.put("RadioButtonMenuItem.acceleratorSelectionForeground", new ColorUIResource(Color.WHITE));
		UIManager.put("RadioButtonMenuItem.border", BorderFactory.createLineBorder(new ColorUIResource(new Color(0, 0, 0, 0)), LINE_BORDER_WIDTH));
		
		UIManager.put("List.selectionBackground", new ColorUIResource(getAccent1()));
		UIManager.put("List.focusCellHighlightBorder", BorderFactory.createEmptyBorder());

		UIManager.put("TableUI", MaterialTableUI.class.getName());
		UIManager.put("TableHeader.cellBorder", BorderFactory.createEmptyBorder());
		UIManager.put("Table.selectionForeground", Color.WHITE);
		UIManager.put("Table.dropCellBackground", Color.LIGHT_GRAY);
		UIManager.put("TableHeaderUI", MaterialTableHeaderUI.class.getName());

		UIManager.put("ToolTip.background", isLightTheme() ? Color.WHITE : getPrimary1());
		UIManager.put("ToolTip.foreground", isLightTheme() ? Color.BLACK : Color.WHITE);
		UIManager.put("ToolTip.border", BorderFactory.createLineBorder(isLightTheme() ? getPrimary1() : WHITE, LINE_BORDER_WIDTH));

		UIManager.put("ToolBar.background", new ColorUIResource(new Color(0, 0, 0, 0)));
		UIManager.put("ToolBar.border", BorderFactory.createLineBorder(new ColorUIResource(new Color(0, 0, 0, 0)), LINE_BORDER_WIDTH));
		
		Color progressBarColor = new ColorUIResource(isLightTheme() ? getPrimary1() : getAccent1());
		UIManager.put("ProgressBar.foreground", progressBarColor);
		UIManager.put("ProgressBar.background", isLightTheme() ? Color.WHITE : getPrimary1());
		UIManager.put("ProgressBar.border", BorderFactory.createEmptyBorder());
		UIManager.put("ProgressBarUI", MaterialProgressBarUI.class.getName());
		
		UIManager.put("SliderUI", MaterialSliderUI.class.getName());
		UIManager.put("Slider.foreground", getBlack());

		UIManager.put("TitledBorder.border", BorderFactory.createLineBorder(isLightTheme() ? Color.LIGHT_GRAY : Color.DARK_GRAY, LINE_BORDER_WIDTH));

		Border textBorder = BorderFactory.createLineBorder(isLightTheme() ? getWhite(): Color.LIGHT_GRAY, LINE_BORDER_WIDTH);
		UIManager.put("TextField.border", textBorder);
		UIManager.put("FormattedTextField.border", textBorder);
		UIManager.put("PasswordField.border", textBorder);
		UIManager.put("ComboBox.border", textBorder);
		
		UIManager.put("TextField.caretForeground", getBlack());
		UIManager.put("FormattedTextField.caretForeground", getBlack());
		UIManager.put("PasswordField.caretForeground", getBlack());
		UIManager.put("TextArea.caretForeground", getBlack());
		UIManager.put("TextPane.caretForeground", getBlack());
		UIManager.put("EditorPane.caretForeground", getBlack());
		UIManager.put("Label.caretForeground", getBlack());
		
		UIManager.put("TaskPaneContainer.background", isLightTheme() ? Color.LIGHT_GRAY : getBlack());
		UIManager.put("TaskPane.titleBackgroundGradientStart", getPrimary1());
		UIManager.put("TaskPane.titleBackgroundGradientEnd", getPrimary1());
		UIManager.put("TaskPane.borderColor", getPrimary1());
		UIManager.put("TaskPane.titleForeground", Color.WHITE);
		UIManager.put("TaskPane.titleBackground", Color.WHITE);
		UIManager.put("TaksPane.specialTitleBackground", Color.WHITE);
		UIManager.put("TaskPane.specialTitleForeground", Color.WHITE);
		
		UIManager.put("ScrollPane.border", BorderFactory.createEmptyBorder());
		UIManager.put("MaterialSwing.autohideScrollBars", autohideScrollBars);
		
		UIManager.put("SpinnerUI", MaterialSpinnerUI.class.getName());
	}
	
	protected void setInactiveColors(ColorUIResource inactiveColor) {
		UIManager.put("TextField.inactiveForeground", inactiveColor);
		UIManager.put("FormattedTextField.inactiveForeground", inactiveColor);
		UIManager.put("TextArea.inactiveForeground", inactiveColor);
		UIManager.put("Label.disabledForeground", inactiveColor);
		UIManager.put("Label.inactiveForeground", inactiveColor);
		UIManager.put("Table.disabledForeground", inactiveColor);
		UIManager.put("Table.inactiveForeground", inactiveColor);
	}
	
	protected abstract boolean isLightTheme();
	
	public static int limitRgbRange(int rgbValue) {
		return Math.max(0,  Math.min(255, rgbValue));
	}
}