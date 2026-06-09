package com.mycompany.projectcars;

import java.util.Scanner;

public class ProjectCars {

    public static void main(String[] args) {
        Scanner data = new Scanner(System.in);
        Vehicles gestor = new Vehicles();
        boolean menu_status = true;

        while (menu_status) {
            System.out.println("\n::: MAIN MENU :::");
            System.out.println("[1]. Users Menu");
            System.out.println("[2]. Cities Menu");
            System.out.println("[3]. Vehicles Menu");
            System.out.println("[4]. Brands Menu");
            System.out.println("[5]. Exit");
            System.out.print("Seleccione una opcion: ");
            
            int opt = data.nextInt(); 
            data.nextLine();

            if (opt == 3) {
                boolean sub_menu = true;
                while (sub_menu) {
                    System.out.println("\n::: VEHICLES MENU :::");
                    System.out.println("[1]. Register vehicle");
                    System.out.println("[2]. List vehicles");
                    System.out.println("[3]. Search vehicle");
                    System.out.println("[3]. Update vehicle");
                    System.out.println("[5]. Delete vehicle");
                    System.out.println("[6]. Back");
                    System.out.print(".::: Press an option: ");
                    
                    int vOpt = data.nextInt(); 
                    data.nextLine();

                    switch (vOpt) {
                        case 1:
                            System.out.print("ID: "); int id = data.nextInt(); data.nextLine();
                            System.out.print("Modelo: "); String modelo = data.nextLine();
                            System.out.print("Color: "); String color = data.nextLine();
                            System.out.print("Placa: "); String placa = data.nextLine();
                            System.out.println(gestor.register(id, modelo, color, placa));
                            break;
                        case 2:
                            var lista = gestor.list();
                            if (lista.isEmpty()) System.out.println("No hay vehiculos.");
                            else for (Vehicles v : lista) System.out.println(v);
                            break;
                        case 3:
                            System.out.print("Ingrese placa a buscar: ");
                            Vehicles v = gestor.search(data.nextLine());
                            System.out.println(v != null ? v : "No encontrado.");
                            break;
                        case 4:
                            System.out.print("Ingrese la placa del vehiculo a actualizar: ");
                            String placaBusqueda = data.nextLine();
                            if (gestor.search(placaBusqueda) != null) {
                                System.out.print("Nuevo ID: "); int nuevoId = data.nextInt(); data.nextLine();
                                System.out.print("Nuevo Modelo: "); String nuevoModelo = data.nextLine();
                                System.out.print("Nuevo Color: "); String nuevoColor = data.nextLine();
                                if (gestor.update(placaBusqueda, nuevoId, nuevoModelo, nuevoColor)) {
                                    System.out.println("Vehículo actualizado correctamente.");
                                } else {
                                    System.out.println("Error al actualizar.");
                                }
                            } else {
                                System.out.println("No se encontro un vehiculo con esa placa.");
                            }
                            break;
                        case 5:
                            System.out.print("Ingrese placa a borrar: ");
                            System.out.println(gestor.delete(data.nextLine()) ? "Vehiculo borrado." : "No encontrado.");
                            break;
                        case 6:
                            sub_menu = false;
                            break;
                        default:
                            System.out.println("Opcion invalida.");
                    }
                }
            } else if (opt == 5) {
                System.out.println("Saliendo del sistema...");
                menu_status = false;
            }
        }
        data.close();
    }
}