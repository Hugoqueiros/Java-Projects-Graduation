package addressbookdemo;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AddressBook implements Serializable {

    Scanner leitura = new Scanner(System.in);

    //inicialização da arraylist da agenda para puder guardar contactos
    ArrayList<ContactDetails> agenda = new ArrayList<ContactDetails>();

    public void adiciona(ContactDetails contacto) {
        //recebe como parâmetro o contacto para adicionar na agenda
        agenda.add(contacto);
    }

    public void elimina(String eli, boolean remove) {
        String opcao;
        //percorre agenda
        for (ContactDetails valor : agenda) {
            //verificação se na agenda existe algum contacto com o nome introduzido pelo utilizador
            if (eli.equals(valor.nome)) {
                //caso exista esse contacto será mostrado o resultado
                valor.print();
                int posicao = agenda.indexOf(valor);
                System.out.println("É este o contacto que pretende eliminar? (S/N)");
                opcao = leitura.nextLine().toLowerCase();
                //o utilizador verifica se é aquele contacto que pretende eliminar, caso digite s o contacto irá ser eliminado
                if (opcao.equals("s")) {
                    remove = true;
                    agenda.remove(posicao);
                    System.out.println("\nContacto eliminado");
                    break;
                } else {
                    remove = true;
                    System.out.println("\nNenhum contacto foi eliminado");
                    break;
                }
            }
        }
        //senão houver o nome presente na agenda 
        if (remove == false) {
            //Caso não exista qualquer animal com o nome introduzido
            System.out.println("Não existem resultados com o nome '" + eli + "'");
        }
    }

    public void pesquisa(String pes_nome, boolean pesquisa) {
        //percorre agenda
        for (ContactDetails valor : agenda) {
            //se algum nome conter aquilo que o utilizador insere irá aparecer 
            if (valor.nome.contains(pes_nome)) {
                pesquisa = true;
                valor.print();
            }
        }
        //caso não exista contactos presentes com o nome digitado
        if (pesquisa == false) {
            System.out.println("Não existem resultados com o nome '" + pes_nome + "'");
        }
    }

    public void modificar(String mod, boolean modificado) {
        boolean input_email = false;
        String opcao, mod_op;
        int mod_nmr;
        //percorre agenda
        for (ContactDetails valor : agenda) {
            //se algum nome corresponder aquilo que o utilizador insere irá aparecer
            if (mod.equals(valor.nome)) {
                valor.print();
                System.out.println("É este o contacto que pretende modificar? (S/N)");
                opcao = leitura.nextLine().toLowerCase();
                if (opcao.equals("s")) {
                    System.out.printf("Modificar- ");
                    mod = leitura.nextLine().toLowerCase();
                    //seleciona qual campo pretende modificar
                    if (mod.equals("nome")) {
                        System.out.printf("Modificar Nome-");
                        mod_op = leitura.nextLine();
                        valor.nome = mod_op;
                        System.out.println("Nome Modificado com Sucesso");
                        modificado = true;
                    } else if (mod.equals("numero")) {
                        System.out.printf("Modificar Número-");
                        mod_nmr = leitura.nextInt();
                        valor.nmr_tel = mod_nmr;
                        System.out.println("Número Modificado com Sucesso");
                        modificado = true;
                    } else if (mod.equals("email")) {
                        System.out.printf("Modificar Email-");
                        mod_op = leitura.nextLine();
                        do {
                            try {
                                mod_op = leitura.nextLine();

                                if (mod_op.contains("@")) {
                                } else {
                                    throw new Excecao();
                                }
                                input_email = true;
                            } catch (Excecao e) {
                                System.out.printf(e.getMessage() + "\nDigite Novamente o Email: ");
                                leitura.reset();
                            }
                        } while (!input_email);
                        valor.email = mod_op;
                        System.out.println("Email Modificado com Sucesso");
                        modificado = true;
                    } else {
                        System.out.println("\nNenhum contacto foi modificado");
                    }
                } else {
                    System.out.println("\nNenhum contacto foi modificado");
                }
            }
        }
        if (modificado = false) {
            System.out.println("Não existem resultados com o nome '" + mod + "'");
        }
    }

    public void ordena() {
        //ordenção da agenda
        Collections.sort(agenda);
        for (ContactDetails valor : agenda) {
            valor.print();
        }
    }

    public void insere_ficheiro() {
        try {
            ObjectOutputStream insere = new ObjectOutputStream(new FileOutputStream("agenda.txt"));
            insere.writeObject(agenda);
        } catch (IOException e) {
            System.out.println("Ficheiro não presente");
        }
        System.out.println("Inserido com sucesso no ficheiro");
    }

    public void exporta_ficheiro() {
        ArrayList<ContactDetails> agenda2 = new ArrayList<ContactDetails>();
        try {
            ObjectInputStream exporta = new ObjectInputStream(new FileInputStream("agenda.txt"));
            agenda2 = (ArrayList) exporta.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler o ficheiro");
        }
        for (ContactDetails valor : agenda2) {
            valor.print();
        }
    }

    public boolean gravarContacto() {
        try {
            FileWriter writer = new FileWriter("agendaexportada.txt");
            for (int i = 0; i < agenda.size(); i++) {
                writer.write("Contacto:" + " Nome- " + agenda.get(i).nome + " Email- " + agenda.get(i).email + " Nº Telemóvel- " + agenda.get(i).nmr_tel + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao escrever em no ficheiro");
        }
        System.out.println("Gravado com Sucesso");
        return true;
    }

    ArrayList<String> agenda_contacto = new ArrayList<String>();

    public boolean lerContacto() {

        try {
            BufferedReader bf = new BufferedReader(new FileReader("agendaexportada.txt"));
            String linha = bf.readLine();
            while (linha != null) {
                agenda_contacto.add(linha);
                linha = bf.readLine();
            }
            bf.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler ficheiro");
        }
        for(int i = 0; i<agenda_contacto.size(); i++){
            System.out.println(agenda_contacto.get(i));
        }
        //System.out.println(agenda_contacto);
        return true;
    }
}
