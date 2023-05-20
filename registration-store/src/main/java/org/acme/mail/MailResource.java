package org.acme.mail;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.smallrye.common.annotation.Blocking;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/mail")
public class MailResource {

    @Inject Mailer mailer;

    @POST
    @Blocking
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void sendEmail() {
        Mail mail = Mail.withText("tulitas1@gmail.com", "Hello", "This is the email body");
        System.out.println("send email " + mail.getFrom());

        mailer.send(mail);
    }

}
