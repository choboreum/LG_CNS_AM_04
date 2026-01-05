package lgcns.domain.user;

public class UserRequestDto {
    private String email, password, name;

    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }

    public UserRequestDto(){
        
    }
    public UserRequestDto(String email, String password, String name){
        this.email = email;
        this.password = password;
        this.name = name;

    }
}
