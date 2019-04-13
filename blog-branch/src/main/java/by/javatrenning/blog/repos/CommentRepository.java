package by.javatrenning.blog.repos;

import by.javatrenning.blog.data.Article;
import by.javatrenning.blog.data.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
    List<Comment> findByArticle(Article article);
}
