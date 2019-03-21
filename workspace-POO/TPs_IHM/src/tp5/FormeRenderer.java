package tp5;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * La classe nous permettant de custominser le renderer
 * d'une JList
 * @author DEMBELE Mama
 */
public class FormeRenderer extends JPanel implements ListCellRenderer {

    String text;

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        text = (String)value;

        //Quand on sélectionne une cellule on
        //change sa couleur de fond en gris et sa
        //couleur de face en vert.

        if(isSelected) {
            setBackground(Color.GRAY);
            setForeground(Color.GREEN);
        }else {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }

        return this;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        FontMetrics fm = g.getFontMetrics();
        g2.drawString(text, 0, fm.getAscent());
        int l = fm.stringWidth(text);
        Shape s = null;

        if(text.trim().toLowerCase().equals("carre"))
            s = new Rectangle2D.Double(this.getX() + l + 30, 0, 20, 20);
        else if(text.trim().toLowerCase().equals("cercle"))
             s = new Ellipse2D.Double(this.getX() + l + 30, 0, 20, 20);
        else
            s = new Line2D.Double(this.getX() + l + 30, 0, l + 10, fm.getAscent());

        g2.draw(s);
    }

    public Dimension getPreferredSize(){
        return new Dimension(100, 30);
    }
}
