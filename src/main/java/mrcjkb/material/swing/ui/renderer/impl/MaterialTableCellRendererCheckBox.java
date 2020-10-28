package mrcjkb.material.swing.ui.renderer.impl;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MaterialTableCellRendererCheckBox extends JCheckBox implements TableCellRenderer {

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
