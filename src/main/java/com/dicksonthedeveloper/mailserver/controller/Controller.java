package com.dicksonthedeveloper.mailserver.controller;

import com.dicksonthedeveloper.mailserver.model.SendMailRequest;
import com.dicksonthedeveloper.mailserver.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("mail")
@RestController
public class Controller {
    private MailService mailService;

    @Autowired
    public Controller(MailService mailService) {
        this.mailService = mailService;
    }


    @PostMapping("/send")
    public String sendEmail(@RequestBody SendMailRequest sendMailRequest) {

        mailService.sendEmail(sendMailRequest);
        return "Email sent successfully";
    }
}
