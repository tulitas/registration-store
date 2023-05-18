package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@ApplicationScoped
@Path("/registration/all")
public class UsersResource {
    private static final Logger LOG = LoggerFactory.getLogger(UsersResource.class);

    @Inject
    RegistrationService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RegistrationEntity> getUsers() {
        LOG.debug("HELLLO");
        return service.getAllRegistrations();
    }
}
