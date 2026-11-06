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
    
    public static int comptadorLloguers = 1;

    public static void inicialitzarDades() {
        Usuari u1 = new Usuari("Mohamed", "Amine", "Kartibou", "11111111A", "600000000", LocalDate.now());
        Usuari u2 = new Usuari("Jeremy", "Samuel", "Hernandez", "22222222B", "611111111", LocalDate.now());
        usuaris.add(u1);
        usuaris.add(u2);

        Joc j1 = new Joc("The Legend of Zelda", "Aventura", 5, 2, 0, 0); 
        Joc j2 = new Joc("Cyberpunk 2077", "Acció", 0, 0, 5, 5); 
        jocs.add(j1);
        jocs.add(j2);

        // Lloguers
        Lloguer ll1 = new Lloguer(comptadorLloguers++, u1, j1, "Switch 2", LocalDate.now().minusDays(10), LocalDate.now().minusDays(3), false);
        Lloguer ll2 = new Lloguer(comptadorLloguers++, u2, j2, "PC", LocalDate.now(), LocalDate.now().plusDays(7), true);

        lloguers.add(ll1);
        lloguers.add(ll2);
    }
}
