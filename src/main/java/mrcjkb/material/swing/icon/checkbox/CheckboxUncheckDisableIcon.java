package mrcjkb.material.swing.icon.checkbox;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;

/**
 * Unchecked disabled checkbox icon.
 */
public class CheckboxUncheckDisableIcon implements Icon {

    /** The width of this icon. */
    private int width;

    /** The height of this icon. */
    private int height;

    /** The rendered image. */
    private BufferedImage image;
    
    private Color backgroundColor;
    
    private Color foregroundColor;

	private CheckboxUncheckDisableIcon(Builder builder) {
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
        
        float origAlpha = 1.0f;
        
        java.util.LinkedList<AffineTransform> transformations = new java.util.LinkedList<AffineTransform>();
        

        // 
        transformations.push(g.getTransform());
        g.transform(new AffineTransform(0.0625f, 0, 0, 0.0625f, 0, 0));

        // _0
        g.setComposite(AlphaComposite.getInstance(3, 0 * origAlpha));

        // _0_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(16.0, 16.0);
        ((GeneralPath) shape).lineTo(0.0, 16.0);
        ((GeneralPath) shape).lineTo(0.0, 0.0);
        ((GeneralPath) shape).lineTo(16.0, 0.0);
        ((GeneralPath) shape).lineTo(16.0, 16.0);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(16.0, 16.0);
        ((GeneralPath) shape).lineTo(0.0, 16.0);
        ((GeneralPath) shape).lineTo(0.0, 0.0);
        ((GeneralPath) shape).lineTo(16.0, 0.0);
        ((GeneralPath) shape).lineTo(16.0, 16.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(foregroundColor);
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(16.0, 16.0);
        ((GeneralPath) shape).lineTo(0.0, 16.0);
        ((GeneralPath) shape).lineTo(0.0, 0.0);
        ((GeneralPath) shape).lineTo(16.0, 0.0);
        ((GeneralPath) shape).lineTo(16.0, 16.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(backgroundColor);
        g.fill(shape);

        // _0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(7.707, 2.0);
        ((GeneralPath) shape).lineTo(9.292999, 2.0);
        ((GeneralPath) shape).lineTo(8.292999, 1.0);
        ((GeneralPath) shape).lineTo(6.707, 1.0);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(4.707, 2.0);
        ((GeneralPath) shape).lineTo(6.2929997, 2.0);
        ((GeneralPath) shape).lineTo(5.2929997, 1.0);
        ((GeneralPath) shape).lineTo(3.707, 1.0);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(12.292999, 2.0);
        ((GeneralPath) shape).lineTo(11.292999, 1.0);
        ((GeneralPath) shape).lineTo(9.707, 1.0);
        ((GeneralPath) shape).lineTo(10.707, 2.0);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(2.0, 2.793);
        ((GeneralPath) shape).lineTo(2.0, 2.0);
        ((GeneralPath) shape).lineTo(3.293, 2.0);
        ((GeneralPath) shape).lineTo(2.293, 1.0);
        ((GeneralPath) shape).lineTo(1.0, 1.0);
        ((GeneralPath) shape).lineTo(1.0, 1.793);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(14.0, 12.707);
        ((GeneralPath) shape).lineTo(14.0, 14.0);
        ((GeneralPath) shape).lineTo(13.207, 14.0);
        ((GeneralPath) shape).lineTo(14.207, 15.0);
        ((GeneralPath) shape).lineTo(15.0, 15.0);
        ((GeneralPath) shape).lineTo(15.0, 13.707);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(2.0, 5.793);
        ((GeneralPath) shape).lineTo(2.0, 4.207);
        ((GeneralPath) shape).lineTo(1.0, 3.2069998);
        ((GeneralPath) shape).lineTo(1.0, 4.7929997);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(14.0, 9.707001);
        ((GeneralPath) shape).lineTo(14.0, 11.293001);
        ((GeneralPath) shape).lineTo(15.0, 12.293001);
        ((GeneralPath) shape).lineTo(15.0, 10.707001);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(14.0, 3.7070007);
        ((GeneralPath) shape).lineTo(14.0, 5.2930007);
        ((GeneralPath) shape).lineTo(15.0, 6.2930007);
        ((GeneralPath) shape).lineTo(15.0, 4.707);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(14.0, 6.7070007);
        ((GeneralPath) shape).lineTo(14.0, 8.293001);
        ((GeneralPath) shape).lineTo(15.0, 9.293001);
        ((GeneralPath) shape).lineTo(15.0, 7.707);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(13.707, 2.0);
        ((GeneralPath) shape).lineTo(14.0, 2.0);
        ((GeneralPath) shape).lineTo(14.0, 2.293);
        ((GeneralPath) shape).lineTo(15.0, 3.293);
        ((GeneralPath) shape).lineTo(15.0, 1.0);
        ((GeneralPath) shape).lineTo(12.707, 1.0);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(2.293, 14.0);
        ((GeneralPath) shape).lineTo(2.0, 14.0);
        ((GeneralPath) shape).lineTo(2.0, 13.707);
        ((GeneralPath) shape).lineTo(1.0, 12.707);
        ((GeneralPath) shape).lineTo(1.0, 15.0);
        ((GeneralPath) shape).lineTo(3.293, 15.0);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(8.793, 14.0);
        ((GeneralPath) shape).lineTo(7.207, 14.0);
        ((GeneralPath) shape).lineTo(8.207, 15.0);
        ((GeneralPath) shape).lineTo(9.792999, 15.0);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(6.793, 15.0);
        ((GeneralPath) shape).lineTo(5.793, 14.0);
        ((GeneralPath) shape).lineTo(3.707, 14.0);
        ((GeneralPath) shape).lineTo(4.707, 15.0);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(2.0, 12.293);
        ((GeneralPath) shape).lineTo(2.0, 10.207001);
        ((GeneralPath) shape).lineTo(1.0, 9.207001);
        ((GeneralPath) shape).lineTo(1.0, 11.293001);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(11.793, 14.0);
        ((GeneralPath) shape).lineTo(10.207001, 14.0);
        ((GeneralPath) shape).lineTo(11.207001, 15.0);
        ((GeneralPath) shape).lineTo(12.793001, 15.0);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(2.0, 8.793);
        ((GeneralPath) shape).lineTo(2.0, 7.207);
        ((GeneralPath) shape).lineTo(1.0, 6.207);
        ((GeneralPath) shape).lineTo(1.0, 7.7929997);
        ((GeneralPath) shape).closePath();

        g.setPaint(foregroundColor);
        g.fill(shape);

        // _0_3

        // _0_3_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(2.0, 14.0);
        ((GeneralPath) shape).lineTo(14.0, 14.0);
        ((GeneralPath) shape).lineTo(14.0, 2.0);
        ((GeneralPath) shape).lineTo(2.0, 2.0);
        ((GeneralPath) shape).lineTo(2.0, 14.0);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(6.0, 8.0);
        ((GeneralPath) shape).lineTo(7.0, 10.0);
        ((GeneralPath) shape).lineTo(10.0, 4.0);
        ((GeneralPath) shape).lineTo(12.0, 4.0);
        ((GeneralPath) shape).lineTo(8.0, 12.0);
        ((GeneralPath) shape).lineTo(6.0, 12.0);
        ((GeneralPath) shape).lineTo(4.0, 8.0);
        ((GeneralPath) shape).lineTo(6.0, 8.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(backgroundColor);
        g.fill(shape);

        g.setTransform(transformations.pop()); // _0

    }

	/**
	 * Creates builder to build {@link CheckboxUncheckDisableIcon}.
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link CheckboxUncheckDisableIcon}.
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

		public CheckboxUncheckDisableIcon build() {
			return new CheckboxUncheckDisableIcon(this);
		}
	}
}

