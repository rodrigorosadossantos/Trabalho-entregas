package br.com.senacrs.alp.aulas.MinhaLista;

public class MinhaListaImp<Tipo> implements MinhaLista<Tipo> {

	private Nodo<Tipo> inicio = null;

	public MinhaListaImp(Tipo valorInicio) {
		
	
		inicio = new Nodo<Tipo>(null);
	
	}
	public Nodo<Tipo> getInicio() {
		return inicio;
	}

	public void setInicio(Nodo<Tipo> inicio) {
		this.inicio = inicio;
	}

	public void sufixar(Tipo valor) {

		Nodo<Tipo> ultimo = buscarUltimoNodo();
		Nodo<Tipo> novoUltimo = new Nodo<Tipo>(valor);

		ultimo.setProximo(novoUltimo);
	}

	private Nodo<Tipo> buscarUltimoNodo() {
		int tamanho = tamanho();
		Nodo<Tipo> resultado = buscarNodo(tamanho - 1);

		return resultado;
	}

	public Nodo<Tipo> buscarNodo(int posicao) {
		
		Nodo<Tipo> resultado = getInicio();

		for (int i = -1; i < posicao; i++) {
			resultado = resultado.getProximo();
		}

		return resultado;
	}

	public void prefixar(Tipo valor) {
		
		Nodo<Tipo> nodo = new Nodo<Tipo>(valor);
		Nodo inicio = getInicio();
		Nodo inicioReal = inicio.getProximo();
		
		nodo.setProximo(inicioReal);
		inicio.setProximo(nodo);//feito em aula
		
		/*Nodo<Tipo> primeiro = buscarPrimeiroNodo();
		Nodo<Tipo> novoPrimeiro = new Nodo<Tipo>(valor);
		novoPrimeiro.setProximo(primeiro);
		
		setInicio(novoPrimeiro);*/

	}


	public Tipo buscar(int posicao) {
		
		Nodo<Tipo> nodo = buscarNodo(posicao);

		return nodo.getValor();

	}

	public void inserir(int posicao, Tipo valor) {
	
		Nodo<Tipo> anterior = buscarNodo(posicao - 1);
		Nodo<Tipo> nodo = new Nodo<Tipo>(valor);
		Nodo<Tipo> proximo = anterior.getProximo();

		anterior.setProximo(nodo);
		nodo.setProximo(proximo);
	}

	public Tipo remover(int posicao) {
		
	   Nodo<Tipo> anterior = buscarNodo(posicao -1);
	   Nodo<Tipo> resultado = anterior.getProximo();
	   Nodo<Tipo> proximo = resultado.getProximo();
	   
	   anterior.setProximo(proximo);
	   
	   return resultado.getValor();
		
		
		
		/*Nodo<Tipo> anterior = buscarNodo(posicao - 1);
		Nodo<Tipo> nodo = anterior.getProximo();
		Nodo<Tipo> proximo = nodo.getProximo();

		anterior.setProximo(proximo);

		return nodo.getValor();*/
	}

	public int tamanho() {
		Nodo<Tipo> nodo = getInicio();
		int resultado = 1;

		while (nodo.getProximo() != null) {
			nodo = nodo.getProximo();
			resultado++;
		}

		return resultado;
	}

}
