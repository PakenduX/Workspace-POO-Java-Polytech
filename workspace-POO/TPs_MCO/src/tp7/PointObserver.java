package tp7;

import java.util.Observable;
import java.util.Observer;

public class PointObserver implements Observer {

    private Point p;

    public PointObserver(Point p){
        this.p = p;
    }

    public void update(Observable o, Object arg) {
        Point p_c = (Point)o;
        p.modifier(p_c.getX(), p_c.getY());
    }
}
