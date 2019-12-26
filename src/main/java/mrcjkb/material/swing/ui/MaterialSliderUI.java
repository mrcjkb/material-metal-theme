package mrcjkb.material.swing.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSliderUI;

import mrcjkb.material.swing.materialui.util.MaterialDrawingUtils;

public class MaterialSliderUI extends BasicSliderUI {

	private JSlider slider;
	
	public MaterialSliderUI(JSlider slider) {
		super(slider);
		this.slider = slider;
	}

	@Override
    public void paintTrack(Graphics g) {
        Graphics2D g2d = (Graphics2D) MaterialDrawingUtils.getAliasedGraphics(g);
        g2d.setPaint(slider.getForeground());
        if (slider.getOrientation() == SwingConstants.HORIZONTAL) {
            g2d.drawLine(trackRect.x, trackRect.y + trackRect.height / 2, 
                    trackRect.x + trackRect.width, trackRect.y + trackRect.height / 2);
        } else {
            g2d.drawLine(trackRect.x + trackRect.width / 2, trackRect.y, 
                    trackRect.x + trackRect.width / 2, trackRect.y + trackRect.height);
        }
    }
	
	@Override
	public void paintThumb(Graphics g)  {
		
		boolean isVertical = slider.getOrientation() == JSlider.VERTICAL;
		int radius = (isVertical ? thumbRect.height : thumbRect.width) / 2 - 1;
		
		g = MaterialDrawingUtils.getAliasedGraphics(g);

		int cx = thumbRect.x + thumbRect.width / 2;
		int cy = thumbRect.y + thumbRect.height / 2;
		Color accent1 = UIManager.getColor("MaterialSwing.accent1Color");
		if (isDragging()) {
			int add = 1;
			g.setColor(new Color(accent1.getRed(), accent1.getGreen(), accent1.getBlue(), 150));
			g.fillOval(cx - radius - add, cy - radius - add, (radius + add) * 2, (radius + add) * 2);
		}

		g.setColor(accent1);
		g.fillOval(cx - radius, cy - radius, radius * 2, radius * 2);

		// need to redraw loaded part of progress line
		Line loaded = getTrack(true);
		g.drawLine(loaded.x1, loaded.y1, loaded.x2, loaded.y2);
    }
	
	private Line getTrack(boolean loaded) {
		if (slider.getOrientation () == JSlider.HORIZONTAL) {
			Line left = new Line (trackRect.x, thumbRect.y + thumbRect.height / 2, thumbRect.x + thumbRect.width / 2, thumbRect.y + thumbRect.height / 2);
			Line right = new Line (thumbRect.x + thumbRect.width / 2, thumbRect.y + thumbRect.height / 2, trackRect.x + trackRect.width, thumbRect.y + thumbRect.height / 2);

			if (loaded) {
				return slider.getInverted () ? right : left;
			}
			else {
				return slider.getInverted () ? left : right;
			}
		} else {
			Line top = new Line (thumbRect.x + thumbRect.width / 2, trackRect.y, thumbRect.x + thumbRect.width / 2, thumbRect.y + thumbRect.height / 2);
			Line bottom = new Line (thumbRect.x + thumbRect.width / 2, thumbRect.y + thumbRect.height / 2, thumbRect.x + thumbRect.width / 2, trackRect.y + trackRect.height);

			if (loaded) {
				return slider.getInverted () ? top : bottom;
			}
			else {
				return slider.getInverted () ? bottom : top;
			}
		}
	}
	
	private static class Line {

		int x1, y1, x2, y2;

		Line (int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}
	
	public static ComponentUI createUI(JComponent c) {
		return new MaterialSliderUI((JSlider) c);
	}
}
