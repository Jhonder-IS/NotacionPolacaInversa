/**
 * esta clase crea los nodos para manekar los siguientes y los datos de la cola,
 * tiene sus atributos como son el elemento y el siguiente a ese elemento,
 * tambien tiene sus set y get para la obtencion y definicion de los atributos
 */
package Clases;

/**
 *
 * @author Jhonder Lopez Alfaro Carne C14252
 * @date 09/05/2022
 * @time 01:54:42 PM
 */
public class clsNodo {

    //atributos
    private String dato;
    private clsNodo siguiente;

    /**
     * constructor vacio
     */
    public clsNodo() {
    }

    /**
     * constructor con un dato que es el elemento
     *
     * @param dato
     */
    public clsNodo(String dato) {
        this.dato = dato;
    }

    /**
     * metodo get para obtener el dato
     *
     * @return el dato
     */
    public String getDato() {
        return dato;
    }

    /**
     * metodo para definir el dato
     *
     * @param dato el dato que se va a definir
     */
    public void setDato(String dato) {
        this.dato = dato;
    }

    /**
     * metodo para obtener el siguiente nodo
     *
     * @return el siguiente nodo
     */
    public clsNodo getSiguiente() {
        return siguiente;
    }

    /**
     * metodo para definir el siguiente nodo
     *
     * @param siguiente el siguiente nodo
     */
    public void setSiguiente(clsNodo siguiente) {
        this.siguiente = siguiente;
    }
}
