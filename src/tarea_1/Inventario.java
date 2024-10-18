
package tarea_1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Inventario {
    // Atributos
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private int fechaDeFabricacion;
    private int precio;

    public Inventario() { // constructor vacio
    }

    // constructor sobrecargado
    public Inventario(String matricula, String marca, String modelo, String color, int fechaDeFabricacion, int precio) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.fechaDeFabricacion = fechaDeFabricacion;
        this.precio = precio;
    }
 
    // setters y getters
    public String getMatricula() { // solo se hace un getter para matricula ya que no se podra modificar la matricula, solo verla y buscarla
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFechaDeFabricacion() {
        return fechaDeFabricacion;
    }

    public void setFechaDeFabricacion(int fechaDeFabricacion) {
        this.fechaDeFabricacion = fechaDeFabricacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() { // Metodo toString para visualizar la informacion de nuestro objeto
        return "Matricula = " + matricula +
                "\nMarca = " + marca + 
                "\nModelo = " + modelo +
                "\nColor = " + color + 
                "\nAño de fabricacion = " + fechaDeFabricacion + 
                "\nPrecio = " + precio;
    }
    
    public Inventario agregarVehiculo(){
        String Matricula = JOptionPane.showInputDialog("Ingresa la Matricula del vehiculo");
        String Marca = JOptionPane.showInputDialog("Ingresa la Marca del vehiculo");
        String Modelo = JOptionPane.showInputDialog("Ingresa el Modelo del vehiculo");
        String Color = JOptionPane.showInputDialog("Ingresa el Color del vehiculo");
        int añoFabricacion = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el Ano de Fabricacion del vehiculo"));
        int Precio = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el Precio del vehiculo"));
        // pedimos cada dato del carro y lo vamos agregando al inventario, Esto retorna el objeto Inventario que luego se guarda en un arraylist
        
        return new Inventario(Matricula, Marca, Modelo, Color, añoFabricacion, Precio); // aqui el uso del metodo sobrecargado, para agregar todo de un solo al inventario
    }
    
    public void listarVehiculos(ArrayList <Inventario> vehiculos){ // ponemos de parametro la lista para que muestre los elementos que tiene dentro
        if (vehiculos.isEmpty()){ // Si esta vacia la lista entonces no mostramos nada
            JOptionPane.showMessageDialog(null, "No hay nada en la lista de vehiculos");
        } else {
            for (int i = 0; i < vehiculos.size(); i++) {
                JOptionPane.showMessageDialog(null, "------------ Vehiculo " + (i+1) + " ------------\n" + vehiculos.get(i)); 
                // mostramos cada dato que tiene almacenado el arraylist
            }
        }
    }
    
    public void modificarVehiculos(ArrayList <Inventario> vehiculos, String matricula){
        String matriculaEncontrada = ""; int posicion = 0, opcion = 0;
        for (int i = 0; i < vehiculos.size(); i++) { // esto sirve para buscar la matricula
            if (matricula.equals(vehiculos.get(i).getMatricula())){
                posicion = i; // si se encuentra la matricula, entonces guardamos la posicion en la que se encontro
                matriculaEncontrada = matricula; // si se encuentra la matricula, la guardamos en otra variable y paramos el ciclo ya que solo estamos buscando una matricula
                break;
            } 
        }
        if (matriculaEncontrada.isEmpty()){ // verificamos si en la variable que se guarda la matricula a buscar esta vacia, si esta vacia entonces no se encontro la matricula que el usuario ingreso
            JOptionPane.showMessageDialog(null, "No se encontro la matricula " + matricula);
        } else { // este es el caso en que si se encontro la matricula
            do{ // aqui preguntamos que cosas desea modificar del vehiculo, y tambien la opcion de poder salir para cuando haya terminado el usuario
                opcion = Integer.parseInt(JOptionPane.showInputDialog("Vehiculo " + (posicion + 1) + " Con matricula " + matriculaEncontrada + "\nQue deseas modificar?\n1) Marca\n2) Modelo\n3) Color\n4) Ano de fabricacion\n5) Precio\n6) Salir"));
                switch (opcion){
                    case 1:
                        String nuevaMarca = JOptionPane.showInputDialog("Ingresa la nueva marca del vehiculo");
                        vehiculos.get(posicion).setMarca(nuevaMarca); 
                        // la variable posicion tiene la posicion en la que se encontro la matricula, entonces buscamos esa posicion en el arraylist y modificamos el dato seleccionado
                        break;
                    case 2:
                        String nuevoModelo = JOptionPane.showInputDialog("Ingresa el nuevo modelo del vehiculo");
                        vehiculos.get(posicion).setModelo(nuevoModelo);
                        break;
                    case 3:
                        String nuevoColor = JOptionPane.showInputDialog("Ingresa el nuevo color del vehiculo");
                        vehiculos.get(posicion).setColor(nuevoColor);
                        break;
                    case 4:
                        int nuevoAñoFabricacion = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el nuevo Año de fabricacion del vehiculo"));
                        vehiculos.get(posicion).setFechaDeFabricacion(nuevoAñoFabricacion);
                        break;
                    case 5:
                        int nuevoPrecio = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el nuevo precio del vehiculo"));
                        vehiculos.get(posicion).setPrecio(nuevoPrecio);
                        break;
                }
            } while (opcion != 6);
        }
    }
    
    public void eliminarVehiculos(ArrayList <Inventario> vehiculos, String matricula){
        String matriculaEncontrada = ""; int posicion = 0;
        for (int i = 0; i < vehiculos.size(); i++) { // se busca la matricula
            if (matricula.equals(vehiculos.get(i).getMatricula())){
                posicion = i;
                matriculaEncontrada = matricula;
                break;
            } 
        }
        if (matriculaEncontrada.isEmpty()){ // en caso de que no la haya encontrado, entonces se muestra el mensaje que no se encontro
            JOptionPane.showMessageDialog(null, "No se encontro la matricula " + matricula);
        } else { // si la encuentra entonces eliminara el vehiculo en la posicion en la que se encontro la matricula ingresada
            vehiculos.remove(posicion);
            JOptionPane.showMessageDialog(null, "Se elimino correctamente el vehiculo con matricula " + matriculaEncontrada);
        }
    }
    
    public void vehiculoAntiguo(ArrayList <Inventario> vehiculos){
        if (vehiculos.isEmpty()){
            JOptionPane.showMessageDialog(null, "No tienes nada en el inventario");
        } else {
            int menor = 0, posicion = 0;
            for (int i = 0; i < vehiculos.size(); i++) {
                if (menor > vehiculos.get(i).getFechaDeFabricacion() || i == 0){
                    // en la primera iteracion vamos a guardar el primer año del primer vehiculo para seguir comparando con el resto
                    // y luego va a verificar si el numero guardado es mayor a los que siguen, significando que, el que encontro es menor al que estaba guardado y se guardara ese como menor
                    menor = vehiculos.get(i).getFechaDeFabricacion();
                    posicion = i;
                }
            }
            // aqui solo mostrar en que posicion esta el vehiculo mas antiguo y mostrar sus datos
            JOptionPane.showMessageDialog(null, "Vehiculo mas antiguo en el inventario es el vehiculo " + (posicion+1) + "\n" + vehiculos.get(posicion));
        }
    }
    
    public void vehiculosRojos(ArrayList <Inventario> vehiculos){
        boolean isRojo = false; // para verificar si se encuentra color rojo o no
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getColor().equalsIgnoreCase("rojo")){ // buscamos en la lista si hay algun vehiculo de color rojo
                isRojo = true; // si encuentra en color rojo entonces se cambia el estado a true y vamos mostrando cada vehiculo rojo que encuentre
                JOptionPane.showMessageDialog(null, "----------- Vehiculo " + (i+1) + " -----------\n" + vehiculos.get(i));
            }
        }
        if (!isRojo){ // aqui vemos si no encontro rojo entonces significa que nunca cambio el estado entonces isRojo seria falso y mostramos que no hay ningun vehiculo de color rojo
            JOptionPane.showMessageDialog(null, "No tienes vehiculos de color rojo");
        } 
    }
    
    public void diferenciaDeAños(ArrayList <Inventario> vehiculos, int vehiculo1, int vehiculo2){ // pedimos de parametro las posiciones de los vehiculos a diferenciar
        int diferencia = 0;
        int añoVehiculo1 = vehiculos.get(vehiculo1-1).getFechaDeFabricacion(); // guardamos el año del primer vehiculo
        int añoVehiculo2 = vehiculos.get(vehiculo2-1).getFechaDeFabricacion(); // guardamos el año del segundo vehiculo
        
        if (añoVehiculo1 > añoVehiculo2){ // estas verificacion es para que cuando se haga la diferencia no quede en numeros negativos y para mostrar cual es el auto mas reciente y antiguo de los que el usuario ingreso
            // caso en que el año del primer vehiculo es mayor al del segundo, entonces se resta el mayor con menor
            diferencia = añoVehiculo1 - añoVehiculo2;
            JOptionPane.showMessageDialog(null, "La diferencia de años entre el vehiculo " + vehiculo1 + " y el vehiculo " + vehiculo2 + " es de (" + diferencia + ") años. \nSiendo el vehiculo " + vehiculo1 + " el mas reciente (" + añoVehiculo1 + ")\n y el vehiculo " + vehiculo2 + " el mas antiguo (" + añoVehiculo2 + ")");
        } else {
            // caso en que el año del segundo vehiculo es mayor al del primero, entonces se resta el mayor con menor
            diferencia = añoVehiculo2 - añoVehiculo1;
            JOptionPane.showMessageDialog(null, "La diferencia de años entre el vehiculo " + vehiculo1 + " y el vehiculo " + vehiculo2 + " es de (" + diferencia + ") años. \nSiendo el vehiculo " + vehiculo2 + " el mas reciente (" + añoVehiculo2 + ")\n y el vehiculo " + vehiculo1 + " el mas antiguo (" + añoVehiculo1 + ")");
        }
    }
}
