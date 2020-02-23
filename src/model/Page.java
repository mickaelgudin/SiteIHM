/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 *
 * @author MGud
 */
public class Page extends BorderPane{
    private BarreMenu menu;
    private Node corps;
    private Node bottom;
    
    public Page(BarreMenu menu, Node corps, HBox pieds){
        setMenu(menu);
        setCorps(corps);
        setPieds(pieds);
    }
    
    
    public final void setMenu(BarreMenu menu){
        this.setTop(menu);
        this.menu = menu;
    }
    public final void setCorps(Node corps){
        this.setCenter(corps);
    }
    
    public final void setPieds(HBox pieds){
        this.setBottom(pieds);
        /*Text infosLegales =  new Text("Informations légales:\n" +
        "N° ELEVEUR : 701022 - N° CAPACITE : 70025 - N° AFFIXE : 69109\n" +
        "N° SIRET : 478 322 340 000 17 (B)\n" +
        "N° Enregistrement MSA Gestion des Entreprises : 478322340 00017");
                infosLegales.getStyleClass().add("infos-legales");

                Text contact = new Text("CONTACT : Françoise Vieillard\n" +
        "Portable : 06 82 41 39 58\n" +
        "Tél.fixe : 03 84 74 31 22");
        contact.getStyleClass().add("contact");
        
        pieds.getChildren().add(infosLegales);
        pieds.getChildren().add(contact);*/
        pieds.getChildren().add(new ImageView(new Image(getClass().getResourceAsStream("footer.png"))));
    }
    
    public void getMenu(){
        this.getTop();
    }
    
    public void getCorps(){
        this.getCenter();
    }
    
    public void getPieds(){
        this.getBottom();
    }
    
    
}
