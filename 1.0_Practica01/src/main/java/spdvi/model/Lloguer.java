/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi.model;

import java.time.LocalDate;

/**
 *
 * @author frand
 */
public class Lloguer {
    private int numRegistre;
    private Usuari usuari;
    private Joc joc;
    private String plataforma;
    private LocalDate dataInici;
    private LocalDate dataPrevista;
    private boolean retornat;

    public Lloguer(int numRegistre, Usuari usuari, Joc joc, String plataforma, LocalDate dataInici, LocalDate dataPrevista, boolean retornat) {
        this.numRegistre = numRegistre;
        this.usuari = usuari;
        this.joc = joc;
        this.plataforma = plataforma;
        this.dataInici = dataInici;
        this.dataPrevista = dataPrevista;
        this.retornat = retornat;
    }

    public int getNumRegistre() {
        return numRegistre;
    }

    public void setNumRegistre(int numRegistre) {
        this.numRegistre = numRegistre;
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }

    public Joc getJoc() {
        return joc;
    }

    public void setJoc(Joc joc) {
        this.joc = joc;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public LocalDate getDataInici() {
        return dataInici;
    }

    public void setDataInici(LocalDate dataInici) {
        this.dataInici = dataInici;
    }

    public LocalDate getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(LocalDate dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public boolean isRetornat() {
        return retornat;
    }

    public void setRetornat(boolean retornat) {
        this.retornat = retornat;
    }

    @Override
    public String toString() {
        return "Lloguer{" + "numRegistre=" + numRegistre + ", usuari=" + usuari + ", joc=" + joc + ", plataforma=" + plataforma + ", dataInici=" + dataInici + ", dataPrevista=" + dataPrevista + ", retornat=" + retornat + '}';
    }
    
}
