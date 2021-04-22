package sample;

public class User {

    private String name;
    private String username;
    private String email;
    private String password;
    private String salt;

    public String getName() { return name; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getSalt() { return salt; }

    public void setName(String _name) { name = _name; }
    public void setUsername(String _username) { username = _username; }
    public void setEmail(String _email) { email = _email; }
    public void setPassword(String _password) { password = _password; }
    public void setSalt(String _salt) { salt = _salt; }

}
