package Clases;

/**
 *
 * @author Daniel
 */
public class NodosLibros {
    int libro_id;
    String titulo;
    String autor;
    
    NodosLibros HijoIzq;
    NodosLibros HijoDer;

    public NodosLibros(int libro_id, String titulo, String autor) {
        this.libro_id = libro_id;
        this.titulo = titulo;
        this.autor = autor;
        this.HijoIzq = HijoIzq;
        this.HijoDer = HijoDer;
    }    
}
