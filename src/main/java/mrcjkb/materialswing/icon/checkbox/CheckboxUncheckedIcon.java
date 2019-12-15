package mrcjkb.materialswing.icon.checkbox;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;

import javax.swing.Icon;

/**
 * SVG icon for an unchecked checkbox.
 */
public class CheckboxUncheckedIcon implements Icon {

    /** The width of this icon. */
    private int width;

    /** The height of this icon. */
    private int height;
    
    /** The background color */
    private Color backgroundColor;
    
    /** The box color */
    private Color boxColor;

    /** The rendered image. */
    private BufferedImage image;

	private CheckboxUncheckedIcon(Builder builder) {
		this.width = builder.width;
		this.height = builder.height;
		this.backgroundColor = builder.backgroundColor;
		this.boxColor = builder.boxColor;
		this.image = builder.image;
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
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(0.5, 0.50000006);
        ((GeneralPath) shape).lineTo(15.5, 0.50000006);
        ((GeneralPath) shape).lineTo(15.5, 15.5);
        ((GeneralPath) shape).lineTo(0.5, 15.5);
        ((GeneralPath) shape).closePath();

        g.setPaint(backgroundColor);
        g.fill(shape);

        // _0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1.5, 1.5);
        ((GeneralPath) shape).lineTo(1.5, 14.5);
        ((GeneralPath) shape).lineTo(14.5, 14.5);
        ((GeneralPath) shape).lineTo(14.5, 1.5);
        ((GeneralPath) shape).closePath();

        g.setPaint(boxColor);
        g.fill(shape);

        // _0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(2.5, 2.5);
        ((GeneralPath) shape).lineTo(13.5, 2.5);
        ((GeneralPath) shape).lineTo(13.5, 13.5);
        ((GeneralPath) shape).lineTo(2.5, 13.5);
        ((GeneralPath) shape).closePath();

        g.setPaint(boxColor);
        g.fill(shape);

        // _0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(2.5, 13.5);
        ((GeneralPath) shape).lineTo(13.5, 13.5);
        ((GeneralPath) shape).lineTo(13.5, 2.5);
        ((GeneralPath) shape).lineTo(2.5, 2.5);
        ((GeneralPath) shape).closePath();

        g.setPaint(backgroundColor);
        g.fill(shape);

        g.setTransform(transformations.pop()); // _0

    }

	/**
	 * Creates builder to build {@link CheckboxUncheckedIcon}.
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link CheckboxUncheckedIcon}.
	 */
	public static final class Builder {
		private int width = 18;
		private int height = 18;
		private Color backgroundColor;
		private Color boxColor;
		private BufferedImage image;

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

		public Builder withBackgroundColor(Color backgroundColor) {
			this.backgroundColor = backgroundColor;
			return this;
		}

		public Builder withBoxColor(Color boxColor) {
			this.boxColor = boxColor;
			return this;
		}

		public Builder withImage(BufferedImage image) {
			this.image = image;
			return this;
		}

		public CheckboxUncheckedIcon build() {
			return new CheckboxUncheckedIcon(this);
		}
	}
}

