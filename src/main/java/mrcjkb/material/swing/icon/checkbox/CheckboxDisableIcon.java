package mrcjkb.material.swing.icon.checkbox;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;

/**
 * Disabled checkbox icon.
 */
public class CheckboxDisableIcon implements Icon {

    /** The width of this icon. */
    private int width;

    /** The height of this icon. */
    private int height;
    
    private Color backgroundColor;
    
    private Color foregroundColor;

    /** The rendered image. */
    private BufferedImage image;

	private CheckboxDisableIcon(Builder builder) {
		this.width = builder.width;
		this.height = builder.height;
		this.backgroundColor = builder.backgroundColor;
		this.foregroundColor = builder.foregroundColor;
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
        ((GeneralPath) shape).moveTo(11.764, 4.471);
        ((GeneralPath) shape).lineTo(11.235, 5.5280004);
        ((GeneralPath) shape).lineTo(9.901999, 4.1950006);
        ((GeneralPath) shape).lineTo(9.999999, 4.0000005);
        ((GeneralPath) shape).lineTo(11.292999, 4.0000005);
        ((GeneralPath) shape).lineTo(11.763999, 4.4710007);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(7.707, 2.0000002);
        ((GeneralPath) shape).lineTo(9.292999, 2.0000002);
        ((GeneralPath) shape).lineTo(8.292999, 1.0000002);
        ((GeneralPath) shape).lineTo(6.7069993, 1.0000002);
        ((GeneralPath) shape).lineTo(7.7069993, 2.0000002);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(4.707, 2.0000002);
        ((GeneralPath) shape).lineTo(6.2929997, 2.0000002);
        ((GeneralPath) shape).lineTo(5.2929997, 1.0000002);
        ((GeneralPath) shape).lineTo(3.7069998, 1.0000002);
        ((GeneralPath) shape).lineTo(4.707, 2.0000002);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(9.431, 5.1380005);
        ((GeneralPath) shape).lineTo(8.901999, 6.1950006);
        ((GeneralPath) shape).lineTo(10.235, 7.528001);
        ((GeneralPath) shape).lineTo(10.764, 6.4710007);
        ((GeneralPath) shape).lineTo(9.431, 5.1380005);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(12.292999, 2.0000005);
        ((GeneralPath) shape).lineTo(11.292999, 1.0000005);
        ((GeneralPath) shape).lineTo(9.706999, 1.0000005);
        ((GeneralPath) shape).lineTo(10.706999, 2.0000005);
        ((GeneralPath) shape).lineTo(12.292999, 2.0000005);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(1.999999, 2.7930005);
        ((GeneralPath) shape).lineTo(1.999999, 2.0000005);
        ((GeneralPath) shape).lineTo(3.292999, 2.0000005);
        ((GeneralPath) shape).lineTo(2.292999, 1.0000005);
        ((GeneralPath) shape).lineTo(0.99999905, 1.0000005);
        ((GeneralPath) shape).lineTo(0.99999905, 1.7930005);
        ((GeneralPath) shape).lineTo(1.999999, 2.7930005);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(13.999999, 12.707);
        ((GeneralPath) shape).lineTo(13.999999, 14.0);
        ((GeneralPath) shape).lineTo(13.206999, 14.0);
        ((GeneralPath) shape).lineTo(14.206999, 15.0);
        ((GeneralPath) shape).lineTo(14.999999, 15.0);
        ((GeneralPath) shape).lineTo(14.999999, 13.707);
        ((GeneralPath) shape).lineTo(13.999999, 12.707);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(6.7929993, 12.0);
        ((GeneralPath) shape).lineTo(5.2069993, 10.414);
        ((GeneralPath) shape).lineTo(5.999999, 12.0);
        ((GeneralPath) shape).lineTo(6.7929993, 12.0);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(7.2639995, 9.471);
        ((GeneralPath) shape).lineTo(6.9999995, 10.0);
        ((GeneralPath) shape).lineTo(6.207, 8.414);
        ((GeneralPath) shape).lineTo(5.7929997, 7.9999995);
        ((GeneralPath) shape).lineTo(4.207, 7.9999995);
        ((GeneralPath) shape).lineTo(8.069, 11.8619995);
        ((GeneralPath) shape).lineTo(8.598001, 10.804999);
        ((GeneralPath) shape).lineTo(7.2640004, 9.471);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(8.431, 7.1379995);
        ((GeneralPath) shape).lineTo(7.7359996, 8.528999);
        ((GeneralPath) shape).lineTo(9.068999, 9.8619995);
        ((GeneralPath) shape).lineTo(9.763999, 8.471);
        ((GeneralPath) shape).lineTo(8.430999, 7.1379995);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(1.9999995, 5.7929993);
        ((GeneralPath) shape).lineTo(1.9999995, 4.2069993);
        ((GeneralPath) shape).lineTo(0.9999995, 3.2069993);
        ((GeneralPath) shape).lineTo(0.9999995, 4.7929993);
        ((GeneralPath) shape).lineTo(1.9999995, 5.7929993);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(14.0, 9.706999);
        ((GeneralPath) shape).lineTo(14.0, 11.292999);
        ((GeneralPath) shape).lineTo(15.0, 12.292999);
        ((GeneralPath) shape).lineTo(15.0, 10.706999);
        ((GeneralPath) shape).lineTo(14.0, 9.706999);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(14.0, 3.7069988);
        ((GeneralPath) shape).lineTo(14.0, 5.292999);
        ((GeneralPath) shape).lineTo(15.0, 6.292999);
        ((GeneralPath) shape).lineTo(15.0, 4.706999);
        ((GeneralPath) shape).lineTo(14.0, 3.7069988);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(14.0, 6.706999);
        ((GeneralPath) shape).lineTo(14.0, 8.292999);
        ((GeneralPath) shape).lineTo(15.0, 9.292999);
        ((GeneralPath) shape).lineTo(15.0, 7.7069993);
        ((GeneralPath) shape).lineTo(14.0, 6.7069993);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(13.707, 1.999999);
        ((GeneralPath) shape).lineTo(14.0, 1.999999);
        ((GeneralPath) shape).lineTo(14.0, 2.292999);
        ((GeneralPath) shape).lineTo(15.0, 3.292999);
        ((GeneralPath) shape).lineTo(15.0, 0.99999905);
        ((GeneralPath) shape).lineTo(12.707, 0.99999905);
        ((GeneralPath) shape).lineTo(13.707, 1.999999);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(2.2930002, 13.999999);
        ((GeneralPath) shape).lineTo(2.0000002, 13.999999);
        ((GeneralPath) shape).lineTo(2.0000002, 13.706999);
        ((GeneralPath) shape).lineTo(1.0000002, 12.706999);
        ((GeneralPath) shape).lineTo(1.0000002, 14.999999);
        ((GeneralPath) shape).lineTo(3.2930002, 14.999999);
        ((GeneralPath) shape).lineTo(2.2930002, 13.999999);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(8.793, 13.999999);
        ((GeneralPath) shape).lineTo(7.2070003, 13.999999);
        ((GeneralPath) shape).lineTo(8.207001, 14.999999);
        ((GeneralPath) shape).lineTo(9.793001, 14.999999);
        ((GeneralPath) shape).lineTo(8.793001, 13.999999);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(6.793, 14.999999);
        ((GeneralPath) shape).lineTo(5.793, 13.999999);
        ((GeneralPath) shape).lineTo(3.7070003, 13.999999);
        ((GeneralPath) shape).lineTo(4.7070003, 14.999999);
        ((GeneralPath) shape).lineTo(6.793, 14.999999);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(2.0, 12.292999);
        ((GeneralPath) shape).lineTo(2.0, 10.206999);
        ((GeneralPath) shape).lineTo(1.0, 9.206999);
        ((GeneralPath) shape).lineTo(1.0, 11.292999);
        ((GeneralPath) shape).lineTo(2.0, 12.292999);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(11.793, 13.999999);
        ((GeneralPath) shape).lineTo(10.207001, 13.999999);
        ((GeneralPath) shape).lineTo(11.207001, 14.999999);
        ((GeneralPath) shape).lineTo(12.793001, 14.999999);
        ((GeneralPath) shape).lineTo(11.793001, 13.999999);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(2.0, 8.792999);
        ((GeneralPath) shape).lineTo(2.0, 7.2069993);
        ((GeneralPath) shape).lineTo(1.0, 6.2069993);
        ((GeneralPath) shape).lineTo(1.0, 7.7929993);
        ((GeneralPath) shape).lineTo(2.0, 8.792999);
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
	 * Creates builder to build {@link CheckboxDisableIcon}.
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link CheckboxDisableIcon}.
	 */
	public static final class Builder {
		private int width = 18;
		private int height = 18;
		private Color backgroundColor;
		private Color foregroundColor;
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

		public Builder withForegroundColor(Color foregroundColor) {
			this.foregroundColor = foregroundColor;
			return this;
		}

		public Builder withImage(BufferedImage image) {
			this.image = image;
			return this;
		}

		public CheckboxDisableIcon build() {
			return new CheckboxDisableIcon(this);
		}
	}
}

