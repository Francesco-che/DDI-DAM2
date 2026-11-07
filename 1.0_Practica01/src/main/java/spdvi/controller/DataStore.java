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
        Usuari u3 = new Usuari("David", "Martinez", "Zapata", "12332123", "654323456", LocalDate.now());
        Usuari u4 = new Usuari("Francesco", "Direnzo", "Cucchiarelli", "33333333C", "123456678", LocalDate.now());
        usuaris.add(u1);
        usuaris.add(u2);
        usuaris.add(u3);
        usuaris.add(u4);

        Joc j1 = new Joc("The Legend of Zelda", "Aventura", 5, 2, 0, 0); 
        Joc j2 = new Joc("Cyberpunk 2077", "Acció", 0, 0, 5, 5);
        Joc j3 = new Joc("Sea of Thieves", "Rol", 3, 2, 1, 0); 
        Joc j4 = new Joc("Call of Duty: Black ops 2", "Acció", 1, 4, 1, 3); 
        jocs.add(j1);
        jocs.add(j2);
        jocs.add(j3);
        jocs.add(j4);

        // Lloguers
        Lloguer ll1 = new Lloguer(comptadorLloguers++, u1, j1, "Switch 2", LocalDate.now().minusDays(10), LocalDate.now().minusDays(3), false);
        Lloguer ll2 = new Lloguer(comptadorLloguers++, u2, j2, "PC", LocalDate.now(), LocalDate.now().plusDays(7), true);
        Lloguer ll3 = new Lloguer(comptadorLloguers++, u3, j3, "PC", LocalDate.now(), LocalDate.now().plusDays(5), true);
        Lloguer ll4 = new Lloguer(comptadorLloguers++, u4, j3, "Xbox", LocalDate.now(), LocalDate.now().plusDays(2), true);
        Lloguer ll5 = new Lloguer(comptadorLloguers++, u1, j4, "PS5", LocalDate.now().minusDays(10), LocalDate.now().minusDays(5), true);

        lloguers.add(ll1);
        lloguers.add(ll2);
        lloguers.add(ll3);
        lloguers.add(ll4);
        lloguers.add(ll5);

    }
}
