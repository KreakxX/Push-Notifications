package com.example.ReminderAPI.App;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ReminderService {
    private final ReminderRepository repository;
    private final WebsocketController controller;


    public Reminder createNewReminder(Reminder reminder) {
        reminder.setNotified(false);
        Reminder saveReminder = repository.save(reminder);
        controller.sendReminderNotification(saveReminder);
        return saveReminder;
    }

}
