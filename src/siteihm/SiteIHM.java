/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siteihm;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.BarreMenu;
import model.Menu;
import model.Page;

/**
 *
 * @author MGud
 */
public class SiteIHM extends Application {
    
    @Override
    public void start(Stage stage) {
        
        stage.setTitle("Elevage de Yorkshire de Villardières");
    	stage.setWidth(1200);
    	stage.setHeight(900);
    	Scene scene = new Scene(new Group());
        /*charger fichier de style*/
        scene.getStylesheets().add("siteihm/style.css");
   	 
        Text contenuCorpsPage =  new Text("");
            
        /* creation de la barre de menu avec ses menus*/ 
        BarreMenu mb = new BarreMenu();
        mb.setMenus(contenuCorpsPage);
        
        ScrollPane corpsPage = new ScrollPane();
       
        corpsPage.setContent(contenuCorpsPage);
        
        HBox piedPage = new HBox();
        
        
        piedPage.getStyleClass().add("pied-page");
        
        piedPage.setSpacing(100);
        piedPage.setPadding(new Insets(10));
        
        
        Page page = new Page(mb, corpsPage, piedPage);
       
        corpsPage.getStyleClass().add("corps-page");
        
        scene.setRoot(page);
 
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
