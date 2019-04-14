package by.javatrenning.blog.services;

import by.javatrenning.blog.data.Article;
import by.javatrenning.blog.repos.ArticleRepository;
import by.javatrenning.blog.repos.CommentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
public class ArticleServiceTest {


    @TestConfiguration
    static class ServiceImplTestContextConfiguration {

        @Bean
        public ArticleService articleService() {
            return new ArticleService();
        }

        @Bean
        public CommentService commentService() {
            return new CommentService();
        }
    }

    @Autowired
    private ArticleService articleServ;

    @Autowired
    private CommentService commentServ;

    @MockBean
    private ArticleRepository articleRepo;

    @MockBean
    private CommentRepository commentRepo;

    @Test
    public void showArticles() {

    }

    @Test
    public void addArticle() {
        Article article = new Article();
        article.setId(111);
        articleServ.addArticle(article);
     //   articleRepo.save(article);
        assertEquals(article.getId(),
                articleRepo.
                        findById(article.getId()).
                        get().
                        getId());
    }

    @Test
    public void deleteArticle() {

    }

    @Before
    public void setUp() {
        Article article = new Article();
        article.setId(123);
        Mockito.when(articleRepo.findById(article.getId()))
                .thenReturn(java.util.Optional.of(article));
    }

    @Test
    public void getArticle() {
        Article article = new Article();
        article.setId(123);
        articleRepo.save(article);
        assertEquals(articleRepo.
                        findById(article.getId()).
                        get().getId(),
                articleServ.
                        getArticle(article.getId())
                        .getId());
    }

    @Test
    public void getUsersArticles() {

    }
}