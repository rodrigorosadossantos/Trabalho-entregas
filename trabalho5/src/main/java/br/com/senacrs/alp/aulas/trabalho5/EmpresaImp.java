package br.com.senacrs.alp.aulas.trabalho5;

import br.com.senacrs.alp.aulas.MinhaLista;
import br.com.senacrs.alp.aulas.MinhaListaImp;

public class EmpresaImp implements Empresa {
	 MinhaLista<Funcionario> listaFuncionario = new MinhaListaImp<Funcionario>();

	@Override
	public void adicionaFuncionario(Funcionario funcionario) {
		if(funcionario == null){
			throw new IllegalArgumentException();
		}
		listaFuncionario.prefixar(funcionario);
	}

	@Override
	public Funcionario buscaFuncionario(String nome) {

		Funcionario funcionario = null;
		FuncionarioImp funcionarioimp = null;
		Funcionario resultado = null;

		for (int i = 0; i < listaFuncionario.tamanho(); i++) {

			funcionario = listaFuncionario.buscar(i);
			funcionarioimp = cast(funcionario);

			if(nome == funcionarioimp.getNome()){
				resultado = funcionario;
				break;
			}

		}

		return resultado;
	}

	@Override
	public int totalFolhaPgto() {

		Funcionario funcionario = null;
		FuncionarioImp funcionarioimp = null;
		int resultado = 0;

		for (int i = 0; i < listaFuncionario.tamanho(); i++) {

			funcionario = listaFuncionario.buscar(i);
			funcionarioimp = cast(funcionario);

			resultado += funcionarioimp.getSalario();

		}

		return resultado;
	}

	private FuncionarioImp cast(Funcionario funcionario){

		return (FuncionarioImp) funcionario;

	}
}
