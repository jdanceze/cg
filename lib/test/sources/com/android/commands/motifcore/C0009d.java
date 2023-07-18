package com.android.commands.motifcore;

import java.util.LinkedList;
import java.util.Random;
/* renamed from: com.android.commands.motifcore.d  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0009d extends LinkedList {
    private Random a;
    private boolean b;
    private long c;

    public C0009d(Random random, long j, boolean z) {
        this.a = random;
        this.c = j;
        this.b = z;
    }

    @Override // java.util.LinkedList, java.util.Deque
    /* renamed from: a */
    public void addLast(AbstractC0008c abstractC0008c) {
        super.add(abstractC0008c);
        if (abstractC0008c.d()) {
            long j = this.c;
            if (this.b && this.c > 0) {
                long nextLong = this.a.nextLong();
                if (nextLong < 0) {
                    nextLong = -nextLong;
                }
                j = (nextLong % this.c) + 1;
            }
            super.add(new ar(j));
        }
    }
}
