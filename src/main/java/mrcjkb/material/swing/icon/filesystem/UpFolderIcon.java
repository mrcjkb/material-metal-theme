package mrcjkb.material.swing.icon.filesystem;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class UpFolderIcon implements Icon {

    /** The foreground color of the icon */
    private final Color foreground;

    /** The accent color of the icon */
    private final Color accent;

    /** The width of this icon. */
    private final int width;

    /** The height of this icon. */
    private final int height;

    /** The rendered image. */
    private BufferedImage image;

    /**
     * Creates a new transcoded SVG image.
     */
    public UpFolderIcon() {
        this(24, 24, UIManager.getColor("MaterialSwing.primary1Color"), UIManager.getColor("MaterialSwing.accent1Color"));
    }

    /**
     * Creates a new transcoded SVG image.
     */
    public UpFolderIcon(int width, int height, Color foreground, Color accent) {
        this.width = width;
        this.height = height;
        this.foreground = foreground;
        this.accent = accent;
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

        g.getComposite();

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
        transformations.push(g.getTransform());
        g.transform(new AffineTransform(1.0153685f, 0, 0, 1.0153685f, 3.1476429f, 0.9812588f));

        // _0_1_0_0
        transformations.push(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 12.445829f, -6.1375823f));

        // _0_1_0_0_0

        // _0_1_0_0_0_0
        transformations.push(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 4.3916445f, 0));

        // _0_1_0_0_0_0_0
        transformations.push(g.getTransform());
        g.transform(new AffineTransform(0.9819766f, 0, 0, 0.9819766f, -19.914373f, 4.8899975f));

        // _0_1_0_0_0_0_0_0

        // _0_1_0_0_0_0_0_0_0
        shape = new GeneralPath();
        shape.moveTo(14.5, 0.0);
        shape.lineTo(6.39, 0.0);
        shape.lineTo(5.39, 2.0);
        shape.lineTo(2.504, 2.0);
        shape.curveTo(1.677, 2.0, 1.0, 2.673, 1.0, 3.5);
        shape.lineTo(1.0, 15.414);
        shape.lineTo(3.0, 13.414);
        shape.lineTo(3.0, 16.0);
        shape.lineTo(7.0, 16.0);
        shape.lineTo(7.0, 13.414);
        shape.lineTo(9.0, 15.414);
        shape.lineTo(9.0, 13.0);
        shape.lineTo(14.5, 13.0);
        shape.curveTo(15.327, 13.0, 16.0, 12.327, 16.0, 11.5);
        shape.lineTo(16.0, 1.5);
        shape.curveTo(16.0, 0.673, 15.327, 0.0, 14.5, 0.0);
        shape.closePath();

        g.setPaint(Color.WHITE);
        g.fill(shape);

        g.setTransform(transformations.pop()); // _0_1_0_0_0_0_0_0

        // _0_1_0_0_0_0_0_1
        shape = new GeneralPath();
        shape.moveTo(-5.6757126, 5.871974);
        shape.lineTo(-13.032682, 5.871974);
        shape.lineTo(-14.014658, 7.835927);
        shape.lineTo(-17.455503, 7.835927);
        shape.curveTo(-17.727533, 7.835381, -17.9488, 8.054891, -17.95042, 8.326916);
        shape.lineTo(-17.95042, 14.299297);
        shape.lineTo(-15.006455, 11.357295);
        shape.lineTo(-11.076584, 15.285201);
        shape.lineTo(-11.076584, 16.673717);
        shape.lineTo(-5.6757126, 16.673717);
        shape.curveTo(-5.545494, 16.673717, -5.420609, 16.621988, -5.328531, 16.52991);
        shape.curveTo(-5.2364526, 16.437832, -5.184724, 16.312946, -5.1847243, 16.182728);
        shape.lineTo(-5.1847243, 6.3629622);
        shape.curveTo(-5.1847243, 6.091797, -5.404547, 5.871974, -5.6757126, 5.871974);
        shape.closePath();
        shape.moveTo(-6.166701, 7.835927);
        shape.lineTo(-12.541693, 7.835927);
        shape.lineTo(-12.050705, 6.8539505);
        shape.lineTo(-6.166701, 6.8539505);
        shape.closePath();

        g.setPaint(foreground);
        g.fill(shape);

        // _0_1_0_0_0_0_0_2
        shape = new GeneralPath();
        shape.moveTo(-12.058561, 15.69174);
        shape.lineTo(-15.004492, 12.74581);
        shape.lineTo(-17.95042, 15.69174);
        shape.lineTo(-17.95042, 17.655693);
        shape.lineTo(-15.986468, 15.69174);
        shape.lineTo(-15.986468, 19.619646);
        shape.lineTo(-14.022514, 19.619646);
        shape.lineTo(-14.022514, 15.69174);
        shape.lineTo(-12.058561, 17.655693);
        shape.closePath();

        g.setPaint(accent);
        g.fill(shape);

        g.setTransform(transformations.pop()); // _0_1_0_0_0_0_0

        g.setTransform(transformations.pop()); // _0_1_0_0_0

        g.setTransform(transformations.pop()); // _0_1_0_0

        g.setTransform(transformations.pop()); // _0_1_0

        g.setTransform(transformations.pop()); // _0_1

        g.setTransform(transformations.pop()); // _0

    }
}

