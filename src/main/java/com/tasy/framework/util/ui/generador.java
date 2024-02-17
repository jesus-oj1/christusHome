//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.tasy.framework.util.ui;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class generador {
    String strFechaNacimiento = "21/03/1990";

    public generador() {
    }
    public String generadorNombre() {
        String[] nombre = new String[]{"Luis", "Carlos", "Brandon", "Ana", "Jahir", "Gloria", "Aleyma", "Alejandra", "Paulina", "Adam", "Axel", "Dante", "Dylan", "Enzo", "Erik", "Gael", "Izan", "Bruno", "Hugo", "Izan", "Joel", "Lucas", "Oliver", "Tiago"};
        int indiceAleatorio = numeroAleatorioEnRango(0, nombre.length - 1);
        String nombreAleatorio = nombre[indiceAleatorio];
        return nombreAleatorio;
    }
    public String generadorPrimerApellido() {
        String[] primerApellido = new String[]{"Savage", "Reyes", "Gonzalez", "Fuentes", "Rosas", "Ortiz", "Cardenas", "Hernandez", "Romero", "Alvarez", "Mendez", "Garcia", "Martinez", "Lopez", "Gonzalez", "Perez", "Rodriguez", "Sanchez", "Ramirez", "Cruz", "Flores", "Gomez", "Morales", "Vazquez", "Reyes", "Jimenez", "Torres", "Diaz", "Gutierrez", "Ruiz", "Mendoza", "Aguilar", "Moreno", "Castillo", "Chavez", "Rivera", "Juarez", "Ramos", "Dominguez", "Herrera", "Medina", "Castro"};
        int indiceAleatorio = numeroAleatorioEnRango(0, primerApellido.length - 1);
        String primerApellidoAleatorio = primerApellido[indiceAleatorio];
        return primerApellidoAleatorio;
    }
    public String generadorSegundoApellido() {
        String[] segundoApellido = new String[]{"Savage", "Reyes", "Gonzalez", "Fuentes", "Rosas", "Ortiz", "Cardenas", "Hernandez", "Romero", "Alvarez", "Mendez", "Garcia", "Martinez", "Lopez", "Gonzalez", "Perez", "Rodriguez", "Sanchez", "Ramirez", "Cruz", "Flores", "Gomez", "Morales", "Vazquez", "Reyes", "Jimenez", "Torres", "Diaz", "Gutierrez", "Ruiz", "Mendoza", "Aguilar", "Moreno", "Castillo", "Chavez", "Rivera", "Juarez", "Ramos", "Dominguez", "Herrera", "Medina", "Castro"};
        int indiceAleatorio = numeroAleatorioEnRango(0, segundoApellido.length - 1);
        String segundoApellidoAleatorio = segundoApellido[indiceAleatorio];
        return segundoApellidoAleatorio;
    }
    public String generadorFecha() {
        Integer intDia = getRandomNumberInRange(1, 30);
        Integer intMes = getRandomNumberInRange(1, 12);
        Integer intAnio = getRandomNumberInRange(1980, 2004);
        if (intMes == 2 && intDia > 28) {
            intDia = 28;
        }

        String strDia = intDia.toString();
        String strMes = intMes.toString();
        String strAnio = intAnio.toString();
        if (intDia < 10) {
            strDia = "0" + intDia.toString();
        }

        if (intMes < 10) {
            strMes = "0" + intMes.toString();
        }

        this.strFechaNacimiento = strDia + strMes + strAnio;
        return this.strFechaNacimiento;
    }
    public String generadorConyugal() {
        String[] Conyugal = new String[]{"Soltero", "Casado", "Divorciado", "Viudo", "Otros"};
        int indiceAleatorio = numeroAleatorioEnRango(0, Conyugal.length - 1);
        String conyugalAleatorio = Conyugal[indiceAleatorio];
        return conyugalAleatorio;
    }
    public String generadorSexo() {
        String[] Sexo = new String[]{"Femenino", "Masculino"};
        int indiceAleatorio = numeroAleatorioEnRango(0, Sexo.length - 1);
        String sexoAleatorio = Sexo[indiceAleatorio];
        return sexoAleatorio;
    }
    public String generadorEstadoNacimiento() {
        String[] estadoNacimiento = new String[]{"Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas", "Chihuahua", "Ciudad de México", "Coahuila", "Durango", "Estado de México", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Otros (internacional)", "Puebla", "Querétaro", "Quintana Roo", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas"};
        int indiceAleatorio = numeroAleatorioEnRango(0, estadoNacimiento.length - 1);
        String estadolAleatorio = estadoNacimiento[indiceAleatorio];
        return estadolAleatorio;
    }
    public String celular() {
        String[] numeroCelular = new String[]{"8118957054", "8118957053", "8118957052", "8118957051", "8118957055", "8118957056", "8118957057", "8118957058", "8118957059", "8118957014", "8118957024", "8118957034", "8118957044", "8118957064", "8118957074", "8118957084", "8118957094", "8118957154", "8118957254", "8118957354", "8118957454", "8118957554", "8118957654", "8118957754", "8118957854"};
        int indiceAleatorio = numeroAleatorioEnRango(0, numeroCelular.length - 1);
        String aleatorioCelular = numeroCelular[indiceAleatorio];
        return aleatorioCelular;
    }
    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        } else {
            Random r = new Random();
            return r.nextInt(max - min + 1) + min;
        }
    }
    public static int numeroAleatorioEnRango(int minimo, int maximo) {
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }
}
