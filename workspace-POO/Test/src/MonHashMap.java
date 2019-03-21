import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MonHashMap<Individu, String> extends HashMap<Individu, String> {

    public MonHashMap<Individu, String>  Intersection(MonHashMap<Individu, String> mapp) {
        MonHashMap<Individu, String> res = new MonHashMap<>();
        Set<Individu> key_mapp = mapp.keySet();
        Set<Individu> key_this = this.keySet();
        Iterator<Individu> it_mapp = key_mapp.iterator();
        Iterator<Individu> it_this = key_this.iterator();
        if (key_this.size() > key_mapp.size()) {
            System.out.println("la taille est plus grande");
            while (it_this.hasNext()) {
                //if (it_this.next().equals( it_mapp.next()))
                    res.put(it_this.next(), this.get(it_this.next()));

            }

        }else {
            while (it_mapp.hasNext()) {
                System.out.println("la taille est plus grande");
                //if (it_this.next().equals(it_mapp.next()))
                    System.out.println("egalite" + it_mapp.next());
                    res.put(it_mapp.next(), this.get(it_mapp.next()));

            }

        }
        return res;
    }


}
