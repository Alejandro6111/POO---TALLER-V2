import controller.Controlador;
import view.Vista;

/**
 * Punto de entrada de la aplicacion.
 *
 * <p>Inicia la interfaz por consola y delega el flujo al {@link Controlador}.</p>
 *
 * @author Equipo
 */
public class App {

    /**
     * Metodo principal que arranca el programa.
     *
     * @param args argumentos de linea de comandos (no se usan)
     */
    public static void main(String[] args) {
        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista);
        controlador.iniciar();
    }
}
