
package javaapplication1;

import java.util.Scanner;

public class JavaApplication1 {

  
    public static void main(String[] args) {
        
        // la clase y el objecto

        Scanner scanner=new Scanner (System.in);
        
         
        // Variables

        int documento, tipo_vehiculo, modelo, edad;
        String nombre; 
        double costoBase =0;
        double costoAdicional = 0;
        double interes = 0;
        String tipoSeguro = "";
        double costoCotizacion = 0;
        
        // se inicia el ingreso con 1 

      System.out.println("Para iniciar la app presione 1, para terminar marque 0 "); 
        int init = scanner.nextInt();

        // se inicia el ciclo mientras, teniendo varias opciones. Dentro de esas opciones estan 1 cotizar, 2 pagar y 3 salir.
        // se le pregunta nombre, edad, documento con las variables dentro de la clase scanner.

        while (init != 0) { 
            System.out.println("Seleccione 1. cotizar 2. pagar 3. Salir"); 
            int servicio = scanner.nextInt(); 

            if (servicio == 1) { 
                System.out.println("Cotizar");

                // Registro Usuario
                System.out.println("Ingrese el nombre ");
                nombre = scanner.next();

                System.out.println("Ingrese el documento ");
                documento = scanner.nextInt();

                System.out.println("Ingrese edad ");
                edad = scanner.nextInt();

                System.out.println("Ingrese tipo de vehículo 1 = carro, 2 = moto, 3 = bicicleta ");
                tipo_vehiculo = scanner.nextInt();

                System.out.println("Ingrese modelo de vehículo ");
                modelo = scanner.nextInt();

                scanner.nextLine();

                // Definir los costos y tipo de seguro según el tipo de vehículo
                
                if (tipo_vehiculo == 1) {
                    tipoSeguro = "Seguro de Carro";
                    costoBase = 100000;
                    costoAdicional = 10000;
                    interes = 0.08;
                } else if (tipo_vehiculo == 2) {
                    tipoSeguro = "Seguro de Moto";
                    costoBase = 50000;
                    costoAdicional = 5000;
                    interes = 0.05;
                } else if (tipo_vehiculo == 3) {
                    tipoSeguro = "Seguro de Bicicleta";
                    costoBase = 20000;
                    costoAdicional = 2000;
                    interes = 0.03;
                } else {
                    System.out.println("Selección inválida.");
                    continue; // Si la selección es inválida, vuelve al inicio del ciclo.
                }

                // Calcular la cotización total
                costoCotizacion = costoBase + costoAdicional + (costoBase * interes);

                // Mostrar cotización al usuario
                
                System.out.println("\nCotización del Seguro:");
                System.out.println("Tipo de Vehículo: " + tipoSeguro);
                System.out.println("Costo Base Anual: $" + costoBase);
                System.out.println("Seguro Adicional: $" + costoAdicional);
                System.out.println("Interés aplicado: " + (interes * 100) + "%");
                System.out.println("Costo Total Anual: $" + costoCotizacion);

                
                // segunda opcion de servicio pagar
                
            } else if (servicio == 2) { 
                if (costoCotizacion == 0) {
                    System.out.println("¡Debe cotizar un seguro primero! Primero realice una cotización antes de poder pagar.");
                } else {
                    
                    // Opción de pago si ya hay una cotización disponible
                    
                    System.out.println("\n¿Desea proceder con el pago?");
                    System.out.println("1. Sí");
                    System.out.println("2. No");
                    int opcionPago = scanner.nextInt();
                    scanner.nextLine(); 

                    // opcion uno de pagar
                    
                    if (opcionPago == 1) {
                        System.out.print("Ingrese el monto a pagar: $");
                        double pago = scanner.nextDouble();
                        scanner.nextLine();

                        // Validar si el monto pagado es suficiente
                        
                        if (pago >= costoCotizacion) {
                            System.out.println("Pago exitoso. El seguro ha sido contratado.");
                        } else {
                            System.out.println("Pago insuficiente. El monto a pagar es de $" + costoCotizacion);
                        }
                    } else {
                        System.out.println("Pago cancelado. Gracias por usar el servicio.");
                    }
                }
                
                // tercera opcion salir 
                
            } else if (servicio == 3) { 
                System.out.println("Salir");
                init = 0; // Salir del ciclo
            } else {
                System.out.println("Selección inválida. Por favor seleccione una opción válida.");
            }
        }

        scanner.close(); // Cerrar el scanner fuera del ciclo
    }
}
  