package com.android.commands.motifcore;

import android.app.IActivityManager;
import android.os.RemoteException;
import android.view.IWindowManager;
/* renamed from: com.android.commands.motifcore.p  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0021p extends AbstractC0008c {
    private final boolean a;
    private final int o;

    public C0021p(int i, boolean z) {
        super(3);
        this.o = i;
        this.a = z;
    }

    @Override // com.android.commands.motifcore.AbstractC0008c
    public int a(IWindowManager iWindowManager, IActivityManager iActivityManager, int i) {
        if (i > 0) {
            System.out.println(":Sending rotation degree=" + this.o + ", persist=" + this.a);
        }
        try {
            iWindowManager.freezeRotation(this.o);
            if (!this.a) {
                iWindowManager.thawRotation();
            }
            return 1;
        } catch (RemoteException e) {
            return -1;
        }
    }
}
