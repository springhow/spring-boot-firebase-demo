package com.springhow.examples.springbootfcmdemo.controllers;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.springhow.examples.springbootfcmdemo.pojo.Note;
import com.springhow.examples.springbootfcmdemo.service.FirebaseMessagingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    private final FirebaseMessagingService firebaseService;

    public TestController(FirebaseMessagingService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @RequestMapping("/send-notification")
    @ResponseBody
    public String sendNotification(@RequestBody Note note,
                                   @RequestParam String topic) throws FirebaseMessagingException {
        return firebaseService.sendNotification(note, topic);
    }
}
