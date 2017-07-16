package com.ammase.latihanprodukdetail.utils;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.ammase.latihanprodukdetail.R;

/**
 * Created by programmer on 13/07/17.
 */

public final class DialogFactory {


/*    public static Dialog createSimpleOkErrorDialog(Context context, String title, String message) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setNeutralButton(R.string.dialog_action_ok, null);
        return alertDialog.create();
    }*/

/*
    public static Dialog createSimpleOkErrorDialog(Context context,
                                                   @StringRes int titleResource,
                                                   @StringRes int messageResource) {
        return createSimpleOkErrorDialog(context,
                context.getString(titleResource),
                context.getString(messageResource));
    }
*/

    public static Dialog createGenericErrorDialog(Context context, String message) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context)
                .setMessage(message)
                .setNeutralButton(R.string.dialog_action_ok, null);
        return alertDialog.create();
    }

  /*  public static Dialog createYesNoDialog(Context context, int message, DialogInterface.OnClickListener onCLick) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton(R.string.dialog_action_yes, onCLick)
                .setNegativeButton(R.string.dialog_action_no, null);
        return alertDialog.create();
    }

    public static Dialog createYesNoDialog(Context context, String message, DialogInterface.OnClickListener onCLick) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton(R.string.dialog_action_yes, onCLick)
                .setNegativeButton(R.string.dialog_action_no, null);
        return alertDialog.create();
    }

    public static Dialog createOkDialog(Context context, String message, DialogInterface.OnClickListener onCLick) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton(R.string.dialog_action_ok, onCLick);
        return alertDialog.create();
    }

    public static Dialog createOkDialog(Context context, @StringRes int message, DialogInterface.OnClickListener onCLick) {
        return createOkDialog(context, context.getString(message), onCLick);
    }

    public static Dialog createSelectDialog(Context context, int title, String[] item, DialogInterface.OnClickListener onCLick) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setItems(item, onCLick);
        return alertDialog.create();
    }

    public static Dialog createSelectDialog(Context context, String[] item, DialogInterface.OnClickListener onCLick) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context)
                .setItems(item, onCLick);
        return alertDialog.create();
    }

    public static Dialog createGenericErrorDialog(Context context, @StringRes int messageResource) {
        return createGenericErrorDialog(context, context.getString(messageResource));
    }

    public static ProgressDialog createProgressDialog(Context context, String message) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
        return progressDialog;
    }

    public static ProgressDialog createProgressDialog(Context context,
                                                      @StringRes int messageResource) {
        return createProgressDialog(context, context.getString(messageResource));
    }

    public static Snackbar createSimpleSnackbar(View view, String message, int length){
        return Snackbar.make(view, message, length);
    }

    public static Snackbar createSimpleSnackbar(View view, int message, int length){
        return Snackbar.make(view, message, length);
    }*/
}
