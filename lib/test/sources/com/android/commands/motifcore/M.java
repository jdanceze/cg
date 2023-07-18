package com.android.commands.motifcore;
/* loaded from: classes.dex */
final class M implements V {
    @Override // com.android.commands.motifcore.V
    public String a() {
        if (Motifcore.c == null) {
            return null;
        }
        return Motifcore.c.getComponent().getPackageName();
    }
}
