package mrcjk.material.swing.materialui.util;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import mrcjkb.materialswing.icon.checkbox.CheckboxCheckedIcon;
import mrcjkb.materialswing.icon.checkbox.CheckboxUncheckedIcon;
import mrcjkb.materialswing.icon.radiobutton.RadioButtonCheckedIcon;
import mrcjkb.materialswing.icon.radiobutton.RadioButtonUncheckedIcon;

public class MaterialUITimer implements MouseListener, ActionListener, MouseMotionListener {

    private Color from, to;
    private boolean forward;
    private int alpha, steps;
    private int[] forwardDeltas, backwardDeltas;

    private JComponent component;
    private Timer timer;

    protected MaterialUITimer(JComponent component, Color to, int steps, int interval) {
        if (component == null) {
            return;
        }
        if(component.getCursor().getType() == Cursor.WAIT_CURSOR){
            return;
        }
        component.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        if(component instanceof JButton){
            JButton button = (JButton) component;
            if (button.isDefaultButton()){
                this.from = UIManager.getColor("Button[Default].background");
            }else{
                this.from = component.getBackground();
            }
        }else{
            this.from = component.getBackground();
        }
        if (null == this.from) {
        	this.from = new ColorUIResource(new Color(0, 0, 0, 0));
        }
        this.to = to;

        this.forwardDeltas = new int[4];
        this.backwardDeltas = new int[4];

        forwardDeltas[0] = (from.getRed() - to.getRed()) / steps;
        forwardDeltas[1] = (from.getGreen() - to.getGreen()) / steps;
        forwardDeltas[2] = (from.getBlue() - to.getBlue()) / steps;
        forwardDeltas[3] = (from.getAlpha() - to.getAlpha()) / steps;

        backwardDeltas[0] = (to.getRed() - from.getRed()) / steps;
        backwardDeltas[1] = (to.getGreen() - from.getGreen()) / steps;
        backwardDeltas[2] = (to.getBlue() - from.getBlue()) / steps;
        backwardDeltas[3] = (to.getAlpha() - from.getAlpha()) / steps;

        this.steps = steps;

        this.component = component;
        //this.component.addMouseListener(this);
        timer = new Timer(interval, this);
        component.setBackground(from);
    }

    private Color nextColor() {
        int rValue = from.getRed() - alpha * forwardDeltas[0];
        int gValue = from.getGreen() - alpha * forwardDeltas[1];
        int bValue = from.getBlue() - alpha * forwardDeltas[2];
        int aValue = from.getAlpha() - alpha * forwardDeltas[3];

        return new Color(rValue, gValue, bValue, aValue);
    }

    private Color previousColor() {
        int rValue = to.getRed() - (steps - alpha) * backwardDeltas[0];
        int gValue = to.getGreen() - (steps - alpha) * backwardDeltas[1];
        int bValue = to.getBlue() - (steps - alpha) * backwardDeltas[2];
        int aValue = to.getAlpha() - (steps - alpha) * backwardDeltas[3];

        return new Color(rValue, gValue, bValue, aValue);
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (!me.getComponent().isEnabled() || null == timer || !component.isEnabled()) {
            return;
        }
        alpha = steps - 1;
        forward = false;
        if(timer.isRunning()){
            timer.stop();
        }
        timer.start();

        alpha = 0;
        forward = true;
        timer.start();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //do nothing
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        //do nothing
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (!me.getComponent().isEnabled() || null == timer || !component.isEnabled()) {
            return;
        }
        if (timer.isRunning()){
            timer.stop();
        }
        alpha = steps - 1;
        forward = false;
        timer.start();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (!me.getComponent().isEnabled() || null == timer || !component.isEnabled()) {
            return;
        }
        alpha = 0;
        forward = true;
        if (timer.isRunning()){
            timer.stop();
        }
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (forward) {
        	if (component instanceof JCheckBox) {
        		setCheckboxIconBackground((JCheckBox) component, nextColor());
        	} else if (component instanceof JRadioButton) {
        		setRadioButtonIconBackground((JRadioButton) component, nextColor());
        	} else {
        		component.setBackground(nextColor());
        	}
            ++alpha;
        } else {
        	if (component instanceof JCheckBox) {
        		setCheckboxIconBackground((JCheckBox) component, previousColor());
        	} else if (component instanceof JRadioButton) {
        		setRadioButtonIconBackground((JRadioButton) component, previousColor());
        	} else {
        		component.setBackground(previousColor());
        	}
            --alpha;
        }

        if (alpha == steps + 1 || alpha == -1) {
            if(timer.isRunning()){
                timer.stop();
            }
        }
    }
    
    /**
     * Set the icon background of a check box
     * @param checkBox
     * @param color
     */
    private static void setCheckboxIconBackground(JCheckBox checkBox, Color color) {
    	checkBox.setIcon(CheckboxUncheckedIcon.builder()
				.withBackgroundColor(color)
				.withBoxColor(checkBox.getForeground())
				.build());
		checkBox.setSelectedIcon(CheckboxCheckedIcon.builder()
				.withBackgroundColor(color)
				.withBoxColor(checkBox.getForeground())
				.withCheckColor(UIManager.getColor("MaterialSwing.accent2Color"))
				.build());
    }
    
    /**
     * Set the icon background of a radio button
     * @param radioButton
     * @param color
     */
    private static void setRadioButtonIconBackground(JRadioButton radioButton, Color color) {
    	radioButton.setIcon(RadioButtonUncheckedIcon.builder()
				.withBackgroundColor(color)
				.withForegroundColor(radioButton.getForeground())
				.build());
		radioButton.setSelectedIcon(RadioButtonCheckedIcon.builder()
				.withBackgroundColor(color)
				.withOuterCircleColor(radioButton.getForeground())
				.withInnerCircleColor(UIManager.getColor("MaterialSwing.accent2Color"))
				.build());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //do nothing this is util only implements interface MouseMotions
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //do nothing this is util only implements interface MouseMotions
    }
}