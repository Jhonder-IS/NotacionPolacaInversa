/**
 * En esta clase se crea una cola con su primero y su ultimo para poder manejarse
 * entre sus datos con el nodo que contiene el siguiente,tiene sus constructores
 * y set y get para la definicion y obtencion de los datos y metodos para manejar
 * la cola como ingresar, sacar elementos o obtener informacion de la cola como
 * saber cual es el primer elemento y demas
 */
package Clases;

/**
 *
 * @author Jhonder Lopez Alfaro Carne C14252
 * @date 11/05/2022
 * @time 08:19:39 PM
 */
public class clsCola {

    //atributos
    private clsNodo primero, ultimo;
    private int tamanio;

    /**
     * Constructor vacío
     */
    public clsCola() {
    }

    /**
     * get del tamanio
     *
     * @return el tamanio
     */
    public int getTamanio() {
        return tamanio;
    }

    /**
     * metodo para saber si la cola se encuentra vacía
     *
     * @return un booleano con true si la cola está vacía y de lo contrario un
     * false
     */
    public boolean empty() {
        return primero == null;
    }

    /**
     * metodo para encolar o ingresar el elemento a la cola, tiene sus
     * validaciones y la inserccion, tambien aumente el tamanio y retorna
     *
     * @param dato el dato que se va a ingresar
     * @return un String con el ultimo dato
     */
    public String enqueue(String dato) {
        clsNodo nuevo = new clsNodo(dato);
        if (primero == null) {
            primero = ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
        tamanio++;
        return ultimo.getDato();
    }

    /**
     * metodo para conocer el primer elemento de la cola
     *
     * @return un string con el dato en la primera posicion
     *
     * @throws colaVaciaException es una excepcion en el caso que la cola se
     * encuentre vacía
     */
    public String first() throws colaVaciaException {
        if (primero == null) {
            throw new colaVaciaException("La cola está vacia");
        }
        return primero.getDato();
    }

    /**
     * metodo para desencolar o sacar el elemento de la cola
     *
     * @return el string con el elemento que saca el metodo
     *
     * @throws colaVaciaException es una excepcion en el caso que la cola se
     * encuentre vacía
     */
    public String dequeue() throws colaVaciaException {
        if (primero == null) {
            throw new colaVaciaException("La cola está vacia");
        }
        String dato = primero.getDato();
        primero = primero.getSiguiente();
        if (primero == null) {
            ultimo = null;
        }
        tamanio--;
        return dato;
    }

    /**
     * metodo para obtener un string con todos los datos de la cola
     *
     * @return un texto que contiene los elementos de la cola
     */
    public String imprimir() {
        String text = "";
        clsNodo actual = primero;
        while (actual != null) {
            text = text + actual.getDato() + "";
            actual = actual.getSiguiente();
        }
        return text;
    }

}
