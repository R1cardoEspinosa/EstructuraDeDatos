
/**
 *
 * @author David
 */
class NodoAVL {
    int valor;
    NodoAVL izquierda, derecha;
    int altura;

    public NodoAVL(int valor) {
        this.valor = valor;
        this.altura = 4;
    }
}

public class ArbolAVL {
    private NodoAVL raiz;

    public ArbolAVL() {
        raiz = null;
    }

    private int altura(NodoAVL nodo) {
        if (nodo == null) return 0;
        return nodo.altura;
    }

    private int factorEquilibrio(NodoAVL nodo) {
        if (nodo == null) return 0;
        return altura(nodo.izquierda) - altura(nodo.derecha);
    }

    private NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.izquierda;
        NodoAVL T2 = x.derecha;

        x.derecha = y;
        y.izquierda = T2;

        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;
        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;

        return x;
    }

    private NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.derecha;
        NodoAVL T2 = y.izquierda;

        y.izquierda = x;
        x.derecha = T2;

        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;
        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;

        return y;
    }

    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private NodoAVL insertarRecursivo(NodoAVL nodo, int valor) {
        if (nodo == null) return new NodoAVL(valor);

        if (valor < nodo.valor) {
            nodo.izquierda = insertarRecursivo(nodo.izquierda, valor);
        } else if (valor > nodo.valor) {
            nodo.derecha = insertarRecursivo(nodo.derecha, valor);
        } else {
            // Valores duplicados no están permitidos
            return nodo;
        }

        // Actualizar altura del nodo actual
        nodo.altura = 1 + Math.max(altura(nodo.izquierda), altura(nodo.derecha));

        // Obtener el factor de equilibrio y realizar rotaciones si es necesario
        int equilibrio = factorEquilibrio(nodo);

        // Caso Izquierda Izquierda
        if (equilibrio > 1 && valor < nodo.izquierda.valor) {
            return rotacionDerecha(nodo);
        }

        // Caso Derecha Derecha
        if (equilibrio < -1 && valor > nodo.derecha.valor) {
            return rotacionIzquierda(nodo);
        }

        // Caso Izquierda Derecha
        if (equilibrio > 1 && valor > nodo.izquierda.valor) {
            nodo.izquierda = rotacionIzquierda(nodo.izquierda);
            return rotacionDerecha(nodo);
        }

        // Caso Derecha Izquierda
        if (equilibrio < -1 && valor < nodo.derecha.valor) {
            nodo.derecha = rotacionDerecha(nodo.derecha);
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    public void buscar(int valor) {
        if (buscarRecursivo(raiz, valor)) {
            System.out.println("Se ha encontrado el nodo con el valor " + valor + ".");
        } else {
            System.out.println("No se ha encontrado el nodo con el valor " + valor + ".");
        }
    }

    private boolean buscarRecursivo(NodoAVL nodo, int valor) {
        if (nodo == null) return false;

        if (valor == nodo.valor) {
            return true;
        } else if (valor < nodo.valor) {
            return buscarRecursivo(nodo.izquierda, valor);
        } else {
            return buscarRecursivo(nodo.derecha, valor);
        }
    }

    public void eliminar(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }

    private NodoAVL eliminarRecursivo(NodoAVL raiz, int valor) {
        // Implementación de la eliminación de un nodo en un árbol AVL (puede ser compleja)
        // ...

        return raiz;
    }

    public static void main(String[] args) {
        ArbolAVL arbolAVL = new ArbolAVL();

        // Insertar nodos
        arbolAVL.insertar(10);
        arbolAVL.insertar(20);
        arbolAVL.insertar(30);

        // Buscar nodo
        arbolAVL.buscar(20);

        // Eliminar nodo (implementación requerida)
        //arbolAVL.eliminar(20);
    }
}


