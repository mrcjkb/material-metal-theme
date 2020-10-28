package mrcjkb.material.swing.ui.renderer.impl;

import mrcjkb.material.swing.ui.renderer.api.IMaterialTableCellRendererComponentDecorator;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class MaterialDefaultTableCellRendererDecorator extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;

    private final DefaultTableCellRenderer tableCellRenderer;
    private final IMaterialTableCellRendererComponentDecorator decorator = new MaterialTableCellRendererComponentDecorator();

    public MaterialDefaultTableCellRendererDecorator(DefaultTableCellRenderer tableCellRenderer) {
        this.tableCellRenderer = tableCellRenderer;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JComponent component = (JComponent) tableCellRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        tableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tableCellRenderer.setVerticalAlignment(SwingConstants.CENTER);
        return decorator.decorateTableCellRendererComponent(table, value, isSelected, hasFocus, row, column, component);
    }

    @Override
    public void setForeground(Color c) {
        tableCellRenderer.setForeground(c);
    }

    @Override
    public void setBackground(Color c) {
        tableCellRenderer.setBackground(c);
    }

    @Override
    public void updateUI() {
        tableCellRenderer.updateUI();
    }

    @Override
    public boolean isOpaque() {
        return tableCellRenderer.isOpaque();
    }

    @Override
    public void invalidate() {
        tableCellRenderer.invalidate();
    }

    @Override
    public void validate() {
        tableCellRenderer.validate();
    }

    @Override
    public void revalidate() {
        tableCellRenderer.revalidate();
    }

    @Override
    public void repaint(long tm, int x, int y, int width, int height) {
        tableCellRenderer.repaint(tm, x, y, width, height);
    }

    @Override
    public void repaint(Rectangle r) {
        tableCellRenderer.repaint(r);
    }

    @Override
    public void repaint() {
        tableCellRenderer.repaint();
    }

    @Override
    public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {
        tableCellRenderer.firePropertyChange(propertyName, oldValue, newValue);
    }

}