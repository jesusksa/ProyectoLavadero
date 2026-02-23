package com.lavadero.util;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class ServicioSMS {

    private static final String ACCOUNT_SID = "ACbd938248770fb67c1d984d241a3f986d";
    private static final String AUTH_TOKEN = "fe8f069ddf1d082a161da6fcab23a631";
    private static final String FROM_NUMBER = "+14475743417";

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
