public class GrassMonster extends Monster {
    public GrassMonster(String name, MonsterSpecies species) {
        super(name, species);
    }

    @Override
    public void attack(Monster target) {
        int damage = attackPower;
        String targetType = target.getSpecies().getType();
        if (targetType.equals("Water")) {
            damage += 10;
        }
        target.takeDamage(damage);
    }
}
