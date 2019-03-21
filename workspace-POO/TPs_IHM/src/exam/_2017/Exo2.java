package exam._2017;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;


public class Exo2 extends JFrame{

    public Exo2(){
        setTitle("Exo2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        Exo2Panel p = new Exo2Panel();
        add(p);
    }

    public static void main(String[] a){
        new Exo2().setVisible(true);
    }
}


class Exo2Panel extends JPanel {

    ArrayList<Rectangle2D> listRect;

    public Exo2Panel(){
        listRect = new ArrayList<>();
        addMouseListener(new SourisListener());
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        Iterator<Rectangle2D> it = listRect.iterator();
        while (it.hasNext())
            g2.draw(it.next());
    }


    public Rectangle2D contient(Point2D p){
        int i = 0;
        while (i < listRect.size() && !listRect.get(i).contains(p))
            i++;

        return i == listRect.size() ? null : listRect.get(i);
    }

    class SourisListener extends MouseAdapter {

        public void mouseClicked(MouseEvent e){
            Point2D p = new Point2D.Double(e.getX(), e.getY());
            Rectangle2D r = contient(p);

            if(e.getClickCount() == 2){
                if(r != null)
                    listRect.remove(r);
            }else{
                if(r == null)
                    listRect.add(new Rectangle2D.Double(e.getX(), e.getY(), 100, 100));
            }
            repaint();
        }
    }
}
