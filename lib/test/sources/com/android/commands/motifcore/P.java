package com.android.commands.motifcore;

import android.os.SystemClock;
/* loaded from: classes.dex */
final class P implements V {
    @Override // com.android.commands.motifcore.V
    public String a() {
        return Long.toString(SystemClock.elapsedRealtime());
    }
}
