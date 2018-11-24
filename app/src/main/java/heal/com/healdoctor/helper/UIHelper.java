package heal.com.healdoctor.helper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

import heal.com.healdoctor.R;

public class UIHelper {

    public static void showToast(Context context, String message) {
        final Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, 500);
    }

    public static void showDialog(Context context, int type, String message, final AlertDialogListener alertDialogListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Please Note!!!");
        builder.setMessage(message);

        // Add the buttons
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                if (alertDialogListener!=null) {
                    alertDialogListener.onPositiveButtonClick();
                }
            }
        });

        if (type == 1) {
            builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User cancelled the dialog
                    dialog.dismiss();

                    if(alertDialogListener!=null) {
                        alertDialogListener.onNegativeButtonClick();
                    }
                }
            });
        }

        // Create the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public interface AlertDialogListener {
        void onPositiveButtonClick();
        void onNegativeButtonClick();
    }


}
