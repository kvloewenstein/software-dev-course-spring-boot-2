package com.example.mycollections.controllers;

import com.example.mycollections.models.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")

public class MovieController {
    private final List<Movie> movies = new ArrayList<>() {{
        add(new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 142));
        add(new Movie("The Godfather", "Francis Ford Coppola", 1972, 175));
        add(new Movie("Inception", "Christopher Nolan", 2010, 148));
    }};

    @GetMapping("/json")
    public List<Movie> getMoviesJson() {
        return movies;
    }

    @GetMapping("/html")
    public String getMoviesHtml() {
        String movieList = "<ul>";
        for (Movie movie : movies) {
            movieList += "<li>" + movie + "</li>";
        }
        movieList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Movies</h1>
                        <ul>
                """ +
                movieList +
                """
                        </ul>
                    </body>
                </html>
                """;
    }
}
