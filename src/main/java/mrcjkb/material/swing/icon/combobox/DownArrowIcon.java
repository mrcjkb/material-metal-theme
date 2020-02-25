package mrcjkb.material.swing.icon.combobox;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;

public class DownArrowIcon implements Icon {

    /** The width of this icon. */
    private int width;

    /** The height of this icon. */
    private int height;

    /** The rendered image. */
    private BufferedImage image;
    
    private Color foreground;

	private DownArrowIcon(Builder builder) {
		this.width = builder.width;
		this.height = builder.height;
		this.image = builder.image;
		this.foreground = builder.foreground;
	}

    /**
     * Creates a new transcoded SVG image.
     */
    public DownArrowIcon() {
        this(1, 1);
    }

    /**
     * Creates a new transcoded SVG image.
     */
    public DownArrowIcon(int width, int height) {
        this.width = width;
        this.height = height;
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
        transformations.push(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 20.506098f, -0.4861358f));

        // _0_0

        // _0_0_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-18.894884, 5.399658);
        ((GeneralPath) shape).lineTo(-6.1173086, 5.2566986);
        ((GeneralPath) shape).lineTo(-12.354725, 11.715573);
        ((GeneralPath) shape).closePath();

        g.setPaint(foreground);
        g.fill(shape);
        transformations.push(g.getTransform());
        g.transform(new AffineTransform(0.7193312f, 0.6946673f, -0.6946673f, 0.7193312f, -13.378003f, -4.3394237f));

        // _0_0_1

        // _0_0_1_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(11.0, 10.0);
        ((GeneralPath) shape).lineTo(5.344, 10.0);
        ((GeneralPath) shape).lineTo(11.0, 4.414);
        ((GeneralPath) shape).closePath();

        g.setPaint(foreground);
        g.fill(shape);

        g.setTransform(transformations.pop()); // _0_0_1

        g.setTransform(transformations.pop()); // _0_0

        g.setTransform(transformations.pop()); // _0

    }

	/**
	 * Creates builder to build {@link DownArrowIcon}.
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link DownArrowIcon}.
	 */
	public static final class Builder {
		private int width = 1;
		private int height = 1;
		private BufferedImage image;
		private Color foreground;

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

		public Builder withForeground(Color foreground) {
			this.foreground = foreground;
			return this;
		}

		public DownArrowIcon build() {
			return new DownArrowIcon(this);
		}
	}
}
