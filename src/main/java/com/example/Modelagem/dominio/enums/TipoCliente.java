package com.example.Modelagem.dominio.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Física"), PESSOAJURIDICA(2, "Pessoa Juridica");

	private Integer cod;
	private String descricao;

	private TipoCliente(int cod, String descrição) {
		this.cod = cod;
		this.descricao = descrição;

	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoCliente toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoCliente x : TipoCliente.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}

		}
		throw new IllegalArgumentException("Id Invalido:" + cod);
	}
}
