package br.senai.sp.jandira.model;

public enum Periodo {
	
	//assim podemos personalizar nosso enum, deixando mais adequado com acentua��o etc
	//ele se torna c�digo quando fazemos essas altera��es, por esse motivo temnos que utilizar ";" ao final das frases
	
	MANHA("Manh�"),
	TARDE("Tarde"),
	NOITE("Noite");
	
	private String descricao;
	
	//o enum n�o permite que o m�todo construtor seja p�blico, afinal ele � uma lista fixa!
	
	private Periodo(String descricao) {
		this.descricao = descricao;
	}
	
	
	public String getDescricao() {
		return descricao;
	}

}
