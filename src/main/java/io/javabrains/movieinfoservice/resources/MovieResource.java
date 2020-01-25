package io.javabrains.movieinfoservice.resources;

import io.javabrains.movieinfoservice.models.Movie;
import io.javabrains.movieinfoservice.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {

        //MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" +  apiKey, MovieSummary.class);
        //return new Movie(id, movieSummary.getTitle(), movieSummary.getOverview());

        return getMovieByID(movieId);
    }


    private Movie getMovieByID(String id){
        //return new Movie(movieId, "Test name", "Test Movie Description");
        Movie movie = new Movie("0","Transformers","Transformers description");
        Movie movie1 = new Movie("1","Transformers 1","Transformers description 1");
        Movie movie2 = new Movie("2","Transformers 2","Transformers description 2");
        Movie movie3 = new Movie("3","Transformers 3","Transformers description 3");

        MovieSummary movieSummary = new MovieSummary();
        movieSummary.setTitle(movie.getName());
        movieSummary.setOverview(movie.getDescription());

        MovieSummary movieSummary1 = new MovieSummary();
        movieSummary1.setTitle(movie1.getName());
        movieSummary1.setOverview(movie1.getDescription());

        MovieSummary movieSummary2 = new MovieSummary();
        movieSummary2.setTitle(movie2.getName());
        movieSummary2.setOverview(movie2.getDescription());

        MovieSummary movieSummary3 = new MovieSummary();
        movieSummary3.setTitle(movie3.getName());
        movieSummary3.setOverview(movie3.getDescription());

        switch (id){
            case "0":
                return new Movie(id, movieSummary.getTitle(), movieSummary.getOverview());
            case "1":
                return new Movie(id, movieSummary1.getTitle(), movieSummary1.getOverview());
            case "2":
                return new Movie(id, movieSummary2.getTitle(), movieSummary2.getOverview());
            case "3":
                return new Movie(id, movieSummary3.getTitle(), movieSummary3.getOverview());
            default:
                return new Movie(id, "Title Not Found", "Summary Not Found");
        }
    }

}
