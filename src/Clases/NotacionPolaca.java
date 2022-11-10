/**
 * En esta clase se crea los metodos necesarios para manejar la formula con las pilas y colas
 * de tal forma que se pueda ingresar la formula original a una cola y así trabajar con
 * ella desde la cola, tambien para saber si la formula está balanceada, para saber las prioridades,
 * ademas en la clase se hace el metodo para obtener la formula de infija a postfija y
 * posteriormente la evaluacion con un metodo que se encuentra en la misma clase
 */
package Clases;

/**
 *
 * @author Jhonder Lopez Alfaro Carne C14252
 * @date 28/06/2022
 * @time 07:08:00 PM
 */
public class NotacionPolaca {

    /**
     * este es el metodo para ingresar la formula en la cola y así tener la
     * formula en una cola que tiene el nombre de colaFormulaOriginal
     *
     * @param formula es un string que contiene la formula
     *
     * @param colaFormulaOriginal es la cola vacía que se va a llenar con al
     * formula en el metodo
     *
     * @return retorna un string con la formula para poder utilizarla en otros
     * metodos proximos
     *
     * @throws colaVaciaException es una excepcion que se muestra cuando la cola
     * está vacía y se intenta trabajar de una forma distinta a el ingreso
     */
    public String formulaOriginal(String formula, clsCola colaFormulaOriginal) throws colaVaciaException {
        formula = "(" + formula + ")";
        for (int i = 0; i < formula.length(); i++) {
            colaFormulaOriginal.enqueue(Character.toString(formula.charAt(i)));
        }
        String text = colaFormulaOriginal.imprimir();
        return text;
    }

    /**
     * etse es un metodo que se crea para saber si la pila se encuentra
     * balanceada
     *
     * @param formula es un string con la formula que se quiere saber si es
     * balanceada
     *
     * @param pila es la pila que se utiliza para validar que la formula está
     * balanceada
     */
    public void balanceo(String formula, clsPila pila) {
        for (int i = 0; i < formula.length(); i++) {
            if (formula.charAt(i) == '(') {
                pila.push(Character.toString(formula.charAt(i)));
            }
            if (formula.charAt(i) == ')') {
                if (pila.empty()) {
                    pila.push("1");
                    return;
                } else if (pila.top().equals("(")) {
                    pila.pop();
                }
            }
            if (formula.charAt(i) == '[') {
                pila.push(Character.toString(formula.charAt(i)));
            }
            if (formula.charAt(i) == ']') {
                if (pila.empty()) {
                    pila.push("1");
                    return;
                } else if (pila.top().equals("[")) {
                    pila.pop();
                }
            }
            if (formula.charAt(i) == '{') {
                pila.push(Character.toString(formula.charAt(i)));
            }
            if (formula.charAt(i) == '}') {
                if (pila.empty()) {
                    pila.push("1");
                    return;
                } else if (pila.top().equals("{")) {
                    pila.pop();
                }
            }
        }
    }

    /**
     * este metodo es creado para saber la prioridad que tienen las distintas
     * operaciones que se pueden ralizar con la calculadora y así saber la
     * operacion que tienen que realizar para obtener la formula postfija
     *
     * @param caracter este es el caractes o mejor dicho la expresion de la
     * formula
     *
     * @return un numero segun la prioridad que tenga el caracter
     */
    public int prioridad(String caracter) {
        int result = 6;
        if (caracter.equals("^") || caracter.equals("?") || caracter.equals("%") || caracter.equals("#") || caracter.equals("&")) {
            result = 5;
        } else if (caracter.equals("*") || caracter.equals("/")) {
            result = 4;
        } else if (caracter.equals("+") || caracter.equals("-")) {
            result = 3;
        } else if (caracter.equals(")") || caracter.equals("]") || caracter.equals("}")) {
            result = 2;
        } else if (caracter.equals("(") || caracter.equals("[") || caracter.equals("{")) {
            result = 1;
        }
        return result;
    }

    /**
     * este metodo es el que hace que la formula postfija quede ordenada de la
     * forma necesaria realizando los pasos necesarios como ingresar y sacar de
     * la cola con la prioridad que tenga el caracter
     *
     * @param colaFormulaOriginal es una cola con la que se va a trabajar en
     * conjunto con una pila temporal la cual nos mantiene los elementos que
     * luego se ingresan en la cola para así lograr obtener la formula postfija
     *
     * @return retorna la cola con la formula postfija dentro de ella
     *
     * @throws colaVaciaException es una excepcion que se muestra cuando la cola
     * está vacía y se intenta trabajar de una forma distinta a el ingreso
     */
    public clsCola formulaPostfija(clsCola colaFormulaOriginal) throws colaVaciaException {
        clsCola colaFormulaPostfija = new clsCola();
        clsPila pila = new clsPila();

        int tamanio = colaFormulaOriginal.getTamanio();
        for (int i = 0; i < tamanio; i++) {
            String caracter = colaFormulaOriginal.dequeue();
            switch (prioridad(caracter)) {
                case 5:
                case 1:
                    pila.push(caracter);
                    break;
                case 2:
                    while (prioridad(pila.top()) != 1) {
                        colaFormulaPostfija.enqueue(pila.pop());
                    }
                    pila.pop();
                    break;
                case 3:
                case 4:
                    while (prioridad(pila.top()) >= prioridad(caracter)) {
                        colaFormulaPostfija.enqueue(pila.pop());
                    }
                    pila.push(caracter);
                    break;
                default:
                    colaFormulaPostfija.enqueue(caracter);
            }
        }
        return colaFormulaPostfija;
    }

    /**
     * en este metodo se van a realizar las operaciones matematicas para obtener
     * un resultado conforme con la formula postfija, en el metodo se va a
     * realizar la operacion segun su signo y continuar hasta que se terminen
     * los elementos en la cola de la formula postfija y en ese momento mostrar
     * el resultado
     *
     * @param colaFormulaPostfija es la cola de formula postfija que es con la
     * que se trabaja para realizar las opreaciones hasta que esta quede vacía
     *
     * @return retorna un texto con el resultado obtenido en las operaciones que
     * se encontraban en la cola
     *
     * @throws colaVaciaException es una excepcion que se muestra cuando la cola
     * está vacía y se intenta trabajar de una forma distinta a el ingreso
     */
    public String evaluarFormula(clsCola colaFormulaPostfija) throws colaVaciaException {
        double resultado;
        clsPila pila = new clsPila();
        while (colaFormulaPostfija.empty() == false) {
            if (!"*".equals(colaFormulaPostfija.first()) && !"/".equals(colaFormulaPostfija.first())
                    && !"+".equals(colaFormulaPostfija.first()) && !"-".equals(colaFormulaPostfija.first())
                    && !"^".equals(colaFormulaPostfija.first()) && !"?".equals(colaFormulaPostfija.first())
                    && !"%".equals(colaFormulaPostfija.first()) && !"#".equals(colaFormulaPostfija.first())
                    && !"&".equals(colaFormulaPostfija.first())) {
                pila.push(colaFormulaPostfija.dequeue());
            } else {
                double operando1;
                double operando2;
                double operacion = 0;
                switch (colaFormulaPostfija.first()) {
                    case "*":
                        operando1 = Double.parseDouble(pila.pop());
                        operando2 = Double.parseDouble(pila.pop());
                        operacion = operando1 * operando2;
                        break;
                    case "/":
                        operando1 = Double.parseDouble(pila.pop());
                        operando2 = Double.parseDouble(pila.pop());
                        operacion = operando2 / operando1;
                        break;
                    case "+":
                        operando1 = Double.parseDouble(pila.pop());
                        operando2 = Double.parseDouble(pila.pop());
                        operacion = operando2 + operando1;
                        break;
                    case "-":
                        operando1 = Double.parseDouble(pila.pop());
                        operando2 = Double.parseDouble(pila.pop());
                        operacion = operando2 - operando1;
                        break;
                    case "^"://potencia
                        operando1 = Double.parseDouble(pila.pop());
                        operando2 = Double.parseDouble(pila.pop());
                        double potencia = Math.pow(operando2, operando1);
                        operacion = potencia;
                        break;
                    case "?"://raiz
                        operando1 = Double.parseDouble(pila.pop());
                        operacion = Math.sqrt(operando1);
                        break;
                    case "%"://sen
                        operando1 = Double.parseDouble(pila.pop());
                        operacion = Math.sin(operando1);
                        break;
                    case "#"://cos
                        operando1 = Double.parseDouble(pila.pop());
                        operacion = Math.cos(operando1);
                        break;
                    case "&"://tan
                        operando1 = Double.parseDouble(pila.pop());
                        operacion = Math.cos(operando1);
                        break;
                }
                pila.push(String.valueOf(operacion));
                colaFormulaPostfija.dequeue();
            }
        }
        resultado = Double.parseDouble(pila.top());
        String mostrar = String.valueOf(resultado);
        return mostrar;
    }
}
