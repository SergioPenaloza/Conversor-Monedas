import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        int menu = -1;
        float dinero = 0;

        Scanner scanner = new Scanner(System.in);




        ConsultaMoneda consulta = new ConsultaMoneda();



        while (menu != 7){
            System.out.println("**************************************");
            System.out.println("Bienvenido/a al conversor de moneda");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.println("***************************************");
            System.out.println("Elija una opcion valida: ");
            menu = scanner.nextInt();
            scanner.nextLine();

            String estadosUnidos = "USD";
            String colombia = "COP";
            String argentina = "ARS";
            String brazil = "BRL";

            if(menu >= 1 && menu <=6){
                System.out.println("Ingrese el valor que deseas convertir: ");
                String dinerotxt = scanner.nextLine();
                dinero = Float.valueOf(dinerotxt);
            }

            switch (menu){
                case 1:
                    consulta.conversionMoneda(estadosUnidos,argentina,dinero);
                    break;
                case 2:
                    consulta.conversionMoneda(argentina,estadosUnidos,dinero);
                    break;
                case 3:
                    consulta.conversionMoneda(estadosUnidos,brazil,dinero);
                    break;
                case 4:
                    consulta.conversionMoneda(brazil,estadosUnidos,dinero);
                    break;
                case 5:
                    consulta.conversionMoneda(estadosUnidos,colombia,dinero);
                    break;
                case 6:
                    consulta.conversionMoneda(colombia,estadosUnidos,dinero);
                    break;
                case 7:
                    System.out.println("Gracias por usar el programa");
                    break;
                default:
                    System.out.println("-- Advertencia -- Ingresa un numero de las opciones correctas");
            }
        }
        scanner.close();
    }
}
