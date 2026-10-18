/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi._abstractmodelexample._interface.tablemodels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import spdvi._abstractmodelexample.dto.Alumn;

/**
 *
 * @author frand
 */
public class AlumnsTableModel extends AbstractTableModel{
    private List<Alumn> alumnList;
    private String[] columns = {"Name", "Course"};
    
    public AlumnsTableModel(List<Alumn> alumnList){
        this.alumnList = alumnList;
    }
    
    @Override
    public int getRowCount(){
        return alumnList.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return alumnList.get(rowIndex).getNom();
            case 1:
                return alumnList.get(rowIndex).getCourse();
        }
        return null;
    }
    public Object getColumnsName(int column){
        return columns[column];
    }
}
