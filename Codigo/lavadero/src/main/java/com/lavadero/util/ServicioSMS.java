package com.lavadero.util;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class ServicioSMS {

    private static final String ACCOUNT_SID = "TU_ACCOUNT_SID";
    private static final String AUTH_TOKEN = "TU_AUTH_TOKEN";
    private static final String FROM_NUMBER = "THE_NUMBER";

    public void enviarSMS(String numeroDestino, String mensaje) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                new PhoneNumber(numeroDestino),
                new PhoneNumber(FROM_NUMBER),
                mensaje
        ).create();

        System.out.println("SMS enviado con SID: " + message.getSid());
    }
}
