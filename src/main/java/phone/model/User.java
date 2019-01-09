package phone.model;

import java.util.Objects;

public class User {
    Integer id;
    String login;
    String name;
    String surname;
    String surnameAndName;
    public User(Integer id, String login, String name, String surname, String surnameAndName) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.surnameAndName = surnameAndName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurnameAndName() {
        return surnameAndName;
    }

    public void setSurnameAndName(String surnameAndName) {
        this.surnameAndName = surnameAndName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(login, user.login) &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(surnameAndName, user.surnameAndName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, name, surname, surnameAndName);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", surnameAndName='" + surnameAndName + '\'' +
                '}';
    }
}
