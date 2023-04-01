public class NodoArbolB {

    int n;
    boolean hoja;
    int llave[];
    NodoArbolB hijo[];
    public NodoArbolB(int t) {
        n = 0;
        hoja = true;
        llave = new int[((2 * t) - 1)];
        hijo = new NodoArbolB[(2 * t)];
    }

    public void imprimir() {
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                System.out.print(llave[i] + " | ");
            } else {
                System.out.print(llave[i]);
            }
        }
        System.out.print("]");
    }
    public int find(int k) {
        for (int i = 0; i < n; i++) {
            if (llave[i] == k) {
                return i;
            }
        }
        return -1;
    }
}

