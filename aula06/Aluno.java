package aula06;

public class Aluno extends Pessoa {
    private final int NMec;
    private DateYMD dataInsc;
    private static int cont = 100;

    public Aluno(String iNome, int iBI, DateYMD iDataNasc, DateYMD iDataInsc) {
        super(iNome, iBI, iDataNasc);
        this.NMec = cont++;
        this.dataInsc = iDataInsc;
    };

    public Aluno(String nome, int cc, DateYMD iDataNasc) {
        super(nome, cc, iDataNasc);
        this.NMec = cont++;
        this.dataInsc = iDataNasc;
    }

    public int getNMec() {
        return NMec;
    }

    public DateYMD getDataInsc() {
        return dataInsc;
    }

    public String toString() {
        return this.getNome() + ", NMec: " + NMec + ", Data de inscrição: " + dataInsc;
    }
}
