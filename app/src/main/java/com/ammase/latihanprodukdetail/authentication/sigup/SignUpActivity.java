package com.ammase.latihanprodukdetail.authentication.sigup;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ammase.latihanprodukdetail.R;
import com.ammase.latihanprodukdetail.model.sigin.ResponseAuth;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity implements SignUpView {
    private SignUpPresenter registrasiPresenter;
    private ProgressDialog loading;
   // private SessionManagement sessionManagement;
    @BindView(R.id.editTextName) EditText fullname;
    @BindView(R.id.editTextEmail) EditText email;
    @BindView(R.id.editTextPassword) EditText pass;
    @BindView(R.id.buttonRegistrasi)
    Button registerNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
        ButterKnife.bind(this);
        initComponent();


        registrasiPresenter = new SignUpPresenter(this);
        loading = new ProgressDialog(getApplicationContext());
    }

    private void initComponent() {

    }

    @OnClick(R.id.buttonRegistrasi)
    public void registerNow(){
        String name = fullname.getText().toString();
        String user = email.getText().toString();
        String password = pass.getText().toString();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(user) || TextUtils.isEmpty(password)){
            Toast.makeText(this, "Input Spesific Data", Toast.LENGTH_SHORT).show();
            return;
        }
        registrasiPresenter.registerProcess(name, user, password);
    }

    @Override
    public void showLoading(String s) {
/*        loading.setIndeterminate(true);
        loading.setCancelable(false);
        loading.setCanceledOnTouchOutside(false);
        loading.setMessage(s);

        loading.show();*/
    }

    @Override
    public void handleRegisSuccess(ResponseAuth responseAuth) {

        Toast.makeText(this, "Sukse Menambah Data", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void handleRegisError(String s) {
        Toast.makeText(this, "Error : "+s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {
        loading.dismiss();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        registrasiPresenter.destroyData();
    }
}
