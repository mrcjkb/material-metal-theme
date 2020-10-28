package mrcjkb.material.swing.ui.renderer.api;

import javax.swing.*;
import java.awt.*;

public interface IMaterialTableCellRendererComponentDecorator {
    Component decorateTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column, JComponent component);
}
