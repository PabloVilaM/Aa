package com.game;

import java.util.HashMap;
import java.util.Map;

public class Preguntas {

    public static void crearLista(){
        Map<Integer, String> map = new HashMap<>();
        //Sección de casteo
        map.put(1, "Es necesario poner casteo de int a double?");
        map.put(2, "Es necesario poner casteo de double a int?");
        map.put(3, "Es necesario poner casteo de short a byte?");
        map.put(4, "Es necesario poner casteo de float a double?");
        map.put(5, "Es necesario poner casteo de double a float?");
        map.put(6, "Es necesario poner casteo de integer a long?");
        map.put(7, "Es necesario poner casteo de long a integer?");
        map.put(8, "Es necesario poner casteo de short a long?");
        map.put(9, "Es necesario poner casteo de long a short??");
        map.put(10, "Es necesario poner casteo de byte a short?");
        //Seccion de String
        map.put(11, "Es necesario poner casteo de int a double?");
        map.put(12, "Es necesario poner casteo de double a int?");
        map.put(13, "Es necesario poner casteo de short a byte?");
        map.put(14, "Es necesario poner casteo de float a double?");
        map.put(15, "Es necesario poner casteo de double a float?");
        map.put(16, "Es necesario poner casteo de integer a long?");
        map.put(17, "Es necesario poner casteo de long a integer?");
        map.put(18, "Es necesario poner casteo de short a long?");
        map.put(19, "Es necesario poner casteo de long a short??");
        map.put(20, "Es necesario poner casteo de byte a short?");

    }

    public static void darPreguntas(int code){
        Map<Integer, String> map = new HashMap<>();

        map.put(1,"Cual es la respuesta");
    }
}
