package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

public final class TeamStat {
    private String cornerKicks;
    private String fouls;
    private String offsides;
    private String possession;
    private String redCards;
    private String saveS;
    private String shotCount;
    private String targetCount;
    private String yellowCards;

    public TeamStat(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        i.g(str, "fouls");
        i.g(str2, "yellowCards");
        i.g(str3, "redCards");
        i.g(str4, "offsides");
        i.g(str5, "cornerKicks");
        i.g(str6, "saveS");
        i.g(str7, "possession");
        i.g(str8, "shotCount");
        i.g(str9, "targetCount");
        this.fouls = str;
        this.yellowCards = str2;
        this.redCards = str3;
        this.offsides = str4;
        this.cornerKicks = str5;
        this.saveS = str6;
        this.possession = str7;
        this.shotCount = str8;
        this.targetCount = str9;
    }

    public static /* synthetic */ TeamStat copy$default(TeamStat teamStat, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i10, Object obj) {
        TeamStat teamStat2 = teamStat;
        int i11 = i10;
        return teamStat.copy((i11 & 1) != 0 ? teamStat2.fouls : str, (i11 & 2) != 0 ? teamStat2.yellowCards : str2, (i11 & 4) != 0 ? teamStat2.redCards : str3, (i11 & 8) != 0 ? teamStat2.offsides : str4, (i11 & 16) != 0 ? teamStat2.cornerKicks : str5, (i11 & 32) != 0 ? teamStat2.saveS : str6, (i11 & 64) != 0 ? teamStat2.possession : str7, (i11 & 128) != 0 ? teamStat2.shotCount : str8, (i11 & 256) != 0 ? teamStat2.targetCount : str9);
    }

    public final String component1() {
        return this.fouls;
    }

    public final String component2() {
        return this.yellowCards;
    }

    public final String component3() {
        return this.redCards;
    }

    public final String component4() {
        return this.offsides;
    }

    public final String component5() {
        return this.cornerKicks;
    }

    public final String component6() {
        return this.saveS;
    }

    public final String component7() {
        return this.possession;
    }

    public final String component8() {
        return this.shotCount;
    }

    public final String component9() {
        return this.targetCount;
    }

    public final TeamStat copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        i.g(str, "fouls");
        i.g(str2, "yellowCards");
        i.g(str3, "redCards");
        i.g(str4, "offsides");
        String str10 = str5;
        i.g(str10, "cornerKicks");
        String str11 = str6;
        i.g(str11, "saveS");
        String str12 = str7;
        i.g(str12, "possession");
        String str13 = str8;
        i.g(str13, "shotCount");
        String str14 = str9;
        i.g(str14, "targetCount");
        return new TeamStat(str, str2, str3, str4, str10, str11, str12, str13, str14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TeamStat)) {
            return false;
        }
        TeamStat teamStat = (TeamStat) obj;
        return i.b(this.fouls, teamStat.fouls) && i.b(this.yellowCards, teamStat.yellowCards) && i.b(this.redCards, teamStat.redCards) && i.b(this.offsides, teamStat.offsides) && i.b(this.cornerKicks, teamStat.cornerKicks) && i.b(this.saveS, teamStat.saveS) && i.b(this.possession, teamStat.possession) && i.b(this.shotCount, teamStat.shotCount) && i.b(this.targetCount, teamStat.targetCount);
    }

    public final String getCornerKicks() {
        return this.cornerKicks;
    }

    public final String getFouls() {
        return this.fouls;
    }

    public final String getOffsides() {
        return this.offsides;
    }

    public final String getPossession() {
        return this.possession;
    }

    public final String getRedCards() {
        return this.redCards;
    }

    public final String getSaveS() {
        return this.saveS;
    }

    public final String getShotCount() {
        return this.shotCount;
    }

    public final String getTargetCount() {
        return this.targetCount;
    }

    public final String getYellowCards() {
        return this.yellowCards;
    }

    public int hashCode() {
        return (((((((((((((((this.fouls.hashCode() * 31) + this.yellowCards.hashCode()) * 31) + this.redCards.hashCode()) * 31) + this.offsides.hashCode()) * 31) + this.cornerKicks.hashCode()) * 31) + this.saveS.hashCode()) * 31) + this.possession.hashCode()) * 31) + this.shotCount.hashCode()) * 31) + this.targetCount.hashCode();
    }

    public final void setCornerKicks(String str) {
        i.g(str, "<set-?>");
        this.cornerKicks = str;
    }

    public final void setFouls(String str) {
        i.g(str, "<set-?>");
        this.fouls = str;
    }

    public final void setOffsides(String str) {
        i.g(str, "<set-?>");
        this.offsides = str;
    }

    public final void setPossession(String str) {
        i.g(str, "<set-?>");
        this.possession = str;
    }

    public final void setRedCards(String str) {
        i.g(str, "<set-?>");
        this.redCards = str;
    }

    public final void setSaveS(String str) {
        i.g(str, "<set-?>");
        this.saveS = str;
    }

    public final void setShotCount(String str) {
        i.g(str, "<set-?>");
        this.shotCount = str;
    }

    public final void setTargetCount(String str) {
        i.g(str, "<set-?>");
        this.targetCount = str;
    }

    public final void setYellowCards(String str) {
        i.g(str, "<set-?>");
        this.yellowCards = str;
    }

    public String toString() {
        return "TeamStat(fouls=" + this.fouls + ", yellowCards=" + this.yellowCards + ", redCards=" + this.redCards + ", offsides=" + this.offsides + ", cornerKicks=" + this.cornerKicks + ", saveS=" + this.saveS + ", possession=" + this.possession + ", shotCount=" + this.shotCount + ", targetCount=" + this.targetCount + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
