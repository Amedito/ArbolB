import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese la clave: ");
        int n=leer.nextInt();
        ArbolB arbol = new ArbolB(n);
        //Valores a ingresar primera ronda
        System.out.print("Indique cuantos valores desea ingresar: ");
        int n2=leer.nextInt();
        int[] valoresArbol = new int[n2];
        for(int i=0; i<n2; i++){
        System.out.print("Ingrese el dato: ");
        valoresArbol[i] = leer.nextInt();
        arbol.insertar(valoresArbol[i]);
        }
        System.out.println("ESTADO ARBOL B");
        arbol.MostrarArbol();
        System.out.println("");
        System.out.print("Ingrese el numero que desea buscar: ");
        int busqueda = leer.nextInt();
        arbol.buscarNodoPorClave(busqueda);
    }
}