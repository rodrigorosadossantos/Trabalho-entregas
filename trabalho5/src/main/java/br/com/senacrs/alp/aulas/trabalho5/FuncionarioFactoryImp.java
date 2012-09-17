package br.com.senacrs.alp.aulas.trabalho5;

public class FuncionarioFactoryImp implements FuncionarioFactory {

	private static FuncionarioFactoryImp instanciaFuncionario;
	
	@Override
	public Funcionario criaFuncionario(String nome, int salario) {
		
		if(nome == null){
			throw new IllegalArgumentException();
		}
		if(nome == ""){
			throw new IllegalArgumentException();
		}
		if(salario < 0){
			throw new IllegalArgumentException();
		}
		
		FuncionarioImp func = new FuncionarioImp(nome, salario);
		
		return func;
	}

	 static FuncionarioFactoryImp getInstancia(){
		 return FuncionarioFactoryImp.instanciaFuncionario;
	}
}
