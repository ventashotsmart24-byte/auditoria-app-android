package mobile.com.requestframe.utils.response;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.ArrayList;
import na.b;
import t9.i;

public final class Match implements Serializable {
    private String channelCode;
    private ArrayList<MatchChannel> channelInfoList;
    private String channelName;
    private String gameId;
    private String gameStatus;
    private String gameTime;
    private boolean isInTenMinutes;
    private boolean isSubscribed;
    private String matchAlias;
    private String matchId;
    private String matchLogo;
    private String matchName;
    private String playBackType;
    private String playBackUrl;
    private String score;
    private Team team_a;
    private Team team_b;

    public Match(String str, Team team, Team team2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, ArrayList<MatchChannel> arrayList) {
        Team team3 = team2;
        String str13 = str2;
        String str14 = str3;
        String str15 = str4;
        String str16 = str6;
        String str17 = str7;
        String str18 = str10;
        String str19 = str11;
        String str20 = str12;
        i.g(str, "gameId");
        i.g(team, "team_a");
        i.g(team3, "team_b");
        i.g(str13, "matchId");
        i.g(str14, "matchName");
        i.g(str15, "matchAlias");
        i.g(str16, "channelName");
        i.g(str17, "channelCode");
        i.g(str18, "gameTime");
        i.g(str19, FirebaseAnalytics.Param.SCORE);
        i.g(str20, "gameStatus");
        this.gameId = str;
        this.team_a = team;
        this.team_b = team3;
        this.matchId = str13;
        this.matchName = str14;
        this.matchAlias = str15;
        this.matchLogo = str5;
        this.channelName = str16;
        this.channelCode = str17;
        this.playBackType = str8;
        this.playBackUrl = str9;
        this.gameTime = str18;
        this.score = str19;
        this.gameStatus = str20;
        this.channelInfoList = arrayList;
    }

    public static /* synthetic */ Match copy$default(Match match, String str, Team team, Team team2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, ArrayList arrayList, int i10, Object obj) {
        Match match2 = match;
        int i11 = i10;
        return match.copy((i11 & 1) != 0 ? match2.gameId : str, (i11 & 2) != 0 ? match2.team_a : team, (i11 & 4) != 0 ? match2.team_b : team2, (i11 & 8) != 0 ? match2.matchId : str2, (i11 & 16) != 0 ? match2.matchName : str3, (i11 & 32) != 0 ? match2.matchAlias : str4, (i11 & 64) != 0 ? match2.matchLogo : str5, (i11 & 128) != 0 ? match2.channelName : str6, (i11 & 256) != 0 ? match2.channelCode : str7, (i11 & 512) != 0 ? match2.playBackType : str8, (i11 & 1024) != 0 ? match2.playBackUrl : str9, (i11 & 2048) != 0 ? match2.gameTime : str10, (i11 & 4096) != 0 ? match2.score : str11, (i11 & 8192) != 0 ? match2.gameStatus : str12, (i11 & 16384) != 0 ? match2.channelInfoList : arrayList);
    }

    public final boolean calcInFifteenMinutes() {
        String a10 = b.a("yyyy-MM-dd HH:mm");
        String b10 = b.b("yyyy-MM-dd HH:mm", 900000L);
        if (a10.compareTo(this.gameTime) >= 0 || b10.compareTo(this.gameTime) < 0) {
            return false;
        }
        return true;
    }

    public final boolean calcInTenMinutes() {
        String a10 = b.a("yyyy-MM-dd HH:mm");
        String b10 = b.b("yyyy-MM-dd HH:mm", 600000L);
        if (a10.compareTo(this.gameTime) >= 0 || b10.compareTo(this.gameTime) < 0) {
            return false;
        }
        return true;
    }

    public final boolean calcOutFifteenMinutes() {
        String a10 = b.a("yyyy-MM-dd HH:mm");
        String b10 = b.b("yyyy-MM-dd HH:mm", 900000L);
        if (a10.compareTo(this.gameTime) >= 0 || b10.compareTo(this.gameTime) >= 0) {
            return false;
        }
        return true;
    }

    public final boolean compareToGameTime() {
        if (b.a("yyyy-MM-dd HH:mm").compareTo(this.gameTime) < 0) {
            return true;
        }
        return false;
    }

    public final String component1() {
        return this.gameId;
    }

    public final String component10() {
        return this.playBackType;
    }

    public final String component11() {
        return this.playBackUrl;
    }

    public final String component12() {
        return this.gameTime;
    }

    public final String component13() {
        return this.score;
    }

    public final String component14() {
        return this.gameStatus;
    }

    public final ArrayList<MatchChannel> component15() {
        return this.channelInfoList;
    }

    public final Team component2() {
        return this.team_a;
    }

    public final Team component3() {
        return this.team_b;
    }

    public final String component4() {
        return this.matchId;
    }

    public final String component5() {
        return this.matchName;
    }

    public final String component6() {
        return this.matchAlias;
    }

    public final String component7() {
        return this.matchLogo;
    }

    public final String component8() {
        return this.channelName;
    }

    public final String component9() {
        return this.channelCode;
    }

    public final Match copy(String str, Team team, Team team2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, ArrayList<MatchChannel> arrayList) {
        String str13 = str;
        i.g(str13, "gameId");
        Team team3 = team;
        i.g(team3, "team_a");
        Team team4 = team2;
        i.g(team4, "team_b");
        String str14 = str2;
        i.g(str14, "matchId");
        String str15 = str3;
        i.g(str15, "matchName");
        String str16 = str4;
        i.g(str16, "matchAlias");
        String str17 = str6;
        i.g(str17, "channelName");
        String str18 = str7;
        i.g(str18, "channelCode");
        String str19 = str10;
        i.g(str19, "gameTime");
        String str20 = str11;
        i.g(str20, FirebaseAnalytics.Param.SCORE);
        String str21 = str12;
        i.g(str21, "gameStatus");
        return new Match(str13, team3, team4, str14, str15, str16, str5, str17, str18, str8, str9, str19, str20, str21, arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Match)) {
            return false;
        }
        Match match = (Match) obj;
        return i.b(this.gameId, match.gameId) && i.b(this.team_a, match.team_a) && i.b(this.team_b, match.team_b) && i.b(this.matchId, match.matchId) && i.b(this.matchName, match.matchName) && i.b(this.matchAlias, match.matchAlias) && i.b(this.matchLogo, match.matchLogo) && i.b(this.channelName, match.channelName) && i.b(this.channelCode, match.channelCode) && i.b(this.playBackType, match.playBackType) && i.b(this.playBackUrl, match.playBackUrl) && i.b(this.gameTime, match.gameTime) && i.b(this.score, match.score) && i.b(this.gameStatus, match.gameStatus) && i.b(this.channelInfoList, match.channelInfoList);
    }

    public final boolean findFirstChannel() {
        MatchChannel firstChannel = getFirstChannel();
        boolean z10 = false;
        if (firstChannel == null) {
            return false;
        }
        String channelCode2 = firstChannel.getChannelCode();
        if (channelCode2 == null || channelCode2.length() == 0) {
            z10 = true;
        }
        return !z10;
    }

    public final String getChannelCode() {
        return this.channelCode;
    }

    public final ArrayList<MatchChannel> getChannelInfoList() {
        return this.channelInfoList;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final MatchChannel getFirstChannel() {
        boolean z10;
        ArrayList<MatchChannel> arrayList = this.channelInfoList;
        if (arrayList == null || arrayList.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return null;
        }
        ArrayList<MatchChannel> arrayList2 = this.channelInfoList;
        i.d(arrayList2);
        return arrayList2.get(0);
    }

    public final String getGameId() {
        return this.gameId;
    }

    public final String getGameStatus() {
        return this.gameStatus;
    }

    public final String getGameTime() {
        return this.gameTime;
    }

    public final String getMatchAlias() {
        return this.matchAlias;
    }

    public final String getMatchId() {
        return this.matchId;
    }

    public final String getMatchLogo() {
        return this.matchLogo;
    }

    public final String getMatchName() {
        return this.matchName;
    }

    public final String getPlayBackType() {
        return this.playBackType;
    }

    public final String getPlayBackUrl() {
        return this.playBackUrl;
    }

    public final String getScore() {
        return this.score;
    }

    public final Team getTeam_a() {
        return this.team_a;
    }

    public final Team getTeam_b() {
        return this.team_b;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.gameId.hashCode() * 31) + this.team_a.hashCode()) * 31) + this.team_b.hashCode()) * 31) + this.matchId.hashCode()) * 31) + this.matchName.hashCode()) * 31) + this.matchAlias.hashCode()) * 31;
        String str = this.matchLogo;
        int i10 = 0;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.channelName.hashCode()) * 31) + this.channelCode.hashCode()) * 31;
        String str2 = this.playBackType;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.playBackUrl;
        int hashCode4 = (((((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.gameTime.hashCode()) * 31) + this.score.hashCode()) * 31) + this.gameStatus.hashCode()) * 31;
        ArrayList<MatchChannel> arrayList = this.channelInfoList;
        if (arrayList != null) {
            i10 = arrayList.hashCode();
        }
        return hashCode4 + i10;
    }

    public final boolean isGameEnd() {
        return i.b(this.gameStatus, "3");
    }

    public final boolean isGameOnGoing() {
        String a10 = b.a("yyyy-MM-dd HH:mm");
        if ((i.b(this.gameStatus, "2") || (i.b(this.gameStatus, "1") && a10.compareTo(this.gameTime) >= 0)) && !isGameOut()) {
            return true;
        }
        return false;
    }

    public final boolean isGameOut() {
        String b10 = b.b("yyyy-MM-dd HH:mm", -10800000L);
        String str = this.gameTime;
        i.f(b10, "inThreeHours");
        if (str.compareTo(b10) < 0) {
            return true;
        }
        return false;
    }

    public final boolean isGameReadied() {
        if (!i.b(this.gameStatus, "1") || !calcInFifteenMinutes()) {
            return false;
        }
        return true;
    }

    public final boolean isInTenMinutes() {
        return this.isInTenMinutes;
    }

    public final boolean isNotStarted() {
        if (!i.b(this.gameStatus, "1") || !compareToGameTime()) {
            return false;
        }
        return true;
    }

    public final boolean isSubscribe() {
        if (!i.b(this.gameStatus, "1") || !calcOutFifteenMinutes() || !findFirstChannel()) {
            return false;
        }
        return true;
    }

    public final boolean isSubscribeWithoutChannel() {
        if (!i.b(this.gameStatus, "1") || !calcOutFifteenMinutes()) {
            return false;
        }
        return true;
    }

    public final boolean isSubscribed() {
        return this.isSubscribed;
    }

    public final void setChannelCode(String str) {
        i.g(str, "<set-?>");
        this.channelCode = str;
    }

    public final void setChannelInfoList(ArrayList<MatchChannel> arrayList) {
        this.channelInfoList = arrayList;
    }

    public final void setChannelName(String str) {
        i.g(str, "<set-?>");
        this.channelName = str;
    }

    public final void setGameId(String str) {
        i.g(str, "<set-?>");
        this.gameId = str;
    }

    public final void setGameStatus(String str) {
        i.g(str, "<set-?>");
        this.gameStatus = str;
    }

    public final void setGameTime(String str) {
        i.g(str, "<set-?>");
        this.gameTime = str;
    }

    public final void setInTenMinutes(boolean z10) {
        this.isInTenMinutes = z10;
    }

    public final void setMatchAlias(String str) {
        i.g(str, "<set-?>");
        this.matchAlias = str;
    }

    public final void setMatchId(String str) {
        i.g(str, "<set-?>");
        this.matchId = str;
    }

    public final void setMatchLogo(String str) {
        this.matchLogo = str;
    }

    public final void setMatchName(String str) {
        i.g(str, "<set-?>");
        this.matchName = str;
    }

    public final void setPlayBackType(String str) {
        this.playBackType = str;
    }

    public final void setPlayBackUrl(String str) {
        this.playBackUrl = str;
    }

    public final void setScore(String str) {
        i.g(str, "<set-?>");
        this.score = str;
    }

    public final void setSubscribed(boolean z10) {
        this.isSubscribed = z10;
    }

    public final void setTeam_a(Team team) {
        i.g(team, "<set-?>");
        this.team_a = team;
    }

    public final void setTeam_b(Team team) {
        i.g(team, "<set-?>");
        this.team_b = team;
    }

    public String toString() {
        return "Match(gameId=" + this.gameId + ", team_a=" + this.team_a + ", team_b=" + this.team_b + ", matchId=" + this.matchId + ", matchName=" + this.matchName + ", matchAlias=" + this.matchAlias + ", matchLogo=" + this.matchLogo + ", channelName=" + this.channelName + ", channelCode=" + this.channelCode + ", playBackType=" + this.playBackType + ", playBackUrl=" + this.playBackUrl + ", gameTime=" + this.gameTime + ", score=" + this.score + ", gameStatus=" + this.gameStatus + ", channelInfoList=" + this.channelInfoList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Match(mobile.com.requestframe.utils.response.Team r18) {
        /*
            r17 = this;
            java.lang.String r0 = "team"
            r4 = r18
            t9.i.g(r4, r0)
            java.lang.String r2 = ""
            java.lang.String r5 = ""
            java.lang.String r6 = ""
            java.lang.String r7 = ""
            java.lang.String r8 = ""
            java.lang.String r9 = ""
            java.lang.String r10 = "0"
            java.lang.String r11 = ""
            java.lang.String r12 = ""
            java.lang.String r13 = ""
            java.lang.String r14 = ""
            java.lang.String r15 = ""
            java.util.ArrayList r16 = new java.util.ArrayList
            r16.<init>()
            r1 = r17
            r3 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: mobile.com.requestframe.utils.response.Match.<init>(mobile.com.requestframe.utils.response.Team):void");
    }
}
