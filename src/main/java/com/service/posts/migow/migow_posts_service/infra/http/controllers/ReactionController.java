package com.service.posts.migow.migow_posts_service.infra.http.controllers;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.posts.migow.migow_posts_service.application.dtos.DateRangeFilter;
import com.service.posts.migow.migow_posts_service.application.dtos.reactions.CreateUpdateReactionDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reactions.SimpleReactionDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.users.SimpleUserDTO;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.CreateUpdateReactionUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.DeleteReactionByIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.GetAllTargetReactionUserByReactionTypeUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.GetAllTargetReactionUserUseCase;
import com.service.posts.migow.migow_posts_service.infra.helpers.SecurityUtils;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("reactions")
@AllArgsConstructor
public class ReactionController {

    private final GetAllTargetReactionUserUseCase getAllTargetReactionUserUseCase;
    private final GetAllTargetReactionUserByReactionTypeUseCase getAllTargetReactionUserByReactionTypeUseCase;
    private final CreateUpdateReactionUseCase createReactionUseCase;
    private final DeleteReactionByIdUseCase deleteReactionByIdUseCase;

    @GetMapping("/with-target/{target}")
    public Page<SimpleUserDTO> getReactionUsersByUsernamePrefix(
            @PathVariable String target,
            @RequestParam(name = "usernamePrefix", defaultValue = "") String usernamePrefix,
            @RequestParam(name = "startDate", defaultValue = "") String startDate,
            @RequestParam(name = "endDate", defaultValue = "") String endDate,
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {

        Pageable p = PageRequest.of(pageNumber, pageSize);
        DateRangeFilter dateRangeFilter = DateRangeFilter.of(startDate, endDate);
        return getAllTargetReactionUserUseCase.execute(target, usernamePrefix, dateRangeFilter, p);
    }

    @GetMapping("/with-target/{target}/by-reaction-type/{reactionTypeCode}")
    public Page<SimpleUserDTO> getReactionUsersByUsernamePrefixAndReactionT(
            @PathVariable String target,
            @PathVariable int reactionTypeCode,
            @RequestParam(name = "usernamePrefix", defaultValue = "") String usernamePrefix,
            @RequestParam(name = "startDate", defaultValue = "") String startDate,
            @RequestParam(name = "endDate", defaultValue = "") String endDate,
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {

        Pageable p = PageRequest.of(pageNumber, pageSize);
        DateRangeFilter dateRangeFilter = DateRangeFilter.of(startDate, endDate);
        return getAllTargetReactionUserByReactionTypeUseCase.execute(target, usernamePrefix, reactionTypeCode, dateRangeFilter, p);
    }

    @PostMapping
    public SimpleReactionDTO createUpdateReaction(@RequestBody CreateUpdateReactionDTO obj) {
        UUID userId = SecurityUtils.getAuthenticatedUserId();
        obj.setOwnerId(userId);
        // TODO: provide created entity to kafka  
        return createReactionUseCase.execute(obj);
    }
    

    @DeleteMapping("/{reactionId}")
    public ResponseEntity<String> deleteReaction(@PathVariable UUID reactionId) {
        // TODO: provide created entity to kafka
        deleteReactionByIdUseCase.execute(reactionId);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Reaction with id '%s' deleted!", reactionId));
    } 

}
