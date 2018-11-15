package ws;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("thisgame")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ws.DesenvolvedorResource.class);
        resources.add(ws.GameResource.class);
        resources.add(ws.GeneroResource.class);
        resources.add(ws.PlataformaResource.class);
    }
    
}
