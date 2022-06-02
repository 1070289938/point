package com.ruoyi.common.enums;

public enum AmountRecordEnum {

    INVITE_REWARDS(1,"邀请用户奖励"),

    INVITATION_CODE_REWARD(2,"邀请码奖励"),

    BUY_SONG(3,"购买歌曲"),

    SIGN(4,"QQ群签到奖励"),
    ;

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }

    private int type;
    private String content;

    AmountRecordEnum(int type, String content) {
        this.type = type;
        this.content = content;
    }


}
