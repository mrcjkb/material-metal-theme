package mrcjkb.material.swing.icon.radiobutton;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;

/**
 * Checked radio button icon.
 */
public class RadioButtonCheckedIcon implements Icon {

    /** The width of this icon. */
    private int width;

    /** The height of this icon. */
    private int height;
    
    private Color backgroundColor;
    
    private Color outerCircleColor;
    
    private Color innerCircleColor;

    /** The rendered image. */
    private BufferedImage image;

	private RadioButtonCheckedIcon(Builder builder) {
		this.width = builder.width;
		this.height = builder.height;
		this.backgroundColor = builder.backgroundColor;
		this.outerCircleColor = builder.outerCircleColor;
		this.innerCircleColor = builder.innerCircleColor;
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
        GeneralPath shape;
        
        java.util.LinkedList<AffineTransform> transformations = new java.util.LinkedList<>();
        

        // 
        transformations.push(g.getTransform());
        g.transform(new AffineTransform(0.0625f, 0, 0, 0.0625f, 0, 0));

        // _0
        transformations.push(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, -19.050846f, -0.13559322f));

        // _0_0
        transformations.push(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 19.050846f, 0.13559322f));

        // _0_0_0

        // _0_0_0_0
        shape = new GeneralPath();
        shape.moveTo(8.0, 15.0);
        shape.curveTo(4.14, 15.0, 1.0, 11.859, 1.0, 8.0);
        shape.curveTo(1.0, 4.14, 4.14, 1.0, 8.0, 1.0);
        shape.curveTo(11.859, 1.0, 15.0, 4.1400003, 15.0, 8.0);
        shape.curveTo(15.0, 11.859, 11.859, 15.0, 8.0, 15.0);
        shape.closePath();

        g.setPaint(backgroundColor);
        g.fill(shape);

        // _0_0_0_1
        shape = new GeneralPath();
        shape.moveTo(8.0, 2.0);
        shape.curveTo(4.688, 2.0, 2.0, 4.688, 2.0, 8.0);
        shape.curveTo(2.0, 11.312, 4.6879997, 14.0, 8.0, 14.0);
        shape.curveTo(11.312, 14.0, 14.0, 11.312, 14.0, 8.0);
        shape.curveTo(14.0, 4.688, 11.313, 2.0, 8.0, 2.0);
        shape.closePath();

        g.setPaint(outerCircleColor);
        g.fill(shape);

        // _0_0_0_2
        shape = new GeneralPath();
        shape.moveTo(8.0, 12.0);
        shape.curveTo(5.790861, 12.0, 4.0, 10.209139, 4.0, 8.0);
        shape.curveTo(4.0, 5.790861, 5.790861, 4.0, 8.0, 4.0);
        shape.curveTo(10.209139, 4.0, 12.0, 5.790861, 12.0, 8.0);
        shape.curveTo(12.0, 10.209139, 10.209139, 12.0, 8.0, 12.0);
        shape.closePath();

        g.fill(shape);

        // _0_0_0_3
        shape = new GeneralPath();
        shape.moveTo(9.948642, 7.9547844);
        shape.curveTo(9.965036, 8.679791, 9.587688, 9.356872, 8.962465, 9.724295);
        shape.curveTo(8.337241, 10.091719, 7.5621104, 10.091912, 6.936703, 9.724801);
        shape.curveTo(6.311296, 9.357691, 5.93361, 8.6807995, 5.9496417, 7.9557843);
        shape.curveTo(5.9736753, 6.8689036, 6.8615065, 6.0002704, 7.9486527, 5.9999986);
        shape.curveTo(9.035799, 5.999727, 9.924065, 6.867916, 9.948642, 7.9547844);
        shape.closePath();

        g.setPaint(innerCircleColor);
        g.fill(shape);

        // _0_0_0_4

        // _0_0_0_4_0
        shape = new GeneralPath();
        shape.moveTo(8.0, 4.0);
        shape.curveTo(5.790861, 4.0, 4.0, 5.790861, 4.0, 8.0);
        shape.curveTo(4.0, 10.209139, 5.790861, 12.0, 8.0, 12.0);
        shape.curveTo(10.209139, 12.0, 12.0, 10.209139, 12.0, 8.0);
        shape.curveTo(12.0, 5.790861, 10.209139, 4.0, 8.0, 4.0);
        shape.closePath();
        shape.moveTo(8.0, 10.0);
        shape.curveTo(7.2749925, 10.016395, 6.597913, 9.639047, 6.2304893, 9.0138235);
        shape.curveTo(5.863066, 8.388599, 5.862872, 7.6134686, 6.229983, 6.9880614);
        shape.curveTo(6.5970936, 6.362654, 7.2739844, 5.984968, 7.999, 6.001);
        shape.curveTo(9.08588, 6.0250335, 9.954514, 6.9128647, 9.954786, 8.000011);
        shape.curveTo(9.955058, 9.087157, 9.086868, 9.975423, 8.0, 10.0);
        shape.closePath();

        g.setPaint(backgroundColor);
        g.fill(shape);

        g.setTransform(transformations.pop()); // _0_0_0

        g.setTransform(transformations.pop()); // _0_0

        g.setTransform(transformations.pop()); // _0

    }

	/**
	 * Creates builder to build {@link RadioButtonCheckedIcon}.
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link RadioButtonCheckedIcon}.
	 */
	public static final class Builder {
		private int width = 18;
		private int height = 18;
		private Color backgroundColor;
		private Color outerCircleColor;
		private Color innerCircleColor;
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

		public Builder withOuterCircleColor(Color outerCircleColor) {
			this.outerCircleColor = outerCircleColor;
			return this;
		}

		public Builder withInnerCircleColor(Color innerCircleColor) {
			this.innerCircleColor = innerCircleColor;
			return this;
		}

		public Builder withImage(BufferedImage image) {
			this.image = image;
			return this;
		}

		public RadioButtonCheckedIcon build() {
			return new RadioButtonCheckedIcon(this);
		}
	}
}

