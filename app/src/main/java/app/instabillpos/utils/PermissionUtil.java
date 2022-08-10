package app.instabillpos.utils;


import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

public class PermissionUtil implements ActivityCompat.OnRequestPermissionsResultCallback {
    public final static int REQUEST_CODE = 1000;
    private static String[] galleryPermissions = {
            "android.permission.WRITE_EXTERNAL_STORAGE",
            "android.permission.READ_EXTERNAL_STORAGE"
    };

    private static String[] cameraPermissions = {
            "android.permission.CAMERA"
    };

    private static String[] contactPermissions = {
            "android.permission.READ_CONTACTS",
    };

    public static String[] getGalleryPermissions() {
        return galleryPermissions;
    }

    public static String[] getCameraPermissions() {
        return cameraPermissions;
    }

    public static String[] getContactPermissions() {
        return contactPermissions;
    }

    public static boolean verifyPermissions(Context context, String[] grantResults) {
        for (String result : grantResults) {
            if (ActivityCompat.checkSelfPermission(context, result) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
            if (ActivityCompat.checkSelfPermission(context, result) == PackageManager.PERMISSION_DENIED) {
                return false;
            }
        }
        return true;
    }

    public static void requestPermission(String[] grantResults, Activity activity) {
        ActivityCompat.requestPermissions(activity, grantResults, REQUEST_CODE);

    }

   /* {

        public static boolean neverAskAgainSelected(final Activity activity, final String permission) {
        final boolean prevShouldShowStatus = getRatinaleDisplayStatus(activity,permission);
        final boolean currShouldShowStatus = activity.shouldShowRequestPermissionRationale(permission);
        return prevShouldShowStatus != currShouldShowStatus;
    }

        public static void setShouldShowStatus(final Context context, final String permission) {
        SharedPreferences genPrefs = context.getSharedPreferences("GENERIC_PREFERENCES", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = genPrefs.edit();
        editor.putBoolean(permission, true);
        editor.commit();
    }
        public static boolean getRatinaleDisplayStatus(final Context context, final String permission) {
        SharedPreferences genPrefs =     context.getSharedPreferences("GENERIC_PREFERENCES", Context.MODE_PRIVATE);
        return genPrefs.getBoolean(permission, false);
    }

    }*/




//
//    public static boolean requestPermissionCamera(String[] grantResults, Activity activity) {
//        ActivityCompat.requestPermissions(activity, grantResults, 1000);
//        if(verifyPermissions(activity,grantResults)==true){
//            return true;
//        }
//        else
//            return false;
//    }

    public boolean checkMarshMellowPermission() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    @Override
    public void onRequestPermissionsResult(int i, @NonNull String[] strings, @NonNull int[] ints) {

    }



   /* @Override
    public void onRequestPermissionsResult(int i, @NonNull String[] strings, @NonNull int[] ints) {
        //   super.onRequestPermissionsResult(i, strings, ints);

        Log.d("perresult", "called in");
    }
*/
    // + requestCode + " permission " + permissions[0] + " grandresult " + grantResults);
        /*switch (requestCode) {

        }
    }

    /*public static void showPermissionDialog(Context mContext,String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext, R.style.DatePicker);
        builder.setTitle("Need Permission");
        builder.setMessage(msg);
        builder.setPositiveButton(mContext.getString(R.string.invitation_yes), (dialogInterface, i)
        {
            dialogInterface.dismiss();
            Intent intent = new Intent();
            intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            Uri uri = Uri.fromParts("package", mContext.getPackageName(), null);
            intent.setData(uri);
            (mContext).startActivity(intent);
        });

        builder.setNegativeButton(mContext.getString(R.string.invitation_del_no), (dialogInterface, i) ){
            dialogInterface.dismiss();
        });
        builder.show();
    }*/

}
