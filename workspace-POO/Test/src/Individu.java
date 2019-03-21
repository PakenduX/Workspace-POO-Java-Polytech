import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Individu {

    private String nom;
    private int age;
    private int taille;

    public Individu(String n, int a, int t){
        nom = n;
        age = a;
        taille = t;
    }

    public int hashCode(){
        int t = nom.length();
        int h = 50*t;

        for(int i = 0; i < t; i++){
            switch (nom.charAt(i)+"".toLowerCase().trim()){
                case "a":
                    h += 1;
                    break;
                case "b":
                    h += 2;
                    break;
                case "c":
                    h += 3;
                    break;
                case "d":
                    h += 4;
                    break;
                case "e":
                    h += 5;
                    break;
                case "f":
                    h += 6;
                    break;
                case "g":
                    h += 7;
                    break;
                case "h":
                    h += 8;
                    break;
                case "i":
                    h += 9;
                    break;
                case "j":
                    h += 10;
                    break;
                case "k":
                    h += 11;
                    break;
                case "l":
                    h += 12;
                    break;
                case "m":
                    h += 13;
                    break;
                case "n":
                    h += 14;
                    break;
                case "o":
                    h += 15;
                    break;
                case "p":
                    h += 16;
                    break;
                case "q":
                    h += 17;
                    break;
                case "r":
                    h += 18;
                    break;
                case "s":
                    h += 19;
                    break;
                case "t":
                    h += 20;
                    break;
                case "u":
                    h += 21;
                    break;
                case "v":
                    h += 22;
                    break;
                case "w":
                    h += 23;
                    break;
                case "x":
                    h += 24;
                    break;
                case "y":
                    h += 25;
                    break;
                case "z":
                    h += 26;
                    break;
            }
        }

        return h;
    }

    public boolean equals(Object o){
        return this.nom.equals(((Individu)o).nom) && this.age == ((Individu)o).age;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public int getTaille() {
        return taille;
    }

    public static void main(String[] args){
        HashMap<Individu, String> hi = new HashMap<>();
        hi.put(new Individu("Mamah", 23, 165), "Pak");
        hi.put(new Individu("Pak", 26, 195), "PakenduX");
        hi.put(new Individu("Mama", 23, 165), "Pap-c");

        Set<Individu> me = hi.keySet();
        Iterator<Individu> it = me.iterator();
        while(it.hasNext())
            System.out.println(it.next().age);

        System.out.println(hi.values() + " " +hi.size());
    }
}
