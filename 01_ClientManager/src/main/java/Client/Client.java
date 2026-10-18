/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import java.util.Date;

/**
 *
 * @author frand
 */
public class Client {
    public String name;
    public String surname;
    private Date dateAdded;
    String province;

    public Client(String name, String surname, Date dateAdded, String province) {
        this.name = name;
        this.surname = surname;
        this.dateAdded = dateAdded;
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    
    public String[] ToStringArray(){
        String[] s = new String[4];
        s[0] = name;
        s[1] = surname;
        s[2] = dateAdded.toString();
        s[3] = province;
        return s;
    }
}
