package by.javafx8.ananiev.objects;

public class Person {

    private String fio;
    private String phone;

    public Person(String fio, String phone) {
        this.fio = fio;
        this.phone = phone;
    }

    public Person() {
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fio='" + fio + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}