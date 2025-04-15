public class Player {
    private String playerId;
    private String name;
    private Monster[] team;
    private int monsterCount;

    public Player(String playerId, String name) {
        this.playerId = playerId;
        this.name = name;
        this.team = new Monster[5];
        this.monsterCount = 0;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }

    public void addMonster(Monster monster) {
        if (monsterCount >= 5) return;
        for (int i = 0; i < monsterCount; i++) {
            if (team[i].getName().equals(monster.getName())) {
                return; // Duplicate nickname not allowed
            }
        }
        team[monsterCount++] = monster;
    }

    public boolean hasAliveMonster() {
        for (int i = 0; i < monsterCount; i++) {
            if (!team[i].isFainted()) return true;
        }
        return false;
    }

    public Monster getNextAliveMonster() {
        for (int i = 0; i < monsterCount; i++) {
            if (!team[i].isFainted()) return team[i];
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" (").append(playerId).append("):\n");
        for (int i = 0; i < monsterCount; i++) {
            sb.append("  ").append(team[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
