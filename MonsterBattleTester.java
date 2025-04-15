public class MonsterBattleTester {
    public static void main(String[] args) throws Exception {
        // Create a instance of the battle system
        MonsterBattleSystem system = new MonsterBattleSystem();

        // Add species to the system
        system.addSpecies("FD001", "FireDragon", "Fire", 100, 50);
        system.addSpecies("WD002", "AquaSerpent", "Water", 110, 45);
        system.addSpecies("GD003", "LeafBeast", "Grass", 90, 55);
        // Uncomment the line below to test duplicate species entry
        // Duplicate species should not be added
        //system.addSpecies("FD001", "FireDragon", "Fire", 100, 50);
        
        // Add players to the system
        system.addPlayer("P100", "John");
        system.addPlayer("P200", "Alice");
        system.addPlayer("P300", "Bob");
        // Uncomment the line below to test duplicate player entry
        // Duplicate players should not be added
        //system.addPlayer("P100", "John"); 

        // Assign monsters to players
        system.assignMonster("P100", "Blaze", "FD001");
        system.assignMonster("P200", "Sprout", "GD003");
        system.assignMonster("P300", "Aqua", "WD002");
        
        // A battle between two players and print the result
        System.out.println(system.battle("P100", "P200")); // Blaze vs. Sprout
        // Uncomment below to test a different battle scenario
        // System.out.println(system.battle("P100", "P300")); // Blaze vs. Aqua
        
        // Print the current state of the system (all players and their monsters)
        System.out.println(system);

    }
}
