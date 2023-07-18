package com.android.commands.motifcore;

import android.app.IActivityManager;
import android.view.IWindowManager;
import java.io.FileOutputStream;
import java.io.IOException;
/* renamed from: com.android.commands.motifcore.f  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0011f extends AbstractC0008c {
    private static final byte[] a = {Byte.MAX_VALUE, 6, 0, 0, -32, 57, 1, 0, 5, 0, 0, 0, 1, 0, 0, 0};
    private static final byte[] o = {-123, 6, 0, 0, -97, -91, 12, 0, 5, 0, 0, 0, 0, 0, 0, 0};
    private final boolean p;

    public C0011f(boolean z) {
        super(5);
        this.p = z;
    }

    @Override // com.android.commands.motifcore.AbstractC0008c
    public int a(IWindowManager iWindowManager, IActivityManager iActivityManager, int i) {
        if (i > 0) {
            System.out.println(":Sending Flip keyboardOpen=" + this.p);
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/dev/input/event0");
            fileOutputStream.write(this.p ? a : o);
            fileOutputStream.close();
            if (!Motifcore.g) {
                try {
                    a();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return 1;
        } catch (IOException e2) {
            System.out.println("Got IOException performing flip" + e2);
            return 0;
        }
    }

    @Override // com.android.commands.motifcore.AbstractC0008c
    public void a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DispatchFlip(");
        if (this.p) {
            stringBuffer.append(true);
        } else {
            stringBuffer.append(false);
        }
        Motifcore.e.write(stringBuffer.toString() + ")\n");
    }
}
