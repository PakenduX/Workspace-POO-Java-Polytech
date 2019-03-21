package tp5;

import javax.swing.*;
public class TableauTempsPassageMarathon extends JFrame {

    public TableauTempsPassageMarathon(){
        setTitle("Temps passage Marathon");
        setBounds(0, 0, 700, 500);

        JTable jt = new JTable();
        jt.setModel(new TTableModel());
        JScrollPane sp = new JScrollPane(jt);

        add(sp);

    }

    public static void main(String[] args){
        new TableauTempsPassageMarathon().setVisible(true);
    }
}
