package by.javatrenning.blog.services;

import by.javatrenning.blog.data.Article;
import by.javatrenning.blog.data.Comment;
import by.javatrenning.blog.repos.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service

public class CommentService {
    @Autowired
    CommentRepository commentRepo;


    public Iterable<Comment> getArticleComments(Article article)
    {
        return commentRepo.findByArticle(article);
    }

    public void deleteComments(Article article)
    {
        commentRepo.deleteAll(commentRepo.findByArticle(article));
    }

    public Iterable<Comment> addComment(Comment comment)
    {
        commentRepo.save(comment);
        return commentRepo.findAll();
    }
}
