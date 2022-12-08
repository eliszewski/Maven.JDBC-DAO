package daos;

public class Login {
    private  static final String username = "eryk";
    private static final String password = "ss995";
    private static final String url = "jdbc:mysql://localhost:3306/test";

    public  static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
    public static String getUrl(){
        return url;
    }
}
