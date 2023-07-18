package com.android.commands.motifcore;

import android.content.ComponentName;
import android.graphics.PointF;
import android.hardware.display.DisplayManagerGlobal;
import android.os.SystemClock;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
/* loaded from: classes.dex */
public class ao implements InterfaceC0010e {
    public static final int a = 12;
    public static final int b = 11;
    public static final int c = 8;
    public static final int d = 9;
    public static final int e = 10;
    public static final int f = 6;
    public static final int g = 1;
    public static final int h = 5;
    public static final int i = 2;
    public static final int j = 4;
    public static final int k = 7;
    public static final int l = 0;
    public static final int m = 3;
    private static final int n = 1;
    private static final int o = 2;
    private static final int p = 0;
    private static final int[] t;
    private Random A;
    private ArrayList y;
    private C0009d z;
    private static final int[] r = {19, 20, 21, 22};
    private static final int[] q = {82, 23};
    private static final int[] u = {3, 4, 5, 6, 24, 25, 164, 91};
    private static final boolean[] s = new boolean[KeyEvent.getMaxKeyCode() + 1];
    private float[] w = new float[12];
    private int v = 0;
    private int C = 0;
    private long B = 0;
    private boolean x = false;

    static {
        for (int i2 = 0; i2 < s.length; i2++) {
            s[i2] = true;
        }
        for (int i3 = 0; i3 < u.length; i3++) {
            s[u[i3]] = KeyCharacterMap.deviceHasKey(u[i3]);
        }
        t = new int[]{0, 1, 2, 3};
    }

    public ao(Random random, ArrayList arrayList, long j2, boolean z) {
        this.w[0] = 15.0f;
        this.w[1] = 10.0f;
        this.w[3] = 15.0f;
        this.w[4] = 0.0f;
        this.w[5] = 25.0f;
        this.w[6] = 15.0f;
        this.w[7] = 2.0f;
        this.w[8] = 2.0f;
        this.w[9] = 1.0f;
        this.w[10] = 3.0f;
        this.w[11] = 10.0f;
        this.w[2] = 2.0f;
        this.A = random;
        this.y = arrayList;
        this.z = new C0009d(random, j2, z);
    }

    public static int a(String str) {
        return KeyEvent.keyCodeFromString(str);
    }

    private PointF a(Random random, Display display) {
        return new PointF(random.nextInt(display.getWidth()), random.nextInt(display.getHeight()));
    }

    private void a(Random random) {
        this.z.addLast(new C0021p(t[random.nextInt(t.length)], random.nextBoolean()));
    }

    private void a(Random random, int i2) {
        Display realDisplay = DisplayManagerGlobal.getInstance().getRealDisplay(0);
        PointF a2 = a(random, realDisplay);
        PointF c2 = c(random);
        long uptimeMillis = SystemClock.uptimeMillis();
        this.z.addLast(new as(0).a(uptimeMillis).a(0, a2.x, a2.y).a(false));
        if (i2 == 1) {
            int nextInt = random.nextInt(10);
            for (int i3 = 0; i3 < nextInt; i3++) {
                a(random, realDisplay, a2, c2);
                this.z.addLast(new as(2).a(uptimeMillis).a(0, a2.x, a2.y).a(true));
            }
        } else if (i2 == 2) {
            PointF a3 = a(random, realDisplay);
            PointF c3 = c(random);
            a(random, realDisplay, a2, c2);
            this.z.addLast(new as(261).a(uptimeMillis).a(0, a2.x, a2.y).a(1, a3.x, a3.y).a(true));
            int nextInt2 = random.nextInt(10);
            for (int i4 = 0; i4 < nextInt2; i4++) {
                a(random, realDisplay, a2, c2);
                a(random, realDisplay, a3, c3);
                this.z.addLast(new as(2).a(uptimeMillis).a(0, a2.x, a2.y).a(1, a3.x, a3.y).a(true));
            }
            a(random, realDisplay, a2, c2);
            a(random, realDisplay, a3, c3);
            this.z.addLast(new as(262).a(uptimeMillis).a(0, a2.x, a2.y).a(1, a3.x, a3.y).a(true));
        }
        a(random, realDisplay, a2, c2);
        this.z.addLast(new as(1).a(uptimeMillis).a(0, a2.x, a2.y).a(false));
    }

    private void a(Random random, Display display, PointF pointF, PointF pointF2) {
        pointF.x = Math.max(Math.min(pointF.x + (random.nextFloat() * pointF2.x), display.getWidth()), 0.0f);
        pointF.y = Math.max(Math.min(pointF.y + (random.nextFloat() * pointF2.y), display.getHeight()), 0.0f);
    }

    private static boolean a(String str, int[] iArr, float f2) {
        if (f2 >= 0.1f) {
            for (int i2 : iArr) {
                if (!s[i2]) {
                }
            }
            System.err.println("** " + str + " has no physical keys but with factor " + f2 + "%.");
            return false;
        }
        return true;
    }

    public static String b(int i2) {
        return KeyEvent.keyCodeToString(i2);
    }

    private void b(Random random) {
        int i2 = 0;
        while (i2 < 10) {
            this.z.addLast(new at(2).a(0, random.nextInt(10) - 5, random.nextInt(10) - 5).a(i2 > 0));
            i2++;
        }
        if (random.nextInt(10) == 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.z.addLast(new at(0).a(uptimeMillis).a(0, 0.0f, 0.0f).a(true));
            this.z.addLast(new at(1).a(uptimeMillis).a(0, 0.0f, 0.0f).a(false));
        }
    }

    private PointF c(Random random) {
        return new PointF((random.nextFloat() - 0.5f) * 50.0f, (random.nextFloat() - 0.5f) * 50.0f);
    }

    private boolean d() {
        int i2 = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i3 = 0; i3 < 12; i3++) {
            if (this.w[i3] <= 0.0f) {
                f3 -= this.w[i3];
            } else {
                f2 += this.w[i3];
                i2++;
            }
        }
        if (f3 > 100.0f) {
            System.err.println("** Event weights > 100%");
        } else if (i2 == 0 && (f3 < 99.9f || f3 > 100.1f)) {
            System.err.println("** Event weights != 100%");
            return false;
        } else {
            float f4 = (100.0f - f3) / f2;
            for (int i4 = 0; i4 < 12; i4++) {
                if (this.w[i4] <= 0.0f) {
                    this.w[i4] = -this.w[i4];
                } else {
                    float[] fArr = this.w;
                    fArr[i4] = fArr[i4] * f4;
                }
            }
            if (this.C > 0) {
                System.out.println("// Event percentages:");
                for (int i5 = 0; i5 < 12; i5++) {
                    System.out.println("//   " + i5 + ": " + this.w[i5] + "%");
                }
            }
            if (f()) {
                float f5 = 0.0f;
                for (int i6 = 0; i6 < 12; i6++) {
                    f5 += this.w[i6] / 100.0f;
                    this.w[i6] = f5;
                }
                return true;
            }
        }
        return false;
    }

    private void e() {
        int nextInt;
        float nextFloat = this.A.nextFloat();
        if (nextFloat < this.w[0]) {
            a(this.A, 0);
        } else if (nextFloat < this.w[1]) {
            a(this.A, 1);
        } else if (nextFloat < this.w[2]) {
            a(this.A, 2);
        } else if (nextFloat < this.w[3]) {
            b(this.A);
        } else if (nextFloat < this.w[4]) {
            a(this.A);
        } else {
            while (true) {
                if (nextFloat < this.w[5]) {
                    nextInt = r[this.A.nextInt(r.length)];
                } else if (nextFloat < this.w[6]) {
                    nextInt = q[this.A.nextInt(q.length)];
                } else if (nextFloat < this.w[7]) {
                    nextInt = u[this.A.nextInt(u.length)];
                } else if (nextFloat < this.w[8]) {
                    this.z.addLast(new C0006a((ComponentName) this.y.get(this.A.nextInt(this.y.size()))));
                    return;
                } else if (nextFloat < this.w[9]) {
                    C0011f c0011f = new C0011f(this.x);
                    this.x = this.x ? false : true;
                    this.z.addLast(c0011f);
                    return;
                } else if (nextFloat < this.w[10]) {
                    this.z.addLast(new C0012g());
                    return;
                } else {
                    nextInt = this.A.nextInt(KeyEvent.getMaxKeyCode() - 1) + 1;
                }
                if (nextInt != 26 && nextInt != 6 && s[nextInt]) {
                    this.z.addLast(new C0016k(0, nextInt));
                    this.z.addLast(new C0016k(1, nextInt));
                    return;
                }
            }
        }
    }

    private boolean f() {
        return a("NAV_KEYS", r, this.w[5]) && a("MAJOR_NAV_KEYS", q, this.w[6]) && a("SYS_KEYS", u, this.w[7]);
    }

    @Override // com.android.commands.motifcore.InterfaceC0010e
    public AbstractC0008c a() {
        if (this.z.isEmpty()) {
            e();
        }
        this.v++;
        AbstractC0008c abstractC0008c = (AbstractC0008c) this.z.getFirst();
        this.z.removeFirst();
        return abstractC0008c;
    }

    @Override // com.android.commands.motifcore.InterfaceC0010e
    public void a(int i2) {
        this.C = i2;
    }

    public void a(int i2, float f2) {
        this.w[i2] = f2;
    }

    public void a(float[] fArr) {
        int length = fArr.length < 12 ? fArr.length : 12;
        for (int i2 = 0; i2 < length; i2++) {
            this.w[i2] = fArr[i2];
        }
    }

    @Override // com.android.commands.motifcore.InterfaceC0010e
    public boolean b() {
        return d();
    }

    public void c() {
        this.z.addLast(new C0006a((ComponentName) this.y.get(this.A.nextInt(this.y.size()))));
    }
}
