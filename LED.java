package led;

public class LED<T> {

    private Celula head;
    private int numitens;

    // classe interna
    private class Celula {
        T item;
        Celula prox;
    }

    // LISTA VAZIA
    public LED() {
        // desnecessarias em java
//		head = null; // obrigatorio em C++
//		numitens = 0;
    }

    // insercao no final
    public void inserir(T item) {
        if (item == null) {
            throw new NullPointerException("Item nulo");
        } else {
            // Lista vazia
            if (head == null) {
                head = new Celula();
                head.item = item;
                // head.prox = null; // desnecessario em java
            } else {
                // caminhar na lista ate encontrar a ultima celula
                Celula aux = head;
                while (aux.prox != null) {
                    aux = aux.prox;
                }
                // quando chegar aqui aux estara na ultima celula
                aux.prox = new Celula();
                aux.prox.item = item;
            }
            numitens++;
        }
    }

    public void inserir(int posicao, T item) {
        if (posicao < 0 || item == null) {
            throw new IllegalArgumentException("Valores invalidos!");
        } else {
            //procurar posicao de insercao
            Celula aux = head;//, ant = null;
            int cont = 0;
            while (aux != null && cont < posicao - 1) {
                // ant = aux;
                aux = aux.prox;
                cont++;

            }
            Celula novo = new Celula();
            novo.item = item;
            novo.prox = aux;
            //ant.prox = novo;
            if (aux == head) {
                head = novo;
            }
        }
    }

    public void excluir(int posicao) {
        if (head == null) {
            // lista vazia
            throw new ArrayIndexOutOfBoundsException("lista vazia");
        } else {
            // meio
            // localizar a celula que serah excluida
            Celula aux = head, ant = null;
            int cont = 0;
            if (posicao == 0) {
                head = aux.prox;
                numitens--;
            } else {
                while (cont < posicao) {
                    ant = aux;
                    aux = aux.prox;
                    cont++;
                }
                ant.prox = aux.prox;
                numitens--;
                
            }

        }
    }

    public T pesquisar(int posicao) {
        if (head == null) {
            // lista vazia
            throw new ArrayIndexOutOfBoundsException("lista vazia");
        } else {
            Celula aux = head, ant = null;
            int cont = 0;
            while (cont < posicao) {
                aux = aux.prox;
                cont++;
            }
            System.out.println(aux.item);
            return aux.item;

        }

    }
   public LED combinar(LED lista) {
        if (head == null) {
            throw new ArrayIndexOutOfBoundsException("lista vazia");
        } else {
            Celula aux = head;
            while (aux.prox != null) {
                aux = aux.prox;
            }
            aux.prox = lista.head;
            return lista;
        }
    }
    
    public LED clona() {
        if (head == null) {
            throw new ArrayIndexOutOfBoundsException("lista vazia");
        } else {
            LED nova = new LED();
            nova.head = head;
            return nova;
        }
    }

    @Override
    public String toString() {
        // Na pratica substituir String s por StringBuilder
        StringBuilder sb = new StringBuilder("[");
        // String s = "[";
        Celula aux = head;
        while (aux != null) {
            sb.append(aux.item);
            sb.append(", ");
            aux = aux.prox;
        }
        if (sb.length() > 2) {
            sb.delete(sb.length() - 2, sb.length()); // apagar o ", " do final
        }
        sb.append("]");
        return sb.toString();
    }
}
