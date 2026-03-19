package Rela;
import java.util.HashSet;
import java.util.Set;
public class Relation {
    private String name;
    private Set<Integer> setA;
    private Set<Pair> pairs;
    public Relation(String name, int[] elementsOfA) {
        this.name = name;
        this.setA = new HashSet<>();
        for (int e : elementsOfA) {
            this.setA.add(e);
        }
        this.pairs = new HashSet<>();
    }
    public void addPair(int a, int b) {
        pairs.add(new Pair(a, b));
    }
    public boolean isReflexive() {
        for (int a : setA) {
            if (!pairs.contains(new Pair(a, a))) {
                return false;
            }
        }
        return true;
    }
    public boolean isSymmetric() {
        for (Pair p : pairs) {
            Pair reversed = new Pair(p.getY(), p.getX());
            if (!pairs.contains(reversed)) {
                return false;
            }
        }
        return true;
    }
    public boolean isTransitive() {
        for (Pair p1 : pairs) { 
            for (Pair p2 : pairs) {   
                if (p1.getY() == p2.getX()) {
                    Pair transitivePair = new Pair(p1.getX(), p2.getY());
                    if (!pairs.contains(transitivePair)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public void printAnalysis() {
        System.out.println("Analyzing Relation " + name + ": " + pairs);
        System.out.println(" - Reflexive: " + isReflexive());
        System.out.println(" - Symmetric: " + isSymmetric());
        System.out.println(" - Transitive: " + isTransitive());
        System.out.println("------------------------------------------------");
    }

    public static void main(String[] args) {
        
        int[] setElements = {0, 1, 2, 3};

       
        Relation r = new Relation("R", setElements);
        r.addPair(0, 0); r.addPair(0, 1); r.addPair(0, 3);
        r.addPair(1, 0); r.addPair(1, 1);
        r.addPair(2, 2);
        r.addPair(3, 0); r.addPair(3, 3);
        
        
        Relation s = new Relation("S", setElements);
        s.addPair(0, 0); s.addPair(0, 2); s.addPair(0, 3);
        s.addPair(2, 3);

        
        Relation t = new Relation("T", setElements);
        t.addPair(0, 1);
        t.addPair(2, 3);

        
        r.printAnalysis();
        s.printAnalysis();
        t.printAnalysis();
    }
}

