package inlamningsuppgift;

import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;

@Path ("/climateservice")

public class Service {
    private static Dao databas = new Dao();
    
    @GET
    @Path("/data")
    @Produces(MediaType.APPLICATION_JSON)
    
    public List<Dag> hejsan() throws ClassNotFoundException{
    
        List<Dag> lista = databas.getAllMeasuringpoints();
        
        return lista;
    }
    
    public String getKompisarJson2() throws ClassNotFoundException{
       return "fdsfs";
    }
    
    
    @POST
    @Path("/data/add")
    public Response addDag(Dag b) throws SQLException, ClassNotFoundException {
        System.out.println("Hejs");
        Response res = new Response("Dag added", Boolean.FALSE);
        databas.addParameter(b);
        res.setStatus(Boolean.TRUE);
        return res;
    }
    
}
