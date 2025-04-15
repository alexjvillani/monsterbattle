public class WaterMonster extends Monster {
    public WaterMonster(String name, MonsterSpecies species) {
        super(name, species);
    }

    @Override
    public void attack(Monster target) {
        int damage = attackPower;
        String targetType = target.getSpecies().getType();
        if (targetType.equals("Fire")) {
            damage += 10;
        }
        target.takeDamage(damage);
    }
}
