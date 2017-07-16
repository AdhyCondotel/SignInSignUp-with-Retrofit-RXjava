package com.ammase.latihanprodukdetail.authentication.sigin;


import android.util.Log;
import android.widget.Toast;

import com.ammase.latihanprodukdetail.api.NetworkClient;
import com.ammase.latihanprodukdetail.api.RequestAPI;
import com.ammase.latihanprodukdetail.model.sigin.ResponseGetLogin;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by programmer on 15/07/17.
 */

public class SignInPresenter {
    private SignInView view;
    private CompositeDisposable mCompositeDisposable;

    public SignInPresenter(SignInView view) {
        this.view = view;
    }

    public void loginProcess(String username, String password) {

        RequestAPI requestAPI   = NetworkClient.getRetrofit().create(RequestAPI.class);
        if (mCompositeDisposable == null)
            mCompositeDisposable    = new CompositeDisposable();

        mCompositeDisposable.add(requestAPI.login(username, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        responseAuth -> handleResponse(responseAuth),
                        throwable -> handleError(throwable)
                )
        );
    }

    private void handleResponse(ResponseGetLogin responseAuth) {
        view.handleLoginSuccess(responseAuth);
        view.hideLoading();
        Log.i("adhy Tes Token :" , responseAuth.getMeta().getToken().toString());
    }

    private void handleError(Throwable throwable) {
        view.handleLoginError(throwable.getLocalizedMessage().toString());

    }

/*    private void handleResponse(ResponseGetLogin responseAuth) {
        view.dataSuccess(responseAuth);
        view.hideLoading();
    }



    private void handleError(Throwable throwable) {
        view.dataFailed(throwable.getLocalizedMessage().toString());
        view.hideLoading();
    }*/

    public void destroyData(){
        if (mCompositeDisposable != null){
            mCompositeDisposable.dispose();
        }
    }
}
