package mrcjkb.material.swing.ui;

import mrcjkb.material.swing.materialui.util.MaterialDrawingUtils;
import mrcjkb.material.swing.ui.renderer.api.IMaterialTableCellRendererDecoratorFactory;
import mrcjkb.material.swing.ui.renderer.factory.MaterialTableCellRendererDecoratorFactory;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.io.Serializable;
import java.util.EventObject;

public class MaterialTableUI extends BasicTableUI {

	public static final String UI_KEY = "TableUI";

	private final IMaterialTableCellRendererDecoratorFactory tableCellRendererDecoratorFactory = new MaterialTableCellRendererDecoratorFactory();

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

		table.setDefaultRenderer(Object.class, tableCellRendererDecoratorFactory.createMaterialTableCellRendererDecorator(table.getDefaultRenderer(Object.class)));
		table.setDefaultRenderer(String.class, tableCellRendererDecoratorFactory.createMaterialTableCellRendererDecorator(table.getDefaultRenderer(String.class)));
		table.setDefaultRenderer(Integer.class, tableCellRendererDecoratorFactory.createMaterialTableCellRendererDecorator(table.getDefaultRenderer(Integer.class)));
		table.setDefaultRenderer(Double.class, tableCellRendererDecoratorFactory.createMaterialTableCellRendererDecorator(table.getDefaultRenderer(Double.class)));
		table.setDefaultRenderer(Float.class, tableCellRendererDecoratorFactory.createMaterialTableCellRendererDecorator(table.getDefaultRenderer(Float.class)));
		table.setDefaultRenderer(Boolean.class, tableCellRendererDecoratorFactory.createMaterialTableCellRendererDecorator(table.getDefaultRenderer(Boolean.class)));
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
	
}