package userservice.dto;

public class UpdatePasswordDto {
    public UpdatePasswordDto(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UpdatePasswordDto() {
    }

    private String password;
}
