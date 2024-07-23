package com.service.posts.migow.migow_posts_service.infra.helpers;

import java.util.UUID;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.service.posts.migow.migow_posts_service.application.dtos.auth.CustomUserDetails;

public class SecurityUtils {
    public static UUID getAuthenticatedUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof CustomUserDetails customUserDetails) {
                return customUserDetails.getId();
            }
        }
        throw new RuntimeException("User not authenticated");
    }
}
