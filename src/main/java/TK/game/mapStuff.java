package TK.game;

import TK.game.EntityStuff.AlienStuff.Alien;
import TK.game.EntityStuff.Entity;

import java.util.*;
import java.util.ArrayList;

import static TK.game.EntityStuff.AlienStuff.AlienFactory.createEnemy;

public class mapStuff {

    public class MapGenerator {

        static List<String> enemyOptions = Arrays.asList("Grunt", "Breacher", "Striker", "Marksman", "Heavy", "Wolve");
        static Random rd = new Random();

        public static List<Object> createMap(Map<Integer, List<Object>> scriptedLevels, int numberOfRooms) {
            List<Object> theMap = new ArrayList<>();

            for (int i = 1; i < numberOfRooms; i++) {
                if (scriptedLevels.containsKey(i)) {
                    theMap.add(scriptedLevels.get(i));
                } else {
                    int numberOfEnemies = calculateNumberOfEnemies(i);
                    List<Alien> pod = generateEnemyPod(numberOfEnemies, enemyOptions, i);
                    theMap.add(pod);
                }
            }

            return theMap;
        }

        public static int calculateNumberOfEnemies(int roomIndex) {
            // More enemies per room the further along the player progresses
            int baseNumberOfEnemies = 3;
            int variability = rd.nextInt(2 + roomIndex / 10 + 3) - 2;
            return baseNumberOfEnemies + variability;
        }

        public static List<Alien> generateEnemyPod(int numberOfEnemies, List<String> enemyOptions, int roomIndex) {
            List<Alien> pod = new ArrayList<>();
            for (int i = 0; i < numberOfEnemies; i++) {
                String species = selectEnemyType(enemyOptions, roomIndex);
                int selectedRank = selectEnemyRank(species, roomIndex);
                Entity enemy = createEnemy(i, roomIndex, species, selectedRank, 10); // Example HP
                pod.add(enemy);
            }
            return pod;
        }

        public static String selectEnemyType(List<String> enemyOptions, int roomIndex) {
            if (roomIndex < 3) {
                return enemyOptions.get(0);
            } else if (roomIndex >= 3 && roomIndex < 10) {
                return enemyOptions.get(rd.nextInt(2));
            } else if (roomIndex >= 10 && roomIndex < 20) {
                return enemyOptions.get(rd.nextInt(enemyOptions.size()));
            } else {
                return enemyOptions.get(rd.nextInt(enemyOptions.size() - 2) + 2);
            }
        }

        public static int selectEnemyRank(String species, int roomIndex) {
            // Implement your rank selection logic here
            return (int) (Math.random() * 8) + 1; // Example logic
        }


        public static void main(String[] args) {
            Map<Integer, List<Object>> scriptedLevels = new HashMap<>();
            scriptedLevels.put(1, Arrays.asList(createEnemy(1, 1, "Grunt", 1, 10)));
            scriptedLevels.put(2, Arrays.asList(createEnemy(1, 2, "Grunt", 1, 10), createEnemy(1, 2, "Grunt", 1, 10)));
            scriptedLevels.put(3, Arrays.asList(createEnemy(1, 3, "Grunt", 1, 10), createEnemy(1, 3, "Grunt", 2, 10)));
            scriptedLevels.put(5, Arrays.asList("Drop Zone"));
            scriptedLevels.put(9, Arrays.asList("Drop Zone"));
            scriptedLevels.put(10, Arrays.asList(createEnemy(1, 20, "Wolve", 8, 20)));
            scriptedLevels.put(15, Arrays.asList("Drop Zone"));
            scriptedLevels.put(19, Arrays.asList("Drop Zone"));
            scriptedLevels.put(20, Arrays.asList(createEnemy(1, 20, "Wolve", 8, 20)));
            scriptedLevels.put(25, Arrays.asList("Drop Zone"));
            scriptedLevels.put(29, Arrays.asList("Drop Zone"));
            scriptedLevels.put(30, Arrays.asList(createEnemy(1, 30, "Wolve", 8, 50)));
            scriptedLevels.put(35, Arrays.asList("Drop Zone"));
            scriptedLevels.put(39, Arrays.asList("Drop Zone"));
            scriptedLevels.put(40, Arrays.asList(createEnemy(1, 40, "Wolve", 8, 35), createEnemy(1, 40, "Wolve", 8, 35)));
            scriptedLevels.put(45, Arrays.asList("Drop Zone"));
            scriptedLevels.put(49, Arrays.asList("Drop Zone"));
            scriptedLevels.put(50, Arrays.asList(createEnemy(1, 50, "Wolve", 8, 500)));  // Final Boss

            int numberOfRooms = 51;  // Example number of rooms
            List<Object> room = createMap(scriptedLevels, numberOfRooms);

            // Print the map or work with it as needed
            System.out.println(room);
        }
    }

}
