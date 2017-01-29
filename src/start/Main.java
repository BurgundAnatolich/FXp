package start;

import by.javafx8.ananiev.interfaces.impl.CollectionAdressBook;
import by.javafx8.ananiev.objects.Person;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../by/javafx8/ananiev/fxml/mainWindow.fxml"));
        primaryStage.setTitle("Adress book");
        Scene scene = new Scene(root, 300, 275);
        primaryStage.setMinHeight(360);
        primaryStage.setMinWidth(320);
        primaryStage.setScene(scene);
        primaryStage.show();

//        testData();
    }

//    private void testData() {
//
//        CollectionAdressBook adressBook = new CollectionAdressBook();
//        adressBook.fillTestData();
//        adressBook.printList();
//    }

    public static void main(String[] args) {
        launch(args);
    }
}
