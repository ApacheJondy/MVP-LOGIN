package come.example.qiaowenhao.prcatices;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFragment extends Fragment implements LoginContract.View {
    private LoginContract.Presenter mPresenter;
    private Button mLoginBtn;
    private AutoCompleteTextView mEmailTv;
    private EditText mPassWordTv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);
        mLoginBtn = root.findViewById(R.id.login);
        mEmailTv = root.findViewById(R.id.email);
        mPassWordTv = root.findViewById(R.id.password);
        View.OnClickListener mOnclickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.login:
                        mPresenter.login();
                        break;
                }
            }
        };
        mLoginBtn.setOnClickListener(mOnclickListener);
        return root;
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public String getUserEmail() {
        return mEmailTv.getText().toString();
    }

    @Override
    public String getPassWord() {
        return mPassWordTv.getText().toString();
    }

    @Override
    public boolean isEmailValid() {
        return getUserEmail().equals("1234");
    }

    @Override
    public boolean isPassWordValid() {
        return getPassWord().equals("qwh");
    }

    @Override
    public void showLoginProgress() {

    }

    @Override
    public void toMainAct() {
        Toast.makeText(getContext(), "Sign in Success!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }
}
