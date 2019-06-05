package come.example.qiaowenhao.prcatices;

//登录契约类,好处是接口方便统一管理\修改,同时,内容清晰,一目了然
public interface LoginContract {

    interface Presenter extends BasePresenter {
        void login();
    }

    interface View extends BaseView<Presenter> {
         String getUserEmail();
         String getPassWord();

         boolean isEmailValid();
         boolean isPassWordValid();

         void showLoginProgress();
         void toMainAct();
    }
}
