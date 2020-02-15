/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siteihm;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.BarreMenu;
import model.Menu;

/**
 *
 * @author MGud
 */
public class SiteIHM extends Application {
    
    @Override
    public void start(Stage stage) {
        
        stage.setTitle("Elevage de Yorkshire de Villardières");
    	stage.setWidth(1000);
    	stage.setHeight(800);
    	Scene scene = new Scene(new Group());
        /*charger fichier de style*/
        scene.getStylesheets().add("siteihm/style.css");
   	 
     	BorderPane gridPane = new BorderPane();
        
        /*Definition des element du menu*/
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu("ACCUEIL"));
        menus.add(new Menu("NAISSANCES"));
        menus.add(new Menu("DISPONIBILITES"));
        menus.add(new Menu("CONTACT"));
            
        /* creation de la barre de menu avec ses menus*/ 
        BarreMenu mb = new BarreMenu(menus); 
        
        
        TextArea corpsDeLaPage =  new TextArea("Mettre le contenu de la page d'accueil");
        corpsDeLaPage.setEditable(false);
        
        TextArea piedDeLaPage =  new TextArea("Mettre le contenu de la du pied de page");
        piedDeLaPage.setEditable(false);
        piedDeLaPage.setBorder(new Border(new BorderStroke(Color.BLACK, 
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        
        /*Menu en haut*/
        gridPane.setTop(mb);
        /*corps de la page au milieu*/
        gridPane.setCenter(corpsDeLaPage);
        /*pied de la page au milieu*/
        gridPane.setBottom(piedDeLaPage);
       
        scene.setRoot(gridPane);
 
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
