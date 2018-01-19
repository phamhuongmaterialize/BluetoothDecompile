package com.example.phamt.bluetoothdecompile.util;

/**
 * Created by phamt on 2018/01/16.
 */

import android.util.Log;

public class LOG
{
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 7;
    private static int h = 1;
    private static boolean i = false;

    public static void a(String paramString1, String paramString2)
    {
        if (h > 6) {}
        while (!i) {
            return;
        }
        Log.e(paramString1, paramString2);
    }

    public static void a(String paramString1, String paramString2, Throwable paramThrowable)
    {
        if (h > 6) {}
        while (!i) {
            return;
        }
        Log.e(paramString1, paramString2, paramThrowable);
    }

    public static void b(String paramString1, String paramString2)
    {
        if (h >= 2) {}
        while (!i) {
            return;
        }
        Log.v(paramString1, paramString2);
    }

    public static void b(String paramString1, String paramString2, Throwable paramThrowable)
    {
        if (h > 2) {}
        while (!i) {
            return;
        }
        Log.v(paramString1, paramString2, paramThrowable);
    }

    public static void c(String paramString1, String paramString2)
    {
        if (h > 3) {}
        while (!i) {
            return;
        }
        Log.d(paramString1, paramString2);
    }

    public static void c(String paramString1, String paramString2, Throwable paramThrowable)
    {
        if (h > 3) {}
        while (!i) {
            return;
        }
        Log.d(paramString1, paramString2, paramThrowable);
    }

    public static void d(String paramString1, String paramString2)
    {
        if (i) {
            Log.i(paramString1, paramString2);
        }
        if (h > 4) {}
    }

    public static void d(String paramString1, String paramString2, Throwable paramThrowable)
    {
        if (h > 4) {}
        while (!i) {
            return;
        }
        Log.i(paramString1, paramString2, paramThrowable);
    }

    public static void e(String paramString1, String paramString2)
    {
        if (i) {
            Log.w(paramString1, paramString2);
        }
        if (h > 5) {}
    }

    public static void e(String paramString1, String paramString2, Throwable paramThrowable)
    {
        if (h > 5) {}
        while (!i) {
            return;
        }
        Log.w(paramString1, paramString2, paramThrowable);
    }

    public static void setDebug(boolean paramBoolean)
    {
        i = paramBoolean;
    }

    public static void setLevel(int paramInt)
    {
        h = paramInt;
    }
}
