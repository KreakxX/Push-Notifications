package com.example.ReminderAPI.App;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class WebsocketController {
    private  final SimpMessagingTemplate template;

    public void sendReminderNotification(Reminder reminder){
        template.convertAndSend("/topic/reminders",reminder);
    }

}
