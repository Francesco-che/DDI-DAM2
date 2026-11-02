/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi.utils;

/**
 *
 * @author frand
 */
public class ValidationAPI {
    public static boolean validarNomMajuscula(String nom) {
        if (nom == null || nom.trim().isEmpty()) {
            return false;
        }
        return Character.isUpperCase(nom.charAt(0));
    }
}