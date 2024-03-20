package com.saddam.mockito.test_double.dummy;

public class DummyEmailService implements EmailService{


    @Override
    public void sendEmail(String message) {
        throw new AssertionError("method not implemented...");
    }
}
