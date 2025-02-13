package aula06;

import java.util.Scanner;
import java.util.ArrayList;

public class exercicio6_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;
        ArrayList<Contacto> listaContactos = new ArrayList<Contacto>();

        while (opcao != 0) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Inserir contacto");
            System.out.println("2. Alterar contacto");
            System.out.println("3. Apagar contacto");
            System.out.println("4. Procurar contacto");
            System.out.println("5. Listar contactos");
            System.out.println("0. Sair");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.next();

                    for (Contacto contacto : listaContactos) {
                        if (contacto.getPessoa().getNome().equalsIgnoreCase(nome)) {
                            System.out.println("Este nome já existe, quer criar um contacto na mesma? (S/N)");
                            String r = sc.next();
                            if (r == "N") {
                                break;
                            }
                            if (r == "S") {
                                continue;
                            }
                        }
                    }
                    System.out.print("CC: ");
                    int cc = sc.nextInt();
                    System.out.print("Ano em que nasceu: ");
                    int ano = sc.nextInt();
                    System.out.print("Mês em que nasceu: ");
                    int mes = sc.nextInt();
                    System.out.print("Dia em que nasceu: ");
                    int dia = sc.nextInt();

                    System.out.println("E-mail: ");
                    String email = sc.next();

                    System.out.println("Número: ");
                    String num = sc.next();

                    DateYMD dataNasc = new DateYMD(ano, mes, dia);
                    Pessoa pessoa = new Pessoa(nome, cc, dataNasc);
                    try {
                        Contacto novoContacto = new Contacto(pessoa, num, email);
                        listaContactos.add(novoContacto);
                        System.out.println("Contacto adicionado com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Não foi possível adicionar o contacto. Erro: " + e.getMessage());
                    }
                    break;
                case 2:

                    System.out.println("Insira o nome ou número do contato que deseja alterar:");
                    String nomeOuNumero = sc.next();

                    int cont = 0;
                    Contacto contsozinho = null;
                    for (Contacto contato : listaContactos) {
                        if (contato.getPessoa().getNome().equalsIgnoreCase(nomeOuNumero)
                                || contato.getTelefone().equals(nomeOuNumero)) {
                            System.out.println(contato);
                            cont++;
                            contsozinho = contato;
                        }
                    }
                    if (cont > 1) {
                        System.out.print("ID do contato que deseja alterar: ");
                        int id = sc.nextInt();
                        for (Contacto contacto : listaContactos) {
                            if (contacto.getId() == id) {
                                System.out.println(contacto);

                                System.out.print("Novo número de telefone: ");
                                String telefone = sc.next();
                                try {
                                    contacto.setTelefone(telefone);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }

                                System.out.print("Novo endereço de email: ");
                                email = sc.next();
                                try {
                                    contacto.setEmail(email);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }

                                System.out.println("O contato foi atualizado:");
                                System.out.println(contacto);
                                break;
                            }
                        }
                    } else {
                        System.out.print("Novo número de telefone: ");
                        String telefone = sc.next();
                        try {
                            contsozinho.setTelefone(telefone);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.print("Novo endereço de email: ");
                        email = sc.next();
                        try {
                            contsozinho.setEmail(email);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.println("O contato foi atualizado:");
                        System.out.println(contsozinho);
                        break;
                    }
                    break;
                case 3:
                    System.out.print("Nome ou número do contato que deseja apagar: ");
                    String nomeOuNumeroApagar = sc.next();
                    boolean contatoEncontradoApagar = false;
                    int contApagar = 0;
                    for (Contacto contato : listaContactos) {
                        if (contato.getPessoa().getNome().equalsIgnoreCase(nomeOuNumeroApagar)
                                || contato.getTelefone().equals(nomeOuNumeroApagar)) {
                            System.out.println(contato);
                            contApagar++;
                            contatoEncontradoApagar = true;
                        }
                    }
                    if (contatoEncontradoApagar) {
                        if (contApagar == 1) {
                            System.out.print("Tem a certeza que pretende apagar este contato? (S/N): ");
                            String resposta = sc.next();
                            if (resposta.equalsIgnoreCase("S")) {
                                listaContactos.removeIf(
                                        contato -> contato.getPessoa().getNome().equalsIgnoreCase(nomeOuNumeroApagar)
                                                || contato.getTelefone().equals(nomeOuNumeroApagar));
                                System.out.println("O contato foi apagado com sucesso.");
                            } else {
                                System.out.println("O contato não foi apagado.");
                            }
                        } else {
                            System.out.print("ID do contato que deseja apagar: ");
                            int id = sc.nextInt();
                            Contacto contatoEncontrado = null;
                            for (Contacto contato : listaContactos) {
                                if (contato.getId() == id) {
                                    contatoEncontrado = contato;
                                    break;
                                }
                            }
                            if (contatoEncontrado != null) {
                                System.out.print("Tem a certeza que pretende apagar este contato? (S/N): ");
                                String resposta = sc.next();
                                if (resposta.equalsIgnoreCase("S")) {
                                    listaContactos.remove(contatoEncontrado);
                                    System.out.println("O contato foi apagado com sucesso.");
                                } else {
                                    System.out.println("O contato não foi apagado.");
                                }
                            } else {
                                System.out.println("Não foi possível encontrar um contato com o ID especificado.");
                            }
                        }
                    } else {
                        System.out.println("Não foi possível encontrar um contato com o nome ou número especificado.");
                    }
                    break;
                case 4:
                    System.out.print("Insira o nome ou número de telefone do contato: ");
                    String nomeouNumero = sc.next();
                    boolean contatoEncontrado = false;
                    int contag = 0;
                    for (Contacto contato : listaContactos) {
                        if (contato.getPessoa().getNome().equalsIgnoreCase(nomeouNumero)
                                || contato.getTelefone().equals(nomeouNumero)) {
                            System.out.println(contato);
                            contag++;
                            contatoEncontrado = true;
                        }
                    }
                    if (contatoEncontrado) {
                        if (contag > 1) {
                            System.out.print("Insira o ID do contato que deseja alterar: ");
                            int id = sc.nextInt();
                            for (Contacto contato : listaContactos) {
                                if (contato.getId() == id) {
                                    System.out.println(contato);
                                    break;
                                }
                            }
                        } else {
                            System.out.println("O contato foi encontrado.");
                        }
                    } else {
                        System.out.println("Não foram encontrados contatos com esse nome ou número de telefone.");
                    }
                    break;
                case 5:
                    for (Contacto contato : listaContactos)
                        System.out.println(contato);
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        }

        sc.close();
    }
}