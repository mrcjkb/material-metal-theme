package mrcjkb.material.swing.ui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Marc Jakobi
 * Some code borrowed from https://github.com/bulenkov/Darcula/blob/master/src/com/bulenkov/darcula/ui/DarculaTreeUI.java
 * by Konstantin Bulenkow
 */
public class MaterialTreeUI extends BasicTreeUI {

    private static final int LINE_WIDTH = 2;

    private Border treeCellBorder = BorderFactory.createEmptyBorder( 3, 12, 3, 3 );

    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(JComponent c) {
        return new MaterialTreeUI();
    }

    public void installUI(JComponent c) {
        super.installUI(c);
        tree.setBorder(BorderFactory.createEmptyBorder());
    }

    @Override
    public int getRightChildIndent() {
        return isSkinny() ? 8 : super.getRightChildIndent();
    }

    private static boolean isSkinny() {
        return true;
    }

    private final MouseListener mySelectionListener = new MouseAdapter() {
        boolean handled = false;
        @Override
        public void mousePressed(final MouseEvent e) {
            handled = false;
            if (!isSelected(e)) {
                handled = true;
                handle(e);
            }
        }

        @Override
        public void mouseReleased(final MouseEvent e) {
            if (!handled) {
                handle(e);
            }
        }

        private boolean isSelected(MouseEvent e) {
            final JTree tree = (JTree)e.getSource();
            final int selected = tree.getClosestRowForLocation(e.getX(), e.getY());
            final int[] rows = tree.getSelectionRows();
            if (rows != null) {
                for (int row : rows) {
                    if (row == selected) {
                        return true;
                    }
                }
            }

            return false;
        }

        private void handle(MouseEvent e) {
            final JTree tree = (JTree)e.getSource();
            if (SwingUtilities.isLeftMouseButton(e) && !e.isPopupTrigger()) {
                // if we can't stop any ongoing editing, do nothing
                if (isEditing(tree) && tree.getInvokesStopCellEditing() && !stopEditing(tree)) {
                    return;
                }

                final TreePath pressedPath = getClosestPathForLocation(tree, e.getX(), e.getY());
                if (pressedPath != null) {
                    Rectangle bounds = getPathBounds(tree, pressedPath);

                    if (e.getY() >= bounds.y + bounds.height) {
                        return;
                    }

                    if (bounds.contains(e.getPoint()) || isLocationInExpandControl(pressedPath, e.getX(), e.getY())) {
                        return;
                    }

                    if (tree.getDragEnabled() || !startEditing(pressedPath, e)) {
                        selectPathForEvent(pressedPath, e);
                    }
                }
            }
        }
    };

    @Override
    protected void completeUIInstall() {
        super.completeUIInstall();

        UIManager.put("Tree.repaintWholeRow", true);

        tree.setShowsRootHandles(true);
        tree.addMouseListener(mySelectionListener);
    }

    @Override
    public void uninstallUI(JComponent c) {
        super.uninstallUI(c);
        c.removeMouseListener(mySelectionListener);
    }

    @Override
    protected void installKeyboardActions() {
        super.installKeyboardActions();

        if (Boolean.TRUE.equals(tree.getClientProperty("MacTreeUi.actionsInstalled"))) return;

        tree.putClientProperty("MacTreeUi.actionsInstalled", Boolean.TRUE);

        final InputMap inputMap = tree.getInputMap(JComponent.WHEN_FOCUSED);
        inputMap.put(KeyStroke.getKeyStroke("pressed LEFT"), "collapse_or_move_up");
        inputMap.put(KeyStroke.getKeyStroke("pressed RIGHT"), "expand");

        final ActionMap actionMap = tree.getActionMap();

        final Action expandAction = actionMap.get("expand");
        if (expandAction != null) {
            actionMap.put("expand", new TreeUIAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    final Object source = e.getSource();
                    if (source instanceof JTree) {
                        JTree tree = (JTree)source;
                        int selectionRow = tree.getLeadSelectionRow();
                        if (selectionRow != -1) {
                            TreePath selectionPath = tree.getPathForRow(selectionRow);
                            if (selectionPath != null) {
                                boolean leaf = tree.getModel().isLeaf(selectionPath.getLastPathComponent());
                                int toSelect = -1;
                                int toScroll = -1;
                                if (!leaf && tree.isExpanded(selectionRow)) {
                                    if (selectionRow + 1 < tree.getRowCount()) {
                                        toSelect = selectionRow + 1;
                                        toScroll = toSelect;
                                    }
                                } else if (leaf) {
                                    toScroll = selectionRow;
                                }

                                if (toSelect != -1) {
                                    tree.setSelectionInterval(toSelect, toSelect);
                                }

                                if (toScroll != -1) {
                                    tree.scrollRowToVisible(toScroll);
                                }

                                if (toSelect != -1 || toScroll != -1) return;
                            }
                        }
                    }
                    expandAction.actionPerformed(e);
                }
            });
        }

        actionMap.put("collapse_or_move_up", new TreeUIAction() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final Object source = e.getSource();
                if (source instanceof JTree) {
                    JTree tree = (JTree)source;
                    int selectionRow = tree.getLeadSelectionRow();
                    if (selectionRow == -1) return;

                    TreePath selectionPath = tree.getPathForRow(selectionRow);
                    if (selectionPath == null) return;

                    if (tree.getModel().isLeaf(selectionPath.getLastPathComponent()) || tree.isCollapsed(selectionRow)) {
                        final TreePath parentPath = tree.getPathForRow(selectionRow).getParentPath();
                        if (parentPath != null) {
                            if (parentPath.getParentPath() != null || tree.isRootVisible()) {
                                final int parentRow = tree.getRowForPath(parentPath);
                                tree.scrollRowToVisible(parentRow);
                                tree.setSelectionInterval(parentRow, parentRow);
                            }
                        }
                    }
                    else {
                        tree.collapseRow(selectionRow);
                    }
                }
            }
        });
    }

    private abstract static class TreeUIAction extends AbstractAction implements UIResource {
    }

    @Override
    protected int getRowX(int row, int depth) {
        return isSkinny() ? 8 * depth + 8 : super.getRowX(row, depth);
    }

    @Override
    protected boolean isToggleSelectionEvent(MouseEvent e) {
        return SwingUtilities.isLeftMouseButton(e) && (System.getProperty("os.name").toLowerCase().startsWith("mac") ? e.isMetaDown() : e.isControlDown()) && !e.isPopupTrigger();
    }

    @Override
    protected Color getHashColor() {
        return tree.getBackground();
    }

    @Override
    protected void paintRow(final Graphics g,
                            final Rectangle clipBounds,
                            final Insets insets,
                            final Rectangle bounds,
                            final TreePath path,
                            final int row,
                            final boolean isExpanded,
                            final boolean hasBeenExpanded,
                            final boolean isLeaf) {

        if (path != null) {
            boolean selected = tree.isPathSelected(path);
            Graphics2D rowGraphics = (Graphics2D) g.create();
            rowGraphics.setClip(clipBounds);

            if (selected) {
                Rectangle treeBounds = tree.getBounds();
                Rectangle highlightRect = new Rectangle(treeBounds.x, bounds.y, LINE_WIDTH, bounds.height);
                Rectangle selectionRect = new Rectangle(treeBounds.x, bounds.y, treeBounds.width, bounds.height);
                Color highlight = UIManager.getColor("Tree.selectionHighlight");
                Color bg = UIManager.getColor("Tree.selectionBackground");
                int alpha = UIManager.getInt("Tree.selectionBackgroundAlpha");

                rowGraphics.setColor(new Color(bg.getRed(), bg.getGreen(), bg.getBlue(), alpha));
                rowGraphics.fill(selectionRect);
                rowGraphics.setColor(highlight);
                rowGraphics.fill(highlightRect);
            }

            if (shouldPaintExpandControl(path, row, isExpanded, hasBeenExpanded, isLeaf)) {
                paintExpandControl(rowGraphics, bounds, insets, bounds, path, row, isExpanded, hasBeenExpanded, isLeaf);
            }
            super.paintRow(rowGraphics, clipBounds, insets, bounds, path, row, isExpanded, hasBeenExpanded, isLeaf);
            rowGraphics.dispose();
        } else {
            super.paintRow(g, clipBounds, insets, bounds, null, row, isExpanded, hasBeenExpanded, isLeaf);
        }
    }

    @Override
    protected void updateRenderer() {
        super.updateRenderer();
        // Do not let the user update the tree cell renderer background and border selection colors or change the cell border.
        if (currentCellRenderer instanceof  DefaultTreeCellRenderer && tree != null) {
            currentCellRenderer = (aTree, aValue, aSelected, aExpanded, aLeaf, aRow, aHasFocus) -> {
                JLabel renderer = (JLabel) tree.getCellRenderer().getTreeCellRendererComponent(aTree, aValue, aSelected, aExpanded, aLeaf, aRow, aHasFocus);
                renderer.setBorder(treeCellBorder);
                renderer.setForeground(UIManager.getColor("Tree.selectionForeground"));
                renderer.setBackground(tree.getBackground());
                renderer.setOpaque(!aSelected);
                if (renderer instanceof  DefaultTreeCellRenderer) {
                    ((DefaultTreeCellRenderer) renderer).setBackgroundSelectionColor(new Color(0, 0, 0, 0));
                    ((DefaultTreeCellRenderer) renderer).setBorderSelectionColor(new Color(0, 0, 0, 0));
                }
                return renderer;
            };
        }
    }

}