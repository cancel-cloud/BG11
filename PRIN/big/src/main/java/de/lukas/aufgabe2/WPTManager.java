package de.lukas.aufgabe2;

import java.util.ArrayList;

public class WPTManager {


    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        Room room1 = new Room(1, false);
        Table table1 = new Table(1, 6);
        Table table2 = new Table(2, 6);
        room1.addTable(table1);
        room1.addTable(table2);
        restaurant.addRoom(room1);

        Room room2 = new Room(2, true);
        Table table3 = new Table(3, 8);
        room2.addTable(table3);
        restaurant.addRoom(room2);

    }

    static class Table {
        private int noOfChairs;
        private int no;

        public Table(int no, int noOfChairs) {
            this.no = no;
            this.noOfChairs = noOfChairs;
        }

        public int getNoOfChairs() {
            return noOfChairs;
        }

        public int getNo() {
            return no;
        }
    }

    static class Room {
        private boolean isSmokingRoom;
        private int no;
        private ArrayList<Table> tables;

        public Room(int no, boolean isSmokingRoom) {
            this.no = no;
            this.isSmokingRoom = isSmokingRoom;
            this.tables = new ArrayList<>();
        }

        public boolean isSmokingRoom() {
            return isSmokingRoom;
        }

        public int getNo() {
            return no;
        }

        public void addTable(Table table) {
            tables.add(table);
        }

        public void deleteTable(Table table) {
            tables.remove(table);
        }

        public ArrayList<Table> getTables() {
            return tables;
        }
    }

    public static class Restaurant {
        private ArrayList<Room> rooms;

        public Restaurant() {
            rooms = new ArrayList<>();
        }

        public void addRoom(Room room) {
            rooms.add(room);
        }

        public void deleteRoom(Room room) {
            rooms.remove(room);
        }

        public ArrayList<Room> getRooms() {
            return rooms;
        }

        public void createTestObjects() {
            for (int i = 1; i <= 3; i++) {
                Room room = new Room(i, false);
                for (int j = 1; j <= 3; j++) {
                    Table table = new Table(j, 4);
                    room.addTable(table);
                }
                this.addRoom(room);
            }
        }

        public void listRoomsAndTables() {
            for (Room room : rooms) {
                System.out.println("Room: " + room.getNo());
                for (Table table : room.getTables()) {
                    System.out.println("Table: " + table.getNo() + " with " + table.getNoOfChairs() + " chairs.");
                }
            }
        }

        public void searchTable(int noOfChairs, boolean isSmokingRoom) {
            for (Room room : rooms) {
                if (room.isSmokingRoom() == isSmokingRoom) {
                    for (Table table : room.getTables()) {
                        if (table.getNoOfChairs() == noOfChairs) {
                            System.out.println("Room: " + room.getNo() + " Table: " + table.getNo());
                        }
                    }
                }
            }
        }
    }
}
