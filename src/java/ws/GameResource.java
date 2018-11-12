package ws;

import classes.Game;
import com.google.gson.Gson;
import dao.GameDAO;
import java.util.ArrayList;
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
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/selectgames/{plataforma}/{genero}/{desenvolvedor}")
    public String selectGames(@PathParam("plataforma") int plataforma, @PathParam("genero") int genero, @PathParam("desenvolvedor") int desenvolvedor)
    {        
        ArrayList<Game> games = new GameDAO().selectGames(plataforma, genero, desenvolvedor);
        
        return new Gson().toJson(games);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/selectgamebyid/{id}/")
    public String selectGameByID(@PathParam("id") int id)
    {        
        return new Gson().toJson(new GameDAO().selectGameByID(id));
    }
}
