package br.senai.sp.jandira.repository;

import br.senai.sp.jandira.model.Aluno;

public class AlunoRepository {
	
	private Aluno[] turma;
	
	//criando esses dois m�todos, podemos criar uma turma padr�o ou com uma quantidade qualquer de alunos
	public AlunoRepository() {
		
		 turma = new Aluno[32];
	}
	
	public AlunoRepository(int quantidadeDeAlunos) {
		
		 turma = new Aluno[quantidadeDeAlunos];
	}
	
	public void salvarAluno(Aluno aluno, int posicao) {
		turma[posicao] = aluno;
	}
	
	//dessa maneira, sem os colchetes, dizemos que queremos apenas um aluno da cole��o
	public Aluno listarAluno(int posicao) {
		return turma[posicao];
	}
	
	//dessa maneira, com os colchetes, dizemos que queremos toda a cole��o
	public Aluno[] listarTodos() {
		return turma;
	}

}
