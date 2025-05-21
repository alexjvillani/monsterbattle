public class QuicksilverElemental extends Monster {
    public QuicksilverElemental(String name, MonsterSpecies species) {
        super(name, species);
    }

    @Override
    public void attack(Monster target) {
        int damage = attackPower;
        // QuicksilverElemental's special: 50% chance to double attack power
        if (Math.random() < 0.5) {
            System.out.println(name + " surges with metallic speed! Double damage!");
            damage *= 2;
        }
        // Metal type deals +10 bonus vs Grass, -10 penalty vs Fire
        String targetType = target.getSpecies().getType();
        if (targetType.equals("Grass")) {
            damage += 10;
        } else if (targetType.equals("Fire")) {
            damage -= 10;
        }
        target.takeDamage(damage);
    }

    @Override
    public String toString() {
        return name + " (" + species.getName() + ", Lv." + level + ", HP: " + hp + ") [Quicksilver Elemental]";
    }
}
