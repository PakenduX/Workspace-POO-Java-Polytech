public class Main {

    public static void main(String[] args)
    {
        MonHashMap<Individu, String> hi = new MonHashMap<>();
        MonHashMap hi1 = new MonHashMap<>();
        hi.put(new Individu("Mama", 23, 165), "Pak");
        hi.put(new Individu("Mamad", 23, 165), "Pak");
        hi.put(new Individu("Zak", 24, 165), "kays");


        hi1.put(new Individu("Mamah", 23, 165), "Pak");
        hi1.put(new Individu("Pak", 26, 195), "PakenduX");
        hi1.put(new Individu("Zak", 24, 165), "kays");

        System.out.println((hi.Intersection(hi1)).values());
    }
}
