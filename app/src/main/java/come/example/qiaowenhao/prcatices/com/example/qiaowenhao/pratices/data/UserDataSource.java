package come.example.qiaowenhao.prcatices.com.example.qiaowenhao.pratices.data;

public interface UserDataSource {

    public interface OnLoginListener {
        void success(User user);
        void failed();
    }

    void Login(OnLoginListener onLoginListener);

    void saveUserInfo(User user);
}
