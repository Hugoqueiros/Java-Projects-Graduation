/*
 * Gestao de uma arvore binaria
 */

package ltc_projeto_5_by_hugo_queiros;

import java.util.*;

public class Main {
    
    // Vector auxiliar para armazenamento dos nos antes de os inserir na arvore
    private Vector<Node> nodeList = new Vector<Node>(); 

    // referencia para a raiz da arvore
    private Node raiz = null;
    
    // metodos para efectuar a visita da arvore
    public void visitaEmOrdem( Node a ){
        if( a != null ){
            visitaEmOrdem( a.getEsquerda() );
            System.out.println( a );
            visitaEmOrdem( a.getDireita() );
        }
    }
    
    public void visitaEmPreOrdem( Node a ){
        if( a != null ){
            System.out.println( a );
            visitaEmPreOrdem( a.getEsquerda() );
            visitaEmPreOrdem( a.getDireita() );
        }
    }
    
    public void visitaEmPosOrdem( Node a ){
        if( a != null ){
            visitaEmPosOrdem( a.getEsquerda() );
            visitaEmPosOrdem( a.getDireita() );
            System.out.println( a );
        }
    }
    
    // Insere nos na arvore garantindo a ordenacao
    // mas nao garantindo que a arvore fique balanceada 
    public Node insereNo( Node r, Node novo ){
        if( r == null ){
            r = novo;
        }
        else{
            if( novo.getDados() < r.getDados() ){
                r.setEsquerda( insereNo( r.getEsquerda(), novo ));
            }
            else{
                r.setDireita( insereNo( r.getDireita(), novo ));
            }
        }
        return r;
    }
    
    // Insere nos na arvore garantindo o balanceamento de nos
    // mas nao garantindo que a arvore fique ordenada
    // a arvore so fica ordenada se os nos forem inseridos por ordem
    public Node insereEquilibrada( int n ){
        int left;
        int right;
        int total = n-1;
        
        if( n == 0 ){
            return null;
        }
        
        left = total/2;
        right = total - left;
        
        Node a = new Node();
        
        a.setEsquerda(insereEquilibrada( left ) );
        
        Node aux = nodeList.elementAt(0);
        nodeList.removeElementAt(0);
        a.setDados( aux.getDados() );
        
        a.setDireita( insereEquilibrada( right ) );
        
        return a;
    }
    
    // metodo para contar o numero de nos da arvore
    public int contaNos( Node r ){
        if( r == null ){
            return 0;
        }
        else {
            return 1 + contaNos( r.getEsquerda() ) + contaNos( r.getDireita() );
        }
    }
    
    // metodo para contar o numero de niveis da arvore
    public int contaNiveis( Node r ){
        if( r == null ){
            return 0;
        }
        else {
            int e = contaNiveis( r.getEsquerda() );
            int d = contaNiveis( r.getDireita() );
            return e > d ? 1+e : 1+d;
        }
    }
    
    // metodo para pesquisa de um valor na arvore
    public Node pesquisa( Node r, int n ){
        if( r == null ){
            return null;
        }
        else {
            if( n == r.getDados() ){
                return r;
            }
            else {
                if( n < r.getDados() ){
                    return pesquisa( r.getEsquerda(), n );
                }
                else {
                    return pesquisa( r.getDireita(), n );
                }
            }
        }
    }
    
    public void go(){
        
        System.out.println( "Metodo de insercao na arvore: ");
        System.out.println( "1 - insereNo ");
        System.out.println( "2 - insereEquilibrada ");
        int metodo = Le.umInt();
        
        // Le os nos da arvore guardando-os temporariamente em nodeList
        while( true ){
            Node n = new Node();
            int v;
            System.out.println( "Insira o valor do no (termina quando for inserido valor negativo): ");
            v = Le.umInt();
            if( v < 0 )
                break;
            n.setDados( v );
            nodeList.add( n );
        }
        
        if( metodo == 1 ){
            // Descarrega os nos existentes em nodeList e insere-os na arvore
            for( Node n: nodeList ){  
                raiz = insereNo( raiz, n );
            }
        }
        
        if( metodo == 2 ){
            // Ordena nodeList garantindo que os nos sao inseridos por ordem
            Collections.sort( nodeList );
            raiz = insereEquilibrada( nodeList.size() );
        }
        
        // Visita da arvore: em ordem, em pre-ordem, e em pos-ordem
        System.out.println( "Em ordem:" );
        visitaEmOrdem( raiz );
        System.out.println( "Pre-ordem:" );
        visitaEmPreOrdem( raiz );
        System.out.println( "Pos-ordem:" );
        visitaEmPosOrdem( raiz );
        
        // Conta o numero de nos existentes na arvore
        System.out.println( "Numero de nos = " + contaNos( raiz) );
        
        // Conta o numero de niveis da arvore
        System.out.println( "Numero de niveis = " + contaNiveis( raiz) );
        
        // Pesquisa um valor na arvore
        System.out.println( "Valor a pesquisar: ");
        int x = Le.umInt();
        Node n = new Node();
        n = pesquisa( raiz, x );
           
        if( n != null ){
            System.out.println( "Encontrado: " + n.getDados());
        }
        else{
            System.out.println( "Nao encontrado!" );
        }
    }

    public static void main(String[] args) {
        new Main().go();
        
    }
}
