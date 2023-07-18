package com.android.a.a;
/* renamed from: com.android.a.a.c  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0002c {
    private static C0002c a;
    private long e = 10000;
    private long f = 10000;
    private long d = 3000;
    private long c = 200;
    private long b = 0;

    private C0002c() {
    }

    public static C0002c a() {
        if (a == null) {
            a = new C0002c();
        }
        return a;
    }

    public C0002c a(long j) {
        this.d = j;
        return this;
    }

    public long b() {
        return this.d;
    }

    public C0002c b(long j) {
        this.b = j;
        return this;
    }

    public long c() {
        return this.b;
    }

    public C0002c c(long j) {
        this.c = j;
        return this;
    }

    public long d() {
        return this.c;
    }

    public C0002c d(long j) {
        this.e = j;
        return this;
    }

    public long e() {
        return this.e;
    }

    public C0002c e(long j) {
        this.f = j;
        return this;
    }

    public long f() {
        return this.f;
    }
}
