package com.android.a.a;
/* loaded from: classes.dex */
public class x extends B {
    public x(E e) {
        super(e);
    }

    public int a(E e) {
        n.a(e);
        return m().b(E.a(n(), E.a(e)));
    }

    public B a(E e, int i) {
        n.a(e, Integer.valueOf(i));
        return new B(E.a(n(), E.a(e).f(i)));
    }

    public B a(E e, String str) {
        n.a(e, str);
        if (str != null) {
            int a = a(e);
            for (int i = 0; i < a; i++) {
                B a2 = a(e, i);
                String j = a2.j();
                if ((j != null && j.contains(str)) || a2.b(new E().d(str)).f()) {
                    return a2;
                }
            }
        }
        throw new C("for description= \"" + str + "\"");
    }

    public B b(E e, String str) {
        n.a(e, str);
        if (str != null) {
            int a = a(e);
            for (int i = 0; i < a; i++) {
                B a2 = a(e, i);
                if (str.equals(a2.o()) || a2.b(new E().k(str)).f()) {
                    return a2;
                }
            }
        }
        throw new C("for text= \"" + str + "\"");
    }
}
