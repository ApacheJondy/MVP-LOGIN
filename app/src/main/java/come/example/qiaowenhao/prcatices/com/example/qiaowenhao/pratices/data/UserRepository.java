package come.example.qiaowenhao.prcatices.com.example.qiaowenhao.pratices.data;

public class UserRepository implements UserDataSource {
    //为简化只有网络请求相关,可以封装缓存相关的逻辑
    private static UserRepository INSTANCE = null;

    public static UserRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserRepository();
        }
        return INSTANCE;
    }

    @Override
    public void Login(OnLoginListener onLoginListener) {
        //此处应该是网络请求成功success之后在主线程回调,现在mock一下假数据
        //推荐使用RxJava + retrofit的方式
         onLoginListener.success(new User("123", "qwh"));
    }

    @Override
    public void saveUserInfo(User user) {
        //缓存相关
    }
}
