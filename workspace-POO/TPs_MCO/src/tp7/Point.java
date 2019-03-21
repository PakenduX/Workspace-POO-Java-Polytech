package tp7;


import java.util.Observable;

/**
 * Class permettant de définir un point du plan
 * avec ses coordonnées x et y
 * @author Mama DEMBELE
 */

public class Point extends Observable implements Cloneable{

    private int x;
    private int y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point additionner(Point p) {
        return new Point(this.x + p.x, this.y + p.y);
    }

    public String toString() {
        return "( " + this.x + ", " + this.y + " )";
    }

    public Point clone() throws CloneNotSupportedException{
        return (Point)super.clone();

    }

    public int hashCode(){
        return x + y;
    }

    public boolean equals(Object o){
        Point p = (Point)o;
        return (p.x == this.x && p.y == this.y);
    }

    public void modifier(int a, int b){
        x = a;
        y = b;
        setChanged();
        //notifyObservers() me renvoie une erreur stackOverflowError, du coup
        //en le mettant en commentaire le programme marche bien sans.
        //notifyObservers();
    }

}