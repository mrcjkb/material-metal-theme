package mrcjkb.material.swing.ui.renderer.api;

import javax.swing.table.TableCellRenderer;

public interface IMaterialTableCellRendererDecoratorFactory {
    TableCellRenderer createMaterialTableCellRendererDecorator(TableCellRenderer tableCellRendererToDecorate);
}
