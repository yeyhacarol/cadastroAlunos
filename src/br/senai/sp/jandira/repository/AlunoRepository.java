package br.senai.sp.jandira.repository;

import br.senai.sp.jandira.model.Aluno;

public class AlunoRepository {
	
	private Aluno[] turma;
	
	//criando esses dois métodos construtores, podemos criar uma turma padrão ou com uma quantidade qualquer de alunos
	public AlunoRepository() {
		turma = new Aluno[32];
	}
	
	public AlunoRepository(int quantidadeDeAlunos) {
		 turma = new Aluno[quantidadeDeAlunos];
	}  
	
	//esse método aloca um aluno numa determinada posição
	public void salvarAluno(Aluno aluno, int posicao) {
		turma[posicao] = aluno;
	}
	
	//dessa maneira, sem os colchetes, dizemos que queremos o retorno de apenas um aluno da coleção
	public Aluno listarAluno(int posicao) {
		return turma[posicao];
	}
	
	//dessa maneira, com os colchetes, dizemos que queremos o retorno de toda a coleção
	public Aluno[] listarTodos() {
		return turma;
	}
	
	//método que retorna o tamanho total da turma 
	public int getTamanho() {
		return turma.length;
	}

}
