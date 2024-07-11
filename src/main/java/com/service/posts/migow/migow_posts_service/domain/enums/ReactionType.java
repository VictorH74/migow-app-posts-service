package com.service.posts.migow.migow_posts_service.domain.enums;

public enum ReactionType {
    LIKE(1), FUNNY(2), LOVE(3), SAD(4), CUTE(5), SCARY(6);

    private final int code;

    private ReactionType(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static ReactionType valueOf(int code) {
        for (ReactionType value : ReactionType.values()) {
            if (value.getCode() == code)
                return value;
        }
        throw new IllegalArgumentException("Invalid ReactionType code!");
    }
}
