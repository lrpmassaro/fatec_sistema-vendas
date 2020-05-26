/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProdutoDAO;
import java.util.List;
import model.Produto;

/**
 *
 * @author Professor
 */
public class ProdutoController {
    
    private ProdutoDAO dao;
    
    // método para cadastrar os Produtos
    public boolean cadastrar(Produto produto) throws Exception{
        dao = new ProdutoDAO();
        if(produto != null){
            dao.salvar(produto);
            return true;
        }else{
            return false;
        }
    }

    // método para pesquisar Produto pelo nome
    public List pesquisar(String nome) throws Exception{
        dao = new ProdutoDAO();
        List<Produto> lista = dao.listaNome(nome);
        if(!lista.isEmpty()){
            return lista;
        }else{
            return null;
        }
    }

    // método para pesquisar Produto pelo codigo
    public List pesquisar(int codigo) throws Exception{
        dao = new ProdutoDAO();
        List<Produto> lista = dao.listaCodigo(codigo);
        if(!lista.isEmpty()){
            return lista;
        }else{
            return null;
        }
    }

    // método para obter o último código de Produto
    public int getUltimoCodigo() throws Exception{
        dao = new ProdutoDAO();
        return dao.getUltimoCodigo();
    }

    // método para retornar a lista de Produtos cadastrados
    public List<Produto> getTodosProdutos() throws Exception{
        dao = new ProdutoDAO();
        return dao.todosProdutos();
    }

    public boolean alterar(Produto produto) throws Exception{
        dao = new ProdutoDAO();
        if(produto != null){
            dao.atualizar(produto);
            return true;
        }else{
            return false;
        }
    }

    public boolean excluir(Produto produto) throws Exception{
        dao = new ProdutoDAO();
        if(produto != null){
            dao.excluir(produto);
            return true;
        }else{
            return false;
        }
    }
}
