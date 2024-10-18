
package tarea_1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Tarea_1 {
    
    
    public static void main(String[] args) {
        Inventario vehiculo = new Inventario();
        Recursividad recursividad = new Recursividad();
        ArrayList <Inventario> vehiculos = new ArrayList();
        
        int opcion = 0, contador = 0;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Inventario de Carros\n2) Recursividad\n3) Salir"));
            switch (opcion){
                case 1:
                    int opc = 0;
                    do {
                        opc = Integer.parseInt(JOptionPane.showInputDialog("1) Agregar nuevo vehiculo\n2) Listar vehiculos\n3) Modificar informacion de vehiculo\n4) Eliminar vehiculo\n5) Vehiculo mas antiguo\n6) Vehiculos de color rojo\n7) Diferencia de años de fabricacion\n8) Salir"));
                        switch (opc) {
                            case 1:
                                if (contador < 50){ // si contador es menor a 50, se ira acumulando el contador, cuando llegue a 50, se llenara el inventario
                                    contador += 1;
                                    vehiculos.add(vehiculo.agregarVehiculo());
                                } else {
                                    JOptionPane.showMessageDialog(null, "Ya se lleno el inventario de vehiculos");
                                }
                                break;
                            case 2: // lista todos los vehiculos agregados
                                vehiculo.listarVehiculos(vehiculos);
                                break;
                            case 3: // modificar datos de los vehiculos a partir de la matricula
                                if (vehiculos.isEmpty()){ // verificamos si la lista esta vacia
                                    JOptionPane.showMessageDialog(null, "No tienes agregado vehiculos para modificar");
                                } else {
                                    // pedimos la matricula del vehiculo y se la mandamos como parametro al metodo para que lo busque y podamos modificar
                                    String matricula = JOptionPane.showInputDialog("Ingresa la matricula del vehiculo que deseas modificar");
                                    vehiculo.modificarVehiculos(vehiculos, matricula);
                                }
                                break;
                            case 4: // eliminar vehiculos
                                if (vehiculos.isEmpty()){ // verificamos si esta vacia la lista
                                    JOptionPane.showMessageDialog(null, "No tienes agregado vehiculos para eliminar");
                                } else {
                                    // pedimos la matricula del vehiculo y se la mandamos como parametro al metodo para que lo busque y lo elimine
                                    String matricula = JOptionPane.showInputDialog("Ingresa la matricula del vehiculo que deseas eliminar");
                                    vehiculo.eliminarVehiculos(vehiculos, matricula);
                                }
                                break;
                            case 5: // buscar el vehiculo mas antiguo del inventario
                                vehiculo.vehiculoAntiguo(vehiculos);
                                break;
                            case 6: // buscar vehiculos de color rojo
                                if (vehiculos.isEmpty()){
                                    JOptionPane.showMessageDialog(null, "No tienes agregado vehiculos");
                                } else {
                                    vehiculo.vehiculosRojos(vehiculos);
                                }
                                break;
                            case 7: // buscar la diferencia de años de fabricacion entre 2 carros
                                if (vehiculos.size() < 2){ 
                                    // verificamos si tenemos mas de 1 carro para poder hacer la operacion, 
                                    //ya que con 1 no podemos buscar la diferencia, se necesita 2 por lo menos para hacerlo
                                    JOptionPane.showMessageDialog(null, "No hay suficientes vehiculos para poder comparar");
                                } else {
                                    int vehiculo1 = 0, vehiculo2 = 0;
                                    do { // repetiremos hasta que ingrese una posicion que este dentro de la lista
                                        vehiculo1 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la posicion del primer vehiculo a comparar"));
                                    } while (vehiculo1 < 1 || vehiculo1 > vehiculos.size());
                                    
                                    do { // repetiremos hasta que ingrese una posicion que este dentro de la lista
                                        vehiculo2 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la posicion del segundo vehiculo a comparar"));  
                                    } while (vehiculo2 < 1 || vehiculo2 > vehiculos.size());
                                    
                                    vehiculo.diferenciaDeAños(vehiculos, vehiculo1, vehiculo2);
                                }
                                break;
                        }
                    } while (opc != 8);
                    break;
                case 2:
                    int opci = 0;
                    do {
                        opci = Integer.parseInt(JOptionPane.showInputDialog("1) Decimal a binario\n2) Maximo comun divisor\n3) Fibonacci\n4) Busqueda Binaria\n5) Salir"));
                        switch (opci){
                            case 1:
                                int num = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero que deseas convertir a binario"));
                                JOptionPane.showMessageDialog(null, "El numero " + num + " convertido a binario es: " + recursividad.decimalABinario(num));
                                break;
                            case 2:
                                int num1 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el primer numero"));
                                int num2 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el segundo numero"));
                                JOptionPane.showMessageDialog(null, "El maximo comun divisor de (" + num1 + ", " + num2 + ") es: " + recursividad.MaxComDiv(num1, num2));
                                
                                break;
                            case 3:
                                int n = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la posicion del numero de la serie fibonacci que deseas ver"));
                                JOptionPane.showMessageDialog(null, "El numero " + n + " de la serie de fibonacci es: " + recursividad.fib(n));
                                break;
                            case 4:
                                int arreglo [] = {4, 5, 8, 29, 34, 41, 70, 83, 98, 115};
                                int numBuscado = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero a buscar en el arreglo " + imprimirArreglo(arreglo)));
                                if (recursividad.busquedaBinaria(arreglo, 0, arreglo.length-1, numBuscado) == -1){
                                    JOptionPane.showMessageDialog(null, imprimirArreglo(arreglo) +"\nEl numero " + numBuscado + " no se encontro en el arreglo");
                                } else {
                                    JOptionPane.showMessageDialog(null, imprimirArreglo(arreglo) +"\nEl numero " + numBuscado + " esta en la posicion " + recursividad.busquedaBinaria(arreglo, 0, arreglo.length-1, numBuscado));
                                }
                                break;
                        }
                    } while (opci != 5);
                    break;
            }
        } while (opcion != 3);
        
    }
    static String imprimirArreglo(int arreglo []){
        String array = "[";
        for (int i = 0; i <arreglo.length; i++) {
            if (i == arreglo.length-1){
                array += arreglo[i];
            } else {
                array += arreglo[i] + ", ";
            }
        }
        array += "]";
        return array;
    }
}
