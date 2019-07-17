package bus.itgds.khadametdz.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

import com.crowdfire.cfalertdialog.CFAlertDialog;

import bus.itgds.khadametdz.view.activity.PaymentMethodsActivity;


public class AppUtils {

    public static void sendMail(Context context, String email, String shareTitle) {
        try {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
//            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
//            emailIntent.putExtra(Intent.EXTRA_TEXT, "Message");
            context.startActivity(emailIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dialog(final Context context, String title, String message){
        CFAlertDialog.Builder builder = new CFAlertDialog.Builder(context)
                .setDialogStyle(CFAlertDialog.CFAlertStyle.ALERT)
                .setTitle(title)
                .setMessage(message)
                .addButton("Ok", -1, -1, CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.JUSTIFIED, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        context.startActivity(new Intent(context, PaymentMethodsActivity.class));
                        dialog.dismiss();
                    }
                }).addButton("Cancel", -1, -1, CFAlertDialog.CFAlertActionStyle.NEGATIVE, CFAlertDialog.CFAlertActionAlignment.JUSTIFIED, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                ;

// Show the alert
        builder.show();
    }

    public static void dialog(final Context context, String title, String message, String fBtnName, String sBtnName){
        CFAlertDialog.Builder builder = new CFAlertDialog.Builder(context)
                .setDialogStyle(CFAlertDialog.CFAlertStyle.ALERT)
                .setTitle(title)
                .setMessage(message)
                .addButton(fBtnName, -1, -1, CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.JUSTIFIED, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
//                        context.startActivity(new Intent(context, AddOfferActivity.class));
                    }
                }).addButton(sBtnName, -1, -1, CFAlertDialog.CFAlertActionStyle.NEGATIVE, CFAlertDialog.CFAlertActionAlignment.JUSTIFIED, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        dialog(context,"Delete","Are You Want To Delete Item !");
                    }
                })
                ;

// Show the alert
        builder.show();
    }

    public static void openMap(Context context,float lat, float lon){
        Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(mapIntent);
        }
    }
}
