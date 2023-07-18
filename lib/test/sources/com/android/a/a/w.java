package com.android.a.a;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.UiAutomation;
import android.util.Log;
import android.view.Display;
import android.view.InputEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public abstract class w {
    private static final String a = w.class.getSimpleName();
    private static final long b = 500;
    private static final long c = 10000;
    private final C0003d d = new C0003d(this);
    private final k e = new k(this);
    private final UiAutomation f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(UiAutomation uiAutomation) {
        this.f = uiAutomation;
    }

    public abstract Display a();

    public AccessibilityEvent a(Runnable runnable, UiAutomation.AccessibilityEventFilter accessibilityEventFilter, long j) {
        return this.f.executeAndWaitForEvent(runnable, accessibilityEventFilter, j);
    }

    public void a(long j) {
        try {
            this.f.waitForIdle(b, j);
        } catch (TimeoutException e) {
            Log.w(a, "Could not detect idle state.", e);
        }
    }

    public void a(UiAutomation.OnAccessibilityEventListener onAccessibilityEventListener) {
        this.f.setOnAccessibilityEventListener(onAccessibilityEventListener);
    }

    public void a(boolean z) {
        AccessibilityServiceInfo serviceInfo = this.f.getServiceInfo();
        if (z) {
            serviceInfo.flags &= -3;
        } else {
            serviceInfo.flags |= 2;
        }
        this.f.setServiceInfo(serviceInfo);
    }

    public boolean a(int i) {
        return this.f.performGlobalAction(i);
    }

    public boolean a(InputEvent inputEvent, boolean z) {
        return this.f.injectInputEvent(inputEvent, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.io.File r7, int r8) {
        /*
            r6 = this;
            r2 = 0
            r3 = 0
            android.app.UiAutomation r0 = r6.f
            android.graphics.Bitmap r4 = r0.takeScreenshot()
            if (r4 != 0) goto Lc
            r0 = r3
        Lb:
            return r0
        Lc:
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch: java.io.IOException -> L2a java.lang.Throwable -> L3d
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.io.IOException -> L2a java.lang.Throwable -> L3d
            r0.<init>(r7)     // Catch: java.io.IOException -> L2a java.lang.Throwable -> L3d
            r1.<init>(r0)     // Catch: java.io.IOException -> L2a java.lang.Throwable -> L3d
            if (r1 == 0) goto L20
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.io.IOException -> L4e java.lang.Throwable -> L50
            r4.compress(r0, r8, r1)     // Catch: java.io.IOException -> L4e java.lang.Throwable -> L50
            r1.flush()     // Catch: java.io.IOException -> L4e java.lang.Throwable -> L50
        L20:
            if (r1 == 0) goto L25
            r1.close()     // Catch: java.io.IOException -> L48
        L25:
            r4.recycle()
            r0 = 1
            goto Lb
        L2a:
            r0 = move-exception
            r1 = r2
        L2c:
            java.lang.String r2 = com.android.a.a.w.a     // Catch: java.lang.Throwable -> L52
            java.lang.String r5 = "failed to save screen shot to file"
            android.util.Log.e(r2, r5, r0)     // Catch: java.lang.Throwable -> L52
            if (r1 == 0) goto L38
            r1.close()     // Catch: java.io.IOException -> L4a
        L38:
            r4.recycle()
            r0 = r3
            goto Lb
        L3d:
            r0 = move-exception
        L3e:
            r1 = r2
        L3f:
            if (r1 == 0) goto L44
            r1.close()     // Catch: java.io.IOException -> L4c
        L44:
            r4.recycle()
            throw r0
        L48:
            r0 = move-exception
            goto L25
        L4a:
            r0 = move-exception
            goto L38
        L4c:
            r1 = move-exception
            goto L44
        L4e:
            r0 = move-exception
            goto L2c
        L50:
            r0 = move-exception
            goto L3f
        L52:
            r0 = move-exception
            r2 = r1
            goto L3e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.a.a.w.a(java.io.File, int):boolean");
    }

    public abstract int b();

    public boolean b(int i) {
        return this.f.setRotation(i);
    }

    public abstract long c();

    public abstract boolean d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0003d e() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k f() {
        return this.e;
    }

    public AccessibilityNodeInfo g() {
        return this.f.getRootInActiveWindow();
    }

    public void h() {
        a(c);
    }
}
