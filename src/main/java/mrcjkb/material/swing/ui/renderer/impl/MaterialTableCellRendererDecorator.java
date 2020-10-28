package mrcjkb.material.swing.ui.renderer.impl;

import mrcjkb.material.swing.ui.renderer.api.IMaterialTableCellRendererComponentDecorator;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MaterialTableCellRendererDecorator implements TableCellRenderer {

    private final TableCellRenderer tableCellRenderer;
    private final IMaterialTableCellRendererComponentDecorator decorator = new MaterialTableCellRendererComponentDecorator();

    public MaterialTableCellRendererDecorator(TableCellRenderer tableCellRenderer) {
        this.tableCellRenderer = tableCellRenderer;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JComponent component = (JComponent) tableCellRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        return decorator.decorateTableCellRendererComponent(table, value, isSelected, hasFocus, row, column, component);
    }
}
