package com.android.commands.motifcore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* renamed from: com.android.commands.motifcore.i  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0014i extends AbstractC0008c {
    private static final String a = "/sdcard/avgFrameRateOut.txt";
    private static final String p = "MonkeyGetFrameRateEvent";
    private static float q;
    private static int r;
    private static long s;
    private static int t;
    private static long u;
    private String w;
    private String x;
    private static String v = null;
    private static final Pattern o = Pattern.compile(".*\\(([a-f[A-F][0-9]].*?)\\s.*\\)");

    public C0014i(String str) {
        super(4);
        this.w = "service call SurfaceFlinger 1013";
        this.x = str;
    }

    public C0014i(String str, String str2) {
        super(4);
        this.w = "service call SurfaceFlinger 1013";
        this.x = str;
        v = str2;
    }

    private float a(int i, float f) {
        if (f > 0.0f) {
            return i / f;
        }
        return 0.0f;
    }

    private String a(String str) {
        Matcher matcher = o.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void e() {
        /*
            r6 = this;
            r2 = 0
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch: java.io.IOException -> L53 java.lang.Throwable -> L80
            java.lang.String r0 = "/sdcard/avgFrameRateOut.txt"
            r3 = 1
            r1.<init>(r0, r3)     // Catch: java.io.IOException -> L53 java.lang.Throwable -> L80
            int r0 = com.android.commands.motifcore.C0014i.r     // Catch: java.io.IOException -> La6 java.lang.Throwable -> La8
            int r2 = com.android.commands.motifcore.C0014i.t     // Catch: java.io.IOException -> La6 java.lang.Throwable -> La8
            int r0 = r0 - r2
            float r2 = com.android.commands.motifcore.C0014i.q     // Catch: java.io.IOException -> La6 java.lang.Throwable -> La8
            float r0 = r6.a(r0, r2)     // Catch: java.io.IOException -> La6 java.lang.Throwable -> La8
            java.lang.String r2 = "%s:%.2f\n"
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.io.IOException -> La6 java.lang.Throwable -> La8
            r4 = 0
            java.lang.String r5 = com.android.commands.motifcore.C0014i.v     // Catch: java.io.IOException -> La6 java.lang.Throwable -> La8
            r3[r4] = r5     // Catch: java.io.IOException -> La6 java.lang.Throwable -> La8
            r4 = 1
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch: java.io.IOException -> La6 java.lang.Throwable -> La8
            r3[r4] = r0     // Catch: java.io.IOException -> La6 java.lang.Throwable -> La8
            java.lang.String r0 = java.lang.String.format(r2, r3)     // Catch: java.io.IOException -> La6 java.lang.Throwable -> La8
            r1.write(r0)     // Catch: java.io.IOException -> La6 java.lang.Throwable -> La8
            r1.close()     // Catch: java.io.IOException -> La6 java.lang.Throwable -> La8
            if (r1 == 0) goto L34
            r1.close()     // Catch: java.io.IOException -> L35
        L34:
            return
        L35:
            r0 = move-exception
            java.lang.String r1 = "MonkeyGetFrameRateEvent"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "IOException "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r1, r0)
            goto L34
        L53:
            r0 = move-exception
            r1 = r2
        L55:
            java.lang.String r2 = "MonkeyGetFrameRateEvent"
            java.lang.String r3 = "Can't write sdcard log file"
            android.util.Log.w(r2, r3, r0)     // Catch: java.lang.Throwable -> Laa
            if (r1 == 0) goto L34
            r1.close()     // Catch: java.io.IOException -> L62
            goto L34
        L62:
            r0 = move-exception
            java.lang.String r1 = "MonkeyGetFrameRateEvent"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "IOException "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r1, r0)
            goto L34
        L80:
            r0 = move-exception
        L81:
            r1 = r2
        L82:
            if (r1 == 0) goto L87
            r1.close()     // Catch: java.io.IOException -> L88
        L87:
            throw r0
        L88:
            r1 = move-exception
            java.lang.String r2 = "MonkeyGetFrameRateEvent"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "IOException "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r2, r1)
            goto L87
        La6:
            r0 = move-exception
            goto L55
        La8:
            r0 = move-exception
            goto L82
        Laa:
            r0 = move-exception
            r2 = r1
            goto L81
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.commands.motifcore.C0014i.e():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c0 A[Catch: IOException -> 0x00c4, TRY_LEAVE, TryCatch #6 {IOException -> 0x00c4, blocks: (B:26:0x00bb, B:28:0x00c0), top: B:59:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e5 A[Catch: IOException -> 0x00e9, TRY_LEAVE, TryCatch #0 {IOException -> 0x00e9, blocks: (B:38:0x00e0, B:40:0x00e5), top: B:55:0x00e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.android.commands.motifcore.AbstractC0008c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int a(android.view.IWindowManager r11, android.app.IActivityManager r12, int r13) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.commands.motifcore.C0014i.a(android.view.IWindowManager, android.app.IActivityManager, int):int");
    }
}
