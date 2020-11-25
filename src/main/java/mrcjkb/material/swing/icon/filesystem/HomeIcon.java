package mrcjkb.material.swing.icon.filesystem;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import static java.awt.Color.WHITE;

public class HomeIcon implements Icon {

    /** The foreground color of the icon */
    private final Color foreground;

    /** The width of this icon. */
    private final int width;

    /** The height of this icon. */
    private final int height;

    /** The rendered image. */
    private BufferedImage image;

    /**
     * Creates a new transcoded SVG image.
     */
    public HomeIcon() {
        this(24, 24, UIManager.getColor("MaterialSwing.primary1Color"));
    }

    /**
     * Creates a new transcoded SVG image.
     * @param width the width
     * @param height the height
     * @param foreground the foreground color
     */
    public HomeIcon(int width, int height, Color foreground) {
        this.width = width;
        this.height = height;
        this.foreground = foreground;
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

        float origAlpha = 1.0f;
        Composite origComposite = g.getComposite();
        if (origComposite instanceof AlphaComposite) {
            AlphaComposite origAlphaComposite = (AlphaComposite)origComposite;
            if (origAlphaComposite.getRule() == AlphaComposite.SRC_OVER) {
                origAlpha = origAlphaComposite.getAlpha();
            }
        }

        LinkedList<AffineTransform> transformations = new LinkedList<>();


        //
        transformations.push(g.getTransform());
        g.transform(new AffineTransform(0.0625f, 0, 0, 0.0625f, 0, 0));

        // _0
        transformations.push(g.getTransform());
        g.transform(new AffineTransform(-0.8333033f, 0, 0, -0.8333033f, 14.666426f, 14.666426f));

        // _0_0
        transformations.push(g.getTransform());
        g.transform(new AffineTransform(-0.908931f, 0, 0, -0.908931f, 4.857255f, 16.195784f));

        // _0_0_0
        g.setComposite(AlphaComposite.getInstance(3, 0 * origAlpha));

        // _0_0_0_0
        shape = new GeneralPath();
        shape.moveTo(4.5423727, 17.016949);
        shape.lineTo(-11.457627, 17.016949);
        shape.lineTo(-11.457627, 1.0169492);
        shape.lineTo(4.5423727, 1.0169492);
        shape.closePath();

        g.setPaint(WHITE);
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_0_1
        shape = new GeneralPath();
        shape.moveTo(4.5423727, 8.895949);
        shape.lineTo(4.5423727, 10.430949);
        shape.lineTo(3.5423727, 11.430949);
        shape.lineTo(3.5423727, 17.016949);
        shape.lineTo(-10.457627, 17.016949);
        shape.lineTo(-10.457627, 11.430948);
        shape.lineTo(-11.457627, 10.430948);
        shape.lineTo(-11.457627, 8.895949);
        shape.lineTo(-3.578627, 1.0169492);
        shape.lineTo(-3.336627, 1.0169492);
        shape.closePath();

        g.setPaint(Color.WHITE);
        g.fill(shape);

        // _0_0_0_2
        shape = new GeneralPath();
        shape.moveTo(1.542373, 15.016949);
        shape.lineTo(-1.457627, 15.016949);
        shape.lineTo(-1.457627, 10.016949);
        shape.lineTo(-5.4576273, 10.016949);
        shape.lineTo(-5.4576273, 15.016949);
        shape.lineTo(-8.457627, 15.016949);
        shape.lineTo(-8.457627, 8.723949);
        shape.lineTo(-3.4576273, 3.7239494);
        shape.lineTo(1.5423727, 8.723949);
        shape.closePath();

        g.fill(shape);

        // _0_0_0_3
        shape = new GeneralPath();
        shape.moveTo(-10.811627, 9.66295);
        shape.lineTo(-10.104628, 10.369949);
        shape.lineTo(-9.457627, 9.723949);
        shape.lineTo(-9.457627, 16.016949);
        shape.lineTo(-4.4576273, 16.016949);
        shape.lineTo(-4.4576273, 11.016949);
        shape.lineTo(-2.4576273, 11.016949);
        shape.lineTo(-2.4576273, 16.016949);
        shape.lineTo(2.5423727, 16.016949);
        shape.lineTo(2.5423727, 9.723949);
        shape.lineTo(3.1883726, 10.369949);
        shape.lineTo(3.8953726, 9.66295);
        shape.lineTo(-3.4576275, 2.3099494);
        shape.closePath();
        shape.moveTo(1.542373, 15.016949);
        shape.lineTo(-1.457627, 15.016949);
        shape.lineTo(-1.457627, 10.016949);
        shape.lineTo(-5.4576273, 10.016949);
        shape.lineTo(-5.4576273, 15.016949);
        shape.lineTo(-8.457627, 15.016949);
        shape.lineTo(-8.457627, 8.723949);
        shape.lineTo(-3.4576273, 3.7239494);
        shape.lineTo(1.5423727, 8.723949);
        shape.closePath();

        g.setPaint(foreground);
        g.fill(shape);

        g.setTransform(transformations.pop()); // _0_0_0

        g.setTransform(transformations.pop()); // _0_0

        g.setTransform(transformations.pop()); // _0
    }
}

