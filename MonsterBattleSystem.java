public class MonsterBattleSystem {
    private MonsterSpecies[] speciesList;
    private Player[] players;
    private int speciesCount;
    private int playerCount;

    public MonsterBattleSystem() {
        speciesList = new MonsterSpecies[50];
        players = new Player[100];
        speciesCount = 0;
        playerCount = 0;
    }

    public void addSpecies(String code, String name, String type, int baseHP, int baseAttack) {
        if (findSpeciesByCode(code) != null) return; // Duplicate check
        speciesList[speciesCount++] = new MonsterSpecies(code, name, type, baseHP, baseAttack);
    }

    public void addPlayer(String playerId, String name) {
        if (findPlayerById(playerId) != null) return; // Duplicate check
        players[playerCount++] = new Player(playerId, name);
    }

    public void assignMonster(String playerId, String nickname, String speciesCode) {
        Player player = findPlayerById(playerId);
        MonsterSpecies species = findSpeciesByCode(speciesCode);
        if (player == null || species == null) return;

        Monster monster;
        switch (species.getType()) {
            case "Fire":
                monster = new FireMonster(nickname, species);
                break;
            case "Water":
                monster = new WaterMonster(nickname, species);
                break;
            case "Grass":
                monster = new GrassMonster(nickname, species);
                break;
            default:
                return;
        }
        player.addMonster(monster);
    }

    public String battle(String player1ID, String player2ID) {
        Player p1 = findPlayerById(player1ID);
        Player p2 = findPlayerById(player2ID);
        if (p1 == null || p2 == null) return "Player not found.";

        Monster m1 = p1.getNextAliveMonster();
        Monster m2 = p2.getNextAliveMonster();
        StringBuilder log = new StringBuilder();

        while (m1 != null && m2 != null) {
            log.append(m1.getName()).append(" (").append(m1.getSpecies().getName()).append(") vs. ")
               .append(m2.getName()).append(" (").append(m2.getSpecies().getName()).append(")\n");

            // Player 1's monster attacks first
            m1.attack(m2);
            log.append(m1.getName()).append(" attacks ").append(m2.getName())
               .append(" (HP left: ").append(Math.max(0, m2.getHp())).append(")\n");
            if (m2.isFainted()) {
                log.append(m2.getName()).append(" fainted!\n");
                m2 = p2.getNextAliveMonster();
                if (m2 == null) break;
            }

            // Player 2's monster attacks if still alive
            m2.attack(m1);
            log.append(m2.getName()).append(" attacks ").append(m1.getName())
               .append(" (HP left: ").append(Math.max(0, m1.getHp())).append(")\n");
            if (m1.isFainted()) {
                log.append(m1.getName()).append(" fainted!\n");
                m1 = p1.getNextAliveMonster();
            }
        }

        String winner = (p1.hasAliveMonster() ? p1.getName() : p2.getName());
        log.append(winner).append(" wins!\n");
        return log.toString();
    }

    private MonsterSpecies findSpeciesByCode(String code) {
        for (int i = 0; i < speciesCount; i++) {
            if (speciesList[i].getCode().equals(code)) return speciesList[i];
        }
        return null;
    }

    private Player findPlayerById(String playerId) {
        for (int i = 0; i < playerCount; i++) {
            if (players[i].getPlayerId().equals(playerId)) return players[i];
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Players and their monsters:\n");
        for (int i = 0; i < playerCount; i++) {
            sb.append(players[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
