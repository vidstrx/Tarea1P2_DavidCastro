
package tarea_1;

public class Recursividad {

    public Recursividad() {
    }
    
    public String decimalABinario(int num){
        if (num < 2) {
            return Integer.toString(num);
        } else {
            return decimalABinario(num/2) + (num%2);
        } 
    }
    
    public int MaxComDiv(int a, int b){
        if (a%b == 0){
            return b;
            // retornamos b ya que segun el algoritmo de euclides, cuando llegamos a residuo de 0, significa que el residuo anterior al 0 es el mcd
            // lo cual en el else guardamos en la variable b el residuo. Todo segun el algoritmo de euclides
        } else {
            int res = a % b;
            a = b;
            b = res;
            return MaxComDiv(a, b);
        }
    }
    
    public int fib(int n){
        if (n == 0 || n == 1){
            return n;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }
    
    public int busquedaBinaria(int arreglo [], int izq, int der, int numBuscado){
        int posicion = (izq + der)/2;
        if (izq > der){
            return -1;
        } else if (arreglo[posicion] == numBuscado){
            return posicion;
        } else if (arreglo[posicion] < numBuscado){
            return busquedaBinaria(arreglo, (posicion+1), der, numBuscado);
        } else {
            return busquedaBinaria(arreglo, izq, (posicion-1), numBuscado);
        }
    }
}
