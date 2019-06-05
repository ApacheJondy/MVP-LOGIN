package come.example.qiaowenhao.prcatices;

import android.content.Context;
import android.widget.Toast;
import come.example.qiaowenhao.prcatices.com.example.qiaowenhao.pratices.data.User;
import come.example.qiaowenhao.prcatices.com.example.qiaowenhao.pratices.data.UserDataSource;
import come.example.qiaowenhao.prcatices.com.example.qiaowenhao.pratices.data.UserRepository;

/**
 * Created by qiaowenhao on 19-6-4.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private UserRepository mUserRepository;
    private LoginContract.View mLoginView;
    private Context mContext;

    public LoginPresenter(Context context, UserRepository userRepository, LoginContract.View loginView) {
        this.mUserRepository = userRepository;
        this.mLoginView = loginView;
        this.mContext = context;
        loginView.setPresenter(this);
    }

    @Override
    public void start() {
         //do nothing
    }

    @Override
    public void login() {
        mLoginView.showLoginProgress();
        mUserRepository.Login(new UserDataSource.OnLoginListener() {
            @Override
            public void success(User user) {
                Toast.makeText(mContext, "成功得到数据", Toast.LENGTH_LONG).show();
                //此处做了一个关于登录成功的简单效验
                if (mLoginView.isEmailValid() && mLoginView.isPassWordValid()) {
                    mLoginView.toMainAct();
                    if (mUserRepository != null) {
                        mUserRepository.saveUserInfo(user);
                    }
                }
            }

            @Override
            public void failed() {

            }
        });
    }

}
