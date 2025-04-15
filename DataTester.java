public class DataTester {
    public static void main(String[] args) throws Exception {
        // Create a MonsterBattleSystem instance
        MonsterBattleSystem system = new MonsterBattleSystem();

        // Add species
        system.addSpecies("FD001", "FireDragon", "Fire", 100, 50);
        system.addSpecies("WD002", "AquaSerpent", "Water", 110, 45);
        system.addSpecies("GD003", "LeafBeast", "Grass", 90, 55);

        // Add players
        system.addPlayer("P100", "John");
        system.addPlayer("P200", "Alice");

        // Assign monsters
        system.assignMonster("P100", "Blaze", "FD001");
        system.assignMonster("P200", "Sprout", "GD003");

        // Save data
        system.saveData();

        // Create a new system instance
        MonsterBattleSystem newSystem = new MonsterBattleSystem();

        // Load data
        newSystem.loadData();

        // Print the state of the new system to verify data
        System.out.println(newSystem);
    }
}
