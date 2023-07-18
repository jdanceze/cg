package com.android.a.a;

import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class n {
    private static final int a = 6;
    private static final int b = 5;
    private static final int c = 7;
    private static final String d = "com.android.uiautomator.core";
    private static final String e = "(unknown method)";
    private static n f = null;
    private File h;
    private r g = r.NONE;
    private List i = new ArrayList();

    public static n a() {
        if (f == null) {
            f = new n();
        }
        return f;
    }

    private static String a(Object obj) {
        return obj.getClass().isArray() ? obj instanceof Object[] ? Arrays.deepToString((Object[]) obj) : "[...]" : obj.toString();
    }

    private static String a(String str, Object[] objArr) {
        if (objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(a(objArr[0]));
        for (int i = 1; i < objArr.length; i++) {
            sb.append(str);
            sb.append(a(objArr[i]));
        }
        return sb.toString();
    }

    public static void a(Object... objArr) {
        a().b(objArr);
    }

    private void b(String str) {
        for (s sVar : this.i) {
            sVar.a(str);
        }
    }

    private void b(Object[] objArr) {
        String d2;
        if (this.g == r.NONE || (d2 = d()) == null) {
            return;
        }
        b(String.format("%s (%s)", d2, a(", ", objArr)));
    }

    private void c() {
        for (s sVar : this.i) {
            sVar.a();
        }
        this.i.clear();
    }

    private static String d() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 7) {
            return e;
        }
        StackTraceElement stackTraceElement = stackTrace[5];
        StackTraceElement stackTraceElement2 = stackTrace[6];
        if (stackTraceElement2.getClassName().startsWith(d)) {
            return null;
        }
        int lastIndexOf = stackTraceElement.getClassName().lastIndexOf(46);
        if (lastIndexOf < 0) {
            lastIndexOf = 0;
        }
        return lastIndexOf + 1 >= stackTraceElement.getClassName().length() ? e : String.format("%s.%s from %s() at %s:%d", stackTraceElement.getClassName().substring(lastIndexOf + 1), stackTraceElement.getMethodName(), stackTraceElement2.getMethodName(), stackTraceElement2.getFileName(), Integer.valueOf(stackTraceElement2.getLineNumber()));
    }

    public void a(r rVar) {
        c();
        this.g = rVar;
        try {
            switch (rVar) {
                case FILE:
                    if (this.h == null) {
                        throw new IllegalArgumentException("Please provide a filename before attempting write trace to a file");
                    }
                    this.i.add(new p(this, this.h));
                    return;
                case LOGCAT:
                    this.i.add(new q(this, null));
                    return;
                case ALL:
                    this.i.add(new q(this, null));
                    if (this.h == null) {
                        throw new IllegalArgumentException("Please provide a filename before attempting write trace to a file");
                    }
                    this.i.add(new p(this, this.h));
                    return;
                default:
                    return;
            }
        } catch (FileNotFoundException e2) {
            Log.w("Tracer", "Could not open log file: " + e2.getMessage());
        }
    }

    public void a(String str) {
        this.h = new File(str);
    }

    public boolean b() {
        return this.g != r.NONE;
    }
}
