import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Day01TeamMembers  {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> playersByTeams = new HashMap<>();

        try {
            File inputFile = new File("teams.txt");
            Scanner scanner = new Scanner(inputFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                String teamName = parts[0];
                String[] players = parts[1].split(",");

                for (String player : players) {
                    if (playersByTeams.containsKey(player)) {
                        playersByTeams.get(player).add(teamName);
                    } else {
                        ArrayList<String> teams = new ArrayList<>();
                        teams.add(teamName);
                        playersByTeams.put(player, teams);
                    }
                }
            }
            for (String player : playersByTeams.keySet()) {
                ArrayList<String> teams = playersByTeams.get(player);
                System.out.println(player + " plays in: " + String.join(", ", teams));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}


