package by.javafx8.ananiev.interfaces.impl;

import by.javafx8.ananiev.interfaces.AdressBook;
import by.javafx8.ananiev.objects.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CollectionAdressBook implements AdressBook {

    private ObservableList<Person> personArrayList = FXCollections.observableArrayList();

    @Override
    public void add(Person person) {
        personArrayList.add(person);
    }

    @Override
//    Для коллекции не используется, но пригодится для случая когда
//    данные хранятся в БД и пр.
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {
        personArrayList.remove(person);
    }

    public ObservableList<Person> getPersonArrayList() {
        return personArrayList;
    }

    public void printList() {
        int index = 1;
        for (Person person : personArrayList) {
            System.out.println(index + ") " + person.getFio() + ", телефон: " + person.getPhone());
            index++;
        }

    }

    public void fillTestData() {
        personArrayList.add(new Person("Ivanov Bob Ivanovich", "12341535"));
        personArrayList.add(new Person("Petrova Bobibo Petrovna", "834183615"));
        personArrayList.add(new Person("Rodriges Antonio Ivanovich", "95646843"));
        personArrayList.add(new Person("Orero Juli Nikolaevna", "999564866"));
        personArrayList.add(new Person("Kniazev Hesus Andreich", "84673341"));
        personArrayList.add(new Person("Lineva Anna Ivanovna", "121532135"));
        personArrayList.add(new Person("Mishina Maria Afinovna", "35458254"));
        personArrayList.add(new Person("Ivanov Bob Ivanovich", "12341535"));
        personArrayList.add(new Person("Petrova Bobibo Petrovna", "834183615"));
        personArrayList.add(new Person("Rodriges Antonio Ivanovich", "95646843"));
        personArrayList.add(new Person("Orero Juli Nikolaevna", "999564866"));
        personArrayList.add(new Person("Kniazev Hesus Andreich", "84673341"));
        personArrayList.add(new Person("Lineva Anna Ivanovna", "121532135"));
        personArrayList.add(new Person("Mishina Maria Afinovna", "35458254"));
    }
}
