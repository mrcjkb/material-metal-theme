package mrcjkb.material.swing.icon.radiobutton;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;

/**
 * Unhecked radio button icon.
 */
public class RadioButtonUncheckedIcon implements javax.swing.Icon {

    /** The width of this icon. */
    private int width;

    /** The height of this icon. */
    private int height;

    /** The rendered image. */
    private BufferedImage image;
    
    private Color backgroundColor;
    
    private Color foregroundColor;

	private RadioButtonUncheckedIcon(Builder builder) {
		this.width = builder.width;
		this.height = builder.height;
		this.image = builder.image;
		this.backgroundColor = builder.backgroundColor;
		this.foregroundColor = builder.foregroundColor;
	}

    @Override
    public int getIconHeight() {
        return height;
    }

    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        if (image == null) {
            image = new BufferedImage(getIconWidth(), getIconHeight(), BufferedImage.TYPE_INT_ARGB);
            double coef = Math.min((double) width / (double) 1, (double) height / (double) 1);
            
            Graphics2D g2d = image.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.scale(coef, coef);
            paint(g2d);
            g2d.dispose();
        }
        
        g.drawImage(image, x, y, null);
    }

    /**
     * Paints the transcoded SVG image on the specified graphics context.
     * 
     * @param g Graphics context.
     */
    private void paint(Graphics2D g) {
        Shape shape = null;
        
        java.util.LinkedList<AffineTransform> transformations = new java.util.LinkedList<AffineTransform>();
        

        // 
        transformations.push(g.getTransform());
        g.transform(new AffineTransform(0.0625f, 0, 0, 0.0625f, 0, 0));

        // _0

        // _0_0

        // _0_0_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(8.0, 15.0);
        ((GeneralPath) shape).curveTo(4.14, 15.0, 1.0, 11.859, 1.0, 8.0);
        ((GeneralPath) shape).curveTo(1.0, 4.14, 4.14, 1.0, 8.0, 1.0);
        ((GeneralPath) shape).curveTo(11.859, 1.0, 15.0, 4.1400003, 15.0, 8.0);
        ((GeneralPath) shape).curveTo(15.0, 11.859, 11.859, 15.0, 8.0, 15.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(backgroundColor);
        g.fill(shape);

        // _0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(8.0, 2.0);
        ((GeneralPath) shape).curveTo(4.688, 2.0, 2.0, 4.688, 2.0, 8.0);
        ((GeneralPath) shape).curveTo(2.0, 11.312, 4.6879997, 14.0, 8.0, 14.0);
        ((GeneralPath) shape).curveTo(11.312, 14.0, 14.0, 11.312, 14.0, 8.0);
        ((GeneralPath) shape).curveTo(14.0, 4.688, 11.313, 2.0, 8.0, 2.0);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(8.0, 12.0);
        ((GeneralPath) shape).curveTo(2.666669, 12.0, 2.666669, 4.0, 8.0, 4.0);
        ((GeneralPath) shape).curveTo(13.333331, 4.0, 13.333331, 12.0, 8.0, 12.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(foregroundColor);
        g.fill(shape);

        // _0_0_2

        // _0_0_2_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(8.0, 4.0);
        ((GeneralPath) shape).curveTo(2.666669, 4.0, 2.666669, 12.0, 8.0, 12.0);
        ((GeneralPath) shape).curveTo(13.333331, 12.0, 13.333331, 4.0, 8.0, 4.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(backgroundColor);
        g.fill(shape);

        g.setTransform(transformations.pop()); // _0

    }

	/**
	 * Creates builder to build {@link RadioButtonUncheckedIcon}.
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link RadioButtonUncheckedIcon}.
	 */
	public static final class Builder {
		private int width = 18;
		private int height = 18;
		private BufferedImage image;
		private Color backgroundColor;
		private Color foregroundColor;

		private Builder() {
		}

		public Builder withWidth(int width) {
			this.width = width;
			return this;
		}

		public Builder withHeight(int height) {
			this.height = height;
			return this;
		}

		public Builder withImage(BufferedImage image) {
			this.image = image;
			return this;
		}

		public Builder withBackgroundColor(Color backgroundColor) {
			this.backgroundColor = backgroundColor;
			return this;
		}

		public Builder withForegroundColor(Color foregroundColor) {
			this.foregroundColor = foregroundColor;
			return this;
		}

		public RadioButtonUncheckedIcon build() {
			return new RadioButtonUncheckedIcon(this);
		}
	}
}

