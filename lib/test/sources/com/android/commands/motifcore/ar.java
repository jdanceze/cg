package com.android.commands.motifcore;

import android.app.IActivityManager;
import android.view.IWindowManager;
/* loaded from: classes.dex */
public class ar extends AbstractC0008c {
    private long a;

    public ar(long j) {
        super(6);
        this.a = j;
    }

    @Override // com.android.commands.motifcore.AbstractC0008c
    public int a(IWindowManager iWindowManager, IActivityManager iActivityManager, int i) {
        if (i > 1) {
            System.out.println("Sleeping for " + this.a + " milliseconds");
        }
        try {
            Thread.sleep(this.a);
            return 1;
        } catch (InterruptedException e) {
            System.out.println("** Monkey interrupted in sleep.");
            return 0;
        }
    }
}
