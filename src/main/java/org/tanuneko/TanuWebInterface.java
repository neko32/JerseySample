package org.tanuneko;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by neko32 on 2016/02/16.
 */
@Service
@Path("/beanmgr")
public class TanuWebInterface {

    private final BeanMgr mgr;

    @Inject
    public TanuWebInterface(BeanMgr mgr){
        this.mgr = mgr;
    }

    @GET
    @Path("/tanubean/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TanuBean getTanuBean(@PathParam("id") int id) {
        return mgr.get(id).orElse(new TanuBean(-1, "None"));
    }

}
