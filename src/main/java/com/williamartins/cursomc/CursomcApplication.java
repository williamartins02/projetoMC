package com.williamartins.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.williamartins.cursomc.domain.Categoria;
import com.williamartins.cursomc.domain.Cidade;
import com.williamartins.cursomc.domain.Cliente;
import com.williamartins.cursomc.domain.Endereco;
import com.williamartins.cursomc.domain.Estado;
import com.williamartins.cursomc.domain.ItemPedido;
import com.williamartins.cursomc.domain.Pagamento;
import com.williamartins.cursomc.domain.PagamentoComBoleto;
import com.williamartins.cursomc.domain.PagamentoComCartao;
import com.williamartins.cursomc.domain.Pedido;
import com.williamartins.cursomc.domain.Produto;
import com.williamartins.cursomc.domain.enums.EstadoPagamento;
import com.williamartins.cursomc.domain.enums.TipoCliente;
import com.williamartins.cursomc.repositories.CategoriaRepository;
import com.williamartins.cursomc.repositories.CidadeRepository;
import com.williamartins.cursomc.repositories.ClienteRepository;
import com.williamartins.cursomc.repositories.EnderecoRepository;
import com.williamartins.cursomc.repositories.EstadoRepository;
import com.williamartins.cursomc.repositories.ItemPedidoRepository;
import com.williamartins.cursomc.repositories.PagamentoRepository;
import com.williamartins.cursomc.repositories.PedidoRepository;
import com.williamartins.cursomc.repositories.ProdutoRepository;

/*Classe prncipal para executar o projeto.*/
@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	/*
	 * metodo auxiliar que permiti executar alguma ação quando a aplicação é
	 * iniciada implements CommandLineRunner inserindo categorias no banco de dados.
	 */
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto (null, "Computador", 2000.00);
		Produto p2 = new Produto (null, "Impressora", 800.00);
		Produto p3 = new Produto (null, "Mouse", 80.00);
		Produto p4 = new Produto (null, "Teclado", 10.00);
		Produto p5 = new Produto (null, "Tela", 150.00);
		Produto p6 = new Produto (null, "Mesa", 250.00);
		
		/*Separando cada produto por suas categorias.*/
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
		cat2.getProdutos().addAll(Arrays.asList(p2, p6));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat1));
		p5.getCategorias().addAll(Arrays.asList(cat1));
		p6.getCategorias().addAll(Arrays.asList(cat1,cat2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));	
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
/*=============================================================================================================================.*/
		
		/*adicionando estado e cidades.
		 * quando é muitos pra um a associação faz dentro do construtor*/
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		Estado est3 = new Estado(null, "Espírito Santo");
		Estado est4 = new Estado(null, "Rio de Janeiro");
		
		
		Cidade c1 = new Cidade(null, "Uberlândlia", est1);
		Cidade c2 = new Cidade(null, "Belo Horizonte", est1); 
		
		Cidade c3 = new Cidade(null, "São Paulo", est2);
		Cidade c4 = new Cidade(null, "Campinas", est2);
		Cidade c5 = new Cidade(null, "Guarulhos", est2);
		
		Cidade c6 = new Cidade(null, "Afonso Cláudio", est3); 
		Cidade c7 = new Cidade(null, "Água Doce do Norte", est3); 
		
		Cidade c8 = new Cidade(null, "Angra dos Reis", est4);
		Cidade c9 = new Cidade(null, "Arraial do Cabo", est4);
		
		est1.getCidades().addAll(Arrays.asList(c1, c2));
		est2.getCidades().addAll(Arrays.asList(c3, c4, c5));
		est3.getCidades().addAll(Arrays.asList(c6, c7));
		est4.getCidades().addAll(Arrays.asList(c8, c9));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2, est3, est4));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9));
/*=============================================================================================================================.*/
		
		/*Salvando Cliente no banco de dados.*/
		Cliente cli1 = new Cliente(null, "Dayane Silva","dadazinha00@gmail.com","699.897.680-13", TipoCliente.PESSOAFISICA);
		Cliente cli2 = new Cliente(null, "William Martins","will100@gmail.com","913.848.710-12", TipoCliente.PESSOAFISICA);
		Cliente cli3 = new Cliente(null, "Giovanna Fátima da Rosa","giovannafatimadarosa@lexos.com.br","26.874.793/0001-61", TipoCliente.PESSOAJURIDICA);
		Cliente cli4 = new Cliente(null, "Benjamin Caleb Caldeira","benjamincalebcaldeira@regler.com.br","53.639.468/0001-97", TipoCliente.PESSOAJURIDICA);
		
		cli1.getTelefones().addAll(Arrays.asList("(11) 3696-3950","(11) 99787-7418"));
		cli2.getTelefones().addAll(Arrays.asList("(11) 50905-8745","(11) 85436-9465"));
		cli3.getTelefones().addAll(Arrays.asList("(21) 50905-8745","(21) 85436-9465"));
		cli4.getTelefones().addAll(Arrays.asList("(28) 56296-0307", "(28) 71288-2112"));
		
		Endereco e1 = new Endereco(null, "Rua Luiz Fuad AbibUberlândia", "300", "Apt-303", "Jardim","38411-453",cli1, c1);
		Endereco e2 = new Endereco(null, "Rua casa do ator", "294", "casa A", "Tagariuna","04546-001",cli2, c3);
		Endereco e3 = new Endereco(null, "Rua Angra dos Reis", "151", "Sala A-21", "Penha","25485-001",cli3, c8);
		Endereco e4 = new Endereco(null, "Rua das flores", "02", "Bloco-X1-00", "Martin","04577-021",cli4, c7);
		Endereco e5 = new Endereco(null, "Rua Luiz Belo Horizonte", "12", "GalpãoG1", "Jardim","34567-453",cli1, c1);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1));
		cli2.getEnderecos().addAll(Arrays.asList(e2));
		cli3.getEnderecos().addAll(Arrays.asList(e3));
		cli4.getEnderecos().addAll(Arrays.asList(e4));
		cli1.getEnderecos().addAll(Arrays.asList(e5));
		
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3,cli4));
		enderecoRepository.saveAll(Arrays.asList(e1,e2,e3,e4,e5));
/*====================================================================================================.*/
		
		/*Salvar pagamentos no banco e forma de pagamento...*/
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); 
		
		Pedido ped1 = new Pedido(null, sdf.parse("01/04/202021 10:32"), cli1, e1); 
		Pedido ped2 = new Pedido(null, sdf.parse("05/04/2021 19:35"), cli1, e2); 
		Pedido ped3 = new Pedido(null, sdf.parse("07/04/2021 13:35"), cli4, e4);
		Pedido ped4 = new Pedido(null, sdf.parse("02/04/2021 20:35"), cli3, e4);
		 
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6); 
		ped1.setPagamento(pagto1);  
		

        Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null); 
        ped2.setPagamento(pagto2); 
        
        Pagamento pagto3 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped3, 7); 
      		ped3.setPagamento(pagto3);
      		
        Pagamento pagto4 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped4, 9); 
		ped4.setPagamento(pagto4); 
		
		
        
        cli1.getPedidos().addAll(Arrays.asList(ped1, ped2)); 
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2,ped3)); 
		pagamentoRepository.saveAll(Arrays.asList(pagto2, pagto2, pagto3, pagto4)); 
		
/*====================================================================================================.*/
		
		/*SAlvando os pedidos no banco*/
		 ItemPedido ip1 = new ItemPedido(ped1, p1, 0.0, 1, 200.00);
		 ItemPedido ip2 = new ItemPedido(ped1, p3, 0.0, 2, 80.00);
		 ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		 
		 ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		 ped2.getItens().addAll(Arrays.asList(ip3));
		 
		 p1.getItens().addAll(Arrays.asList(ip1));
		 p1.getItens().addAll(Arrays.asList(ip3));
		 p1.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
/*====================================================================================================.*/
		
	}

}
