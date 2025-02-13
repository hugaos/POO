package aula06;

public class Bolseiro extends Aluno {
    private Professor orientador;
    private double bolsa;

    public Bolseiro(String nome, int cc, DateYMD dataNasc, Professor orientador, double bolsa) {
        super(nome, cc, dataNasc);
        this.orientador = orientador;
        this.bolsa = bolsa;
    }

    public Bolseiro(String nome, int cc, DateYMD dataNasc, DateYMD dataInsc, Professor orientador, double bolsa) {
        super(nome, cc, dataNasc, dataInsc);
        this.orientador = orientador;
        this.bolsa = bolsa;
    }

    public Professor getOrientador() {
        return this.orientador;
    }

    public double getBolsa() {
        return this.bolsa;
    }

    public void setOrientador(Professor orientador) {
        this.orientador = orientador;
    }

    public void setBolsa(double bolsa) {
        this.bolsa = bolsa;
    }

    @Override
    public String toString() {
        return getNome() + "; NMec: " + getNMec() + "; Data de Inscricao: " + getDataInsc() +
                "; Orientador: " + orientador.getNome() + "; Bolsa: " + bolsa;
    }
}
