package com.ammase.latihanprodukdetail.authentication.sigin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.ammase.latihanprodukdetail.R;
import com.ammase.latihanprodukdetail.authentication.sigup.SignUpActivity;
import com.ammase.latihanprodukdetail.model.sigin.ResponseGetLogin;
import com.ammase.latihanprodukdetail.ui.MainActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInActivity extends AppCompatActivity implements SignInView {

    private SignInPresenter signInPresenter;
    private ProgressDialog loading;

    @BindView(R.id.editTextEmail) EditText signin_username;
    @BindView(R.id.editTextPassword) EditText signin_password;
    @BindView(R.id.signin_button) AppCompatButton signin_button;
    @BindView(R.id.textViewSignUp) TextView text_sigiUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        initComponent();
    }

    private void initComponent() {
        signInPresenter = new SignInPresenter(this);
        loading = new ProgressDialog(getApplicationContext());
    }

    @OnClick(R.id.signin_button)
    public void signInNow(){
        String username = signin_username.getText().toString();
        String password = signin_password.getText().toString();
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            Toast.makeText(getApplicationContext(), "Input Spesific Data", Toast.LENGTH_SHORT).show();
            return;
        }
        signInPresenter.loginProcess(username, password);
    }


    @Override
    public void hideLoading() {

    }

    @Override
    public void handleLoginSuccess(ResponseGetLogin responseAuth) {
        Toast.makeText(getApplicationContext(), "Token : "+responseAuth.getMeta().getToken(), Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void handleLoginError(String s) {
        Toast.makeText(getApplicationContext(), "Error : "+s, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.textViewSignUp)
    public void anchorSignUp(){
        startActivity(new Intent(this, SignUpActivity.class));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        signInPresenter.destroyData();
    }

}
