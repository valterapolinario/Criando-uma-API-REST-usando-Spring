package com.example.Modelagem;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Modelagem.dominio.Categoria;
import com.example.Modelagem.dominio.Cidade;
import com.example.Modelagem.dominio.Cliente;
import com.example.Modelagem.dominio.Endereco;
import com.example.Modelagem.dominio.Estado;
import com.example.Modelagem.dominio.Pagamento;
import com.example.Modelagem.dominio.PagamentoBoleto;
import com.example.Modelagem.dominio.PagamentoCartao;
import com.example.Modelagem.dominio.Pedido;
import com.example.Modelagem.dominio.Produto;
import com.example.Modelagem.dominio.enums.EstadoPagamento;
import com.example.Modelagem.dominio.enums.TipoCliente;
import com.example.Modelagem.repositorios.CategoriaRepositorio;
import com.example.Modelagem.repositorios.CidadeRepositorio;
import com.example.Modelagem.repositorios.ClienteRepositorio;
import com.example.Modelagem.repositorios.EnderecoRepositorio;
import com.example.Modelagem.repositorios.EstadoRepositorio;
import com.example.Modelagem.repositorios.PagamentoRepositorio;
import com.example.Modelagem.repositorios.PedidoRepositorio;
import com.example.Modelagem.repositorios.ProdutoRepositorio;

@SpringBootApplication
public class ModelagemConceitualApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	@Autowired
	private EstadoRepositorio estadoRespositorio;
	@Autowired
	private CidadeRepositorio cidadeRepositorio;
	@Autowired
	private EnderecoRepositorio enderecoRepositorio;
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	@Autowired
	private PagamentoRepositorio pagamentoRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(ModelagemConceitualApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "escritorio");

		Produto p1 = new Produto(null, "computador", 2000);
		Produto p2 = new Produto(null, "impressora", 800);
		Produto p3 = new Produto(null, "mouse", 80);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p1));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepositorio.saveAll(Arrays.asList(cat1, cat2));

		produtoRepositorio.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "minas gerais");
		Estado est2 = new Estado(null, "Sao paulo");

		Cidade c1 = new Cidade(null, "uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRespositorio.saveAll(Arrays.asList(est1, est2));
		cidadeRepositorio.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "maria Silva", "Maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Mattos", "105", "sala 800", "Centro", "38777012", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepositorio.saveAll(Arrays.asList(cli1));
		enderecoRepositorio.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

		Pagamento pagto1 = new PagamentoCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),
				null);
		ped2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepositorio.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepositorio.saveAll(Arrays.asList(pagto1, pagto2));
	}

}
