package come.example.qiaowenhao.prcatices.com.example.qiaowenhao.pratices.data;

/**
 * Created by qiaowenhao on 19-6-3.
 */

public class User {
    private String userId;
    private String password;

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
