package aula06;

public class Conjunto {
    private int[] vetor;

    public Conjunto() {
        this.vetor = new int[0];
    }

    public int[] getVetor() {
        return vetor;
    }

    public boolean contains(int n) {
        for (int i = 0; i < vetor.length; i++) {
            if (n == vetor[i]) {
                return true;
            }
        }

        return false;
    }

    public void insert(int n) {
        if (this.contains(n)) {
            return;
        }

        int nl = vetor.length + 1;
        int[] nv = new int[nl];

        for (int i = 0; i < vetor.length; i++) {
            nv[i] = vetor[i];
        }

        nv[nl - 1] = n;

        vetor = nv;
    }

    public void remove(int n) {
        if (!this.contains(n)) {
            return;
        }

        int nl = vetor.length - 1;
        int[] nv = new int[nl];
        boolean removed = false;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == n) {
                removed = true;
                continue;
            }

            if (!removed) {
                nv[i] = vetor[i];
            } else {
                nv[i - 1] = vetor[i];
            }
        }

        vetor = nv;
    }

    public void empty() {
        vetor = new int[0];
    }

    public int size() {
        return vetor.length;
    }

    public String toString() {
        String s = "";

        for (int n : vetor) {
            s += n + " ";
        }

        return s;
    }

    public Conjunto combine(Conjunto add) {
        Conjunto nc = new Conjunto();
        nc = this;

        for (int i = 0; i < add.size(); i++) {
            int n = add.getVetor()[i];
            if (!nc.contains(n)) {
                nc.insert(n);
            }
        }
        return nc;
    }

    public Conjunto subtract(Conjunto dif) {
        Conjunto nc = new Conjunto();
        nc = this;

        for (int i = 0; i < dif.size(); i++) {
            int n = dif.getVetor()[i];
            if (nc.contains(n)) {
                nc.remove(n);
            }
        }
        return nc;
    }

    public Conjunto intersect(Conjunto inter) {
        Conjunto nc = new Conjunto();

        for (int i = 0; i < inter.size(); i++) {
            int n = inter.getVetor()[i];
            if (this.contains(n)) {
                nc.insert(n);
            }
        }
        return nc;
    }
}
