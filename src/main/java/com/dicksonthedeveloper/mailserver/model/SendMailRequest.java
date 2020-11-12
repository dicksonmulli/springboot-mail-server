package com.dicksonthedeveloper.mailserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendMailRequest {
    private String senderName;
    private String senderEmail;
    private String subject;
    private String message;
}
