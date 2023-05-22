package org.acme.mail;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.smallrye.common.annotation.Blocking;
import org.acme.users.Users;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/mail")
public class MailResource {

    @Inject
    Mailer mailer;

//    @Inject
//    private RegistrationResource registrationResource;

    @POST
    @Blocking
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void sendEmail(Users user) {
        Mail mail = Mail.withText("tulitas1@gmail.com", "Hello", "This is the email body");
        System.out.println("send email " + mail.getFrom() + " " + user);
//        mapUserToDto(user);
//        registrationResource.update(user.getId(), user);
        mailer.send(mail);
    }

//    public RegistrationDTO mapUserToDto(Users user){
//        RegistrationDTO registrationDTO = new RegistrationDTO();
//        registrationDTO.setName(user.getName());
//        registrationDTO.setSurname(user.getSurname());
//        registrationDTO.setEmail(user.getEmail());
//        registrationDTO.setSelectedUser(user.isSelectedUser());
//    return registrationDTO;
//    }
}
