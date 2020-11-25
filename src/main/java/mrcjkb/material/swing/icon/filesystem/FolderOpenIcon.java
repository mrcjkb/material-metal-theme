package mrcjkb.material.swing.icon.filesystem;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class FolderOpenIcon implements Icon {

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
    public FolderOpenIcon() {
        this(24, 24, UIManager.getColor("MaterialSwing.primary1Color"));
    }

    /**
     * Creates a new transcoded SVG image.
     * @param width the width
     * @param height the height
     * @param foreground the foreground color
     */
    public FolderOpenIcon(int width, int height, Color foreground) {
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

        LinkedList<AffineTransform> transformations = new LinkedList<>();


        //
        transformations.push(g.getTransform());
        g.transform(new AffineTransform(0.0625f, 0, 0, 0.0625f, 0, 0));

        // _0
        transformations.push(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 2.0108564f, 0.0086851f));

        // _0_0

        g.setTransform(transformations.pop()); // _0_0
        transformations.push(g.getTransform());
        g.transform(new AffineTransform(0.90677965f, 0, 0, 0.90677965f, -16.508474f, -0.30128425f));

        // _0_1
        transformations.push(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 19.028038f, 1.4636421f));

        // _0_1_0

        // _0_1_0_0
        shape = new GeneralPath();
        shape.moveTo(0.0, 3.9776852);
        shape.lineTo(0.0, 12.977685);
        shape.curveTo(0.0, 13.594685, 0.227, 14.079685, 0.57, 14.412685);
        shape.curveTo(1.14, 14.955686, 2.0, 14.977685, 2.0, 14.977685);
        shape.lineTo(13.677, 14.977685);
        shape.lineTo(16.0, 9.173685);
        shape.lineTo(16.0, 7.977685);
        shape.lineTo(15.0, 7.977685);
        shape.lineTo(15.0, 5.977685);
        shape.curveTo(15.0, 4.678685, 13.97, 3.977685, 13.0, 3.977685);
        shape.lineTo(10.116, 3.977685);
        shape.lineTo(9.116, 1.977685);
        shape.lineTo(2.0, 1.977685);
        shape.curveTo(1.005, 1.977685, 0.0, 2.674685, 0.0, 3.977685);
        shape.closePath();

        g.setPaint(Color.WHITE);
        g.fill(shape);

        // _0_1_0_1
        shape = new GeneralPath();
        shape.moveTo(2.0, 14.008685);
        shape.lineTo(13.0, 14.008685);
        shape.lineTo(15.0, 9.008685);
        shape.lineTo(15.0, 9.008685);
        shape.lineTo(14.0, 9.008685);
        shape.lineTo(14.0, 6.008685);
        shape.curveTo(14.0, 5.008685, 12.764, 5.008685, 13.0, 5.008685);
        shape.lineTo(9.5, 5.008685);
        shape.lineTo(8.5, 3.008685);
        shape.lineTo(2.0, 3.008685);
        shape.curveTo(2.0, 3.008685, 1.0, 3.008685, 1.0, 4.008685);
        shape.lineTo(1.0, 13.008685);
        shape.moveTo(1.0, 13.008685);
        shape.curveTo(1.0, 13.978685, 1.94, 13.992685, 1.997, 13.992685);
        shape.moveTo(1.997, 13.992685);
        shape.lineTo(2.0, 13.992685);
        shape.lineTo(2.0, 4.008685);
        shape.lineTo(8.0, 4.008685);
        shape.lineTo(9.0, 6.008685);
        shape.lineTo(13.0, 6.008685);
        shape.lineTo(13.0, 9.008685);
        shape.lineTo(13.0, 9.008685);
        shape.lineTo(4.0, 9.008685);
        shape.lineTo(2.0, 14.008685);

        g.setPaint(foreground);
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0 * origAlpha));
        transformations.push(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 2.0108564f, 0.0086851f));

        // _0_1_0_2
        shape = new GeneralPath();
        shape.moveTo(11.175584, 11.386511);
        shape.lineTo(0.8027033, 11.386511);
        shape.lineTo(0.8027033, 1.0136299);
        shape.lineTo(11.175584, 1.0136299);
        shape.closePath();

        g.setPaint(Color.WHITE);
        g.fill(shape);

        g.setTransform(transformations.pop()); // _0_1_0_2
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_1_0_3
        shape = new GeneralPath();
        shape.moveTo(1.9999994, 14.008685);
        shape.lineTo(13.0, 14.008685);
        shape.lineTo(14.999999, 9.008685);
        shape.lineTo(14.999999, 9.008685);
        shape.curveTo(10.317406, 8.993415, 11.134832, 8.994005, 4.0, 9.008685);
        shape.moveTo(1.9969994, 13.992685);
        shape.curveTo(6.629546, 10.664152, 26.902239, 9.008685, 3.9999995, 9.008685);

        g.setPaint(foreground);
        g.fill(shape);

        g.setTransform(transformations.pop()); // _0_1_0

        g.setTransform(transformations.pop()); // _0_1

        g.setTransform(transformations.pop()); // _0

    }
}

