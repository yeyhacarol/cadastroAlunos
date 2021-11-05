package br.senai.sp.jandira.model;

public enum Periodo {
	
	//assim podemos personalizar nosso enum, deixando mais adequado com acentuação etc
	//ele se torna código quando fazemos essas alterações, por esse motivo temnos que utilizar ";" ao final das frases
	
	MANHA("Manhã"),
	TARDE("Tarde"),
	NOITE("Noite");
	
	private String descricao;
	
	//o enum não permite que o método construtor seja público, afinal ele é uma lista fixa!
	
	private Periodo(String descricao) {
		this.descricao = descricao;
	}
	
	
	public String getDescricao() {
		return descricao;
	}

}
