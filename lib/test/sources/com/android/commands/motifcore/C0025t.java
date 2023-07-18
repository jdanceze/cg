package com.android.commands.motifcore;

import java.util.LinkedList;
import java.util.Queue;
/* renamed from: com.android.commands.motifcore.t  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0025t implements InterfaceC0024s {
    private final Queue a;

    private C0025t() {
        this.a = new LinkedList();
    }

    public AbstractC0008c a() {
        return (AbstractC0008c) this.a.poll();
    }

    @Override // com.android.commands.motifcore.InterfaceC0024s
    public void a(AbstractC0008c abstractC0008c) {
        this.a.offer(abstractC0008c);
    }
}
