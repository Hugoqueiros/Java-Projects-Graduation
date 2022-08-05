package addressbookdemo;

import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddressBookDemo {

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        int escolha;
        String nome = null, email = null, mod = null;
        int nmr_tel = 0, nmr_tel2 = 0;
        boolean remove = false, pesquisa = false, modificado = true, guardar = true;
        //inicialização da agenda para guardar cada contacto
        AddressBook agenda = new AddressBook();

        do {
            boolean input_nome = false, input_nmr = false, input_email = false;
            int length = 0;
            System.out.println("\n|1 - Inserir Contacto");
            System.out.println("|2 - Pesquisar Contacto");
            System.out.println("|3 - Eliminar Contacto");
            System.out.println("|4 - Modificar Contacto");
            System.out.println("|5 - Visualizar Contactos Ordenados|");
            System.out.println("|6 - Guardar Contactos num ficheiro Binário|");
            System.out.println("|7 - Lê Contactos num ficheiro Binário|");
            System.out.println("|8 - Guardar Contactos num ficheiro Texto|");
            System.out.println("|9 - Lê Contactos num ficheiro Texto|");
            System.out.println("|10- Sair|");
            System.out.printf("\nEscolha uma das opções: ");
            escolha = leitura.nextInt();
            switch (escolha) {
                case 1:
                    ContactDetails contacto = new ContactDetails();
                    System.out.printf("\nNome- ");
                    nome = leitura.nextLine();
                    //verificação do nome estar vazio, caso esteja é lançada uma exceção
                    do {
                        try {
                            nome = leitura.nextLine().toLowerCase();

                            if (nome.equals("")) {
                                throw new Excecao();
                            }
                            input_nome = true;
                        } catch (Excecao e) {
                            System.out.printf(e.getMessage() + "\nDigite Novamente o Nome: ");
                            leitura.reset();
                        }
                    } while (!input_nome);
                    //verificação do número ser um tipo de dados diferente, caso seja é lançada uma exceção
                    System.out.printf("\nNúmero Telemóvel- ");
                    do {
                        try {
                            nmr_tel = leitura.nextInt();
                            input_nmr = true;

                        } catch (InputMismatchException e) {
                            System.out.printf("Error: " + e + "\nInsira dados válidos: ");
                            leitura.reset();
                            leitura.next();
                        }
                    } while (!input_nmr);
                    //verificação do número conter 9 carateres, caso não tenha é parada a inserção do contacto
                    nmr_tel2 = nmr_tel;
                    while (nmr_tel2 > 0) {
                        nmr_tel2 = nmr_tel2 / 10;
                        length++;
                    }
                    if (length < 9 || length > 9) {
                        System.out.println("Número Inválido");
                        guardar = false;
                        break;
                    }
                    System.out.printf("\nEmail- ");
                    email = leitura.nextLine();
                    //verificação do email conter o @, caso não esteja presente é lançada uma exceção
                    do {
                        try {
                            email = leitura.nextLine();

                            if (email.contains("@")) {
                            } else {
                                throw new Excecao();
                            }
                            input_email = true;
                        } catch (Excecao e) {
                            System.out.printf(e.getMessage() + "\nDigite Novamente o Email: ");
                            leitura.reset();
                        }
                    } while (!input_email);

                    //ao cumprir todos os requisitos é criado um contacto que vai chamar o método para adicionar na agenda
                    if(guardar == true){
                    contacto.setNome(nome);
                    contacto.setEmail(email);
                    contacto.setNmr_tel(nmr_tel);
                    agenda.adiciona(contacto);

                    System.out.println("Contacto Inserido com Sucesso!");
                    }
                    break;

                case 2:
                    String pes_nome;
                    leitura.nextLine();
                    System.out.println("Pesquisar pelo nome- ");
                    pes_nome = leitura.nextLine().toLowerCase();
                    //chamado o método de pesquisa na agenda
                    agenda.pesquisa(pes_nome, pesquisa);
                    break;

                case 3:
                    String eli;
                    leitura.nextLine();
                    System.out.printf("\nPesquisar Nome que pretende Eliminar- ");
                    eli = leitura.nextLine().toLowerCase();
                    //chamado o método de eliminar na agenda
                    agenda.elimina(eli, remove);
                    break;

                case 4:
                    leitura.nextLine();
                    System.out.printf("\nPesquisar Nome que pretende Modificar- ");
                    mod = leitura.nextLine();
                    //chamado o método de modificação na agenda
                    agenda.modificar(mod, modificado);
                    break;

                case 5:
                    //chamado o método de ordenar a agenda por ordem alfabética do nome
                    agenda.ordena();
                    break;

                case 6:
                    //chamado o método de inserir no ficheiro todos os contactos presentes na agenda
                    agenda.insere_ficheiro();
                    break;

                case 7:
                    //chamado o método de exportar do ficheiro todos os contactos presentes na agenda
                    agenda.exporta_ficheiro();
                    break;
                    
                case 8:
                    agenda.gravarContacto();
                    break;
                    
                case 9:
                    agenda.lerContacto();
            }

        } while (escolha != 10);
    }
}
