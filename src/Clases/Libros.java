package Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class Libros {
    NodosLibros Raiz;
    
    public Libros(){
        Raiz = null;
    }

    public boolean listaVacia(){
        return Raiz == null;
    }
    
    //Método para insertar un nuevo libro
    public void Insertar(int id, String titulo, String autor){
        NodosLibros nuevo = new NodosLibros(id, titulo, autor);
        if (listaVacia()){
            Raiz = nuevo;
        }else{
            NodosLibros aux = Raiz;
            NodosLibros Padre;
            while (true){
                Padre = aux;
                if (id < aux.libro_id){
                    aux = aux.HijoIzq;
                    if (aux == null){
                        Padre.HijoIzq = nuevo;
                        return;
                    }
                }else{
                    aux = aux.HijoDer;
                    if (aux ==null){
                        Padre.HijoDer = nuevo;
                        return;
                    }
                }
            }
        }
        
    }
    
    //Método para el recorrido Pre-Order
    public void preOrder(NodosLibros Nodo){
        if (Nodo != null){
            System.out.println(Nodo.libro_id);
            JOptionPane.showMessageDialog(null, Nodo.libro_id);
            preOrder(Nodo.HijoIzq);
            preOrder(Nodo.HijoDer);
        }
    }
    
    //Método para consultar un libro por medio de un Id
    public NodosLibros ConsultarLibro(int id){
        NodosLibros aux = Raiz;
        while(aux.libro_id != id){
            if (id < aux.libro_id){
                aux = aux.HijoIzq;
            }else{
                aux = aux.HijoDer;
            }
            if (aux == null){
                JOptionPane.showMessageDialog(null, "El libro no existe");
                return null;
            }
        }
        JOptionPane.showMessageDialog(null, "El id del libro es: " + aux.libro_id + "\nSu título es: " + aux.titulo + "\nSu autor es: " + aux.autor);
        return aux;
        }
    
    //Método para eliminar un Libro
    public boolean Extraer(int eliminar_libro){
        NodosLibros aux = Raiz;
        NodosLibros padre = Raiz;
        boolean esHijoIzquierda = true;
        
        while (aux.libro_id != eliminar_libro){
            padre = aux;
            if (eliminar_libro < aux.libro_id){
                esHijoIzquierda = true;
                aux = aux.HijoIzq;
            }else{
                esHijoIzquierda = false;
                aux = aux.HijoDer;
            }
            if (aux == null){
                return false;
            }
        }
        if (aux.HijoIzq == null && aux.HijoDer == null){
            if (aux == Raiz){
                Raiz = null;
            }else if (esHijoIzquierda){
                padre.HijoIzq = null;
            }else{
                padre.HijoDer = null;
            }
        }else if (aux.HijoDer == null){
            if (aux == Raiz){
                Raiz = aux.HijoIzq;
            }else if (esHijoIzquierda){
                padre.HijoIzq = aux.HijoIzq;
            }else{
                padre.HijoDer = aux.HijoIzq;
            }
        }else if (aux.HijoIzq == null){
            if (aux == Raiz){
                Raiz = aux.HijoDer;
            }else if (esHijoIzquierda){
                padre.HijoIzq = aux.HijoDer;
            }else{
                padre.HijoDer = aux.HijoIzq;
            }
        }else{
            NodosLibros reemplazo = obtenerNodoReemplazo(aux);
                if (aux == Raiz){
                    Raiz = reemplazo;
                }else if (esHijoIzquierda){
                    padre.HijoIzq = reemplazo;
                }else{
                    padre.HijoDer = reemplazo;
                }
            reemplazo.HijoIzq = aux.HijoIzq;
        }
        return true;
    }
    
    //Método para devolver el dato reemplazado
    public NodosLibros obtenerNodoReemplazo(NodosLibros nodoReemplazo){
        NodosLibros reemplazoPadre = nodoReemplazo;
        NodosLibros reemplazo = nodoReemplazo;
        NodosLibros aux = nodoReemplazo.HijoDer;
        
        while (aux != null){
            reemplazoPadre = reemplazo;
            reemplazo = aux;
            aux = aux.HijoIzq;
        }
        if (reemplazo != nodoReemplazo.HijoDer){
            reemplazoPadre.HijoIzq = reemplazo.HijoDer;
            reemplazo.HijoDer = nodoReemplazo.HijoDer;
        }
        JOptionPane.showMessageDialog(null, "El dato reemplazado es: " + reemplazo);
        return reemplazo;
    }
    
    //Método para mostrar todos los libros
    public void MostrarBiblioteca(NodosLibros Nodo){
        if (Nodo != null){
            MostrarBiblioteca(Nodo.HijoIzq);
            MostrarBiblioteca(Nodo.HijoDer);              
            JOptionPane.showMessageDialog(null, "Lista de libros:\n" + Nodo.libro_id + ", " + Nodo.titulo + ", " + Nodo.autor);
          
        }    
    }    
}
