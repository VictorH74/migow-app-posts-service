package com.service.posts.migow.migow_posts_service.domain.enums;

public enum ReactionTargetType {
    POST(1),
    COMMENT(2),
    REPLY_COMMENT(3);

    private final int code;

    private ReactionTargetType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ReactionTargetType valueOf(int code) {
        for (ReactionTargetType value : ReactionTargetType.values()) {
            if (value.getCode() == code) {
                return value;

            }
        }
        throw new IllegalArgumentException("Invalid ReactionTargetType code!");
    }

}
