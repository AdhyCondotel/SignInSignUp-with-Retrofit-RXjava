package com.ammase.latihanprodukdetail.ui;
import com.ammase.latihanprodukdetail.model.listuser.ResponseGetListUser;

/**
 * Created by programmer on 13/07/17.
 */

public interface MainView {
    void handleUserSuccess(ResponseGetListUser responseAuth);

    void handleUserError(String throwable);
}
