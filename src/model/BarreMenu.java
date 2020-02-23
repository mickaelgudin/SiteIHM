/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 *
 * @author MGud
 */
public class BarreMenu extends MenuBar{
    private List<Menu> menus = new ArrayList<>(); 
    
    public BarreMenu(){
        super();
        this.setMinHeight(50);
    }
    
    public final void setMenus(Text contenuCorpsPage){
        Label accueil = new Label();
        accueil.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("accueil.png"))));
        
        Label naissances = new Label("");
        naissances.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("naissances.png"))));
        
        Label chiensDispo = new Label("");
        chiensDispo.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("chiens_disponibles.png"))));
        
        Label reservations = new Label("");
        reservations.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("reservations.png"))));
        
        Label contact = new Label("");
        contact.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("contact.png"))));
        
        Label facebook = new Label("");
        Image fb = new Image(getClass().getResourceAsStream("facebook.png"), 100, 100, false, false);
        facebook.setGraphic(new ImageView(fb));
        
        menus.add(new Menu("", accueil, "ACCUEIL", contenuCorpsPage));
        menus.add(new Menu("", naissances, "NAISSANCES", contenuCorpsPage));
        menus.add(new Menu("", chiensDispo, "CHIENS DISPONIBLES",contenuCorpsPage));
        menus.add(new Menu("", reservations, "RESERVERSATIONS",contenuCorpsPage));
        menus.add(new Menu("", contact, "CONTACT",contenuCorpsPage));
        menus.add(new Menu("", facebook, "FACEBOOK",contenuCorpsPage));
        System.out.print("AAAAAAAAAAAAAA : "+menus.get(5).getStyleClass());
        this.getMenus().addAll(menus);
    }
}
