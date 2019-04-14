package by.javatrenning.blog.services;

import by.javatrenning.blog.data.Article;
import by.javatrenning.blog.data.User;
import by.javatrenning.blog.repos.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepo;

    @Autowired
    CommentService commentServ;


    public ArticleService() {
    }



    public Iterable<Article> showArticles()
    {
        return articleRepo.findAll();
    }

    public Iterable<Article> addArticle(Article article)
    {
        articleRepo.save(article);
        return articleRepo.findAll();
    }

    public Iterable<Article> deleteArticle(Article article)
    {
        commentServ.deleteComments(article);
        articleRepo.delete(article);
        return articleRepo.findAll();
    }

    public Article getArticle(int id)
    {
        Article article = articleRepo.findById(id);;
        return article;
    }

    public Iterable<Article> getUsersArticles(User user)
    {
        return articleRepo.findByUser(user);
    }
}
