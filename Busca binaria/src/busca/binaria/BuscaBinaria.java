/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca.binaria;
import java.util.Arrays;
/**
 *
 * @author hugo-
 */
public class BuscaBinaria {

        private static int busca(int[] array, int chave) {
		return buscaBinariaRecursiva(array, 0, array.length - 1, chave);
	}

	private static int buscaBinariaRecursiva(int[] array, int menor, int maior,
			int chave) {
		int media = (maior + menor) / 2;
		int valorMeio = array[media];

		if (menor > maior)
			return -1;
		else if(valorMeio == chave) 
			return media;
		else if (valorMeio < chave)
			return buscaBinariaRecursiva(array, media+1, maior, chave);
		else
			return buscaBinariaRecursiva(array, menor, media-1, chave);
	}
    public static void main(String[] args) {
        int[] array = { 1, 8, 34, 67, 9, 6, 78, 12, 56, 41, 90 };
		Arrays.sort(array);
		System.out.println("Está na posição "+busca(array, 6) + "do vetor");
		System.out.println(busca(array, 78));
		System.out.println(busca(array, 90));
	}

    }
   if(aluno==true && ordem==true){
                        int media, maior=nota_alunos[0], menor=nota_alunos[0], nota=0;
                        for (int i = 0; i < a; i++) {
                           if(nota_alunos[i] < menor){
				menor = nota_alunos[i];
                           }
                        }
			for (int i = 0; i < a; i++) {
                           if(nota_alunos[i] > maior){
				maior = nota_alunos[i];
                           }
                        }
                        media= (maior+menor)/2;
                        System.out.println("Qual a nota que pretende pesquisar?");
                        nota=leitura.nextInt();
                        


        private static int pesquisaInterpolada(int nota_alunos[], int a, int nota) {
            int start=0, end=a-1, pos;
            while(start <= end && nota>= nota_alunos[start] && nota<= nota_alunos[end] ){
                            pos= start +(((int)(end-start)/(nota_alunos[end]-nota_alunos[start]))*(nota-nota_alunos[start]));
                            if(nota_alunos[pos]==nota){
                               return pos;
                            }
                            if(nota_alunos[pos]<nota){
                                start=pos+1;
                                return start;
                            }
                            else{
                                end= pos-1;
                                return end;
                            }   
            }   
        return pesquisaInterpolada(nota_alunos, a, nota);
        }


    
    

