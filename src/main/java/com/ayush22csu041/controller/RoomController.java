package com.ayush22csu041.controller;
//AyushSehrawat
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoomController {
    private List<Room> rooms = new ArrayList<>(Arrays.asList(
            new Room(1, "Standard", 20, 20),
            new Room(2, "Deluxe", 10, 10),
            new Room(3, "Suite", 5, 5),
            new Room(4, "ICU", 3, 3),
            new Room(5, "Emergency", 2, 2),
            new Room(6, "Maternity", 4, 4),
            new Room(7, "Pediatric", 6, 6)
    ));

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return rooms;
    }

    @GetMapping("/rooms/{room_id}")
    public Room getRoomById(@PathVariable int room_id) {
        return rooms.stream()
                .filter(room -> room.getRoom_id() == room_id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/rooms")
    public String createRoom(@RequestBody Room room) {
        rooms.add(room);
        return "Room added successfully";
    }

    @PutMapping("/rooms/{room_id}")
    public String updateRoom(@PathVariable int room_id, @RequestBody Room updatedRoom) {
        Room room = rooms.stream()
                .filter(r -> r.getRoom_id() == room_id)
                .findFirst()
                .orElse(null);

        if (room != null) {
            room.setType(updatedRoom.getType());
            room.setTotal_rooms(updatedRoom.getTotal_rooms());
            room.setAvailable_rooms(updatedRoom.getAvailable_rooms());
            return "Room updated successfully";
        } else {
            return "Room not found";
        }
    }

    @DeleteMapping("/rooms/{room_id}")
    public String deleteRoom(@PathVariable int room_id) {
        Room room = rooms.stream()
                .filter(r -> r.getRoom_id() == room_id)
                .findFirst()
                .orElse(null);

        if (room != null) {
            rooms.remove(room);
            return "Room deleted successfully";
        } else {
            return "Room not found";
        }
    }

    // Model class definition (assuming it's in the same package)
    public static class Room {
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
}


