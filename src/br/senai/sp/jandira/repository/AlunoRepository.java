package br.senai.sp.jandira.repository;

import br.senai.sp.jandira.model.Aluno;

public class AlunoRepository {
	
	private Aluno[] turma;
	
	//criando esses dois métodos, podemos criar uma turma padrão ou com uma quantidade qualquer de alunos
	public AlunoRepository() {
		
		 turma = new Aluno[32];
	}
	
	public AlunoRepository(int quantidadeDeAlunos) {
		
		 turma = new Aluno[quantidadeDeAlunos];
	}
	
	public void salvarAluno(Aluno aluno, int posicao) {
		turma[posicao] = aluno;
	}
	
	//dessa maneira, sem os colchetes, dizemos que queremos apenas um aluno da coleção
	public Aluno listarAluno(int posicao) {
		return turma[posicao];
	}
	
	//dessa maneira, com os colchetes, dizemos que queremos toda a coleção
	public Aluno[] listarTodos() {
		return turma;
	}

}
