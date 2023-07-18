package com.android.commands.motifcore;

import android.app.IActivityManager;
import android.content.Intent;
import android.os.Environment;
import android.view.IWindowManager;
import android.view.KeyEvent;
import android.view.MotionEvent;
import java.io.File;
/* renamed from: com.android.commands.motifcore.c  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0008c {
    public static final int b = 4;
    public static final int c = 5;
    public static final int d = 0;
    public static final int e = 7;
    public static final int f = 3;
    public static final int g = 6;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = -1;
    public static final int k = -2;
    public static final int l = 0;
    public static final int m = 1;
    protected int n;

    public AbstractC0008c(int i2) {
        this.n = i2;
    }

    public abstract int a(IWindowManager iWindowManager, IActivityManager iActivityManager, int i2);

    public void a() {
    }

    public void a(int i2) {
    }

    public void a(Intent intent) {
    }

    public void a(KeyEvent keyEvent) {
    }

    public void a(MotionEvent motionEvent) {
    }

    public int b() {
        return this.n;
    }

    public boolean c() {
        File file = new File(Environment.getLegacyExternalStorageDirectory(), "window_dump.xml");
        if (file.exists()) {
            new File(Environment.getLegacyExternalStorageDirectory(), "window_dump.xml.pre").delete();
            file.renameTo(new File(Environment.getLegacyExternalStorageDirectory(), "window_dump.xml.pre"));
            au.a("uiautomator dump");
            if (au.a(new File(Environment.getLegacyExternalStorageDirectory(), "window_dump.xml"), new File(Environment.getLegacyExternalStorageDirectory(), "window_dump.xml.pre"))) {
                return false;
            }
        } else {
            au.a("uiautomator dump");
        }
        return true;
    }

    public boolean d() {
        return true;
    }
}
