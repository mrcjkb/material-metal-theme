package mrcjkb.material.swing.icon.checkbox;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;

/**
 * SVG icon for a checked checkbox.
 */
public class CheckboxCheckedIcon implements Icon {

    /** The width of this icon. */
    private int width;

    /** The height of this icon. */
    private int height;
    
    private Color backgroundColor;
    
    private Color boxColor;
    
    private Color checkColor;

    /** The rendered image. */
    private BufferedImage image;

	private CheckboxCheckedIcon(Builder builder) {
		this.width = builder.width;
		this.height = builder.height;
		this.backgroundColor = builder.backgroundColor;
		this.boxColor = builder.boxColor;
		this.checkColor = builder.checkColor;
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
        g.transform(new AffineTransform(1, 0, 0, 1, -20.364407f, 5.923729f));

        // _0_0

        // _0_0_0
        shape = new GeneralPath();
        shape.moveTo(20.864407, -5.423729);
        shape.lineTo(35.864407, -5.423729);
        shape.lineTo(35.864407, 9.576271);
        shape.lineTo(20.864407, 9.576271);
        shape.closePath();

        g.setPaint(backgroundColor);
        g.fill(shape);

        // _0_0_1
        shape = new GeneralPath();
        shape.moveTo(21.864407, -4.423729);
        shape.lineTo(21.864407, 8.576271);
        shape.lineTo(34.864407, 8.576271);
        shape.lineTo(34.864407, -4.423729);
        shape.closePath();

        g.setPaint(boxColor);
        g.fill(shape);

        // _0_0_2
        shape = new GeneralPath();
        shape.moveTo(22.864407, -3.4237287);
        shape.lineTo(33.864407, -3.4237287);
        shape.lineTo(33.864407, 7.576271);
        shape.lineTo(22.864407, 7.576271);
        shape.closePath();

        g.setPaint(boxColor);
        g.fill(shape);

        // _0_0_3
        shape = new GeneralPath();
        shape.moveTo(22.864407, 7.5762715);
        shape.lineTo(33.864407, 7.5762715);
        shape.lineTo(33.864407, -3.4237285);
        shape.lineTo(22.864407, -3.4237285);
        shape.closePath();
        shape.moveTo(25.117407, 2.4232717);
        shape.lineTo(26.864407, 4.1692715);
        shape.lineTo(31.411407, -0.37672853);
        shape.lineTo(32.11841, 0.33027148);
        shape.lineTo(26.864408, 5.583271);
        shape.lineTo(24.410408, 3.130271);
        shape.closePath();

        g.setPaint(backgroundColor);
        g.fill(shape);

        // _0_0_4
        shape = new GeneralPath();
        shape.moveTo(26.864407, 5.583271);
        shape.lineTo(24.410406, 3.130271);
        shape.lineTo(25.117407, 2.423271);
        shape.lineTo(26.864407, 4.169271);
        shape.lineTo(31.411407, -0.376729);
        shape.lineTo(32.11841, 0.330271);
        shape.closePath();

        g.setPaint(checkColor);
        g.fill(shape);

        g.setTransform(transformations.pop()); // _0_0

        g.setTransform(transformations.pop()); // _0

    }

	/**
	 * Creates builder to build {@link CheckboxCheckedIcon}.
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link CheckboxCheckedIcon}.
	 */
	public static final class Builder {
		private int width = 18;
		private int height = 18;
		private Color backgroundColor;
		private Color boxColor;
		private Color checkColor;
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

		public Builder withCheckColor(Color checkColor) {
			this.checkColor = checkColor;
			return this;
		}

		public Builder withImage(BufferedImage image) {
			this.image = image;
			return this;
		}

		public CheckboxCheckedIcon build() {
			return new CheckboxCheckedIcon(this);
		}
	}
}

