package mrcjkb.material.swing.ui;


import mrcjkb.material.swing.materialui.util.MaterialDrawingUtils;
import mrcjkb.material.swing.materialui.util.MaterialManagerListener;
import mrcjkb.material.swing.materialui.util.MaterialUIMovement;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.FocusListener;
import java.awt.geom.RectangularShape;
import java.awt.geom.RoundRectangle2D;

public class MaterialComboBoxUI extends BasicComboBoxUI {

	private static final int MIN_WIDTH = 49;
	private static final int MIN_HEIGHT = 24;
	private static final int BUTTON_WIDTH = 23;

	protected Color background;
	protected int arc = 2; //default value

	public static ComponentUI createUI(JComponent c) {
		return new MaterialComboBoxUI();
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
		button = new JButton() {
			@Override
			public Dimension getPreferredSize() {
				return getArrowButtonPreferredSize(comboBox);
			}
		};
		button.setUI(new MaterialComboBoxButtonUI());
		return button;
	}

	@Override
	public void paint(Graphics g, JComponent c) {
		Container parent = c.getParent();
		g = MaterialDrawingUtils.getAliasedGraphics(g);
		if (parent != null) {
			g.setColor(c.getBackground());
			g.fillRect(0, 0, c.getWidth(), c.getHeight());
		}

		Graphics2D g2 = (Graphics2D) g.create();
		Rectangle r = new Rectangle(c.getSize());

		try {
			g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
			g2.translate(r.x, r.y);

			g2.setColor(c.getBackground());
			g2.fill(getOuterShape(r, arc));
		}
		finally {
			g2.dispose();
		}
		if (!comboBox.isEditable()) {
			checkFocus();
			paintCurrentValue(g, rectangleForCurrentValue(), hasFocus);
		}
		currentValuePane.removeAll();
	}

	protected void checkFocus() {
		hasFocus = false;
		if (!comboBox.isEnabled()) {
			hasFocus = false;
			return;
		}
		hasFocus = hasFocus(comboBox);
		if (hasFocus) {
			return;
		}
		ComboBoxEditor ed = comboBox.getEditor();
		if (ed != null) {
			hasFocus = hasFocus(ed.getEditorComponent());
		}
	}

	@Override
	public Dimension getPreferredSize(JComponent c) {
		return getSizeWithButton(super.getMinimumSize(c), editor != null ? editor.getPreferredSize() : null);
	}


	@Override
	public Dimension getMinimumSize(JComponent c) {
		Dimension minSize = super.getMinimumSize(c);
		Insets i = c.getInsets();
		minSize.width = MIN_WIDTH + BUTTON_WIDTH + i.left + i.right;
		return getSizeWithButton(minSize, editor != null ? editor.getMinimumSize() : null);
	}

	protected Dimension getSizeWithButton(Dimension size, Dimension editorSize) {
		Insets i = getInsets();
		Dimension abSize = getArrowButtonPreferredSize(comboBox);

		int paddingLeft = null == padding ? 0 : padding.left;
		int paddingRight = null == padding ? 0 : padding.right;
		int editorHeight = editorSize != null ? editorSize.height + i.top + i.bottom : 0;
		int editorWidth = editorSize != null ? editorSize.width + i.left + paddingLeft + paddingRight : 0;
		editorWidth = Math.max(editorWidth, MIN_WIDTH + i.left);

		int width = size != null ? size.width : 0;
		int height = size != null ? size.height : 0;

		width = Math.max(editorWidth + abSize.width, width + paddingLeft);
		height = Math.max(Math.max(editorHeight, Math.max(abSize.height, height)),
				MIN_HEIGHT + i.top + i.bottom);

		return new Dimension(width, height);
	}


	@SuppressWarnings({"unchecked", "rawtypes"})
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

	private RectangularShape getOuterShape(Rectangle r, float arc) {
		return new RoundRectangle2D.Float(0F, 0F, r.width - 0F * 2, r.height - 0F * 2, arc, arc);
	}

	private static boolean hasFocus(Component c) {
		Component owner = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
		return owner != null && SwingUtilities.isDescendingFrom(owner, c);
	}

	private static Dimension getArrowButtonPreferredSize(JComboBox<?> comboBox) {
		Insets i = comboBox != null ? comboBox.getInsets() : new Insets(3, 3, 3, 3);
		int height = MIN_HEIGHT + i.top + i.bottom;
		return new Dimension(BUTTON_WIDTH + i.left, height);
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