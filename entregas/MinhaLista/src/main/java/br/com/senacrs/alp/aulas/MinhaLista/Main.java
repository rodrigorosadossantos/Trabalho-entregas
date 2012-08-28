package br.com.senacrs.alp.aulas.MinhaLista;

public class Main 
{
	public static void main(String[] args)
	{
		MinhaLista<String> lista =
				new MinhaListaImp<String>("inicio");
		
		MinhaLista<Integer> lista2 = 
				new MinhaListaImp<Integer>(Integer.valueOf(0));
		
		System.out.println(lista2.tamanho());
		System.out.println(lista2.buscar(0));
		lista.prefixar("novoInicio");
		lista.sufixar("novoFim");
		System.out.println(lista2.tamanho());
			
	}

}
