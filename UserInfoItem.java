public class UserInfoItem {

    private String user;

    private String password;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    private boolean state;
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserInfoItem(String user, String pwd, boolean state) {
        setPassword(pwd);
        setUser(user);
        setState(state);
    }
}
