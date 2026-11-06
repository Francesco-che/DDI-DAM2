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
public class Usuari {
    private String nom;
    private String cognom1;
    private String cognom2;
    private String dni;
    private String telefon;
    private LocalDate dataRegistre;

    public Usuari(String nom, String cognom1, String cognom2, String dni, String telefon, LocalDate dataRegistre) {
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.dni = dni;
        this.telefon = telefon;
        this.dataRegistre = dataRegistre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }
    
    public String getCognoms() {
        return cognom1 + cognom2;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public LocalDate getDataRegistre() {
        return dataRegistre;
    }

    public void setDataRegistre(LocalDate dataRegistre) {
        this.dataRegistre = dataRegistre;
    }
    
    

    @Override
    public String toString() {
        return nom + " " + cognom1; 
    }
    
    
    
}
