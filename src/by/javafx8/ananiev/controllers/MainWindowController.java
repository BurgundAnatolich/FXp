package by.javafx8.ananiev.controllers;

import by.javafx8.ananiev.objects.Person;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import by.javafx8.ananiev.interfaces.impl.CollectionAdressBook;

import java.io.IOException;

public class MainWindowController {

    private CollectionAdressBook adressBookImpl = new CollectionAdressBook();

    @FXML
    private Button mainEditButton;
    @FXML
    private Button mainDeleteButton;
    @FXML
    private Button mainSearchButton;
    @FXML
    private TextField mainSearchField;
    @FXML
    private TableView mainTable;
    @FXML
    private TableColumn<Person, String> tableColumnFIO;
    @FXML
    private TableColumn<Person, String> tableColumnTelefon;
    @FXML
    private Label mainLabel;
    @FXML
    private Button mainAddButton;

    @FXML
    private void initialize() {
        tableColumnFIO.setCellValueFactory(new PropertyValueFactory<Person, String>("fio"));
        tableColumnTelefon.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));

        adressBookImpl.getPersonArrayList().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> c) {
                updateLabelCount();
            }
        });

        adressBookImpl.fillTestData();

        mainTable.setItems(adressBookImpl.getPersonArrayList());


    }

    private void updateLabelCount() {
        mainLabel.setText("Количество записей: " + adressBookImpl.getPersonArrayList().size());
    }

    public void showDialog(ActionEvent actionEvent) {

        // определение источника события с помощью метода getSource().
        Object sourse = actionEvent.getSource();

        // если нажата не кнопка - выходим из метода.
        if (!(sourse instanceof Button)) {
            return;
        }

        // записываем в переменную clicedButton ссылку на нажатую кнопку.
        Button clicedButton = (Button) sourse;


        Person selectedPerson = (Person) mainTable.getSelectionModel().getSelectedItem();

        // по Id нажатой кнопки выволим дополнительную информацию
        // о выбранной во время нажатия строке таблицы
        switch (clicedButton.getId()) {
            case "mainAddButton":
                System.out.println("Add: " + selectedPerson);
                break;
            case "mainEditButton":
                System.out.println("Edit: " + selectedPerson);
                break;
            case "mainDeleteButton":
                System.out.println("Delete: " + selectedPerson);
                break;
        }

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/edit.fxml"));
            stage.setTitle("Editor");
            stage.setMinWidth(450);
            stage.setMinHeight(100);
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
