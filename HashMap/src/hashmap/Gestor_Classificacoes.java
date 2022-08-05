package hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class Gestor_Classificacoes {

    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        HashMap<Integer, Aluno> classificacao = new HashMap<Integer, Aluno>();
        int escolha, numero, nota, elimina_id, pesquisa_id;
        String curso, nome;
        do {
            System.out.println("________MENU DE OPÇÕES________ ");
            System.out.println("1- Inserir dados Aluno ");
            System.out.println("2- Eliminar dados Aluno");
            System.out.println("3- Pesquisar Aluno ");
            System.out.println("4- Pauta da Turma ");
            System.out.println("5- Sair ");
            System.out.println("\nOpção Pretendida: ");
            escolha = leitura.nextInt();
            switch (escolha) {

                case 1:
                    leitura.nextLine();
                    System.out.println("Insira o nome do aluno: ");
                    nome = leitura.nextLine();
                    System.out.println("");
                    System.out.println("Insira o número do aluno: ");
                    numero = leitura.nextInt();
                    System.out.println("");
                    leitura.nextLine();
                    System.out.println("Insira o curso: ");
                    curso = leitura.nextLine();
                    System.out.println("");
                    System.out.println("Insira a nota do aluno: ");
                    nota = leitura.nextInt();
                    if (nota < 0 || nota > 20) {
                        System.out.println("Nota Inválida");
                    } else {
                        Aluno aluno = new Aluno();
                        aluno.setClassificacao(nota);
                        aluno.setNome(nome);
                        aluno.setAluno_id(numero);
                        aluno.setCurso(curso);
                        classificacao.put(aluno.getAluno_id(), aluno);
                        System.out.println("Dados submetidos com sucesso\n");
                    }
                    break;

                case 2:
                    System.out.println("Digite o número do Aluno ao qual pretende eliminar os dados: ");
                    elimina_id = leitura.nextInt();
                    for (int i : classificacao.keySet()) {
                        if (i == elimina_id) {
                            classificacao.remove(elimina_id);
                            System.out.println("Dados dos Alunos foram removidos com sucesso");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Digite o número do Aluno pelo qual pretende pesquisar: ");
                    pesquisa_id = leitura.nextInt();
                    for (int i : classificacao.keySet()) {
                        if (i == pesquisa_id) {
                            System.out.println(classificacao.get(i));
                        } 
                        else {
                            System.out.println("Não há nenhum aluno correspondente a esse número");
                        }
                    }

                    break;

                case 4:
                    System.out.println(classificacao);
                    break;

                default:
                    System.out.println("Programa terminado");
                    break;
            }
        } while (escolha != 4);

    }

}
