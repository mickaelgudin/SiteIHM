/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Database;
import controller.Email;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

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
                VBox vbox2 = new VBox();
                Label objet = new Label("Objet : ");
                vbox2.getChildren().add(objet);
                TextField objetField = new TextField();
                vbox2.getChildren().add(objetField);
                
                Label email = new Label("Adresse mail : ");
                vbox2.getChildren().add(email);
                TextField emailField = new TextField();
                vbox2.getChildren().add(emailField);
                
                Label contenuMail = new Label("Message : ");
                vbox2.getChildren().add(contenuMail);
                TextArea messageTextArea = new TextArea();
                vbox2.getChildren().add(messageTextArea);
                
                Button envoiMail = new Button("Envoyer le message");
                envoiMail.setMinWidth(50);
                
                Text reponse = new Text();
                envoiMail.setOnAction(action -> {
                    //on reintialise le message du formulaire
                    reponse.setText("");
                    
                    String incorrectValue = ""; 
                    
                    /*VERIFICATION DES CHAMPS DU FORMULAIRE*/
                    if(objetField.getText() == null || objetField.getText().equals("")){
                        incorrectValue = "Objet";
                    } 
                    if(emailField.getText() == null || emailField.getText().equals("")){
                        incorrectValue = "Adresse mail";
                    }
                    if(messageTextArea.getText() == null || messageTextArea.getText().equals("")){
                        incorrectValue = "Message";
                    }
                    
                    if(!incorrectValue.isEmpty()){
                        reponse.setText("Veuillez renseigner le champ : "+incorrectValue);
                    } 
                    /*SI TOUS LES CHAMPS DU FORMULAIRE SONT REMPLIS ALORS ON ENVOI LE MESSAGE SUR LA BOITE MAIL*/
                    else{
                        try{
                            Email.sendMail(emailField.getText(), objetField.getText(), messageTextArea.getText());
                            reponse.setText("Votre message a bien été envoyé");
                        }
                        catch(Exception e){
                            
                        }
                        
                    }
                });
                
                vbox2.getChildren().add(envoiMail);
                vbox2.getChildren().add(reponse);
                
                nomMenu.setOnMouseClicked(mouseEvent->{corps.setContent(vbox2);});
                break;
            case "RESERVERSATIONS" :
                VBox vbox = new VBox();
                Label dateReservation = new Label("Date de réservation : ");
                vbox.getChildren().add(dateReservation);
                DatePicker datePicker = new DatePicker();
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
                
                Text reponseFormulaire = new Text();
               

                prendreRDV.setOnAction(action -> {
                    //on reintialise le message du formulaire
                    reponseFormulaire.setText("");
                    
                    String incorrectValue = ""; 
                    
                    /*VERIFICATION DES CHAMPS DU FORMULAIRE*/
                    if(datePicker.getValue() == null){
                        incorrectValue = "date";
                    } 
                    if(cb.getValue() == null){
                        incorrectValue = "heure";
                    }
                    
                    if(numberField.getText() == null || numberField.getText().equals("") || numberField.getText().length() != 10){
                        incorrectValue = "telephone";
                    } 
                    if(incorrectValue != "telephone"){
                        for(Character c : numberField.getText().toCharArray()){
                            if(!Character.isDigit(c)){
                                incorrectValue = "telephone";
                            }
                        }
                    }
                    if(!incorrectValue.isEmpty()){
                        reponseFormulaire.setText("Veuillez renseigner le champ : "+incorrectValue);
                    } 
                    /*SI TOUS LES CHAMPS DU FORMULAIRE SONT REMPLIS ALORS ON INSERE LA RESERVATION DANS LA BASE DE DONNEES*/
                    else{
                        Reservation reservation = new Reservation(String.valueOf(java.sql.Date.valueOf(datePicker.getValue())), cb.getValue().toString(), numberField.getText(), textArea.getText());
                        Database database = new Database();
                        database.insertReservation(reservation);
                        reponseFormulaire.setText("Votre réservation a bien été enregistrée");
                    }
                });
                vbox.getChildren().add(prendreRDV);
                vbox.getChildren().add(reponseFormulaire);
                nomMenu.setOnMouseClicked(mouseEvent->{corps.setContent(vbox);});
                break;
           
            default:
                break;
        }
    }
    
}
