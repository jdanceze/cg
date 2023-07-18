package com.android.a.a;

import android.graphics.Rect;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
/* loaded from: classes.dex */
public class D extends x {
    private static final double g = 0.1d;
    private static final int h = 5;
    private static final int j = 55;
    private boolean l;
    private double m;
    private static final String i = D.class.getSimpleName();
    private static int k = 30;

    public D(E e) {
        super(e);
        this.l = true;
        this.m = g;
    }

    public boolean C() {
        n.a(new Object[0]);
        return g(5);
    }

    public boolean D() {
        n.a(new Object[0]);
        return h(5);
    }

    public int E() {
        n.a(new Object[0]);
        return k;
    }

    public double F() {
        n.a(new Object[0]);
        return this.m;
    }

    public boolean G() {
        n.a(new Object[0]);
        return g(j);
    }

    public boolean H() {
        n.a(new Object[0]);
        return h(j);
    }

    public D I() {
        n.a(new Object[0]);
        this.l = false;
        return this;
    }

    public D J() {
        n.a(new Object[0]);
        this.l = true;
        return this;
    }

    @Override // com.android.a.a.x
    public B a(E e, int i2) {
        n.a(e, Integer.valueOf(i2));
        return new B(E.a(n(), E.a(e).f(i2)));
    }

    @Override // com.android.a.a.x
    public B a(E e, String str) {
        n.a(e, str);
        return a(e, str, true);
    }

    public B a(E e, String str, boolean z) {
        n.a(e, str, Boolean.valueOf(z));
        if (str != null) {
            if (z) {
                e(new E().d(str));
            }
            return super.a(e, str);
        }
        throw new C("for description= \"" + str + "\"");
    }

    public D a(double d) {
        n.a(Double.valueOf(d));
        this.m = d;
        return this;
    }

    public boolean a(B b) {
        boolean z = true;
        Rect g2 = b.g();
        Rect p = b.p();
        if (p.width() * p.height() == g2.width() * g2.height()) {
            return true;
        }
        if (this.l) {
            if (g2.top != p.top) {
                z = false;
            }
        } else if (g2.left != p.left) {
            z = false;
        }
        return this.l ? z ? d(10) : a(10) : z ? b(10) : c(10);
    }

    @Override // com.android.a.a.x
    public B b(E e, String str) {
        n.a(e, str);
        return b(e, str, true);
    }

    public B b(E e, String str, boolean z) {
        n.a(e, str, Boolean.valueOf(z));
        if (str != null) {
            if (z) {
                e(new E().k(str));
            }
            return super.b(e, str);
        }
        throw new C("for text= \"" + str + "\"");
    }

    public boolean b(B b) {
        n.a(b.n());
        return e(b.n());
    }

    public boolean b(String str) {
        n.a(str);
        return e(new E().c(str));
    }

    public boolean c(int i2, int i3) {
        n.a(Integer.valueOf(i2), Integer.valueOf(i3));
        Log.d(i, "scrollToBeginning() on selector = " + n());
        for (int i4 = 0; i4 < i2 && g(i3); i4++) {
        }
        return true;
    }

    public boolean c(String str) {
        n.a(str);
        return e(new E().k(str));
    }

    public boolean d(int i2, int i3) {
        n.a(Integer.valueOf(i2), Integer.valueOf(i3));
        for (int i4 = 0; i4 < i2 && h(i3); i4++) {
        }
        return true;
    }

    protected boolean d(E e) {
        return m().a(e) != null;
    }

    public boolean e(int i2) {
        n.a(Integer.valueOf(i2));
        return c(i2, 5);
    }

    public boolean e(E e) {
        n.a(e);
        E b = n().b(e);
        if (!d(b)) {
            i(k);
            if (!d(b)) {
                for (int i2 = 0; i2 < k; i2++) {
                    boolean H = H();
                    if (!d(b)) {
                        if (!H) {
                            return false;
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    public boolean f(int i2) {
        n.a(Integer.valueOf(i2));
        return d(i2, 5);
    }

    public boolean g(int i2) {
        int i3;
        int centerY;
        int i4;
        int centerY2;
        n.a(Integer.valueOf(i2));
        Log.d(i, "scrollBackward() on selector = " + n());
        AccessibilityNodeInfo b = b(10000L);
        if (b == null) {
            throw new C(n().toString());
        }
        Rect rect = new Rect();
        b.getBoundsInScreen(rect);
        if (this.l) {
            int height = (int) (rect.height() * F());
            Log.d(i, "scrollToBegining() using vertical scroll");
            i3 = rect.centerX();
            centerY = rect.top + height;
            i4 = rect.centerX();
            centerY2 = rect.bottom - height;
        } else {
            int width = (int) (rect.width() * F());
            Log.d(i, "scrollToBegining() using hotizontal scroll");
            i3 = rect.left + width;
            centerY = rect.centerY();
            i4 = rect.right - width;
            centerY2 = rect.centerY();
        }
        return k().a(i3, centerY, i4, centerY2, i2);
    }

    public boolean h(int i2) {
        int i3;
        int centerY;
        int i4;
        int centerY2;
        n.a(Integer.valueOf(i2));
        Log.d(i, "scrollForward() on selector = " + n());
        AccessibilityNodeInfo b = b(10000L);
        if (b == null) {
            throw new C(n().toString());
        }
        Rect rect = new Rect();
        b.getBoundsInScreen(rect);
        if (this.l) {
            int height = (int) (rect.height() * F());
            i3 = rect.centerX();
            centerY = rect.bottom - height;
            i4 = rect.centerX();
            centerY2 = rect.top + height;
        } else {
            int width = (int) (rect.width() * F());
            i3 = rect.right - width;
            centerY = rect.centerY();
            i4 = rect.left + width;
            centerY2 = rect.centerY();
        }
        return k().a(i3, centerY, i4, centerY2, i2);
    }

    public boolean i(int i2) {
        n.a(Integer.valueOf(i2));
        return c(i2, j);
    }

    public boolean j(int i2) {
        n.a(Integer.valueOf(i2));
        return d(i2, j);
    }

    public D k(int i2) {
        n.a(Integer.valueOf(i2));
        k = i2;
        return this;
    }
}
