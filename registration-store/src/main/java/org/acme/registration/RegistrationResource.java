package org.acme.registration;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Path("/registration")
public class RegistrationResource {
    private static final Logger LOG = LoggerFactory.getLogger(RegistrationResource.class);
    @Inject
    RegistrationService registrationService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void register(@Valid @NotNull RegistrationDTO registration) {
        var name = registration.name();
        var surname = registration.surname();
        var email = registration.email();

        LOG.debug("registration for {}", name);
        LOG.debug("registration for {}", surname);
        LOG.debug("registration for {}", email);

        registrationService.register(registration.name(), registration.surname(), registration.email());
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<RegistrationEntity> getUsers() {
         return registrationService.getAllRegistrations();
    }
}
