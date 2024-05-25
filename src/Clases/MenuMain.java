package Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */

public class MenuMain {
    public static void main(String[] args) {
        int menu = 0;
        String mensaje_ventana_principal = "";        
        int menu_usuarios = 0, menu_libros = 0, menu_prestamos = 0;
        
        Usuarios usuario = new Usuarios();
        Libros libro = new Libros();
        ColaPrestamos prestamo = new ColaPrestamos();
        ColaPrestamos cola = new ColaPrestamos();
        
        JOptionPane.showMessageDialog(null, "Bienvenido a la Biblioteca Virtual");
                                
        mensaje_ventana_principal =  
                    """                    
                    Biblioteca.
                    
                    MEN\u00da:
                    
                    1. Usuarios
                    2. Libros
                    3. Pr\u00e9stamos
                    4. SALIR
                    
                    
                    Ingresa una opci\u00f3n: 
                    """;
        
        
        //Menú principal de la biblioteca
        do{
            try{
                menu = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje_ventana_principal));
            
            //Bucle switch para navegar por las opciones del primer menu
                switch(menu){
                    case 1:
                        do{
                            menu = 0;
                            //submenu para ventana de usuarios
                            menu_usuarios = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                                               USUARIOS.
                                                                                               
                                                                                               Opciones:
                                                                                               
                                                                                               1. Ingresar un nuevo usuario
                                                                                               2. Consultar un usuario por ID
                                                                                               3. Mostrar lista de usuarios
                                                                                               4. Eliminar un usuario
                                                                                               5. ATR\u00c1S
                                                                                               
                                                                                               
                                                                                               Ingresa una opci\u00f3n: 
                                                                                               """));
                                                        
                        switch(menu_usuarios){
                            case 1 -> {
                                int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor ingresa el documento del nuevo usuario: "));
                                String nombre_usuario = JOptionPane.showInputDialog(null, "Por favor ingresa los nombres completos: ");
                                usuario.Insertar(id, nombre_usuario);
                        }
                            case 2 -> {
                                int consulta_usuario = Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor ingresa el documento del usuario a consultar: "));
                                usuario.ConsultarUsuario(consulta_usuario);
                        }
                            
                            case 3 -> {
                                if (!usuario.listaVacia()){
                                    usuario.MostrarUsuarios(usuario.Raiz);
                                }else{
                                    JOptionPane.showMessageDialog(null, "Aún no hay usuarios agregados. Digita 1 para agregar un usuario nuevo");
                                }                                
                        }
                            
                            case 4 -> {
                                int eliminar_usuario = Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor ingresa el documento del usuario a eliminar: "));
                                usuario.Extraer(eliminar_usuario);
                        }
                            
                            case 5 -> menu_usuarios = 11;
                            
                            default -> {
                                    menu = 1;
                                    JOptionPane.showMessageDialog(null, "OPCIÓN INVÁLIDA");
                        }
                        }
                        } while(menu_usuarios < 10);
                    break; 
                    
                           
                    case 2:
                        do{
                        //submenu para ventana de libros
                            menu = 0;
                            menu_libros = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                                             LIBROS
                                                                                             
                                                                                             Opciones:
                                                                                             
                                                                                             1. Ingresar un nuevo libro
                                                                                             2. Consultar un libro por ID
                                                                                             3. Mostrar lista de libros
                                                                                             4. Eliminar un libro por ID
                                                                                             5. ATR\u00c1S
                                                                                             
                                                                                             
                                                                                             Ingresa una opci\u00f3n: 
                                                                                             """));
                                                        
                        switch(menu_libros){
                            case 1 -> {
                                int id_libro = Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor ingresa el ID del nuevo libro: "));
                                String titulo_libro = JOptionPane.showInputDialog(null, "Por favor ingresa el título completo del libro: ");
                                String autor_libro = JOptionPane.showInputDialog(null, "Por favor ingresa el autor del libro: ");
                                libro.Insertar(id_libro, titulo_libro, autor_libro);
                        }
                            
                            case 2 -> {
                                int tituloConsultado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del libro que desea consultar:"));
                                libro.ConsultarLibro(tituloConsultado);
                        }
                                
                            case 3 -> {
                                if (!usuario.listaVacia()){
                                    libro.MostrarBiblioteca(libro.Raiz);
                                }else{
                                    JOptionPane.showMessageDialog(null, "Aún no hay libros agregados. Digita 1 para agregar un libro nuevo a la biblioteca");
                                }                                
                        }                                 
                            
                            case 4 -> {
                                int eliminar_libro = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del libro que desea eliminar:"));
                                libro.Extraer(eliminar_libro);
                        }
                            
                            case 5 -> menu_libros = 11;
                            
                            default -> JOptionPane.showMessageDialog(null, "OPCIÓN INVÁLIDA");
                        }
                        } while(menu_libros < 10);
                    break;
                    
                    case 3:
                        do{
                           menu = 0;
                        //submenu para ventana de prestamos
                            menu_prestamos = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                                                PR\u00c9STAMOS
                                                                                                
                                                                                                Opciones:
                                                                                                
                                                                                                1. Hacer un pr\u00e9stamo
                                                                                                2. Devolver libro
                                                                                                3. Consultar pr\u00e9stamos
                                                                                                4. ATR\u00c1S
                                                                                                
                                                                                                
                                                                                                Ingresa una opci\u00f3n: 
                                                                                                """));
                                                        
                        switch(menu_prestamos){
                            case 1 -> {
                                int id_prestamo = Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor ingresa el ID del libro que deseas"));
                                prestamo.Insertar(id_prestamo);
                        }
                            
                            case 2 -> {
                                if(!cola.ColaVacia()){
                                    JOptionPane.showMessageDialog(null, "Se devolvió: " + cola.Extraer());
                                } else {
                                    JOptionPane.showMessageDialog(null, "Aún no hay préstamos");
                                }
                        }
                            
                            case 3 -> prestamo.MostrarPrestamos();
                            
                            case 4 -> menu_prestamos = 11;
                                
                            default -> JOptionPane.showMessageDialog(null, "OPCIÓN INVÁLIDA");
                        }
                        } while(menu_prestamos < 10);
                    break;    
                    
                    case 4:
                        menu = 4;
                        break;
                    default:
                        menu = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje_ventana_principal));
                    break;
                }
            } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "OPCIÓN INVÁLIDA");
            }
            
        }while(menu != 4);
        
        
    }
    
}
