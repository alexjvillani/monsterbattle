public class FireMonster extends Monster {
    public FireMonster(String name, MonsterSpecies species) {
        super(name, species);
    }

    @Override
    public void attack(Monster target) {
        int damage = attackPower;
        String targetType = target.getSpecies().getType();
        if (targetType.equals("Grass")) {
            damage += 10;
        }
        target.takeDamage(damage);
    }
}
