/**
 *
 * @author Alumno-64
 */
public class BusquedaBinaria {
    public static void main(String[] args) {
        int[] numerosAleatorios = generarNumerosAleatorios(1000);
        sortAscending(numerosAleatorios);
        
        System.out.println("Números aleatorios :");
        for (int numero : numerosAleatorios) {
            System.out.println(numero);
        }
    }

    public static int[] generarNumerosAleatorios(int contador) {
        int[] numeros = new int[contador];
        for (int i = 0; i < contador; i++) {
            numeros[i] = (int) (Math.random() * 10000);
        }
        return numeros;
    }

    public static void sortAscending(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    int busqueda = 34;
    int primero = 0;
    int ultimo = generarNumerosAleatorios().length -1;
    
    while (primero<=ultimo){
    int mitad = (primero - ultimo)/2;
    if (numerosAleatorios[mitad] == busqueda){
        System.out.println("El numero"+ busqueda +"se encuentra en la posicion"+ mi);
    }
         
}
}
           
