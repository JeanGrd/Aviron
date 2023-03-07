/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaprojetaviron.view;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author PaulineVarin
 */
public class CreateTournoiView { 
    //Bouttons
    private Button suivantB = new Button("Suivant") ;
    private Button retourB = new Button("Retour") ; 
    
    //Labels
    private Label l = new Label() ;   
    private Label[] listLabels ;
    
    //Mise en place des éléments à remplir et leurs labels
    private TextField[] listTextBox ;
    private ComboBox[] listComboBox ; 
    
    
    //Scenes
    private VBox rootTitre = new VBox(10) ;
    private HBox rootBouton = new HBox(10) ; 
    private VBox rootBox =  new VBox(10) ;
    private VBox root = new VBox(10) ;
      
   
    public Scene creationScene() {
        //Création des différents éléments 
        //Mise en place du label pour le titre
        this.l.setText("Création de tournoi");
        
        //Creation de la scene titre
        this.rootTitre.setAlignment(Pos.CENTER);
        this.rootTitre.getChildren().add(l) ; 
        
        //Definiton du comportement des boutons
        this.suivantB.setOnAction(new EventHandler<ActionEvent> () {
            public void handle(ActionEvent e) {
                Scene s1 = ((Button)e.getSource()).getScene() ; 
                Stage stageP =  (Stage) s1.getWindow() ; 
                
                //Mise en place de la scene suivante
                CreateTeamView teamCreateView = new CreateTeamView() ; 
                Scene sceneCreateTeam = teamCreateView.creationScene() ; 
                stageP.setScene(sceneCreateTeam);
            }
            
        });
        
        this.retourB.setOnAction(new EventHandler<ActionEvent> () {
            public void handle(ActionEvent e) {
                Scene s1 = ((Button)e.getSource()).getScene() ; 
                Stage stageP =  (Stage) s1.getWindow() ; 
                
                //Mise en place de la scene arrière
                HomeView tournoiHomeView = new HomeView() ; 
                Scene sceneHomeView = tournoiHomeView.creationScene() ; 
                stageP.setScene(sceneHomeView);
            }
            
        });
        
        //Creation de la scene des boutons
        this.rootBouton.setAlignment(Pos.CENTER);
        this.rootBouton.getChildren().addAll(retourB, suivantB) ; 
        
        
        
        
        //Mise en place du label pour chaque element de la page
        this.listLabels = new Label[7] ;
        String labelsString[]=new String[]{
            "Nom : ",
            "Lieu : ",
            "Type : ",
            "Nombre d'équipes : ",
            "Nombre de mètres : ",
            "Intervalle de temps : ",
            "Code : "
            }; 
        
        for(int i = 0; i < this.listLabels.length; i++) {
            this.listLabels[i]=new Label(labelsString[i]);
        }
        
       
    
        //Creation des textBox
        String placeholderTextBox[]=new String[]{
            "Championnat",
            "Toulouse",
            "HS8+"
            }; 
        
        this.listTextBox = new TextField[3] ; 
        for(int i=0;i<this.listTextBox.length;i++) {
            this.listTextBox[i] = new TextField(placeholderTextBox[i]) ; 
        }
        
        
        //Creation des ComboBox
        this.listComboBox = new ComboBox[4];
       
        ObservableList<String> typeChampionnat 
                = FXCollections.observableArrayList ("COURSE CONTRE LA MONTRE", "COURSE LIGNE");
        this.listComboBox[0] = new ComboBox(typeChampionnat);
        this.listComboBox[0].getSelectionModel().select(0);
        
        ObservableList<String> nbEquipes 
                = FXCollections.observableArrayList ("2", "3","4","5","6");
        listComboBox[1] = new ComboBox(nbEquipes);
        listComboBox[1].getSelectionModel().select(0);
        
        ObservableList<String> nbMetres
                = FXCollections.observableArrayList ("2000", "3000","4000","5000","6000");
        listComboBox[2] = new ComboBox(nbMetres);
        listComboBox[2].getSelectionModel().select(0);
        
       ObservableList<String> intervalleTemps
                = FXCollections.observableArrayList ("500", "1000","1500","2000","2500");
        listComboBox[3] = new ComboBox(intervalleTemps);
        listComboBox[3].getSelectionModel().select(0);
              
        //Liaison de chaque texte box avec sa combo box dans une mini scene
        HBox nomChampionnatBox = new HBox(listLabels[0],listTextBox[0]) ; 
        nomChampionnatBox.setAlignment(Pos.CENTER);
        
        HBox lieuChampionnatBox = new HBox(listLabels[1],listTextBox[1]) ; 
        lieuChampionnatBox.setAlignment(Pos.CENTER);
        
        HBox typeChampionnatBox = new HBox(listLabels[2],listComboBox[0]) ; 
        typeChampionnatBox.setAlignment(Pos.CENTER);
        
        HBox nbEquipesChampionnatBox = new HBox(listLabels[3],listComboBox[1]) ; 
        nbEquipesChampionnatBox.setAlignment(Pos.CENTER);
        
        HBox nbMetresChampionnatBox = new HBox(listLabels[4],listComboBox[2]) ; 
        nbMetresChampionnatBox.setAlignment(Pos.CENTER);
        
        HBox tempsChampionnatBox = new HBox(listLabels[5],listComboBox[3]) ; 
        tempsChampionnatBox.setAlignment(Pos.CENTER);
        
        HBox codeChampionnatBox = new HBox(listLabels[6],listTextBox[2]) ; 
        codeChampionnatBox.setAlignment(Pos.CENTER);
        
        
        //Mise en place du corps 
        this.rootBox.setAlignment(Pos.CENTER);
        this.rootBox.getChildren().addAll(nomChampionnatBox, lieuChampionnatBox, typeChampionnatBox, nbEquipesChampionnatBox, nbMetresChampionnatBox, tempsChampionnatBox, codeChampionnatBox) ; 
        
        
        //Creation de la scene principale  
        this.root.setAlignment(Pos.CENTER);
        this.root.getChildren().addAll(rootTitre,rootBox, rootBouton) ; 
        Scene scene = new Scene(root, 1000,600); 
        
        //Envoi des données via le controlleur au model
        //Le model devra vérifier que les données fournis sont ok
        return scene ;
    }
    
}