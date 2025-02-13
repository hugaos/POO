package aula06;

public class Contacto {
    private static int nextId = 1;
    private int id;
    private Pessoa pessoa;
    private String telefone;
    private String email;

    public Contacto(Pessoa pessoa, String telefone, String email) throws Exception {
        this.id = nextId++;
        this.pessoa = pessoa;
        setTelefone(telefone);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws Exception {
        if (telefone.length() != 9 || !telefone.startsWith("9")) {
            throw new Exception("Número de telefone inválido");
        }
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if (!email.contains("@") || !email.contains(".")) {
            throw new Exception("Endereço de email inválido");
        }
        int dotIndex = email.lastIndexOf(".");
        String dominio = email.substring(dotIndex + 1);
        if (!dominio.equals("com") && !dominio.equals("pt")) {
            throw new Exception("Endereço de email inválido");
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Pessoa: " + pessoa.getNome() + ", Telefone: " + telefone + ", Email: " + email;
    }

}
