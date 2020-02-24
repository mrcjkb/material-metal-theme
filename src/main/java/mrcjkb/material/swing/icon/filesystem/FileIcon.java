package mrcjkb.material.swing.icon.filesystem;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class FileIcon implements Icon {

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
    public FileIcon() {
        this(24, 24, UIManager.getColor("MaterialSwing.primary1Color"));
    }

    /**
     * Creates a new transcoded SVG image.
     */
    public FileIcon(int width, int height, Color foreground) {
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


        LinkedList<AffineTransform> transformations = new LinkedList<>();


        //
        transformations.push(g.getTransform());
        g.transform(new AffineTransform(0.0625f, 0, 0, 0.0625f, 0, 0));

        // _0
        transformations.push(g.getTransform());
        g.transform(new AffineTransform(0.84609437f, 0, 0, 0.84609437f, 1.4878573f, 1.3119057f));

        // _0_0

        // _0_0_0
        transformations.push(g.getTransform());
        g.transform(new AffineTransform(0.9962585f, 0, 0, 0.9962585f, -16.56813f, -23.772976f));

        // _0_0_0_0

        // _0_0_0_0_0
        shape = new GeneralPath();
        shape.moveTo(31.652542, 39.79661);
        shape.lineTo(18.652542, 39.79661);
        shape.lineTo(18.652542, 23.796612);
        shape.lineTo(27.273542, 23.796612);
        shape.lineTo(31.652542, 28.175611);
        shape.closePath();

        g.setPaint(Color.WHITE);
        g.fill(shape);

        // _0_0_0_0_1
        shape = new GeneralPath();
        shape.moveTo(29.652542, 37.79661);
        shape.lineTo(20.652542, 37.79661);
        shape.lineTo(20.652542, 25.796612);
        shape.lineTo(25.652542, 25.796612);
        shape.lineTo(25.652542, 29.796612);
        shape.lineTo(29.652542, 29.796612);
        shape.closePath();
        shape.moveTo(26.652542, 28.796612);
        shape.lineTo(26.652542, 26.003613);
        shape.lineTo(29.445541, 28.796612);
        shape.closePath();

        g.fill(shape);

        // _0_0_0_0_2
        shape = new GeneralPath();
        shape.moveTo(19.652542, 24.79661);
        shape.lineTo(19.652542, 38.796608);
        shape.lineTo(30.652542, 38.796608);
        shape.lineTo(30.652542, 28.589607);
        shape.lineTo(26.859543, 24.796608);
        shape.closePath();
        shape.moveTo(29.652542, 37.796608);
        shape.lineTo(20.652542, 37.796608);
        shape.lineTo(20.652542, 25.796608);
        shape.lineTo(25.652542, 25.796608);
        shape.lineTo(25.652542, 29.796608);
        shape.lineTo(29.652542, 29.796608);
        shape.closePath();
        shape.moveTo(26.652542, 28.796608);
        shape.lineTo(26.652542, 26.003609);
        shape.lineTo(29.445541, 28.796608);
        shape.closePath();

        g.setPaint(foreground);
        g.fill(shape);

        g.setTransform(transformations.pop()); // _0_0_0_0
        transformations.push(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 0.2417624f, -0.42494765f));

        // _0_0_0_1

        g.setTransform(transformations.pop()); // _0_0_0_1
        transformations.push(g.getTransform());
        g.transform(new AffineTransform(1.1819013f, 0, 0, 1.1819013f, -8.177217f, -2.3824382f));

        // _0_0_1

        g.setTransform(transformations.pop()); // _0_0_1

        g.setTransform(transformations.pop()); // _0_0

        g.setTransform(transformations.pop()); // _0

    }
}

