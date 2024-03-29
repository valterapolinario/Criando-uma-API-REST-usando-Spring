package com.example.Modelagem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Modelagem.dominio.Cidade;
import com.example.Modelagem.dominio.Cliente;
import com.example.Modelagem.dominio.Endereco;
import com.example.Modelagem.dominio.enums.TipoCliente;
import com.example.Modelagem.dto.ClienteDTO;
import com.example.Modelagem.dto.ClienteNewDto;
import com.example.Modelagem.repositorios.CidadeRepositorio;
import com.example.Modelagem.repositorios.ClienteRepositorio;
import com.example.Modelagem.repositorios.EnderecoRepositorio;
import com.example.Modelagem.services.exceptions.DataIntegrityException;
import com.example.Modelagem.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepositorio clienteRepo;
	@Autowired
	EnderecoRepositorio enderecoRepo;
	@Autowired
	CidadeRepositorio cidadeRepo;

	@Transactional
	public Cliente insert(Cliente obj) {

		obj.setId(null);

		obj = clienteRepo.save(obj);

		enderecoRepo.saveAll(obj.getEnderecos());

		return obj;

	}

	public List<Cliente> findAll() {
		return clienteRepo.findAll();
	}

	public Cliente findById(Integer id) {
		Optional<Cliente> obj = clienteRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));

	}

	public Cliente update(Cliente obj) {

		Cliente newObj = findById(obj.getId());
		updateData(newObj, obj);
		return clienteRepo.save(newObj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			clienteRepo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("não é possivel exluir um Cliente que contenha pedidos");
		}
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		return clienteRepo.findAll(pageRequest);

	}

	public Cliente toClie(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
	}

	public Cliente toClie(ClienteNewDto objDto) {
		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(),
				TipoCliente.toEnum(objDto.getTipo()));

		Optional<Cidade> optionalCidade = cidadeRepo.findById(objDto.getCidadeId());

		Cidade cid = optionalCidade.get();

		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(),
				objDto.getBairro(), objDto.getCep(), cli, cid);

		cli.getEnderecos().add(end);

		cli.getTelefones().add(objDto.getTelefone1());

		if (objDto.getTelefone2() != null) {

			cli.getTelefones().add(objDto.getTelefone2());

		}

		if (objDto.getTelefone3() != null) {

			cli.getTelefones().add(objDto.getTelefone3());

		}

		return cli;

	}

	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
}
