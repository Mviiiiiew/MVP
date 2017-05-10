package com.mvpsoftware.mvpapplication.login;

/**
 * Created by MAN on 5/10/2017.
 */

public class LoginPresenter implements ILoginContract.LoginPresenter {
    private ILoginContract.LoginView view;

    public LoginPresenter(ILoginContract.LoginView view) {
        this.view = view;

    }

    @Override
    public void attemptLogin(String username, String password) {
        if (username.equals("man") && (password.equals("11"))) {
            view.navigateToMain();
        } else {
            view.loginFailed();

        }

    }
}
