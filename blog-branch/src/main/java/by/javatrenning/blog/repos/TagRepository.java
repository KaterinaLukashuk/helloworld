package by.javatrenning.blog.repos;

import by.javatrenning.blog.data.Article;
import by.javatrenning.blog.data.Comment;
import by.javatrenning.blog.data.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {
    List<Tag> findByArticles(Article article);
    List<Tag> findByTagId(int id);
}
