package mrcjk.material.swing.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import mrcjk.material.swing.materialui.util.MaterialDrawingUtils;

public class MaterialTableUI extends BasicTableUI {

	public static final String UI_KEY = "TableUI";

	public static ComponentUI createUI(JComponent c) {
		return new MaterialTableUI();
	}

	@Override
	public void installUI(JComponent c) {
		super.installUI(c);

		table.getTableHeader().setResizingAllowed(true);
		int rowHeight = UIManager.getInt("Table.rowHeight");
		if (rowHeight > 0) {
			table.setRowHeight(rowHeight);
		} else {
			table.setRowHeight(table.getRowHeight() + 4);
		}

		this.setDefaultCellRenderWithType(table);

		table.setDefaultEditor(Object.class, new MaterialTableCellEditor());
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
	}

	@Override
	public void paint(Graphics g, JComponent c) {
		super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
	}

	/**
	 * This method setting a MaterialCellRender at the particular class
	 * With this class not working correctly the color alternate in the Jtable
	 */
	protected void setDefaultCellRenderWithType(JTable table) {
		if(table == null){
			throw new IllegalArgumentException("Table is null");
		}

		table.setDefaultRenderer(Object.class, new MaterialTableCellRenderer());
		table.setDefaultRenderer(String.class, new MaterialTableCellRenderer());
		table.setDefaultRenderer(Integer.class, new MaterialTableCellRenderer());
		table.setDefaultRenderer(Double.class, new MaterialTableCellRenderer());
		table.setDefaultRenderer(Float.class, new MaterialTableCellRenderer());
		table.setDefaultRenderer(Boolean.class, new MaterialTableCellRenderer());
	}
	
	private static JTextField initTextField() {
        JTextField textField = new JTextField();
        return textField;
    }
	
	private static JTextField initTextField(JTextField textField) {
        textField = new JTextField();
        return textField;
    }
	
	public class MaterialTableCellEditor extends DefaultCellEditor {

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
	        super(initTextField(textField));
	    }

	    @Override
	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
	        Color background = UIManager.getColor("Table.background");
	        editorComponent.setBackground(background);
	        return editorComponent;
	    }
	}
	
	public class MaterialTableCellRenderer extends DefaultTableCellRenderer {

		private static final long serialVersionUID = 1L;

		@Override
		public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			JComponent component = (JComponent) super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
			// hides yellow selection highlight
			this.setHorizontalAlignment (SwingConstants.CENTER);
			this.setVerticalAlignment (SwingConstants.CENTER);

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
			if(table == null){
				throw new IllegalArgumentException("Table is null");
			}

			Component component = table.getDefaultRenderer(ImageIcon.class).getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			component.setBackground(color);
		}
	}
	
	class MaterialTableCellRendererCheckBox extends JCheckBox implements TableCellRenderer {

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
}