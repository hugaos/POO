public class Wrestler extends Fighter {
    private int speed = (int) Math.round(Math.random() * 10);

    public Wrestler(String nome, int hp, int w, int l, int speed) {
        super(nome, hp, w, l);
        this.speed = speed;
    }

    public int getspeed() {
        return speed;
    }

    public void setspeed(int speed) {
        this.speed = speed;
    }

    public int attack(Fighter enemy) {
        int dist = (int) Math.round(Math.random() * 10);
        if (this.speed >= dist) {
            int damage = (int) Math.round(Math.random() * 100);
            enemy.damage(damage);
            return damage;
        } else
            System.out.println("O ataque falhou!");
        return 0;
    }

    public String getype() {
        return "Wrestler";
    }
}
