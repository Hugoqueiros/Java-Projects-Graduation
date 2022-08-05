package hugo_projeto4;

class HashNode<id_aluno, if_aluno> {

    //um nó em cadeias
    id_aluno key;
    if_aluno value;

    // Referencia para o próximo node  
    HashNode<id_aluno, if_aluno> proximo;

    // Construtor 
    public HashNode(id_aluno key, if_aluno value) {
        this.key = key;
        this.value = value;
    }

    public void print(id_aluno key, if_aluno value) {
    }
}

// Classe para representar a hash table
class Map<id_aluno, if_aluno> {

    private HashNode<id_aluno, if_aluno>[] bucketArray;

    // Capacidade atual do array 
    private int capacidade;

    // Tamanho atual do array  
    private int tamanho;

    // Construtor (Inicializa capacidade, tamanho e o array)  
    public Map() {
        capacidade = 30;
        bucketArray = new HashNode[capacidade];
        tamanho = 0;

        // Cria array vazios
        for (int i = 0; i < capacidade; i++) {
            bucketArray[i] = (null);
        }
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean isEmpty() {
        return tamanho() == 0;
    }

    // Implementa uma função para encontrar o índice da chave
    private int getBucketIndex(id_aluno key) {
        int hashCode = key.hashCode();
        int index = hashCode % capacidade;
        return index;
    }

    // Adicionar valores para a tabela
    public void add(id_aluno key, if_aluno value) {

        //Encontra o elemento do topo da cadeia para a chave fornecida 
        int bucketIndex = getBucketIndex(key);
        HashNode<id_aluno, if_aluno> head = null;
        for (bucketIndex = 0; bucketIndex < tamanho; bucketIndex++) {
            head = bucketArray[bucketIndex];
            break;
        }

        // Verifica se o valor está presente 
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.proximo;
        }

        //Insere a chave na cadeia 
        tamanho++;
        for (bucketIndex = 0; bucketIndex < tamanho; bucketIndex++) {
            head = bucketArray[bucketIndex];
            break;
        }
        HashNode<id_aluno, if_aluno> newNode = new HashNode<id_aluno, if_aluno>(key, value);
        newNode.proximo = head;
        bucketArray[bucketIndex] = newNode;

        // Se chegar a 75% da capacidade  da tabela ele duplica o valor da tabela  
        if ((1.0 * tamanho) / capacidade >= 0.75) {
            HashNode<id_aluno, if_aluno>[] temp = bucketArray;
            capacidade = 2 * capacidade;
            bucketArray = new HashNode[capacidade];
            tamanho = 0;
            for (int i = 0; i < capacidade; i++) {
                bucketArray[i] = (null);
            }
            for (HashNode<id_aluno, if_aluno> headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.proximo;
                }
            }
        }
    }

    // Método de remover um elemento 
    public if_aluno remove(id_aluno key) {

        int bucketIndex = getBucketIndex(key);

        // Obter topo  
        HashNode<id_aluno, if_aluno> head = null;
        for (bucketIndex = 0; bucketIndex < tamanho; bucketIndex++) {
            head = bucketArray[bucketIndex];
            break;
        }

        // Procurar pelo número do aluno 
        HashNode<id_aluno, if_aluno> anterior = null;
        while (head != null) {
            // Se o número foi encontrado 
            if (head.key.equals(key)) {
                break;
            }
            // Senão continua para o próximo
            anterior = head;
            head = head.proximo;
        }

        // Caso não exista o número de aluno correspondente 
        if (head == null) {
            System.out.print("Esse número nao corresponde a qualquer aluno.");
            return null;
        }

        // Reduz tamanho 
        tamanho--;

        // Remove o aluno
        if (anterior != null) {
            anterior.proximo = head.proximo;
            System.out.print("O aluno foi removido!");
        } else {
            bucketArray[bucketIndex] = head.proximo;
        }
        return head.value;
    }

    // Retorna as informações do aluno correspondente 
    public if_aluno get(id_aluno chave) {

        int bucketIndex = getBucketIndex(chave);

        //Percorrer o Array
        HashNode<id_aluno, if_aluno> head = null;
        for (bucketIndex = 0; bucketIndex < tamanho; bucketIndex++) {
            head = bucketArray[bucketIndex];
            break;
        }

        // Pesquisa pelo Aluno no array 
        while (head != null) {
            if (head.key.equals(chave)) {
                return head.value;
            }
            head = head.proximo;
        }
        return null;
    }
    
    

    @Override
    public String toString() {
        HashNode<id_aluno, if_aluno> head = null;
        for (int bucketIndex = 0; bucketIndex < tamanho; bucketIndex++) {
            System.out.println(head.hashCode());
        }
        return null;   
}
}

