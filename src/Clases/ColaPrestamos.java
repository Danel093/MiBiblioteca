package Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
class Nodo {
    int id_prestamo;
    Nodo siguiente;
}

public class ColaPrestamos {

    private Nodo inicioCola, finalCola;
    String cola = "";
    Libros libro = new Libros();
    Usuarios usuario = new Usuarios();
    
    public ColaPrestamos(){
        inicioCola = null;
        finalCola= null;
    }
    
    //Método para saber si la cola está vacía
    public boolean ColaVacia(){
        return inicioCola == null;
    }
    
    //Método para insertar un dato en un nuevo nodo
    public void Insertar(int informacion){
        Nodo nuevo_nodo = new Nodo();
        nuevo_nodo.id_prestamo = informacion;
        nuevo_nodo.siguiente = null;
        
        if(ColaVacia()){
            inicioCola = nuevo_nodo;
            finalCola = nuevo_nodo;
        } else {
            finalCola.siguiente = nuevo_nodo;
            finalCola = nuevo_nodo;
        }
    }
    
    //Método para extraer un prestamo
    public int Extraer(){
        if(!ColaVacia()){
            int informacion = inicioCola.id_prestamo;
            if(inicioCola==finalCola){
                inicioCola = null;
                finalCola = null;
            } else {
                inicioCola = inicioCola.siguiente;
            }
            return informacion;
        } else {
            return Integer.MAX_VALUE;
        }
    }
    
    //Método para mostrar el contenido
    public void MostrarPrestamos(){
        Nodo recorrer = inicioCola;
        cola = "";
        if(recorrer!=null){
            cola += recorrer.id_prestamo + "";
            recorrer = recorrer.siguiente;
        } else {
            JOptionPane.showMessageDialog(null, "Aún no hay datos en la lista");
        }
    }
}
