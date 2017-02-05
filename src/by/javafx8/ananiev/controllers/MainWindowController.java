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
import javafx.stage.Window;

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


    private EditController editController;
    private FXMLLoader fxmlLoader;
    private Stage editDialogStage;
    private Parent fxmlEdit;

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

        try {
            fxmlLoader.setLocation(getClass().getResource(""));
            fxmlEdit = fxmlLoader.load();
            editController = fxmlLoader.getController();
        } catch (IOException e)
        {
            e.printStackTrace();
        }


    }

    private void updateLabelCount() {
        mainLabel.setText("Количество записей: " + adressBookImpl.getPersonArrayList().size());
    }

    public void actionButtonPressed(ActionEvent actionEvent) {

        // определение источника события с помощью метода getSource().
        Object sourse = actionEvent.getSource();

        // если нажата не кнопка - выходим из метода.
        if (!(sourse instanceof Button)) {
            return;
        }

        // записываем в переменную clicedButton ссылку на нажатую кнопку.
        Button clicedButton = (Button) sourse;

        // в переменную селектедПерсон записываем ссылку на объект выбранный в текущий момент
        // при нажатии на кнопку
        Person selectedPerson = (Person) mainTable.getSelectionModel().getSelectedItem();

        Window parentWindow = ((Node) sourse).getScene().getWindow();

        editController.setPerson(selectedPerson);

        // по Id нажатой кнопки выволим дополнительную информацию
        // о выбранной во время нажатия строке таблицы
        switch (clicedButton.getId()) {
            case "mainAddButton":
                System.out.println("Add: " + selectedPerson);
                break;
            case "mainEditButton":
                showDialog(parentWindow);
                break;
            case "mainDeleteButton":
                System.out.println("Delete: " + selectedPerson);
                break;
        }

    }

    private void showDialog(Window parentWindow) {

        if (editDialogStage == null){
            editDialogStage = new Stage();
            editDialogStage.setTitle("Редактирование записей");
            editDialogStage.setMinWidth(450);
            editDialogStage.setMinHeight(100);
            editDialogStage.setResizable(false);
            editDialogStage.setScene(new Scene(fxmlEdit));
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editDialogStage.initOwner(parentWindow);
        }

        editDialogStage.show();
    }
}
