package bookapp.domain;

import bookapp.constant.Role;

public abstract class Account {

    private Long id;
    private Role role;
    private String name;

    public Long getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public String getName() {
        return name;
    }
}
