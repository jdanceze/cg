package com.android.commands.motifcore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes.dex */
public class ap implements InterfaceC0010e {
    private aq a;
    private Random b;
    private boolean c;
    private int d;
    private ArrayList e;
    private aq f;
    private int g;

    public ap(String str, ArrayList arrayList, long j, boolean z, Random random, long j2, long j3, boolean z2) {
        this.g = 0;
        this.f = null;
        this.e = new ArrayList();
        this.a = null;
        this.c = false;
        this.d = 0;
        if (str != null) {
            this.f = new aq(random, str, j, z, j2, j3);
            this.a = this.f;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.e.add(new aq(random, (String) it.next(), j, z, j2, j3));
        }
        this.b = random;
        this.c = z2;
    }

    public ap(ArrayList arrayList, long j, boolean z, Random random, long j2, long j3, boolean z2) {
        this(null, arrayList, j, z, random, j2, j3, z2);
    }

    @Override // com.android.commands.motifcore.InterfaceC0010e
    public AbstractC0008c a() {
        if (this.a == null) {
            int size = this.e.size();
            if (size == 1) {
                this.a = (aq) this.e.get(0);
            } else if (size > 1) {
                if (this.c) {
                    this.a = (aq) this.e.get(this.b.nextInt(size));
                } else {
                    this.a = (aq) this.e.get(this.d % size);
                    this.d++;
                }
            }
        }
        if (this.a != null) {
            AbstractC0008c a = this.a.a();
            if (a == null) {
                this.a = null;
                return a;
            }
            return a;
        }
        return null;
    }

    @Override // com.android.commands.motifcore.InterfaceC0010e
    public void a(int i) {
        this.g = i;
        if (this.f != null) {
            this.f.a(i);
        }
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((aq) it.next()).a(i);
        }
    }

    @Override // com.android.commands.motifcore.InterfaceC0010e
    public boolean b() {
        if (this.f == null || this.f.b()) {
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                if (!((aq) it.next()).b()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
