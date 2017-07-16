package com.ammase.latihanprodukdetail.authentication.sigup;

import com.ammase.latihanprodukdetail.api.NetworkClient;
import com.ammase.latihanprodukdetail.api.RequestAPI;
import com.ammase.latihanprodukdetail.model.sigin.ResponseAuth;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by programmer on 14/07/17.
 */

public class SignUpPresenter {
    private SignUpView view;
    private CompositeDisposable mCompositeDisposable;

    public SignUpPresenter(SignUpView view) {
        this.view = view;
    }

    public void registerProcess(String name, String user, String password) {

        view.showLoading("Register processing...");
        RequestAPI requestAPI   = NetworkClient.getRetrofit().create(RequestAPI.class);
        if (mCompositeDisposable == null)
            mCompositeDisposable    = new CompositeDisposable();

        mCompositeDisposable.add(requestAPI.register(name, user, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        responseAuth -> handleResponse(responseAuth),
                        throwable -> handleError(throwable)
                )
        );

    }

    private void handleResponse(ResponseAuth responseAuth) {
        view.handleRegisSuccess(responseAuth);
        view.hideLoading();
    }


    private void handleError(Throwable throwable) {
        view.handleRegisError(throwable.getLocalizedMessage().toString());
        view.hideLoading();
    }

    public void destroyData(){
        if (mCompositeDisposable != null){
            mCompositeDisposable.dispose();
        }
    }
}
