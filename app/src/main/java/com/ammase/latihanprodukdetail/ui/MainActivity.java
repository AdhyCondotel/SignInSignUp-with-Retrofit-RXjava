package com.ammase.latihanprodukdetail.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.ammase.latihanprodukdetail.R;
import com.ammase.latihanprodukdetail.adapter.adapterListUser;
import com.ammase.latihanprodukdetail.model.listuser.ResponseGetListUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView{
    private MainPresenter presenter;
    @BindView(R.id.recyclerview) RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        presenter = new MainPresenter(this);
        presenter.Loaddata();
    }

    private void init() {
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.destroyData();
    }

    @Override
    public void handleUserSuccess(ResponseGetListUser responseAuth) {
        this.recyclerView.setAdapter(new adapterListUser(getApplicationContext(), responseAuth.getData()));
    }

    @Override
    public void handleUserError(Throwable throwable) {

    }
}
