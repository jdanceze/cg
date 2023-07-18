package com.android.a.a;

import android.os.SystemClock;
import android.view.KeyEvent;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.android.a.a.e  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0004e implements Runnable {
    final /* synthetic */ C0003d a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0004e(C0003d c0003d, int i, int i2) {
        this.a = c0003d;
        this.b = i;
        this.c = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean a;
        long uptimeMillis = SystemClock.uptimeMillis();
        a = this.a.a(new KeyEvent(uptimeMillis, uptimeMillis, 0, this.b, 0, this.c, -1, 0, 0, 257));
        if (a) {
            this.a.a(new KeyEvent(uptimeMillis, uptimeMillis, 1, this.b, 0, this.c, -1, 0, 0, 257));
        }
    }
}
