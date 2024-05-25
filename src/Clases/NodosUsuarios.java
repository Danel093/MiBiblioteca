package Clases;

/**
 *
 * @author Daniel
 */
public class NodosUsuarios {
    int Id;
    String Nombre;
    NodosUsuarios HijoIzq;
    NodosUsuarios HijoDer;

    public NodosUsuarios(int id, String nombre) {
        this.Id = id;
        this.Nombre = nombre;
        this.HijoIzq = HijoIzq;
        this.HijoDer = HijoDer;
    }
}
