package com.ammase.latihanprodukdetail.ui;

import com.ammase.latihanprodukdetail.api.NetworkClient;
import com.ammase.latihanprodukdetail.api.RequestAPI;
import com.ammase.latihanprodukdetail.model.listuser.ResponseGetListUser;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by programmer on 13/07/17.
 */

public class MainPresenter {
    private MainView view;
    private CompositeDisposable mCompositeDisposable;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void Loaddata(String token) {
        RequestAPI requestAPI = NetworkClient.getRetrofit().create(RequestAPI.class);
        if (mCompositeDisposable == null) mCompositeDisposable = new CompositeDisposable();
        mCompositeDisposable.add(requestAPI.getUser("Bearer "+token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        responseAuth -> combineSuccessObserver(responseAuth),
                        throwable -> combineErrorObserver(throwable)
                )
        );
    }

    private void combineSuccessObserver(ResponseGetListUser responseAuth) {
        view.handleUserSuccess(responseAuth);

    }

    private void combineErrorObserver(Throwable throwable) {
        view.handleUserError(throwable.getLocalizedMessage().toString());
      //  view.handleRegisError(throwable.getLocalizedMessage().toString());

    }

    public void destroyData(){
        if (mCompositeDisposable != null){
            mCompositeDisposable.dispose();
        }
    }
}
