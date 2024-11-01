import axios from "axios";
import { Reminder } from "./Reminder";

const api = axios.create({
  baseURL: 'http://localhost:8080/api/v1/Reminder',
});

export const createNewReminder = async(reminder: Reminder) =>{
  try{
    const API_Response = await api.post("/new",reminder)
    return API_Response.data;
  }catch(error){
    console.log(error);
    throw error;
  }
}

export const getAllDueReminders = async() =>{
  try{
    const API_Response = await api.get("/get/due/Reminders")
    return API_Response.data;
  }catch(error){
    console.log(error);
    throw error;
  }
}

export const updateNotificationStauts = async(reminderId : number)=>{
try{
  const API_Response = await api.put(`/update/notificationStatus/${reminderId}`)
  return API_Response.data;
}catch(error){
  console.log(error);
  throw error;
}
}
