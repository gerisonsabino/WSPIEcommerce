package ws;

import classes.Desenvolvedor;
import com.google.gson.Gson;
import dao.DesenvolvedorDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("desenvolvedor")
public class DesenvolvedorResource {

    @Context
    private UriInfo context;

    public DesenvolvedorResource() { }

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/selectdesenvolvedorbyid/{id}")
    public String selectDesenvolvedorByID(@PathParam("id") int id)
    { 
        Desenvolvedor d = new DesenvolvedorDAO().selectDesenvolvedorByID(id);
        
        return new Gson().toJson(d);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/selectdesenvolvedores")
    public String selectDesenvolvedores() 
    {
        List<Desenvolvedor> desenvolvedores = new DesenvolvedorDAO().selectDesenvolvedores();
        
        return new Gson().toJson(desenvolvedores);
    }       
}
