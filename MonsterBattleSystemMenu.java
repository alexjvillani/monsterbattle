import java.util.Scanner;

public class MonsterBattleSystemMenu {

    public static void main(String[] args) throws Exception {
        MonsterBattleSystem system = new MonsterBattleSystem();
        Scanner scanner = new Scanner(System.in);

        String option;
        do {
            displayMenu();
            System.out.print("Please enter an option (1-8 or X): ");
            option = scanner.nextLine().toUpperCase();

            switch (option) {
                case "1":
                    addMonsterSpecies(system, scanner);
                    break;
                case "2":
                    registerPlayer(system, scanner);
                    break;
                case "3":
                    recruitMonsterToPlayer(system, scanner);
                    break;
                case "4":
                    displayPlayerInfo(system, scanner);
                    break;
                case "5":
                    displayAllData(system);
                    break;
                case "6":
                    system.saveData();
                    System.out.println("Data saved.");
                    break;
                case "7":
                    system.loadData();
                    System.out.println("Data loaded.");
                    break;
                case "8":
                    battleBetweenTwoPlayers(system, scanner);
                    break;
                case "X":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (!option.equals("X"));

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("=======================");
        System.out.println("Monster Battle Quest");
        System.out.println("=======================");
        System.out.println("1. Add Monster Species");
        System.out.println("2. Register Player");
        System.out.println("3. Recruit Monster to Player");
        System.out.println("4. Display Player Info");
        System.out.println("5. Display All Data");
        System.out.println("6. Save Data");
        System.out.println("7. Load Data");
        System.out.println("8. Battle Between Two Players");
        System.out.println("X. Exit");
    }

    private static void addMonsterSpecies(MonsterBattleSystem system, Scanner scanner) {
        System.out.print("Enter species code: ");
        String code = scanner.nextLine();
        System.out.print("Enter species name: ");
        String name = scanner.nextLine();
        System.out.print("Enter species type (Fire, Water, Grass): ");
        String type = scanner.nextLine();
        System.out.print("Enter base HP: ");
        int baseHP = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter base attack: ");
        int baseAttack = Integer.parseInt(scanner.nextLine());

        system.addSpecies(code, name, type, baseHP, baseAttack);
        System.out.println("Species added.");
    }

    private static void registerPlayer(MonsterBattleSystem system, Scanner scanner) {
        System.out.print("Enter player ID: ");
        String playerId = scanner.nextLine();
        System.out.print("Enter player name: ");
        String name = scanner.nextLine();

        system.addPlayer(playerId, name);
        System.out.println("Player registered.");
    }

    private static void recruitMonsterToPlayer(MonsterBattleSystem system, Scanner scanner) {
        System.out.print("Enter player ID: ");
        String playerId = scanner.nextLine();
        System.out.print("Enter monster nickname: ");
        String nickname = scanner.nextLine();
        System.out.print("Enter species code: ");
        String speciesCode = scanner.nextLine();

        system.assignMonster(playerId, nickname, speciesCode);
        System.out.println("Monster recruited.");
    }

    private static void displayPlayerInfo(MonsterBattleSystem system, Scanner scanner) {
        System.out.print("Enter player ID: ");
        String playerId = scanner.nextLine();
        Player player = system.findPlayerById(playerId);
        if (player != null) {
            System.out.println(player);
        } else {
            System.out.println("Player not found.");
        }
    }

    private static void displayAllData(MonsterBattleSystem system) {
        System.out.println(system);
    }

    private static void battleBetweenTwoPlayers(MonsterBattleSystem system, Scanner scanner) {
        System.out.print("Enter player 1 ID: ");
        String player1ID = scanner.nextLine();
        System.out.print("Enter player 2 ID: ");
        String player2ID = scanner.nextLine();

        String battleResult = system.battle(player1ID, player2ID);
        System.out.println(battleResult);
    }
}
