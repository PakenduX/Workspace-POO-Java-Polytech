package tp4;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RectangularShape;

/**
 * La classe permettant de déssiner une forme
 * en fonctions des valueurs données par un menu déroulant.
 * @author DEMBELE Mama
 */
public class DessinForme extends JPanel {

    /**
     * Ces attributs définissent les type, couleur et dimension
     * de la forme à dessiner.
     */

    private RectangularShape forme_type;
    private Color forme_color;
    private Dimension forme_dim;

    public DessinForme(){
        forme_type = null;
        forme_color = null;
        forme_dim = null;
    }

    public void paintComponent(Graphics g){
        //On déssine que si les trois indications sont connues.
        if(forme_type != null && forme_color != null && forme_dim != null) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(forme_color);
            forme_type.setFrame(100, 100, forme_dim.getWidth(), forme_dim.getHeight());
            g2.draw(forme_type);
        }

    }

    public void setForme_type(RectangularShape forme_type) {
        this.forme_type = forme_type;
    }

    public void setForme_color(Color forme_color) {
        this.forme_color = forme_color;
    }

    public void setForme_dim(Dimension d){
        this.forme_dim = d;
    }
}
