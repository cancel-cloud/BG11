package de.lukas.aufgabe2;

import java.util.ArrayList;
import java.util.List;


public class RestaurantManager {

    public static void main(String[] args) {
        RestaurantManager manager = new RestaurantManager();

        RestaurantManager.Restaurant restaurant = manager.new Restaurant();
        RestaurantManager.Room room = new Room(false, 1);
        RestaurantManager.Table table = new Table(1, 4);

        room.addTable(table);
        restaurant.rooms.add(room);

        System.out.println("Das Restaurant " + restaurant.restaurantName + " hat " + restaurant.rooms.size() + " Räume.");
        System.out.println("Der Raum " + room.getNumber() + " hat " + room.getTables().size() + " Tische.");
        System.out.println("Der Tisch " + table.getNumber() + " hat " + table.getSeats() + " Sitzplätze.");
    }

    public class Restaurant {
        String restaurantName = "Hüftgold";
        List<Room> rooms = new ArrayList<>();
    }

    public static class Room {
        private boolean smoking;
        private int number;
        List<Table> tables = new ArrayList<>();

        public Room(boolean smoking, int number) {
            this.smoking = smoking;
            this.number = number;
        }

        public boolean isSmoking() {
            return smoking;
        }

        public int getNumber() {
            return number;
        }

        public List<Table> getTables() {
            return tables;
        }

        public void addTable(Table table) {
            this.tables.add(table);
        }

        public void removeTable(Table table) {
            this.tables.remove(table);
        }

    }

    public static class Table {
        private int number;
        private int seats;

        public Table(int number, int seats) {
            this.number = number;
            this.seats = seats;
        }

        public int getNumber() {
            return number;
        }

        public int getSeats() {
            return seats;
        }

        public void addSeatingMember() {
            this.seats++;
        }

        public void removeSeatMember() {
            this.seats--;
        }
    }

}
