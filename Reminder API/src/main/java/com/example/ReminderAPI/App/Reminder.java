package com.example.ReminderAPI.App;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reminder {

    @Id
    @GeneratedValue
    private Integer ReminderId;

    private String content;

    private String title;

    private boolean isNotified;

    private LocalDateTime dueDate;
}
