package com.socoolby.scroll_table.unit;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by socoolby on 3/20/14.
 */
public class Func {
    public static boolean isDebug=true;
    public static void Log(String TAG,String info)
    {
        if(isDebug)
        {
            Log.i(TAG, info);
        }
    }
    public static void DebugShowInToast(Context context,String text)
    {
        if(isDebug)
        {
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
        }
    }
    public static void toast(Context context, CharSequence text){
        if(null!=text)
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
