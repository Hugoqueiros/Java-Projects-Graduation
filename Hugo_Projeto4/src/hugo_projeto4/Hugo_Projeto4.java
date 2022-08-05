package hugo_projeto4;

import java.util.Scanner;

public class Hugo_Projeto4 {

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        int escolha, nota;
        String nome, id_aluno, curso, elimina_id, pesquisa_id;
        Map<String, Aluno> classificacao = new Map<>();
        do {
            System.out.println("___MENU DE OPÇÕES___ ");
            System.out.println("1- Inserir dados Aluno ");
            System.out.println("2- Eliminar dados Aluno");
            System.out.println("3- Pesquisar Aluno ");
            System.out.println("4- Número de Alunos Inscritos ");
            System.out.println("5- Pauta da Turma ");
            System.out.printf("\nOpção Pretendida: ");
            escolha = leitura.nextInt();
            System.out.println();
            switch (escolha) {
                case 1:
                    Aluno aluno1 = new Aluno();
                    System.out.printf("Insira o nome do aluno: ");
                    leitura.nextLine();
                    nome = leitura.nextLine();
                    System.out.printf("Insira o número do aluno: ");
                    id_aluno = leitura.nextLine();
                    System.out.printf("Insira o curso: ");
                    curso = leitura.nextLine();
                    System.out.printf("Insira a nota do aluno: ");
                    nota = leitura.nextInt();
                    System.out.println("");
                    if (nota >= 0 || nota <= 20) {
                        aluno1.setNome(nome);
                        aluno1.setId_aluno(id_aluno);
                        aluno1.setNota(nota);
                        aluno1.setCurso(curso);
                        classificacao.add(id_aluno, aluno1);
                    } else {
                        System.out.println("Nota Inválida");
                    }
                    break;
                case 2:
                    leitura.nextLine();
                    System.out.printf("Digite o número do Aluno ao qual pretende eliminar os dados: ");
                    elimina_id = leitura.nextLine();
                    classificacao.remove(elimina_id);
                    System.out.println("As informações do aluno foram removidas com sucesso.");
                    System.out.println();
                    break;
                case 3:
                    leitura.nextLine();
                    System.out.printf("Digite o número do Aluno pelo qual pretende pesquisar: ");
                    pesquisa_id = leitura.nextLine();
                    System.out.println(classificacao.get(pesquisa_id));
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Há " + classificacao.tamanho()+ " alunos inscritos ");
                    System.out.println();
                    break;
                    
                case 5:
                    System.out.println(classificacao.toString());
                    break;
                    
                default:
                    System.out.println("Programa finalizado.");
                    break;
            }
        } while (escolha != 6);
    }
}