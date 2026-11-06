/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi.model;

/**
 *
 * @author frand
 */
public class Joc {
    private String titol;
    private String genere;
    private int stockPS5;
    private int stockSwitch2;
    private int stockXbox;
    private int stockPC;

    public Joc(String titol, String genere, int stockPS5, int stockSwitch2, int stockXbox, int stockPC) {
        this.titol = titol;
        this.genere = genere;
        this.stockPS5 = stockPS5;
        this.stockSwitch2 = stockSwitch2;
        this.stockXbox = stockXbox;
        this.stockPC = stockPC;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public int getStockPS5() {
        return stockPS5;
    }

    public void setStockPS5(int stockPS5) {
        this.stockPS5 = stockPS5;
    }

    public int getStockSwitch2() {
        return stockSwitch2;
    }

    public void setStockSwitch2(int stockSwitch2) {
        this.stockSwitch2 = stockSwitch2;
    }

    public int getStockXbox() {
        return stockXbox;
    }

    public void setStockXbox(int stockXbox) {
        this.stockXbox = stockXbox;
    }

    public int getStockPC() {
        return stockPC;
    }

    public void setStockPC(int stockPC) {
        this.stockPC = stockPC;
    }

    @Override
    public String toString() {
        return titol;
    }
}
