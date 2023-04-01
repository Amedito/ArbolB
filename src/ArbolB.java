public class ArbolB {
    NodoArbolB root;
    int t;

    public ArbolB(int t) {
        this.t = t;
        root = new NodoArbolB(t);
    }
    public void buscarNodoPorClave(int num) {
        NodoArbolB temp = busqueda(root, num);
        if (temp == null) {
            System.out.println("No se ha encontrado un nodo con el valor ingresado");
        } else {
            System.out.println("Se ha encontrado el numero, esta el el rama: ");
            print(temp);
        }
    }

    private NodoArbolB busqueda(NodoArbolB actual, int llave) {
        int i = 0;
        while (i < actual.n && llave > actual.llave[i]) {
            i++;
        }
        if (i < actual.n && llave == actual.llave[i]) {
            return actual;
        }
        if (actual.hoja) {
            return null;
        } else {
            return busqueda(actual.hijo[i], llave);
        }
    }

    public void insertar(int llave) {
        NodoArbolB r = root;
        if (r.n == ((2 * t) - 1)) {
            NodoArbolB s = new NodoArbolB(t);
            root = s;
            s.hoja = false;
            s.n = 0;
            s.hijo[0] = r;
            partir(s, 0, r);
            nonFullInsert(s, llave);
        } else {
            nonFullInsert(r, llave);
        }
    }

    private void partir(NodoArbolB x, int i, NodoArbolB y) {
        NodoArbolB z = new NodoArbolB(t);
        z.hoja = y.hoja;
        z.n = (t - 1);
        for (int j = 0; j < (t - 1); j++) {
            z.llave[j] = y.llave[(j + t)];
        }

        if (!y.hoja) {
            for (int k = 0; k < t; k++) {
                z.hijo[k] = y.hijo[(k + t)];
            }
        }

        y.n = (t - 1);
        for (int j = x.n; j > i; j--) {
            x.hijo[(j + 1)] = x.hijo[j];
        }
        x.hijo[(i + 1)] = z;
        for (int j = x.n; j > i; j--) {
            x.llave[(j + 1)] = x.llave[j];
        }
        x.llave[i] = y.llave[(t - 1)];
        x.n++;
    }

    private void nonFullInsert(NodoArbolB x, int llave) {
        if (x.hoja) {
            int i = x.n;
            while (i >= 1 && llave < x.llave[i - 1]) {
                x.llave[i] = x.llave[i - 1];
                i--;
            }
            x.llave[i] = llave;
            x.n++;
        } else {
            int j = 0;
            while (j < x.n && llave > x.llave[j]) {
                j++;
            }
            if (x.hijo[j].n == (2 * t - 1)) {
                partir(x, j, x.hijo[j]);
                if (llave > x.llave[j]) {
                    j++;
                }
            }
            nonFullInsert(x.hijo[j], llave);
        }
    }

    public void MostrarArbol() {
        print(root);
    }
    private void print(NodoArbolB n) {
        n.imprimir();
        if (!n.hoja) {
            for (int j = 0; j <= n.n; j++) {
                if (n.hijo[j] != null) {
                    System.out.println();
                    print(n.hijo[j]);
                }
            }
        }
    }
}