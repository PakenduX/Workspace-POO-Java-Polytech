package exam._2015;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

public class Exo1 extends JFrame{

    public Exo1(){
        setTitle("Exo1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        Exo1Panel p = new Exo1Panel();
        add(p);
    }

    public static void main(String[] args){
        new Exo1().setVisible(true);
    }
}

class Exo1Panel extends JPanel {

    ArrayList<Rectangle2D> wayPoints;

    public Exo1Panel(){
        wayPoints = new ArrayList<>();
        addMouseListener(new Clique());
        addMouseMotionListener(new Move());
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        Iterator<Rectangle2D> it = wayPoints.iterator();
        if(!wayPoints.isEmpty()) {
            Rectangle2D r = it.next();
            Rectangle2D precedent = r;

            while (it.hasNext()) {
                g2.draw(precedent);
                r = it.next();
                g2.draw(new Line2D.Double(precedent.getCenterX(), precedent.getCenterY(), r.getCenterX(), r.getCenterY()));
                precedent = r;
            }
            g2.draw(precedent);
        }
    }

    class Clique extends MouseAdapter{
        public void mouseClicked(MouseEvent e){
            wayPoints.add(new Rectangle2D.Double(e.getX(), e.getY(), 10, 10));
            repaint();
        }
    }
    class Move implements MouseMotionListener{

        public void mouseDragged(MouseEvent e) {

        }

        public void mouseMoved(MouseEvent e) {

        }
    }
}
