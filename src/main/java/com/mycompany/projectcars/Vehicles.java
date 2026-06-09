package com.mycompany.projectcars;

import java.util.ArrayList;
import java.util.List;

public class Vehicles {
    private int id;
    private String modelo;  
    private String color;   
    private String plate_number;
    
    private static List<Vehicles> listaVehiculos = new ArrayList<>();

    public Vehicles() {}

    public Vehicles(int id, String modelo, String color, String plate_number) {
        this.id = id;
        this.modelo = modelo;
        this.color = color;
        this.plate_number = plate_number;
    }

    public String register(int id, String modelo, String color, String plate_number) {
        for (Vehicles v : listaVehiculos) {
            if (v.plate_number.equalsIgnoreCase(plate_number)) {
                return "Error: Placa ya registrada.";
            }
        }
        listaVehiculos.add(new Vehicles(id, modelo, color, plate_number));
        return "Vehículo registrado correctamente.";
    }

    public List<Vehicles> list() {
        return listaVehiculos;
    }

    public Vehicles search(String plate) {
        for (Vehicles v : listaVehiculos) {
            if (v.plate_number.equalsIgnoreCase(plate)) return v;
        }
        return null;
    }

    public boolean update(String plateToFind, int newId, String newModelo, String newColor) {
        for (Vehicles v : listaVehiculos) {
            if (v.plate_number.equalsIgnoreCase(plateToFind)) {
                v.id = newId;
                v.modelo = newModelo;
                v.color = newColor;
                return true;
            }
        }
        return false;
    }

    public boolean delete(String plate) {
        return listaVehiculos.removeIf(v -> v.plate_number.equalsIgnoreCase(plate));
    }

    @Override
    public String toString() {
        return "--------------------------" +
               "\nID     : " + id + 
               "\nMODELO : " + modelo + 
               "\nCOLOR  : " + color + 
               "\nPLACA  : " + plate_number + 
               "\n--------------------------";
    }
}