package mrcjkb.material.swing.ui.renderer.factory;

import mrcjkb.material.swing.ui.renderer.api.IMaterialTableCellRendererDecoratorFactory;
import mrcjkb.material.swing.ui.renderer.impl.MaterialDefaultTableCellRendererDecorator;
import mrcjkb.material.swing.ui.renderer.impl.MaterialTableCellRendererDecorator;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class MaterialTableCellRendererDecoratorFactory implements IMaterialTableCellRendererDecoratorFactory {

    @Override
    public TableCellRenderer createMaterialTableCellRendererDecorator(TableCellRenderer tableCellRendererToDecorate) {
        if (tableCellRendererToDecorate instanceof DefaultTableCellRenderer) {
            // To make sure users can cast to DefaultTableCellRenderer
            return new MaterialDefaultTableCellRendererDecorator((DefaultTableCellRenderer) tableCellRendererToDecorate);
        }
        return new MaterialTableCellRendererDecorator(tableCellRendererToDecorate);
    }

}
