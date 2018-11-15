package ws;

import classes.Genero;
import com.google.gson.Gson;
import dao.GeneroDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("genero")
public class GeneroResource {

    @Context
    private UriInfo context;

    public GeneroResource() { }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/selectgenerobyid/{id}")
    public String selectGeneroByID(@PathParam("id") int id)
    { 
        Genero g = new GeneroDAO().selectGeneroByID(id);
        
        return new Gson().toJson(g);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/selectgeneros")
    public String selectGeneros() 
    {
        List<Genero> generos = new GeneroDAO().selectGeneros();
        
        return new Gson().toJson(generos);
    }   
}
