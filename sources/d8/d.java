package d8;

import t9.g;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public int f16410a;

    /* renamed from: b  reason: collision with root package name */
    public int f16411b;

    /* renamed from: c  reason: collision with root package name */
    public int f16412c;

    public d(int i10, int i11, int i12) {
        this.f16410a = i10;
        this.f16411b = i11;
        this.f16412c = i12;
    }

    public final int a() {
        return this.f16411b;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                if (this.f16410a == dVar.f16410a) {
                    if (this.f16411b == dVar.f16411b) {
                        if (this.f16412c == dVar.f16412c) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((this.f16410a * 31) + this.f16411b) * 31) + this.f16412c;
    }

    public String toString() {
        return "SelectedTracks(videoTrack=" + this.f16410a + ", audioTrack=" + this.f16411b + ", subtitleTrack=" + this.f16412c + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(int i10, int i11, int i12, int i13, g gVar) {
        this((i13 & 1) != 0 ? -1 : i10, (i13 & 2) != 0 ? -1 : i11, (i13 & 4) != 0 ? -1 : i12);
    }
}
