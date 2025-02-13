package aula06;

public class Pessoa {
    private String nome;
    private int cc;
    private DateYMD dataNasc;

    // .....
    public Pessoa(String nome, int cc, DateYMD dataNasc) {
        this.nome = nome;
        this.cc = cc;
        this.dataNasc = dataNasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if (nome == null || nome.trim().isEmpty()) {
            throw new Exception("Nome inválido");
        }
        this.nome = nome;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) throws Exception {
        if (cc < 0) {
            throw new Exception("Número do cartão do cidadão inválido");
        }
        this.cc = cc;
    }

    public DateYMD getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(DateYMD dataNasc) throws Exception {
        if (dataNasc == null) {
            throw new Exception("Data de nascimento inválida");
        }
        this.dataNasc = dataNasc;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", CC: " + cc + ", Data de Nascimento: " + dataNasc.toString();
    }

}
