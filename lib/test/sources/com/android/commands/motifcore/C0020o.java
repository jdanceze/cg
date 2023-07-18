package com.android.commands.motifcore;

import android.app.IActivityManager;
import android.content.ContentValues;
import android.os.Build;
import android.view.IWindowManager;
import java.util.ArrayList;
/* renamed from: com.android.commands.motifcore.o  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0020o extends AbstractC0008c {
    private static final String a = "/sdcard/autotester.log";
    private static final String o = "PowerTester";
    private static final String p = "AUTOTEST_TEST_BEGIN_DELAY";
    private static final String q = "AUTOTEST_TEST_SUCCESS";
    private static final String r = "AUTOTEST_IDLE_SUCCESS";
    private static final String s = "AUTOTEST_SEQUENCE_BEGIN";
    private static final String t = "AUTOTEST_TEST_BEGIN";
    private static final long u = 10000;
    private static ArrayList v = new ArrayList();
    private static long w;
    private String x;
    private String y;

    public C0020o() {
        super(4);
        this.x = null;
        this.y = null;
    }

    public C0020o(String str) {
        super(4);
        this.x = str;
        this.y = null;
    }

    public C0020o(String str, String str2) {
        super(4);
        this.x = str;
        this.y = str2;
    }

    private void a(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str.compareTo(t) == 0) {
            w = currentTimeMillis;
        } else if (str.compareTo(r) == 0) {
            currentTimeMillis = Long.parseLong(str2) + w;
            str = q;
        } else if (str.compareTo(p) == 0) {
            w = currentTimeMillis + u;
            currentTimeMillis = w;
            str = t;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("date", Long.valueOf(currentTimeMillis));
        contentValues.put("tag", str);
        if (str2 != null) {
            contentValues.put("value", str2);
        }
        v.add(contentValues);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void e() {
        /*
            r7 = this;
            r2 = 0
            r1 = 0
            java.util.ArrayList r0 = com.android.commands.motifcore.C0020o.v
            android.content.ContentValues[] r3 = new android.content.ContentValues[r1]
            java.lang.Object[] r0 = r0.toArray(r3)
            android.content.ContentValues[] r0 = (android.content.ContentValues[]) r0
            java.util.ArrayList r3 = com.android.commands.motifcore.C0020o.v
            r3.clear()
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch: java.io.IOException -> L70 java.lang.Throwable -> L81
            r3.<init>()     // Catch: java.io.IOException -> L70 java.lang.Throwable -> L81
        L16:
            int r4 = r0.length     // Catch: java.io.IOException -> L70 java.lang.Throwable -> L81
            if (r1 >= r4) goto L5b
            r4 = r0[r1]
            java.lang.String r5 = "date"
            java.lang.Long r5 = r4.getAsLong(r5)     // Catch: java.io.IOException -> L70 java.lang.Throwable -> L81
            long r5 = r5.longValue()     // Catch: java.io.IOException -> L70 java.lang.Throwable -> L81
            java.lang.String r5 = com.android.commands.motifcore.au.a(r5)     // Catch: java.io.IOException -> L70 java.lang.Throwable -> L81
            r3.append(r5)     // Catch: java.io.IOException -> L70 java.lang.Throwable -> L81
            java.lang.String r5 = "tag"
            java.lang.String r5 = r4.getAsString(r5)     // Catch: java.io.IOException -> L70 java.lang.Throwable -> L81
            r3.append(r5)     // Catch: java.io.IOException -> L70 java.lang.Throwable -> L81
            java.lang.String r5 = "value"
            boolean r5 = r4.containsKey(r5)     // Catch: java.io.IOException -> L70 java.lang.Throwable -> L81
            if (r5 == 0) goto L53
            java.lang.String r5 = "value"
            java.lang.String r4 = r4.getAsString(r5)     // Catch: java.io.IOException -> L70 java.lang.Throwable -> L81
            java.lang.String r5 = " "
            r3.append(r5)     // Catch: java.io.IOException -> L70 java.lang.Throwable -> L81
            r5 = 10
            r6 = 47
            java.lang.String r4 = r4.replace(r5, r6)     // Catch: java.io.IOException -> L70 java.lang.Throwable -> L81
            r3.append(r4)     // Catch: java.io.IOException -> L70 java.lang.Throwable -> L81
        L53:
            java.lang.String r4 = "\n"
            r3.append(r4)     // Catch: java.io.IOException -> L70 java.lang.Throwable -> L81
            int r1 = r1 + 1
            goto L16
        L5b:
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch: java.io.IOException -> L70 java.lang.Throwable -> L81
            java.lang.String r0 = "/sdcard/autotester.log"
            r4 = 1
            r1.<init>(r0, r4)     // Catch: java.io.IOException -> L70 java.lang.Throwable -> L81
            java.lang.String r0 = r3.toString()     // Catch: java.io.IOException -> L8d java.lang.Throwable -> L8f
            r1.write(r0)     // Catch: java.io.IOException -> L8d java.lang.Throwable -> L8f
            if (r1 == 0) goto L6f
            r1.close()     // Catch: java.io.IOException -> L89
        L6f:
            return
        L70:
            r0 = move-exception
            r1 = r2
        L72:
            java.lang.String r2 = "PowerTester"
            java.lang.String r3 = "Can't write sdcard log file"
            android.util.Log.w(r2, r3, r0)     // Catch: java.lang.Throwable -> L91
            if (r1 == 0) goto L6f
            r1.close()     // Catch: java.io.IOException -> L7f
            goto L6f
        L7f:
            r0 = move-exception
            goto L6f
        L81:
            r0 = move-exception
        L82:
            r1 = r2
        L83:
            if (r1 == 0) goto L88
            r1.close()     // Catch: java.io.IOException -> L8b
        L88:
            throw r0
        L89:
            r0 = move-exception
            goto L6f
        L8b:
            r1 = move-exception
            goto L88
        L8d:
            r0 = move-exception
            goto L72
        L8f:
            r0 = move-exception
            goto L83
        L91:
            r0 = move-exception
            r2 = r1
            goto L82
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.commands.motifcore.C0020o.e():void");
    }

    @Override // com.android.commands.motifcore.AbstractC0008c
    public int a(IWindowManager iWindowManager, IActivityManager iActivityManager, int i) {
        if (this.x == null) {
            e();
            return 1;
        } else if (this.x.compareTo(s) == 0) {
            a(this.x, Build.FINGERPRINT);
            return 1;
        } else if (this.y != null) {
            a(this.x, this.y);
            return 1;
        } else {
            return 1;
        }
    }
}
