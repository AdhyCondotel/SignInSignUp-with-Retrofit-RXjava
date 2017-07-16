package com.ammase.latihanprodukdetail.authentication.sigup;

import com.ammase.latihanprodukdetail.model.sigin.ResponseAuth;

/**
 * Created by programmer on 14/07/17.
 */

public interface SignUpView {
    void showLoading(String s);
    void handleRegisSuccess(ResponseAuth responseAuth);
    void handleRegisError(String s);
    void hideLoading();
}
