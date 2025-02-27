package userservice.dto;

import userservice.model.Roles;

public class UserDto {
    private Long id;

    public UserDto(Long id, String userName, String email, Roles role) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.role = role;
        /*this.isAccountExpired = isAccountExpired;
        this.isAccountLocked = isAccountLocked;
        this.isCredentialsExpired = isCredentialsExpired;*/
    }

    public UserDto() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Roles getRole() {
        return role;
    }
/*
    public boolean isAccountExpired() {
        return isAccountExpired;
    }

    public void setAccountExpired(boolean accountExpired) {
        isAccountExpired = accountExpired;
    }

    public boolean isAccountLocked() {
        return isAccountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        isAccountLocked = accountLocked;
    }

    public boolean isCredentialsExpired() {
        return isCredentialsExpired;
    }

    public void setCredentialsExpired(boolean credentialsExpired) {
        isCredentialsExpired = credentialsExpired;
    }*/

    public void setRole(Roles role) {
        this.role = role;
    }

    private String userName;
    private String email;
    private Roles role;
   /* private boolean isAccountExpired;
    private boolean isAccountLocked;
    private boolean  isCredentialsExpired;*/
}
