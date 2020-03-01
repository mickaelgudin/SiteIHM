/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author MGud
 */
public class Reservation {
    private String date;
    private String heure;
    private String telephone;
    private String notes;
    
    public Reservation(String date, String heure, String telephone, String notes){
        super();
        this.date = date;
        this.heure = heure;
        this.telephone = telephone;
        this.notes = notes;
    }
    
    public String getDate(){
        return this.date;
    }
    
    public String getHeure(){
        return this.heure;
    }
    
    public String getTelephone(){
        return this.telephone;
    }
    
    public String getNotes(){
        return this.notes;
    }
    
    public String toString(){
        return "date : "+this.date+"\nheure : "+this.heure+"\ntelephone : "+this.telephone+"\nNotes : "+this.notes;
    }
}
