
import java.sql.*;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Ejecutor {
    public static void main(String[] args){
        Semaphore sm = new Semaphore(1);
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca numero de registros aleatorios a insertar :");
        int numRegistros = sc.nextInt();
        System.out.println("Introduzca numero de hilos pare realizar la tarea :");
        int numHilos = sc.nextInt();
        int tramo = numRegistros/numHilos;
        int resto = numRegistros%numHilos;

        int inicio = 0;
        int fin = tramo;
        System.out.println(resto);
        for(int x = 1; x <= numHilos;x++){
            System.out.println("hilo"+ x);
            System.out.println("inicio"+ inicio);
            System.out.println("fin"+fin);
            Insercion hilo = new Insercion(inicio, fin);

            try {
                sm.acquire();
                hilo.start();
                sm.release();
                inicio = fin;
                if (x==numHilos-1){
                    fin = fin + tramo + resto;

                }else{
                    fin = fin+tramo;
                }




            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }






    }




}
