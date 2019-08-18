package crud.model;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable {

    private String name;
    private String surname;
    private String email;
    private Set<Role> roles;
    private Set<Number> numbers;

    public User(String name, String surname, String email, Set<Role> roles, Set<Number> numbers) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.roles = roles;
        this.numbers = numbers;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public Set<Role> getRoles() { return roles; }

    public Set<Number> getNumbers() {
        return numbers;
    }
}
