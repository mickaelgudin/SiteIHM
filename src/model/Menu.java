/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

/**
 *
 * @author MGud
 */
public class Menu extends javafx.scene.control.Menu{
    
    public Menu(String titre, Node nomMenu, String nom, Text corps){
        super(titre, nomMenu);
        
        corps.setText(Contenu.getAccueil());
       
        switch(nom){
            case "ACCUEIL" :
                nomMenu.setOnMouseClicked(mouseEvent->{corps.setText(Contenu.getAccueil() );});
                break;
            case "CONTACT" :
                nomMenu.setOnMouseClicked(mouseEvent->{corps.setText("CONTACT");});
                break;
            default:
                break;
        }
    }
    
}
