package presentacio;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Created by Xavi on 09/12/2015.
 */
public class CustomTableCellRenderer extends DefaultTableCellRenderer {
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    if (value.equals("-1")) {
      cell.setBackground(Color.BLACK);
    }
    return cell;
  }
}
