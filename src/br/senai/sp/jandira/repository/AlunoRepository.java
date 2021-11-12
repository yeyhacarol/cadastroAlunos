package br.senai.sp.jandira.repository;

import br.senai.sp.jandira.model.Aluno;

public class AlunoRepository {
	
	private Aluno[] turma;
	
	//criando esses dois m�todos construtores, podemos criar uma turma padr�o ou com uma quantidade qualquer de alunos
	public AlunoRepository() {
		turma = new Aluno[32];
	}
	
	public AlunoRepository(int quantidadeDeAlunos) {
		 turma = new Aluno[quantidadeDeAlunos];
	}  
	
	//esse m�todo aloca um aluno numa determinada posi��o
	public void salvarAluno(Aluno aluno, int posicao) {
		turma[posicao] = aluno;
	}
	
	//dessa maneira, sem os colchetes, dizemos que queremos o retorno de apenas um aluno da cole��o
	public Aluno listarAluno(int posicao) {
		return turma[posicao];
	}
	
	//dessa maneira, com os colchetes, dizemos que queremos o retorno de toda a cole��o
	public Aluno[] listarTodos() {
		return turma;
	}
	
	//m�todo que retorna o tamanho total da turma 
	public int getTamanho() {
		return turma.length;
	}

}
