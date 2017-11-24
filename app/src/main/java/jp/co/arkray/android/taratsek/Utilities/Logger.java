package jp.co.arkray.android.taratsek.Utilities;

import android.content.Context;
import android.util.Log;

/**
 * Created by USER on 11/24/2017.
 */

public class Logger {
    public static void e(Context context, String message){
        Log.e(context.getClass().getSimpleName(),message);
    }
    public static void d(Context context, String message){
        Log.d(context.getClass().getSimpleName(),message);
    }
    public static void w(Context context, String message){
        Log.w(context.getClass().getSimpleName(),message);
    }
}
