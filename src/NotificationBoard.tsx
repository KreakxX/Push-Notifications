import { useEffect, useState } from "react";
import SockJS from "sockjs-client";
import { Client } from "@stomp/stompjs";
import { Reminder } from "./Reminder";

const NotificationBoard: React.FC = () => {
  useEffect(() => {
    const socket = new SockJS("http://localhost:8080/reminder");
    const client = new Client({
      webSocketFactory: () => socket,
      onConnect: () => {
        client.subscribe("/topic/reminders", (message) => {
          const newReminder = JSON.parse(message.body);
          new Notification(newReminder.title, {
            body: newReminder.content,
          });
        });
      },
    });

    client.activate();

    return () => {
      client.deactivate();
    };
  }, []);

  return <div>{}</div>;
};

export default NotificationBoard;
