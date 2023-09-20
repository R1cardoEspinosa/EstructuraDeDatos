package ListaSimple;

public class Main {

    public static void main(String[] args) {

        System.out.println("Lista simple");
        ListaSimplementeEnlazada lista = new ListaSimplementeEnlazada();

        lista.insertar(5);
        lista.insertar(59);
        lista.insertar(91);
        lista.insertar(-17);
        lista.insertar(73);
        lista.insertar(34);
        lista.insertar(40);

        lista.eliminar(2);
        lista.eliminar(3);

        System.out.printf("Indice 3: %d\n", lista.obtener(3));
    }

}