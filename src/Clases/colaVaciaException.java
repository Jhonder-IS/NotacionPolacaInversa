/**
 * Esta es una excepcion que va a mostrar un mensaje en el caso de que la cola se encuentre vacía
 */
package Clases;

public class colaVaciaException extends Exception {

    /**
     * esta es la excepcion que va a recibir un mensaje que se va mostrar en el
     * caso del error ya mencionado
     *
     * @param message el String o texto con el mensaje de error
     */
    public colaVaciaException(String message) {
        super(message);
    }

}
