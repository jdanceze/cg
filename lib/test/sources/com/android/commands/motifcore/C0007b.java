package com.android.commands.motifcore;

import android.app.IActivityManager;
import android.view.IWindowManager;
/* renamed from: com.android.commands.motifcore.b  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0007b extends AbstractC0008c {
    private String a;

    public C0007b(String str) {
        super(4);
        this.a = str;
    }

    @Override // com.android.commands.motifcore.AbstractC0008c
    public int a(IWindowManager iWindowManager, IActivityManager iActivityManager, int i) {
        if (this.a != null) {
            try {
                System.err.println("// Shell command " + this.a + " status was " + Runtime.getRuntime().exec(this.a).waitFor());
                return 1;
            } catch (Exception e) {
                System.err.println("// Exception from " + this.a + ":");
                System.err.println(e.toString());
                return 1;
            }
        }
        return 1;
    }
}
