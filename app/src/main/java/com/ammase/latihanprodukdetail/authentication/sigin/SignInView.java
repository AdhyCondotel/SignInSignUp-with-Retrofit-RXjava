package com.ammase.latihanprodukdetail.authentication.sigin;

import com.ammase.latihanprodukdetail.model.sigin.ResponseGetLogin;

/**
 * Created by programmer on 15/07/17.
 */

public interface SignInView {

    void hideLoading();
    void handleLoginSuccess(ResponseGetLogin responseAuth);
    void handleLoginError(String s);
}
