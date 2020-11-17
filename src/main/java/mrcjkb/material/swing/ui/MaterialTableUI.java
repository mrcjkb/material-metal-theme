package mrcjkb.material.swing.ui;

import mrcjkb.material.swing.materialui.util.MaterialDrawingUtils;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MaterialTableUI extends BasicTableUI {

	public static final String UI_KEY = "TableUI";

	public static ComponentUI createUI(JComponent c) {
		return new MaterialTableUI();
	}

	@Override
	public void installUI(JComponent c) {
		super.installUI(c);

		table.getTableHeader().setResizingAllowed(true);
		table.setSelectionBackground(UIManager.getColor("Table.selectionBackground"));
		int rowHeight = UIManager.getInt("Table.rowHeight");
		if (rowHeight > 0) {
			table.setRowHeight(rowHeight);
		} else {
			table.setRowHeight(table.getRowHeight() + 4);
		}

		this.setDefaultCellRenderWithType(table, new MaterialTableCellRenderer());
		table.setDefaultEditor(Object.class, new MaterialTableCellEditor());
		table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
	}

	@Override
	protected void uninstallDefaults() {
		super.uninstallDefaults();

		table.setSelectionForeground(null);
		table.setBackground(null);
		table.setForeground(null);
		table.setFont(null);
		table.setBorder(null);
		table.setSelectionBackground(null);

		table.removeEditor();
		table.setDefaultRenderer(Object.class, null);
		table.setDefaultEditor(Object.class, null);
	}

	@Override
	public void paint(Graphics g, JComponent c) {
		super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
	}

	/**
	 * Sets a MaterialCellRender as default for the respective classes.
	 */
	protected void setDefaultCellRenderWithType(JTable table, TableCellRenderer renderer) {
		if (null != table) {
			table.setDefaultRenderer(Object.class, renderer);
			table.setDefaultRenderer(String.class, renderer);
			table.setDefaultRenderer(Integer.class, renderer);
			table.setDefaultRenderer(Double.class, renderer);
			table.setDefaultRenderer(Float.class, renderer);
			table.setDefaultRenderer(Boolean.class, renderer);
		}
	}
	
	public static class MaterialTableCellRenderer extends DefaultTableCellRenderer {

		private static final long serialVersionUID = 1L;

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			JComponent component = (JComponent) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			// hides yellow selection highlight
			this.setHorizontalAlignment(SwingConstants.CENTER);
			this.setVerticalAlignment(SwingConstants.CENTER);

			if(value instanceof Boolean){
				TableCellRenderer renderer = new MaterialTableCellRendererCheckBox();
				return renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			}
			Color background = UIManager.getColor("Table.background");
			component.setBackground(background);
			setDefaultCellRenderWithAllType(table, value, isSelected, hasFocus, row, column, background);
			return component;
		}

		  // This method setting a MaterialCellRender at the particular class
		  // With this class not working correctly the color alternate in the Jtable
		  // in particular the IconImage without this code the cell is painted not correctly or
		  // in the cell did print the path of the image

		protected void setDefaultCellRenderWithAllType(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column, Color color) {
			if(table == null) {
				throw new IllegalArgumentException("Table is null");
			}

			Component component = table.getDefaultRenderer(ImageIcon.class).getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			component.setBackground(color);
		}
	}
	
	static class MaterialTableCellRendererCheckBox extends JCheckBox implements TableCellRenderer {

		private static final long serialVersionUID = 1L;

	    public MaterialTableCellRendererCheckBox() {
	        setLayout(new GridBagLayout());
	        setMargin(new Insets(0, 0, 0, 0));
	        setHorizontalAlignment(JLabel.CENTER);
	    }

	    @Override
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        if (value instanceof Boolean) {
	            setSelected((Boolean) value);
	        }
	        boolean alternativeRow = UIManager.getBoolean("Table.alternateRowColor");
	        Color alternativeRowColor = UIManager.getColor("Table.alternateRowBackground");
	        Color normalColor = UIManager.getColor("Table.background");
	        if(alternativeRow){
	            if(!isSelected){
	                if(row%2 == 1) {
	                    this.setBackground(alternativeRowColor);
	                }else{
	                    this.setBackground(normalColor);
	                }
	                this.setForeground(table.getForeground());
	            }else{
	                this.setForeground(table.getSelectionForeground());
	                this.setBackground(table.getSelectionBackground());
	            }
	        }
	        return this;
	    }
	}

	private static JTextField initTextField() {
		return new JTextField();
	}

	public static class MaterialTableCellEditor extends DefaultCellEditor {

		private static final long serialVersionUID = 1L;

		public MaterialTableCellEditor() {
			super(initTextField());
		}

		public MaterialTableCellEditor(JComboBox<?> comboBox) {
			super(comboBox);
		}

		public MaterialTableCellEditor(JCheckBox checkBox) {
			super(checkBox);
		}

		public MaterialTableCellEditor(JTextField textField) {
			super(textField);
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
			Component component = super.getTableCellEditorComponent(table, value, isSelected, row, column);
			Color background = UIManager.getColor("Table.background");
			component.setBackground(background);
			return component;
		}

	}
}