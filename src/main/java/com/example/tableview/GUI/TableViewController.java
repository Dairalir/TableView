package com.example.tableview.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TableViewController {

    public TableView<Client> lst_clients;
    public TableColumn<Object, Object> col_prenom;
    public TableColumn<Object, Object> col_nom;
    public TableColumn<Object, Object> col_ville;
    public TextField txt_prenom;
    public TextField txt_nom;
    public TextField txt_ville;
    public Button btn_sauver;
    public Button btn_annuler;
    public Button btn_supprimer;

    @FXML
    private TableView<Client> clients;

    @FXML
    private TableColumn<Client, String> prenom;
    @FXML
    private TableColumn<Client, String> nom;
    @FXML
    private TableColumn<Client, String> ville;

    public void sauver(ActionEvent actionEvent) {
        model.add(new Client(txt_prenom.getText(),txt_nom.getText(),txt_ville.getText()));
    }

    public void annuler(ActionEvent actionEvent) {
        txt_prenom.clear();
        txt_nom.clear();
        txt_ville.clear();
    }

    public void supprimer(ActionEvent actionEvent) {
        lst_clients.getItems().remove(lst_clients.getSelectionModel().getSelectedIndex());
    }

    public static class Client {
        private  String nom;
        private  String prenom;
        private  String ville;

        public Client() {}

        public Client(String p, String n, String v) {
            this.prenom = p;
            this.nom = n;
            this.ville = v;
        }
        //Getters and Setters
        public String getNom() {
            return this.nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getPrenom() {
            return this.prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public String getVille() {
            return this.ville;
        }

        public void setVille(String ville) {
            this.ville = ville;
        }
    }

    ObservableList<Client> model = FXCollections.observableArrayList();

    public void initialize() {
        //initialisation du modèle
        model.add(new Client("Josh", "Homme", "Joshua Tree"));
        model.add(new Client("Dave", "Grohl", "Warren"));
        model.add(new Client("Krist", "Novoselic", "Compton"));
        model.add(new Client("Robert", "Trujillo", "Santa Monica"));

        //On rend le tableau non-éditable
        lst_clients.setEditable(false);

        // Jonction du tableau avec les données
        col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_ville.setCellValueFactory(new PropertyValueFactory<>("ville"));

        // On indique au TableView quelle modèle observer pour trouver les données
        lst_clients.setItems(model);
    }
}