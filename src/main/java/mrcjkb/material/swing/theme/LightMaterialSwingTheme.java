package mrcjkb.material.swing.theme;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

/**
 * Light material theme for the Swing Metal LAF.
 * @author Marc Jakobi (MAJ)
 */
public class LightMaterialSwingTheme extends AbstractMaterialSwingTheme {

	private static final ColorUIResource INACTIVE_COLOR = new ColorUIResource(Color.LIGHT_GRAY);

	private LightMaterialSwingTheme(Builder builder) {
		this.primary1 = builder.primary1;
		if (null == this.primary1) {
			this.primary1 = new ColorUIResource(50, 50, 50);
		}
		this.primary2 = builder.primary2;
		if (null == this.primary2) {
			int diff = 181;
			int r = limitRgbRange(this.primary1.getRed() + diff);
			int g = limitRgbRange(this.primary1.getGreen() + diff);
			int b = limitRgbRange(this.primary1.getBlue() + diff);
			this.primary2 = new ColorUIResource(r, g, b);
		}
		this.primary3 = builder.primary3;
		if (null == this.primary3) {
			this.primary3 = this.primary2;
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
			this.secondary3 = this.primary2;
		}
		this.accent1 = builder.accent1;
		if (null == this.accent1) {
			int diff = 181;
			int r = limitRgbRange(this.primary1.getRed() + diff);
			int g = limitRgbRange(this.primary1.getGreen() + diff);
			int b = limitRgbRange(this.primary1.getBlue() + diff);
			this.accent1 = new ColorUIResource(r, g, b);
		}
		this.accent2 = builder.accent2;
		if (null == this.accent2) {
			this.accent2 = new ColorUIResource(Color.GREEN);
		}
		this.hoverColor = builder.hoverColor;
		if (null == this.hoverColor) {
			this.hoverColor = new ColorUIResource(Color.LIGHT_GRAY.darker());
		}
		this.autohideScrollBars = builder.autohideScrollBars;
		applyUIManagerConfig();
	}

	@Override
	protected boolean isLightTheme() {
		return true;
	}
	
	protected void applyUIManagerConfig() {
		super.applyUIManagerConfig();
		UIManager.put("MenuItem.acceleratorForeground", getPrimary1());
		UIManager.put("CheckBoxMenuItem.acceleratorForeground", getPrimary1());
		UIManager.put("RadioButtonMenuItem.acceleratorForeground", getPrimary1());
		UIManager.put("ToggleButton.select", getPrimary1());
		UIManager.put("MaterialSwing.scrollbarPressedColor", getPrimary1());
		UIManager.put("Tree.selectionHighlight", Color.LIGHT_GRAY );
		UIManager.put("Tree.selectionBackground", getAccent1());
		UIManager.put("Tree.selectionBackgroundAlpha", 255);
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
		return getPrimary1();
	}

	@Override
	public ColorUIResource getWhite() {
		return WHITE;
	}
	
	/**
	 * Creates builder to build {@link LightMaterialSwingTheme}.
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link LightMaterialSwingTheme}.
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
		
		public LightMaterialSwingTheme build() {
			return new LightMaterialSwingTheme(this);
		}
	}
}
