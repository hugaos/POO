package aula06;

public class Professor extends Pessoa {
    private String categ;
    private String dep;

    public Professor(String nome, int cc, DateYMD dataNasc, String categ, String dep) {
        super(nome, cc, dataNasc);
        this.categ = categ;
        this.dep = dep;
    }

    public String getcateg() {
        return categ;
    }

    public void setcateg(String categ) {
        this.categ = categ;
    }

    public String getdep() {
        return dep;
    }

    public void setdep(String dep) {
        this.dep = dep;
    }

    @Override
    public String toString() {
        return this.getNome() + ", Data de Nascimento: " + this.getDataNasc() + ", Categoria: " + this.categ
                + ", Departamento: " + this.dep;
    }
}
