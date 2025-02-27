package userservice.dto;

import userservice.model.Roles;

public class ManageUserAccountDto {
    private Long id;
    private Roles role;
    private boolean isAccountExpired;
    private boolean isAccountLocked;
    private boolean  isCredentialsExpired;

    public ManageUserAccountDto(Long id, Roles role, boolean isAccountExpired, boolean isAccountLocked, boolean isCredentialsExpired) {
        this.id = id;
        this.role = role;
        this.isAccountExpired = isAccountExpired;
        this.isAccountLocked = isAccountLocked;
        this.isCredentialsExpired = isCredentialsExpired;
    }

    public ManageUserAccountDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Roles getRole() {
        return role;
    }

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
    }

    public void setRole(Roles role) {
        this.role = role;
    }


}


