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
