package ws;

import classes.Plataforma;
import com.google.gson.Gson;
import dao.PlataformaDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("plataforma")
public class PlataformaResource {

    @Context
    private UriInfo context;

    public PlataformaResource() { }

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/selectplataformabyid/{id}")
    public String selectPlataformaByID(@PathParam("id") int id)
    { 
        Plataforma p = new PlataformaDAO().selectPlataformaByID(id);
        
        return new Gson().toJson(p);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/selectplataformas")
    public String selectPlataformas() 
    {
        List<Plataforma> plataformas = new PlataformaDAO().selectPlataformas();
        
        return new Gson().toJson(plataformas);
    }
}
