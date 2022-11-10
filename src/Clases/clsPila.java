/**
 * En esta clase se crea una cola con su cima para poder manejarse
 * entre sus datos con el nodo que contiene el siguiente elemento bajo ella,
 * tiene sus constructores y set y get para la definicion y obtencion de los
 * datos y metodos para manejar la pila como ingresar, sacar elementos o obtener
 * informacion de la cola como saber cual es el elemento en el top de la pila y demas
 */
package Clases;

import java.util.EmptyStackException;

/**
 *
 * @author Jhonder Lopez Alfaro Carne C14252
 * @date 11/05/2022
 * @time 08:19:39 PM
 */
public class clsPila {

    //atributos
    private clsNodo cima;
    private final int tamanio;
    private int contElementos;

    /**
     * constructor sin parametros que setea algunos atributos en 0
     */
    public clsPila() {
        tamanio = 0;
        contElementos = 0;
    }

    /**
     * constructor con un parametro para definir su tamanio
     *
     * @param tamanio un int con el tamanio
     */
    public clsPila(int tamanio) {
        if (tamanio >= 1) {
            this.tamanio = tamanio;
        } else {
            this.tamanio = 0;
        }
        contElementos = 0;
    }

    /**
     * metodo para saber si la pila se encuentra vacía
     *
     * @return un booleano con true si la pila está vacía y de lo contrario un
     * false
     */
    public boolean empty() {
        return cima == null;
    }

    /**
     * este metodo nos dice cual es el elemento que se encuentra mas arriba en
     * la pila, en su cima
     *
     * @return el string o texto con su primer elemento o el elemento que se
     * encuentra mas arriba, en la cima de la pila
     *
     * @throws EmptyStackException cuando la pila se encuentra vacía se va a
     * mostrar esta excepcion
     */
    public String top() throws EmptyStackException {
        if (cima == null) {
            throw new EmptyStackException();
        }
        return cima.getDato();
    }

    /**
     * este metodo es para quitar el elemento de la pila, el elemento es el que
     * se encuentra en la cima de la pila, el de mas arriba
     *
     * @return un string o texto con el elemento dicho
     * @throws EmptyStackException cuando la pila se encuentra vacía se va a
     * mostrar esta excepcion
     */
    public String pop() throws EmptyStackException {
        if (cima == null) {
            throw new EmptyStackException();
        }
        String dato = cima.getDato();
        cima = cima.getSiguiente();
        contElementos--;
        return dato;
    }

    /**
     * este metodo es para ingresar un elemento en la cima de la pila y que el
     * elemento que se pase por parametros quede en lo mas arriba de la pila
     *
     * @param dato el dato a ingresar en la pila
     *
     * @return un string o texto con el elemento que se ingresa
     */
    public String push(String dato) {
        if (tamanio != 0 && tamanio == contElementos) {
            throw new StackOverflowError();
        }
        clsNodo nuevo = new clsNodo(dato);
        nuevo.setSiguiente(cima);
        cima = nuevo;
        contElementos++;
        return cima.getDato();
    }

    /**
     * metodo para almacenar en un string todos los elementos de la pila y
     * posteriormente poder verlos
     *
     * @return un string o texto con todos los elementos de la pila
     */
    public String imprimir() {
        String text = "";
        clsNodo actual = cima;
        while (actual != null) {
            text = text + actual.getDato() + " ";
            actual = actual.getSiguiente();
        }
        return text;
    }
}
