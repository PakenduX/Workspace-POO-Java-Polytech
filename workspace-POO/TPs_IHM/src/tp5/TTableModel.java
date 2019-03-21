package tp5;

import javax.swing.table.AbstractTableModel;

public class TTableModel extends AbstractTableModel {


    public int getRowCount() {
        return 9;
    }

    public int getColumnCount() {
        return 10;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {

        int col_1 = 6;
        int row_1 = 0;

        if(columnIndex == 0 && rowIndex != 0)
           return  col_1 + rowIndex*2 + " km/h";

        else if(rowIndex == 0 && columnIndex != 0)
            return  row_1 + columnIndex*5 + " km";

        else if(rowIndex != 0 && columnIndex != 0)
            return (60*(row_1 + columnIndex*5))/(col_1 + rowIndex*2);

        return null;
    }
}
