package ws;

import classes.Game;
import com.google.gson.Gson;
import dao.GameDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("game")
public class GameResource 
{
    @Context
    private UriInfo context;

    public GameResource() { }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/selectgamebyid/{id}/")
    public String selectGameByID(@PathParam("id") int id)
    {        
        return new Gson().toJson(new GameDAO().selectGameByID(id));
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON+ ";charset=UTF-8")
    @Path("/selectgames/{pla}/{gen}/{dev}/")
    public String selectGames(@PathParam("pla") int idPlataforma, @PathParam("gen") int idGenero, @PathParam("dev") int idDesenvolvedor) 
    {
        return new Gson().toJson(new GameDAO().selectGames(idPlataforma, idGenero, idDesenvolvedor));
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON+ ";charset=UTF-8")
    @Path("/selectcountbyiddesenvolvedor/{dev}/{gen}/{pla}/")
    public String selectCountByIDDesenvolvedor(@PathParam("dev") int idDesenvolvedor, @PathParam("gen") int idGenero, @PathParam("pla") int idPlataforma) 
    {
        return "{\"count\":" + new GameDAO().selectCountByIDDesenvolvedor(idDesenvolvedor, idGenero, idPlataforma) + "}";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON+ ";charset=UTF-8")
    @Path("/selectcountbyidgenero/{gen}/{pla}/{dev}/")
    public String selectCountByIDGenero( @PathParam("gen") int idGenero, @PathParam("pla") int idPlataforma, @PathParam("dev") int idDesenvolvedor) 
    {
        return "{\"count\":" + new GameDAO().selectCountByIDGenero(idGenero, idPlataforma, idDesenvolvedor) + "}";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON+ ";charset=UTF-8")
    @Path("/selectcountbyidplataforma/{pla}/{gen}/{dev}/")
    public String selectCountByIDPlataforma(@PathParam("pla") int idPlataforma, @PathParam("gen") int idGenero, @PathParam("dev") int idDesenvolvedor) 
    {
        return "{\"count\":" + new GameDAO().selectCountByIDPlataforma(idPlataforma, idGenero, idDesenvolvedor)+ "}";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON+ ";charset=UTF-8")
    @Path("/pesquisargames/{termo}")
    public String pesquisarGames(@PathParam("termo") String termo)
    {        
        List<Game> games = new GameDAO().pesquisarGames(termo);
        
        return new Gson().toJson(games);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON+ ";charset=UTF-8")
    @Path("/selectgamesrandom/{qtde}")
    public String selectGamesRandom(@PathParam("qtde") int qtde)
    {        
        List<Game> games = new GameDAO().selectGames();
        Collections.shuffle(games);
        
        if (qtde > games.size()) 
        {
            games = games.subList(0, games.size());
        }
        else
        {
            games = games.subList(0, qtde);
        }
        
        return new Gson().toJson(games);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON+ ";charset=UTF-8")
    @Path("/selectrecomendacoes/{json}")
    public String selectRecomendacoes(@PathParam("json") String json)
    {   
        ArrayList<String> gameIds = new ArrayList<>();
        gameIds = new Gson().fromJson(json, gameIds.getClass());
        
        return new Gson().toJson(new GameDAO().selectRecomendacoes(gameIds));
    }
}
