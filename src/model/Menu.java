/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Database;
import java.time.LocalDate;
import java.time.Month;
import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.converter.NumberStringConverter;

/**
 *
 * @author MGud
 */
public class Menu extends javafx.scene.control.Menu{
    
    public Menu(String titre, Node nomMenu, String nom, ScrollPane corps){
        super(titre, nomMenu);
        
        corps.setContent(new Text(Contenu.getAccueil()));
       
        switch(nom){
            case "ACCUEIL" :
                nomMenu.setOnMouseClicked(mouseEvent->{corps.setContent(new Text(Contenu.getAccueil()) );});
                break;
            case "CONTACT" :
                nomMenu.setOnMouseClicked(mouseEvent->{corps.setContent(new Text("CONTACT"));});
                break;
            case "RESERVERSATIONS" :
                VBox vbox = new VBox();
                Label dateReservation = new Label("Date de réservation : ");
                vbox.getChildren().add(dateReservation);
                DatePicker datePicker = new DatePicker();
                datePicker.setValue(LocalDate.now());
                datePicker.setShowWeekNumbers(true);
                vbox.getChildren().add(datePicker);
                
                Label heureReservation = new Label("Heure de réservation : ");
                vbox.getChildren().add(heureReservation);
                ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(
                    "9:30", "10:00", "10:30","11:00","11:30")
                );
                vbox.getChildren().add(cb);
                Label numeroTelephone = new Label("Numéro de téléphone : ");
                vbox.getChildren().add(numeroTelephone);
                TextField numberField = new TextField();
                
                vbox.getChildren().add(numberField);
                
                Label notes = new Label("Notes de rendez-vous : ");
                vbox.getChildren().add(notes);
                TextArea textArea = new TextArea();
                vbox.getChildren().add(textArea);
                
                Button prendreRDV = new Button("Prendre RDV");
                prendreRDV.setMinWidth(50);

                prendreRDV.setOnAction(action -> {
                    Reservation reservation = new Reservation(String.valueOf(java.sql.Date.valueOf(datePicker.getValue())), cb.getValue().toString(), numberField.getText(), textArea.getText());
                    Database database = new Database();
                    database.insertReservation(reservation);
                    //textArea.setText(reservation.toString());
                });
                vbox.getChildren().add(prendreRDV);
                
                nomMenu.setOnMouseClicked(mouseEvent->{corps.setContent(vbox);});
                break;
           
            default:
                break;
        }
    }
    
}
