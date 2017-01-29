package by.javafx8.ananiev.interfaces;


import by.javafx8.ananiev.objects.Person;

public interface AdressBook {

    //    добавить запись
    void add(Person person);

    //  внести измененные значения
    void update(Person person);

    //    удалить запись
    void delete(Person person);

}
