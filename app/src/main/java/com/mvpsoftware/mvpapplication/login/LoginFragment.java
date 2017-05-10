package com.mvpsoftware.mvpapplication.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mvpsoftware.mvpapplication.R;
import com.mvpsoftware.mvpapplication.main.MainActivity;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class LoginFragment extends Fragment implements ILoginContract.LoginView, View.OnClickListener {
    ILoginContract.LoginPresenter presenter;
    EditText et_username;
    EditText et_password;
    Button btn_login;

    public LoginFragment() {
        super();
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        initInstances(rootView);
        presenter = new LoginPresenter(this);
        btn_login.setOnClickListener(this);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        et_password = (EditText) rootView.findViewById(R.id.et_password);
        et_username = (EditText) rootView.findViewById(R.id.et_username);
        btn_login = (Button) rootView.findViewById(R.id.btn_login);

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore Instance State here
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void navigateToMain() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        Toast.makeText(getActivity(), "Login Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed() {

        Toast.makeText(getActivity(), "Login Failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if (btn_login == v) {
            presenter.attemptLogin(et_username.getText().toString(), et_password.getText().toString());
        }
    }
}
