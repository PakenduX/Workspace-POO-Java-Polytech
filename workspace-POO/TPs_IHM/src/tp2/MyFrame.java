package tp2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 1. Clic sur un bouton.
 * @author DEMBELE Mama
 */
public class MyFrame extends JFrame {

    private Panel panel;
    private JButton r , j, b;

    public MyFrame(){
        setTitle("Clic sur le bouton");
        setBounds(30, 30, 700, 700);
        panel = new Panel();
        add(panel);

        r = new JButton("R");
        j = new JButton("J");
        b = new JButton("B");

        panel.add(r);
        panel.add(j);
        panel.add(b);

        ButtonListener bl = new ButtonListener();
        r.addActionListener(bl);
        j.addActionListener(bl);
        b.addActionListener(bl);
    }

    class ButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent e){
            if(e.getSource() == r)
                panel.setBackground(Color.RED);
            else if(e.getSource() == j)
                panel.setBackground(Color.YELLOW);
            else
                panel.setBackground(Color.BLUE);
        }
    }
}
