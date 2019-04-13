package by.javatrenning.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.SQLException;


@SpringBootApplication
public class Application {
    public static void main(String[] args) throws IOException, SQLException {
     SpringApplication.run(Application.class, args);
    }

}