package by.javatrenning.blog.services;

import by.javatrenning.blog.data.Article;
import by.javatrenning.blog.data.Comment;
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
public class CommentServiceTest {
    @TestConfiguration
    static class ServiceImplTestContextConfiguration {

        @Bean
        public CommentService commentService() {
            return new CommentService();
        }

    }



    @Autowired
    private CommentService commentServ;



    @MockBean
    private CommentRepository commentRepo;


    @Before
    public void setUp() {
        Comment comment = new Comment();
        comment.setId(123);
        Article article = new Article();
        article.setId(123);
        comment.setArticle(article);
       // comment.setArticle();
        Mockito.when(commentRepo.findById(comment.getId()))
                .thenReturn(java.util.Optional.of(comment));
    }

    @Test
    public void getArticleComments() {
      //  Iterable<Comment> comments = commentRepo
        Article article = new Article();
        article.setId(123);
        Comment comment = new Comment();
        comment.setId(123);
        assertEquals(comment,commentServ.getArticleComments(article));
    }

    @Test
    public void deleteComments() {
    }

    @Test
    public void addComment() {
    }
}