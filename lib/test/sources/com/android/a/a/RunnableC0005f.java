package com.android.a.a;

import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.android.a.a.f  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0005f implements Runnable {
    final /* synthetic */ C0003d a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0005f(C0003d c0003d, int i, int i2) {
        this.a = c0003d;
        this.b = i;
        this.c = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean f;
        f = this.a.f(this.b, this.c);
        if (f) {
            SystemClock.sleep(100L);
            this.a.h(this.b, this.c);
        }
    }
}
