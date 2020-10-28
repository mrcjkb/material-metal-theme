package mrcjkb.material.swing.ui;

import mrcjkb.material.swing.materialui.util.MaterialDrawingUtils;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.io.Serializable;

public class MaterialTableHeaderUI extends BasicTableHeaderUI {

	public static ComponentUI createUI(JComponent c) {
		return new MaterialTableHeaderUI();
	}

	@Override
	public void installUI(JComponent c) {
		super.installUI(c);

		JTableHeader header = (JTableHeader) c;
		header.setDefaultRenderer(new MaterialTableHeaderCellRendererDecorator(header.getDefaultRenderer()));
	}

	@Override
	public void uninstallUI(JComponent c) {

		JTableHeader header = (JTableHeader) c;
		header.setDefaultRenderer(null);
		header.setBackground(null);
		header.setForeground(null);
		header.setFont(null);
		header.setBorder(null);
		header.setOpaque(false);

		super.uninstallUI(c);
	}

	@Override
	public void paint(Graphics g, JComponent c) {
		super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
	}
	
	public static class MaterialTableHeaderCellRendererDecorator implements TableCellRenderer, Serializable {

		private final TableCellRenderer tableCellRenderer;

		private static final long serialVersionUID = 1L;

		public MaterialTableHeaderCellRendererDecorator(TableCellRenderer tableCellRenderer) {
			this.tableCellRenderer = tableCellRenderer;
		}

		@Override
		public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			JComponent component = (JComponent) tableCellRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			if (tableCellRenderer instanceof DefaultTableCellRenderer) {
				((DefaultTableCellRenderer) tableCellRenderer).setVerticalAlignment(SwingConstants.CENTER);
			}
			return component;
		}
	}
}


