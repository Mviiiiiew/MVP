package com.mvpsoftware.mvpapplication.login;

/**
 * Created by MAN on 5/10/2017.
 */

public interface ILoginContract {
    interface LoginView {

        void showLoading();

        void hideLoading();

        void navigateToMain();

        void loginFailed();
    }

    interface LoginPresenter {

        void attemptLogin(String username, String password);
    }
}
