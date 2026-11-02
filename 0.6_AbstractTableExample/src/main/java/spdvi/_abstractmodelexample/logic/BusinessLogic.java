/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi._abstractmodelexample.logic;

import java.util.List;
import java.util.ArrayList;
import spdvi._abstractmodelexample.dto.Alumn;

/**
 *
 * @author frand
 */
public class BusinessLogic {
    public List<Alumn> alumnsList = new ArrayList<>();
    
    public BusinessLogic(){
        alumnsList = new ArrayList<>();
        alumnsList.add(new Alumn("Francesco", "DAM2"));
        alumnsList.add(new Alumn("Joan", "DAM2"));
        alumnsList.add(new Alumn("Marc", "DAM2"));
        alumnsList.add(new Alumn("Pere", "DAM2"));
    }
    public List<Alumn> getAlumnList(){
        return alumnsList;
    }
}
