package led;
public class TesteLED {
	public static void main(String[] args) {
		LED lista = new LED();
		lista.inserir(1);
		lista.inserir(2);
		lista.inserir(3);
		lista.inserir(4);
		lista.inserir(5);
                lista.inserir(6);
                System.out.println(lista);
                lista.excluir(0);
                System.out.println(lista);
              
//		lista.inserir(6);
//		System.out.println(lista);
	}
}
