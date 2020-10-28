package mrcjkb.material.swing.ui.renderer.impl;

import mrcjkb.material.swing.ui.renderer.api.IMaterialTableCellRendererComponentDecorator;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MaterialTableCellRendererComponentDecorator implements IMaterialTableCellRendererComponentDecorator {

    @Override
    public Component decorateTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column, JComponent component) {
        // hides yellow selection highlight
        if (value instanceof Boolean) {
            TableCellRenderer renderer = new MaterialTableCellRendererCheckBox();
            return renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
        Color background = UIManager.getColor("Table.background");
        component.setBackground(background);
        if (null != table) {
            table.getDefaultRenderer(ImageIcon.class).getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column).setBackground(background);
        }
        return component;
    }

}
