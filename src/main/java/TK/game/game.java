package TK.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class game {
    static Random rd = new Random();
    public static int getRandomIntInRange(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Minimum cannot be higher than maximum");
        }
        return rd.nextInt((max - min) + 1) + min;
    }

    public static String getRandomListItem(List<String> list) {
        if (!(list instanceof List<String>)) {
            throw new IllegalArgumentException("Wrong list type");
        }
        return list.get(rd.nextInt(list.size()));
    }

    public static void createMap(){
        int totalAmountOfRooms = getRandomIntInRange(50, 100);
        while ((totalAmountOfRooms / 10) != 0) {
            totalAmountOfRooms += 1;
        }
        totalAmountOfRooms += 1; // game end room
        ArrayList<Objects> room = new ArrayList<>();
        int currentRoomNumber = 0;
    }
}
