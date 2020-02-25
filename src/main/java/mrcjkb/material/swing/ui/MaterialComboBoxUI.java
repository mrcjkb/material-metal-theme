package mrcjkb.material.swing.ui;


import mrcjkb.material.swing.materialui.util.MaterialDrawingUtils;
import mrcjkb.material.swing.materialui.util.MaterialManagerListener;
import mrcjkb.material.swing.materialui.util.MaterialUIMovement;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MaterialComboBoxUI extends BasicComboBoxUI {

	public static ComponentUI createUI(JComponent c) {
		return new MaterialComboBoxUI();
	}

	protected Color background;
	protected FocusListener focusListener;
	protected int arc = 2; //default value

	public MaterialComboBoxUI() {
		focusListener = new FocusListenerColor();
	}

	@Override
	public void installUI(JComponent c) {
		super.installUI(c);

		comboBox.setFont(UIManager.getFont("ComboBox.font"));
		background = UIManager.getColor("ComboBox.background");
		comboBox.setBackground(background);
		comboBox.setForeground(UIManager.getColor("ComboBox.foreground"));
		comboBox.setBorder(UIManager.getBorder("ComboBox.border"));
		comboBox.setLightWeightPopupEnabled(true);
		comboBox.setFocusable(true);
		comboBox.addMouseListener(MaterialUIMovement.getMovement(comboBox, UIManager.getColor("MaterialSwing.hoverColor")));

		this.arc = UIManager.getInt("ComboBox.arc");
	}

	@Override
	public void uninstallUI(JComponent c) {
		comboBox.setBackground(null);
		comboBox.setForeground(null);
		comboBox.setBorder(null);
		comboBox.setLightWeightPopupEnabled(true);
		comboBox.setCursor(null);
		comboBox.setRenderer(null);
		comboBox.setEditor(null);
		comboBox.setFocusable(true);

		comboBox.removeFocusListener(focusListener);
		MaterialManagerListener.removeAllMaterialMouseListener(comboBox);

		super.uninstallUI(comboBox);
	}

	@Override
	protected JButton createArrowButton() {
		JButton button;
		button = new JButton();
		button.setUI(new MaterialComboBoxButtonUI());
		return button;
	}

	@Override
	public void update(Graphics g, JComponent c) {
		g = MaterialDrawingUtils.getAliasedGraphics(g);
		g.setColor(c.getBackground());
		g.fillRoundRect(0, 0, comboBox.getWidth(), comboBox.getHeight(), arc, arc);
		paint(g, c);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected ListCellRenderer createRenderer() {
		return new MaterialComboBoxRenderer();
	}

	@Override
	protected ComboBoxEditor createEditor() {
		return new MaterialComboBoxEditor();
	}

	@Override
	protected FocusListener createFocusListener() {
		comboBox.addFocusListener(focusListener);
		return super.createFocusListener();
	}

	protected class FocusListenerColor implements FocusListener {

		private Border focus;
		private Border unfocus;

		public FocusListenerColor() {
			focus = BorderFactory.createLineBorder(UIManager.getColor("MaterialSwing.accent1Color"), UIManager.getInt("MaterialSwing.lineBorderWidth"));
			unfocus = UIManager.getBorder("ComboBox.border");
		}

		@Override
		public void focusGained(FocusEvent e) {
			if (e.getComponent() == null) {
				return;
			}
			JComboBox<?> cb = (JComboBox<?>) e.getComponent();
			if (focus != null) {
				cb.setBorder(focus);
				cb.repaint();
				arrowButton.setOpaque(true);
				arrowButton.repaint();
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			if (e.getComponent() == null) {
				return;
			}
			JComboBox<?> cb = (JComboBox<?>) e.getComponent();
			if (unfocus != null) {
				cb.setBorder(unfocus);
				cb.repaint();
				arrowButton.setOpaque(false);
				arrowButton.repaint();
			}
		}
	}
	
	public static class MaterialComboBoxRenderer extends BasicComboBoxRenderer {

		private static final long serialVersionUID = 5430108421010322387L;

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

			setBorder((UIManager.getBorder("ComboBox.borderItems")));
			if(isSelected){
				setForeground(UIManager.getColor("ComboBox[item].selectionForeground"));
			}else{
				setForeground(UIManager.getColor("ComboBox.foreground"));
			}
			setBackground(isSelected || cellHasFocus ?
					UIManager.getColor("ComboBox.selectedInDropDownBackground") :
					UIManager.getColor("ComboBox.background"));

			return this;
		}
	}
	
	public static class MaterialComboBoxEditor extends BasicComboBoxEditor {

	    @Override
	    public Component getEditorComponent() {
	        Component component = super.getEditorComponent();
	        component.setForeground(UIManager.getColor("ComboBox.selectionForeground"));
	        return component;
	    }
	}
}