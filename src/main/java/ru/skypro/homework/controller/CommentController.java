package ru.skypro.homework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.Comments;
import ru.skypro.homework.dto.CreateOrUpdateComment;
import ru.skypro.homework.service.CommentService;

@RestController
@RequestMapping("/ads")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{id}/comments")
    public Comments getCommentsByAdId(@PathVariable int id) {
        return new Comments();
    }

    @PostMapping("/{id}/comments")
    public CreateOrUpdateComment addCommentByAdId(@PathVariable int id) {
        return new CreateOrUpdateComment();
    }

    @DeleteMapping("/ads/{adId}/comments/{commentId}")
    public ResponseEntity<?> deleteCommentByAdId(@PathVariable int adId, @PathVariable int commentId) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/ads/{adId}/comments/{commentId}")
    public CreateOrUpdateComment updateCommentByAdId(@PathVariable int adId, @PathVariable int commentId) {
        return new CreateOrUpdateComment();
    }
}
