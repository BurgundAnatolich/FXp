package by.javafx8.ananiev.objects;

import javafx.beans.property.SimpleStringProperty;

public class Person {

    //    в целях исключения ошибок отображения данных в таблице инициализируем
//    пустым значением поля фио и фон
    private SimpleStringProperty fio = new SimpleStringProperty("");
    private SimpleStringProperty phone = new SimpleStringProperty("");

    public Person(String fio, String phone) {
        this.fio = new SimpleStringProperty(fio);
        this.phone = new SimpleStringProperty(phone);
    }

    public Person() {
    }

    public String getFio() {
        return fio.get();
    }

    public void setFio(String fio) {
        this.fio.set(fio);
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public SimpleStringProperty fioProperty() {
        return fio;
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fio='" + fio + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
