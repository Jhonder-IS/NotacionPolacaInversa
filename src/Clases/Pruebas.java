/**
 * esta es la clase main donde se va a llamar y hacer visible la
 * vista principal que es la que controla todo el funcionamiento de
 * los metodos de otras clases con sus bootones, muestra la informacion y demas cosas
 */
package Clases;

public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //se llama a la vista
        Vista vista = new Vista();
        //se hace visible la vista
        vista.setVisible(true);
    }

}
