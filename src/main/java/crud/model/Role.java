package crud.model;

import java.io.Serializable;

public class Role implements Serializable {

    private String role;

    public Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
