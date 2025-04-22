package com.ayush22csu041.model;
//AyushSehrawat
public class Room {
    private int room_id;
    private String type;
    private int total_rooms;
    private int available_rooms;

    public Room() {
    }

    public Room(int room_id, String type, int total_rooms, int available_rooms) {
        this.room_id = room_id;
        this.type = type;
        this.total_rooms = total_rooms;
        this.available_rooms = available_rooms;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public int getTotal_rooms() {
        return total_rooms;
    }
    public void setTotal_rooms(int total_rooms) {
        this.total_rooms = total_rooms;
    }
    public int getAvailable_rooms() {
        return available_rooms;
    }
    public void setAvailable_rooms(int available_rooms) {
        this.available_rooms = available_rooms;
    }
}


