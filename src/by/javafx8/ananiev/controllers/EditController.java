package by.javafx8.ananiev.controllers;

import by.javafx8.ananiev.objects.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditController {

    @FXML
    private Label lblFIO;
    @FXML
    private Label lblTelefon;
    @FXML
    private TextField txtEditFIO;
    @FXML
    private TextField txtEditTelefon;
    @FXML
    private Button editBtnOK;
    @FXML
    private Button editBtnCancel;

    private Person person;


    public void setPerson(Person person) {
        this.person = person;
        txtEditFIO.setText(person.getFio());
        txtEditTelefon.setText(person.getPhone());
    }

    public void actionClose(ActionEvent actionEvent) {

        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }


}
