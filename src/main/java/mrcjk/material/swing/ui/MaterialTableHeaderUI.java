package mrcjk.material.swing.ui;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import mrcjk.material.swing.materialui.util.MaterialDrawingUtils;

public class MaterialTableHeaderUI extends BasicTableHeaderUI {

	public static ComponentUI createUI(JComponent c) {
		return new MaterialTableHeaderUI();
	}

	@Override
	public void installUI(JComponent c) {
		super.installUI(c);

		JTableHeader header = (JTableHeader) c;
		header.setDefaultRenderer (new MaterialTableHeaderCellRenderer());
	}

	@Override
	public void uninstallUI(JComponent c) {

		JTableHeader header = (JTableHeader) c;
		header.setDefaultRenderer (null);
		header.setBackground(null);
		header.setForeground(null);
		header.setFont(null);
		header.setBorder(null);

		super.uninstallUI(c);
	}

	@Override
	public void paint(Graphics g, JComponent c) {
		super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
	}
	
	public class MaterialTableHeaderCellRenderer extends DefaultTableCellRenderer {

		private static final long serialVersionUID = 1L;

		@Override
		public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			JComponent component = (JComponent) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

			this.setVerticalAlignment(SwingConstants.CENTER);

			return component;
		}
	}
}


