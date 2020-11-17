package mrcjkb.material.swing.ui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;

public class MaterialSplitPaneUI extends BasicSplitPaneUI {

    public static ComponentUI createUI(JComponent c) {
        JSplitPane splitPane = (JSplitPane) c;
        splitPane.setDividerSize((int) (splitPane.getDividerSize() * 1.5));
        splitPane.setBorder(null);
        return new MaterialSplitPaneUI();
    }

    @Override
    public BasicSplitPaneDivider createDefaultDivider() {
        return new BasicSplitPaneDivider(this) {
            private static final long serialVersionUID = 8623947921750342305L;
            @Override
            public void setBorder(Border b) {
            }
        };
    }
}
