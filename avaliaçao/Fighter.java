public abstract class Fighter {
    private String nome;
    private int hp = 100;
    private int w, l = 0;

    public Fighter(String nome, int hp, int w, int l) {
        this.nome = nome;
        this.hp = hp;
        this.w = w;
        this.l = l;
    }

    public String getNome() {
        return nome;
    }

    public int getHp() {
        return hp;
    }

    public int getWins() {
        return w;
    }

    public int getLosses() {
        return l;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void set(int hp, int w, int l) {
        this.hp = hp;
        this.w = w;
        this.l = l;
    }

    public boolean isAlive() {
        if (this.hp <= 0) {
            this.l += 1;

            return false;
        } else {
            return true;
        }
    }

    public void damage(int damage) {
        this.hp -= damage;
        System.out.println(
                "Golpe acertado, foi infligido " + damage + " de dano e o oponente ficou a " + this.hp + " HP");
    }

    public void incrementwin() {
        this.w++;
    }

    public abstract int attack(Fighter enemy);

    @Override
    public String toString() {
        return nome + "W: " + w + "L: " + l;
    }
}
