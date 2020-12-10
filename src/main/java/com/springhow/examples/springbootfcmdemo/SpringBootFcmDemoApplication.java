package com.springhow.examples.springbootfcmdemo;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class SpringBootFcmDemoApplication {

    @Bean
    FirebaseMessaging firebaseMessaging() throws IOException {
        GoogleCredentials googleCredentials = GoogleCredentials
                .fromStream(new ClassPathResource("firebase-service-account.json").getInputStream());
        FirebaseOptions firebaseOptions = FirebaseOptions
                .builder()
                .setCredentials(googleCredentials)
                .build();
        List<FirebaseApp> apps =  FirebaseApp.getApps();
        if (apps.size() < 1) {
            FirebaseApp app = FirebaseApp.initializeApp(firebaseOptions, "my-app");
            return FirebaseMessaging.getInstance(app);
        } else {
            return FirebaseMessaging.getInstance(apps.get(0));
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFcmDemoApplication.class, args);
    }

}
