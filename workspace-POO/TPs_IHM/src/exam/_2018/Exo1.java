package exam._2018;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Exo1 extends JFrame {

    public Exo1(){
        setTitle("Exo2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        Exo1Panel p = new Exo1Panel();
        add(p);
    }

    public static void main(String[] a){
        new Exo1().setVisible(true);
    }
}

class Exo1Panel extends JPanel{
    Ellipse2D r = new Ellipse2D.Double(30, 30, 50, 50);

    public Exo1Panel(){
        addMouseMotionListener(new Dragger());
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.draw(r);
    }

    class Dragger implements MouseMotionListener{

        public void mouseDragged(MouseEvent e) {
            r.setFrameFromCenter(e.getPoint(), new Point2D.Double(e.getX() - 30, e.getY() - 30));
            //r = new Rectangle2D.Double(e.getX(), e.getY(), 50, 50);
            repaint();
        }

        public void mouseMoved(MouseEvent e) {

        }
    }
}
