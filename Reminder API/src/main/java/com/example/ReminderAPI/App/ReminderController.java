package com.example.ReminderAPI.App;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reminders")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class ReminderController {
    private final ReminderService service;

    @PostMapping()
    public Reminder createNewReminder(@RequestBody Reminder reminder){
        return service.createNewReminder(reminder);
    }

    @GetMapping("/due")
    public List<Reminder> getDueReminders(){
        return service.getDueReminders();
    }
}
