package com.example.Modelagem.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.example.Modelagem.services.validation.ClienteInsert;

@ClienteInsert
public class ClienteNewDto implements Serializable {

	private static final long serialVersionUID = 1L;

	// dados do cliente
	@NotEmpty(message = "preenchimento obrigatorio")
	@Length(min = 5, max = 120, message = "O tamanho do nome deve ser entre 5 e 120 caracteres")
	private String nome;
	@NotEmpty(message = "preenchimento obrigatorio")
	@Email(message = "E-mail inválido")
	private String email;
	@NotEmpty(message = "preenchimento CPF obrigatorio")
	@Pattern(regexp = "[0-9]+", message = "Preencher apenas com numeros")
	private String cpfOuCnpj;

	private Integer tipo;

	// dados do endereço
	@NotEmpty(message = "preenchimento logradouro obrigatorio")
	private String logradouro;
	@NotEmpty(message = "preenchimento numero obrigatorio")
	private String numero;
	private String complemento;
	private String bairro;
	@NotEmpty(message = "preenchimento cep obrigatorio")
	private String cep;
	@NotEmpty(message = "preenchimento de pelo menos um telefone obrigatorio")
	private String telefone1;
	private String telefone2;
	private String telefone3;

	private Integer cidadeId;

	public ClienteNewDto() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}

}
