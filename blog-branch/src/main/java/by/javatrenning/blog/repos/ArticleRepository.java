package by.javatrenning.blog.repos;

import by.javatrenning.blog.data.Article;
import by.javatrenning.blog.data.Tag;
import by.javatrenning.blog.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Article findById(int id);
    List<Article> findByUser(User user);
    List<Article> findByTags(Tag tag);
}
