/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listadoblementeenlazada;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {

        ListaDoblementeEnlazada listadoble = new ListaDoblementeEnlazada();
        
        
        listadoble.insertar(5);
        listadoble.insertar(59);
        listadoble.insertar(91);
        listadoble.insertar(-17);
        listadoble.insertar(73);
        listadoble.insertar(34);
        listadoble.insertar(40);
        
        listadoble.eliminar(2);
        listadoble.eliminar(3);
        
        System.out.println(listadoble.obtener(3));
        
    }
}
