package app.instabillpos.utils;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Helper {

    public static String BaseUrl = "https://instabill.co/api/";
    public static Long timeOutTime = 180L;

    public static long imageSize(Context mContext, Uri imageUri) {
        Bitmap bitmap = null;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), imageUri);
        } catch (Exception e) {
            Log.d("SANJAY", "imageSize: " + e.getMessage());
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] imageInByte = stream.toByteArray();
        long lengthbmp = imageInByte.length;
        return lengthbmp / 1024;
    }

    public static String showDeviceInfo(Context context) {
        @SuppressLint("HardwareIds")
        String deviceId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        return deviceId;
    }

    public static AlertDialog initDialog(Context mContext) {
        return new AlertDialog.Builder(mContext).create();
    }

    public static String formatDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            date = format2.format(format.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
        //this is will return yyyy-mm-dd
    }

    public static String[] getCurrentMonthStartEndDate() {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = 1;
        int numOfDaysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);

        String startDate = getFinalDate(mYear, mMonth, mDay);
        String endDate = getFinalDate(mYear, mMonth, numOfDaysInMonth);

        return new String[]{startDate, endDate};
    }


    public static String getFinalDate(int year, int month, int day) {
        final DecimalFormat mFormat = new DecimalFormat("00");
        return year + "-" + mFormat.format((month + 1)) + "-" + mFormat.format(day);
    }


    public static String[] getLastMonthStartEndDate() {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = 1;
        c.set(mYear, mMonth - 1, mDay);

        int numOfDaysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (mMonth == 0) {
            mMonth = 12;
            mYear -= 1;
        }
//        Log.d(TAG, "numofdayinmonth::=> " + numOfDaysInMonth+ " c month "+mMonth);
        String startDate = getFinalDate(mYear, mMonth - 1, mDay);
        String endDate = getFinalDate(mYear, mMonth - 1, numOfDaysInMonth);


        return new String[]{startDate, endDate};
    }

    public static String encodeString(String inputString) {
        try {
            byte[] start_date_data = inputString.getBytes("UTF-8");
            inputString = Base64.encodeToString(start_date_data, Base64.DEFAULT);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return inputString;

    }

}
