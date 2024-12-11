package io.arrogantprogrammer.thanksgivingai.ai.tools;

import dev.langchain4j.agent.tool.Tool;
import io.arrogantprogrammer.thanksgivingai.api.ThanksgivingInvitation;
import io.quarkus.logging.Log;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class EmailTool {

    @Inject
    Mailer mailer;

    private static final String EMAIL_SUBJECT = "Join me for Thanksgiving!";

    @Tool("send the given content by email")
    public void sendAnEmail(ThanksgivingInvitation content) {
        Log.debugf("Sending an email: %s", content);
        mailer.send(
                Mail
                .withText(content.thanksgivingMenuRecord().email(), EMAIL_SUBJECT, content.thanksgivingMenuRecord().toString())
                .setFrom("jeremy.davis@redhat.com"));
//                        .addAttachment(content.url()));
        Log.debugf("Email sent");
    }
}
