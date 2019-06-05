package come.example.qiaowenhao.prcatices;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import come.example.qiaowenhao.prcatices.com.example.qiaowenhao.pratices.data.UserRepository;
//Activity作为整体控制器来创建和连接view(Fragment)\model和presenter
public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //静态加载方式,通过fragmentManager.findFragmentById获取fragment实例
        LoginFragment loginFragment = ((LoginFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrag));

        //create presenter
        new LoginPresenter(getApplicationContext(), UserRepository.getInstance(), loginFragment);
    }
}
