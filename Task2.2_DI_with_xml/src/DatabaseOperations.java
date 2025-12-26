public class DatabaseOperations {

    private String url;
    private String username;
    private String password;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    void insert(String brand)
    {
        System.out.println(String.format("Inserting %s into database [%s, %s, %s]..."
                ,brand, url,username,password));
    }
}
