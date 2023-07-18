package com.android.commands.motifcore;

import android.app.IActivityManager;
import android.view.IWindowManager;
/* renamed from: com.android.commands.motifcore.n  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0019n extends AbstractC0008c {
    public C0019n() {
        super(7);
    }

    @Override // com.android.commands.motifcore.AbstractC0008c
    public int a(IWindowManager iWindowManager, IActivityManager iActivityManager, int i) {
        if (i > 1) {
            System.out.println("NOOP");
        }
        return 1;
    }
}
