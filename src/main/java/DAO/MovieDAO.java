package DAO;

import com.mongodb.client.MongoCollection;
import model.Movie;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO extends  AbsDAO{
    public List<Movie> getMovies(int limit){
        MongoCollection<Document> movies = getMd().getCollection("movies");
        List<Movie> list = new ArrayList<>();
        movies.find().limit(limit).forEach(d-> list.add(docToMovie(d)));
        return  list;
    }
    public Movie docToMovie(Bson bson){
        Movie movie = new Movie();
        Document document = (Document) bson;
        movie.set_id(document.getObjectId("_id").toHexString());
        movie.setTitle(MessageFormat.format("{0}", document.get("title")));
        movie.setCast((List<String>) document.get("cast"));
        movie.setPlog(document.getString("plot"));
        movie.setFullPlot(document.getString("fullplot"));
        movie.setType(document.getString("type"));
        movie.setDirectors((List<String>) document.get("directors"));
        movie.setWriters((List<String>) document.get("writers"));
        movie.setCountries((List<String>) document.get("countries"));
        movie.setGenres((List<String>) document.get("genres"));
        movie.setPoster(document.getString("poster"));
        movie.setYear(document.getInteger("year"));
        return movie;
    }
}
