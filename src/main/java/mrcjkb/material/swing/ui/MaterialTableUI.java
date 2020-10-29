package mrcjkb.material.swing.ui;

import mrcjkb.material.swing.materialui.util.MaterialDrawingUtils;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.io.Serializable;
import java.util.EventObject;

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

		this.setDefaultCellRenderWithType(table);

		table.setDefaultEditor(Object.class, new MaterialTableCellEditorDecorator(table.getDefaultEditor(Object.class)));
		table.setDefaultEditor(String.class, new MaterialTableCellEditorDecorator(table.getDefaultEditor(String.class)));
		table.setDefaultEditor(Integer.class, new MaterialTableCellEditorDecorator(table.getDefaultEditor(Integer.class)));
		table.setDefaultEditor(Double.class, new MaterialTableCellEditorDecorator(table.getDefaultEditor(Double.class)));
		table.setDefaultEditor(Float.class, new MaterialTableCellEditorDecorator(table.getDefaultEditor(Float.class)));
		table.setDefaultEditor(Boolean.class, new MaterialTableCellEditorDecorator(table.getDefaultEditor(Boolean.class)));
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
	 * Sets a MaterialCellRender as default for the respective classes.
	 */
	protected void setDefaultCellRenderWithType(JTable table) {
		if(table == null){
			throw new IllegalArgumentException("Table is null");
		}

		table.setDefaultRenderer(Object.class, new MaterialTableCellRendererDecorator(table.getDefaultRenderer(Object.class)));
		table.setDefaultRenderer(String.class, new MaterialTableCellRendererDecorator(table.getDefaultRenderer(String.class)));
		table.setDefaultRenderer(Integer.class, new MaterialTableCellRendererDecorator(table.getDefaultRenderer(Integer.class)));
		table.setDefaultRenderer(Double.class, new MaterialTableCellRendererDecorator(table.getDefaultRenderer(Double.class)));
		table.setDefaultRenderer(Float.class, new MaterialTableCellRendererDecorator(table.getDefaultRenderer(Float.class)));
		table.setDefaultRenderer(Boolean.class, new MaterialTableCellRendererDecorator(table.getDefaultRenderer(Boolean.class)));
	}

	public static class MaterialTableCellEditorDecorator implements TableCellEditor, Serializable {

		private static final long serialVersionUID = 1L;

		private final TableCellEditor tableCellEditor;

	    public MaterialTableCellEditorDecorator(TableCellEditor tableCellEditor) {
	        this.tableCellEditor = tableCellEditor;
	    }

	    @Override
	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
	    		Component component = tableCellEditor.getTableCellEditorComponent(table, value, isSelected, row, column);
	        Color background = UIManager.getColor("Table.background");
					component.setBackground(background);
	        return component;
	    }

		@Override
		public Object getCellEditorValue() {
			return tableCellEditor.getCellEditorValue();
		}

		@Override
		public boolean isCellEditable(EventObject eventObject) {
			return tableCellEditor.isCellEditable(eventObject);
		}

		@Override
		public boolean shouldSelectCell(EventObject eventObject) {
			return tableCellEditor.shouldSelectCell(eventObject);
		}

		@Override
		public boolean stopCellEditing() {
			return tableCellEditor.stopCellEditing();
		}

		@Override
		public void cancelCellEditing() {
			tableCellEditor.cancelCellEditing();
		}

		@Override
		public void addCellEditorListener(CellEditorListener cellEditorListener) {
			tableCellEditor.addCellEditorListener(cellEditorListener);
		}

		@Override
		public void removeCellEditorListener(CellEditorListener cellEditorListener) {
			tableCellEditor.removeCellEditorListener(cellEditorListener);
		}
	}
	
	public static class MaterialTableCellRendererDecorator implements TableCellRenderer, Serializable {

		private static final long serialVersionUID = 1L;

		private final TableCellRenderer tableCellRenderer;

		public MaterialTableCellRendererDecorator(TableCellRenderer tableCellRenderer) {
			this.tableCellRenderer = tableCellRenderer;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			JComponent component = (JComponent) tableCellRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			// hides yellow selection highlight
			if (tableCellRenderer instanceof DefaultTableCellRenderer) {
				((DefaultTableCellRenderer) tableCellRenderer).setHorizontalAlignment(SwingConstants.CENTER);
				((DefaultTableCellRenderer) tableCellRenderer).setVerticalAlignment(SwingConstants.CENTER);
			}

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
}