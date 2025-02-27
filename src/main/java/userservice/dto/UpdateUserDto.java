package userservice.dto;

public class UpdateUserDto {
    private String userName;

    public UpdateUserDto() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public UpdateUserDto(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
