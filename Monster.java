public abstract class Monster {
    protected String name;
    protected MonsterSpecies species;
    protected int level;
    protected int hp;
    protected int attackPower;

    public Monster(String name, MonsterSpecies species) {
        this.name = name;
        this.species = species;
        this.level = 1;
        this.hp = species.getBaseHP();
        this.attackPower = species.getBaseAttack();
    }

    public String getName() {
        return name;
    }

    public MonsterSpecies getSpecies() {
        return species;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public abstract void attack(Monster target);

    public void takeDamage(int amount) {
        this.hp -= amount;
    }

    public boolean isFainted() {
        return this.hp <= 0;
    }

    @Override
    public String toString() {
        return name + " (" + species.getName() + ", Lv." + level + ", HP: " + hp + ")";
    }
}
