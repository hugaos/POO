public class Boxer extends Fighter {
    protected int range;

    public Boxer(String nome, int hp, int w, int l, int range) {
        super(nome, hp, w, l);
        this.range = range;
    }

    public int getrange() {
        return range;
    }

    public void setrange(int range) {
        this.range = range;
    }

    public int attack(Fighter enemy) {
        int dist = (int) Math.round(Math.random() * 10);
        if (dist < this.range) {
            int damage = (int) Math.round(Math.random() * 100);
            enemy.damage(damage);
            return damage;
        } else {
            System.out.println("O ataque falhou!");
            return 0;
        }

    }

    public String getype() {
        return "Boxer";
    }
}
