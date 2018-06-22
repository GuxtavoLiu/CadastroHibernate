package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.DAOProduto;
import modelo.Produto;

@ManagedBean
@ViewScoped
public class ProdutoMB {
	private Produto produto = new Produto();
	private List<Produto> produtos = new ArrayList<>();
	private DAOProduto daoProduto = new DAOProduto();

	// ↓↓↓↓↓↓↓↓↓ usado para buscar e apresentar na table os dados que estão no banco de dados
	public ProdutoMB() {
		produtos = daoProduto.buscarTodos();
	}

	public void inserir() {
		if (produto.getId() == null) {
			daoProduto.salvar(produto);
			produtos = daoProduto.buscarTodos();
			produto = new Produto();
		} else {
			daoProduto.alterar(produto);
		}
	}

	public void excluir(Long id) {
		daoProduto.excluir(id);
		produtos = daoProduto.buscarTodos();
	}

	public DAOProduto getDaoProduto() {
		return daoProduto;
	}

	public void setDaoProduto(DAOProduto daoProduto) {
		this.daoProduto = daoProduto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
