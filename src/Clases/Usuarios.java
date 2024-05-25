package Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class Usuarios {
    NodosUsuarios Raiz;
    
    public Usuarios(){
        Raiz = null;
    }

    public boolean listaVacia(){
        return Raiz == null;
    }
    //Método para insertar un nuevo usuario
    public void Insertar(int id, String nombre){
        NodosUsuarios nuevo = new NodosUsuarios(id, nombre);
        if (listaVacia()){
            Raiz = nuevo;
        }else{
            NodosUsuarios aux = Raiz;
            NodosUsuarios Padre;
            while (true){
                Padre = aux;
                if (id < aux.Id){
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
    public void preOrder(NodosUsuarios Nodo){
        if (Nodo != null){
            System.out.println(Nodo.Id);
            JOptionPane.showMessageDialog(null, Nodo.Id);
            preOrder(Nodo.HijoIzq);
            preOrder(Nodo.HijoDer);
        }
    }
    
    //Método para consultar un usuario por medio de un Id
    public NodosUsuarios ConsultarUsuario(int id){
        NodosUsuarios aux = Raiz;
        while(aux.Id != id){
            if (id < aux.Id){
                aux = aux.HijoIzq;
            }else{
                aux = aux.HijoDer;
            }
            if (aux == null){
                JOptionPane.showMessageDialog(null, "El usuario no existe");
                return null;
            }
        }
        JOptionPane.showMessageDialog(null, "El usuario es: " + aux.Id + "\nSu nombre es: " + aux.Nombre);
        return aux;
        }
    
    //Método para eliminar un usuario
    public boolean Extraer(int eliminar_usuario){
        NodosUsuarios aux = Raiz;
        NodosUsuarios padre = Raiz;
        boolean esHijoIzquierda = true;
        
        while (aux.Id != eliminar_usuario){
            padre = aux;
            if (eliminar_usuario < aux.Id){
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
            NodosUsuarios reemplazo = obtenerNodoReemplazo(aux);
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
    public NodosUsuarios obtenerNodoReemplazo(NodosUsuarios nodoReemplazo){
        NodosUsuarios reemplazoPadre = nodoReemplazo;
        NodosUsuarios reemplazo = nodoReemplazo;
        NodosUsuarios aux = nodoReemplazo.HijoDer;
        
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
    
    //Método para mostrar todos los usuarios
    public void MostrarUsuarios(NodosUsuarios Nodo){
        if (Nodo != null){
            MostrarUsuarios(Nodo.HijoIzq);
            MostrarUsuarios(Nodo.HijoDer);              
            JOptionPane.showMessageDialog(null, "Lista de usuarios:\n" + Nodo.Id + ", " + Nodo.Nombre);
        }    
    } 
}
