/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import spdvi.model.Joc;
import spdvi.model.Lloguer;
import spdvi.model.Usuari;

/**
 *
 * @author frand
 */
public class DataStore {
    public static List<Usuari> usuaris = new ArrayList<>();
    public static List<Joc> jocs = new ArrayList<>();
    public static List<Lloguer> lloguers = new ArrayList<>();

    public static void inicialitzarDades() {
        // Dos usuaris diferents[cite: 3]
        Usuari u1 = new Usuari("Laura", "García", "Pérez", "11111111A", "600000000", LocalDate.now());
        Usuari u2 = new Usuari("Marc", "López", "Gómez", "22222222B", "611111111", LocalDate.now());
        usuaris.add(u1);
        usuaris.add(u2);

        // Joc 1 (PS5 i Switch 2) i Joc 2 (Xbox i PC)[cite: 3]
        Joc j1 = new Joc("The Legend of Zelda", "Aventura", 5, 5, 0, 0); 
        Joc j2 = new Joc("Cyberpunk 2077", "Acció", 0, 0, 5, 5); 
        jocs.add(j1);
        jocs.add(j2);

        // Lloguers inicials per usuari[cite: 3]
        Lloguer ll1 = new Lloguer(1, u1, j1, "Switch 2", LocalDate.now(), LocalDate.now().plusDays(7), false);
        j1.setStockSwitch2(j1.getStockSwitch2() - 1); // Consum de la unitat[cite: 3]
        
        Lloguer ll2 = new Lloguer(2, u2, j2, "PC", LocalDate.now(), LocalDate.now().plusDays(7), false);
        j2.setStockPC(j2.getStockPC() - 1); // Consum de la unitat[cite: 3]

        lloguers.add(ll1);
        lloguers.add(ll2);
    }
}
