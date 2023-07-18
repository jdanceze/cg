package com.android.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ C0003d a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ int e;
    final /* synthetic */ int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(C0003d c0003d, int i, int i2, int i3, int i4, int i5) {
        this.a = c0003d;
        this.b = i;
        this.c = i2;
        this.e = i3;
        this.f = i4;
        this.d = i5;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b(this.b, this.c, this.e, this.f, this.d);
    }
}
