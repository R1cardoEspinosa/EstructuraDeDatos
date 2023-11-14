/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author David
 */
import java.util.ArrayList;
import java.util.List;

class NodoB {
    List<Integer> claves;
    List<NodoB> hijos;
    boolean esHoja;

    public NodoB() {
        this.claves = new ArrayList<>();
        this.hijos = new ArrayList<>();
        this.esHoja = true;
    }
}

public class ArbolB {
    private NodoB raiz;

    public ArbolB() {
        this.raiz = new NodoB();
    }

    public void insertar(int valor) {
        insertarRec(raiz, valor);
    }

    private void insertarRec(NodoB nodo, int valor) {
        if (nodo.claves.size() == 5) {
            NodoB nuevaRaiz = new NodoB();
            nuevaRaiz.hijos.add(nodo);
            dividirHijo(nuevaRaiz, 0);
            raiz = nuevaRaiz;
            insertarNoLleno(nuevaRaiz, valor);
        } else {
            insertarNoLleno(nodo, valor);
        }
    }

    private void insertarNoLleno(NodoB nodo, int valor) {
        int i = nodo.claves.size() - 1;

        if (nodo.esHoja) {
            while (i >= 0 && valor < nodo.claves.get(i)) {
                i--;
            }
            nodo.claves.add(i + 1, valor);
        } else {
            while (i >= 0 && valor < nodo.claves.get(i)) {
                i--;
            }
            i++;
            if (nodo.hijos.get(i).claves.size() == 2) {
                dividirHijo(nodo, i);
                if (valor > nodo.claves.get(i)) {
                    i++;
                }
            }
            insertarNoLleno(nodo.hijos.get(i), valor);
        }
    }

    private void dividirHijo(NodoB padre, int indice) {
        NodoB hijo = padre.hijos.get(indice);
        NodoB nuevoHijo = new NodoB();
        padre.hijos.add(indice + 1, nuevoHijo);
        padre.claves.add(indice, hijo.claves.get(1));

        nuevoHijo.claves.add(hijo.claves.remove(2));
        nuevoHijo.claves.add(hijo.claves.remove(1));

        if (!hijo.esHoja) {
            nuevoHijo.esHoja = false;
            nuevoHijo.hijos.add(hijo.hijos.remove(2));
            nuevoHijo.hijos.add(hijo.hijos.remove(1));
        }
    }

    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(NodoB nodo, int valor) {
        int i = 0;
        while (i < nodo.claves.size() && valor > nodo.claves.get(i)) {
            i++;
        }
        if (i < nodo.claves.size() && valor == nodo.claves.get(i)) {
            System.out.println("Se encontró el nodo con valor " + valor + " en el árbol.");
            return true;
        } else if (nodo.esHoja) {
            System.out.println("No se encontró el nodo con valor " + valor + " en el árbol.");
            return false;
        } else {
            return buscarRec(nodo.hijos.get(i), valor);
        }
    }

    public void eliminar(int valor) {
        // Implementa la lógica para eliminar un nodo
    }

    public static void main(String[] args) {
        ArbolB arbolB = new ArbolB();
        
        // Insertar valores de prueba
        arbolB.insertar(10);
        arbolB.insertar(20);
        arbolB.insertar(5);
        arbolB.insertar(6);
        arbolB.insertar(12);
        arbolB.insertar(30);
        arbolB.insertar(7);

        // Buscar un nodo
        arbolB.buscar(6);
        arbolB.buscar(15);

        // Eliminar un nodo
        arbolB.eliminar(12);
    }
}


