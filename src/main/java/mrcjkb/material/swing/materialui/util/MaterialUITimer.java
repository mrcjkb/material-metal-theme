package mrcjkb.material.swing.materialui.util;

import mrcjkb.material.swing.icon.checkbox.CheckboxCheckedIcon;
import mrcjkb.material.swing.icon.checkbox.CheckboxUncheckedIcon;
import mrcjkb.material.swing.icon.radiobutton.RadioButtonCheckedIcon;
import mrcjkb.material.swing.icon.radiobutton.RadioButtonUncheckedIcon;
import mrcjkb.material.swing.ui.MaterialCheckBoxUI;
import mrcjkb.material.swing.ui.MaterialRadioButtonUI;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.*;

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
        initComponent(component);
    }

    private void initComponent(JComponent component) {
        if (component instanceof JCheckBox) {
            MaterialCheckBoxUI.setDefaultIcons((JCheckBox) component);
        } else if (component instanceof JRadioButton) {
            MaterialRadioButtonUI.setDefaultIcons((JRadioButton) component);
        } else {
            component.setBackground(from);
        }
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
        		setCheckboxIconHover((JCheckBox) component, nextColor());
        	} else if (component instanceof JRadioButton) {
        		setRadioButtonIconHover((JRadioButton) component, nextColor());
        	} else {
        		component.setBackground(nextColor());
        	}
            ++alpha;
        } else {
        	if (component instanceof JCheckBox) {
        		setCheckboxIconHover((JCheckBox) component, previousColor());
        	} else if (component instanceof JRadioButton) {
        		setRadioButtonIconHover((JRadioButton) component, previousColor());
        	} else {
        		component.setBackground(previousColor());
        	}
            --alpha;
        }

        if (alpha == steps + 1 || alpha == -1) {
            if(timer.isRunning()){
                timer.stop();
                if (alpha == -1) {
                    // reset
                    initComponent(component);
                }
            }
        }
    }
    
    /**
     * Set the icon background of a check box
     * @param checkBox
     * @param color
     */
    private static void setCheckboxIconHover(JCheckBox checkBox, Color color) {
    	checkBox.setIcon(CheckboxUncheckedIcon.builder()
				.withBoxColor(color)
				.withBackgroundColor(checkBox.getBackground())
				.build());
		checkBox.setSelectedIcon(CheckboxCheckedIcon.builder()
				.withBackgroundColor(checkBox.getBackground())
				.withBoxColor(color)
				.withCheckColor(color)
				.build());
    }
    
    /**
     * Set the icon background of a radio button
     * @param radioButton
     * @param color
     */
    private static void setRadioButtonIconHover(JRadioButton radioButton, Color color) {
    	radioButton.setIcon(RadioButtonUncheckedIcon.builder()
				.withBackgroundColor(radioButton.getBackground())
				.withForegroundColor(color)
				.build());
		radioButton.setSelectedIcon(RadioButtonCheckedIcon.builder()
				.withBackgroundColor(radioButton.getBackground())
				.withOuterCircleColor(color)
				.withInnerCircleColor(color)
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