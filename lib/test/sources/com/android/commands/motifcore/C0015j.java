package com.android.commands.motifcore;

import android.app.IActivityManager;
import android.app.IInstrumentationWatcher;
import android.app.IUiAutomationConnection;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.IWindowManager;
/* renamed from: com.android.commands.motifcore.j  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0015j extends AbstractC0008c {
    String a;
    String o;

    public C0015j(String str, String str2) {
        super(4);
        this.o = str;
        this.a = str2;
    }

    @Override // com.android.commands.motifcore.AbstractC0008c
    public int a(IWindowManager iWindowManager, IActivityManager iActivityManager, int i) {
        ComponentName unflattenFromString = ComponentName.unflattenFromString(this.a);
        if (unflattenFromString == null || this.o == null) {
            throw new IllegalArgumentException("Bad component name");
        }
        Bundle bundle = new Bundle();
        bundle.putString("class", this.o);
        try {
            iActivityManager.startInstrumentation(unflattenFromString, (String) null, 0, bundle, (IInstrumentationWatcher) null, (IUiAutomationConnection) null, 0);
            return 1;
        } catch (RemoteException e) {
            System.err.println("** Failed talking with activity manager!");
            return -1;
        }
    }
}
