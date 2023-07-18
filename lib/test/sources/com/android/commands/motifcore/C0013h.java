package com.android.commands.motifcore;

import android.os.Environment;
import java.io.BufferedReader;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* renamed from: com.android.commands.motifcore.h  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0013h extends AbstractC0008c {
    private static final String p = "MonkeyGetAppFrameRateEvent";
    private static float r;
    private static int s;
    private static long t;
    private static int u;
    private static long v;
    private String x;
    private String y;
    private static String q = null;
    private static String w = null;
    private static final String a = new File(Environment.getExternalStorageDirectory(), "avgAppFrameRateOut.txt").getAbsolutePath();
    private static final Pattern o = Pattern.compile(".* ([0-9]*) frames rendered");

    public C0013h(String str) {
        super(4);
        this.x = "dumpsys gfxinfo %s";
        this.y = str;
    }

    public C0013h(String str, String str2) {
        super(4);
        this.x = "dumpsys gfxinfo %s";
        this.y = str;
        q = str2;
    }

    public C0013h(String str, String str2, String str3) {
        super(4);
        this.x = "dumpsys gfxinfo %s";
        this.y = str;
        q = str2;
        w = str3;
    }

    private float a(int i, float f) {
        if (f > 0.0f) {
            return i / f;
        }
        return 0.0f;
    }

    private String a(BufferedReader bufferedReader) {
        Matcher matcher;
        do {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            matcher = o.matcher(readLine);
        } while (!matcher.matches());
        return matcher.group(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void e() {
        /*
            r6 = this;
            r2 = 0
            java.lang.String r0 = "MonkeyGetAppFrameRateEvent"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L97
            r1.<init>()     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L97
            java.lang.String r3 = "file: "
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L97
            java.lang.String r3 = com.android.commands.motifcore.C0013h.a     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L97
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L97
            java.lang.String r1 = r1.toString()     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L97
            android.util.Log.w(r0, r1)     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L97
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L97
            java.lang.String r0 = com.android.commands.motifcore.C0013h.a     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L97
            r3 = 1
            r1.<init>(r0, r3)     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L97
            int r0 = com.android.commands.motifcore.C0013h.s     // Catch: java.io.IOException -> Lbd java.lang.Throwable -> Lbf
            int r2 = com.android.commands.motifcore.C0013h.u     // Catch: java.io.IOException -> Lbd java.lang.Throwable -> Lbf
            int r0 = r0 - r2
            float r2 = com.android.commands.motifcore.C0013h.r     // Catch: java.io.IOException -> Lbd java.lang.Throwable -> Lbf
            float r0 = r6.a(r0, r2)     // Catch: java.io.IOException -> Lbd java.lang.Throwable -> Lbf
            java.lang.String r2 = "%s:%.2f\n"
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.io.IOException -> Lbd java.lang.Throwable -> Lbf
            r4 = 0
            java.lang.String r5 = com.android.commands.motifcore.C0013h.w     // Catch: java.io.IOException -> Lbd java.lang.Throwable -> Lbf
            r3[r4] = r5     // Catch: java.io.IOException -> Lbd java.lang.Throwable -> Lbf
            r4 = 1
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch: java.io.IOException -> Lbd java.lang.Throwable -> Lbf
            r3[r4] = r0     // Catch: java.io.IOException -> Lbd java.lang.Throwable -> Lbf
            java.lang.String r0 = java.lang.String.format(r2, r3)     // Catch: java.io.IOException -> Lbd java.lang.Throwable -> Lbf
            r1.write(r0)     // Catch: java.io.IOException -> Lbd java.lang.Throwable -> Lbf
            if (r1 == 0) goto L4b
            r1.close()     // Catch: java.io.IOException -> L4c
        L4b:
            return
        L4c:
            r0 = move-exception
            java.lang.String r1 = "MonkeyGetAppFrameRateEvent"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "IOException "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r1, r0)
            goto L4b
        L6a:
            r0 = move-exception
            r1 = r2
        L6c:
            java.lang.String r2 = "MonkeyGetAppFrameRateEvent"
            java.lang.String r3 = "Can't write sdcard log file"
            android.util.Log.w(r2, r3, r0)     // Catch: java.lang.Throwable -> Lc1
            if (r1 == 0) goto L4b
            r1.close()     // Catch: java.io.IOException -> L79
            goto L4b
        L79:
            r0 = move-exception
            java.lang.String r1 = "MonkeyGetAppFrameRateEvent"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "IOException "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r1, r0)
            goto L4b
        L97:
            r0 = move-exception
        L98:
            r1 = r2
        L99:
            if (r1 == 0) goto L9e
            r1.close()     // Catch: java.io.IOException -> L9f
        L9e:
            throw r0
        L9f:
            r1 = move-exception
            java.lang.String r2 = "MonkeyGetAppFrameRateEvent"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "IOException "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r2, r1)
            goto L9e
        Lbd:
            r0 = move-exception
            goto L6c
        Lbf:
            r0 = move-exception
            goto L99
        Lc1:
            r0 = move-exception
            r2 = r1
            goto L98
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.commands.motifcore.C0013h.e():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c3 A[Catch: IOException -> 0x00c7, TRY_LEAVE, TryCatch #1 {IOException -> 0x00c7, blocks: (B:26:0x00be, B:28:0x00c3), top: B:55:0x00be }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e8 A[Catch: IOException -> 0x00ec, TRY_LEAVE, TryCatch #9 {IOException -> 0x00ec, blocks: (B:38:0x00e3, B:40:0x00e8), top: B:61:0x00e3 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.android.commands.motifcore.AbstractC0008c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int a(android.view.IWindowManager r12, android.app.IActivityManager r13, int r14) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.commands.motifcore.C0013h.a(android.view.IWindowManager, android.app.IActivityManager, int):int");
    }
}
