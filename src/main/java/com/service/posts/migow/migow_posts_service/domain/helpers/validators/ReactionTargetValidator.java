package com.service.posts.migow.migow_posts_service.domain.helpers.validators;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReactionTargetValidator {
    private static final String PATTERN = "^(post_|comment_|reply_comment_)([0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12})$";

    public static boolean validateString(String target) {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(target);

        if (!matcher.matches()) {
            return false;
        }

        // Extract the UUID part from the matched target
        String uuidPart = matcher.group(2);

        // Validate the extracted UUID
        try {
            UUID.fromString(uuidPart);
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }

    public static String generateTarget(UUID targetId, String targetClass) {
        String target = targetClass + targetId;
        if (validateString(target))
            return target;

        throw new IllegalArgumentException("Invalid target class!: " + target);
    }
}
