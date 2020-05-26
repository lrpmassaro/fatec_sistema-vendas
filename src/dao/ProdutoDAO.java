/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Produto;
import util.ConnectionFactory;

/**
 *
 * @author Professor
 */
public class ProdutoDAO {

    // declaração de variável de instância
    private Connection conn;

    // construtor
    public ProdutoDAO() throws Exception {
        try{
            this.conn = ConnectionFactory.getConnection();
        }catch(Exception exception){
            throw new Exception(exception.getMessage());
        }
    }

    // método para salvar os dados do objeto Produto
    public void salvar(Produto produto) throws Exception{
        // variável para armazenar referência do PreparedStatement
        PreparedStatement ps = null;
        // verifica se produto é null
        if(produto == null){
            throw new Exception("Erro: produto não pode ser nulo.");
        }
        try{
            String SQL = "INSERT INTO produtos(nome, categoria, estoque, precoCusto, precoVenda) " +
                    "values(?,?,?,?,?)";
            // obtém instância de um objeto PreparedStatement
            ps = this.conn.prepareStatement(SQL);
            // configura a conexão
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getCategoria());
            ps.setInt(3, produto.getEstoque());
            ps.setDouble(4, produto.getPrecoCusto());
            ps.setDouble(5, produto.getPrecoVenda());
            // executa a instrução
            ps.executeUpdate();
        }catch(SQLException sqlException){
            throw new Exception("Erro ao inserir dados: " +
                    sqlException.getMessage());
        }finally{
            ConnectionFactory.closeConnection(conn, ps);
        }
    }

    // método para atualizar dados do Produto
    public void atualizar(Produto produto) throws Exception{
        // variável para armazenar a referência de PreparedStatement
        PreparedStatement ps = null;
        // verifica se produto é nulo
        if(produto == null){
            throw new Exception("Erro: produto não pode ser nulo.");
        }
        try{
            String SQL = "UPDATE produtos SET nome=?," +
                    "categoria=?," +
                    "estoque=?," +
                    "precoCusto=?," +
                    "precoVenda=?" +
                    " WHERE codigo=?";
            // obtém instância de PreparedStatement
            ps = this.conn.prepareStatement(SQL);
            // configura a instrução
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getCategoria());
            ps.setInt(3, produto.getEstoque());
            ps.setDouble(4, produto.getPrecoCusto());
            ps.setDouble(5, produto.getPrecoVenda());
            ps.setInt(6, produto.getCodigo());
            // executa a instrução
            ps.executeUpdate();
        }catch(SQLException sqlException){
            throw new Exception("Erro ao atualizar dados: " +
                    sqlException.getMessage());
        }finally{
            ConnectionFactory.closeConnection(conn, ps);
        }
    }

    // método para excluir dados de Produto
    public void excluir(Produto produto) throws Exception{
        // variável para armazenar a referência de PreparedStatement
        PreparedStatement ps = null;
        // verifica se produto é nulo
        if(produto == null){
            throw new Exception("Erro: produto não pode ser nulo.");
        }
        try{
            // obtém instância de PreparedStatement
            ps = this.conn.prepareStatement("DELETE FROM produtos " +
                    "WHERE codigo=?");
            // configura a instrução
            ps.setInt(1, produto.getCodigo());
            // executa a instrução
            ps.executeUpdate();
        }catch(SQLException sqlException){
            throw new Exception("Erro ao excluir dados: " +
                    sqlException.getMessage());
        }finally{
            ConnectionFactory.closeConnection(conn, ps);
        }
    }

    // método para listar os dados de todos Produtos
    public List todosProdutos() throws Exception{
        // variável para armazenar a referência de PreparedStatement
        PreparedStatement ps = null;
        // variável para armazenar a referência de ResultSet
        ResultSet rs = null;
        try{
            // obtém instância e configura o PreparedStatement
            ps = this.conn.prepareStatement("SELECT * FROM produtos");
            // executa a instrução e armazena o resultado em ResultSet
            rs = ps.executeQuery();
            List<Produto> lista = new ArrayList<Produto>();
            while(rs.next()){
                Integer codigo = rs.getInt(1);
                String nome = rs.getString(2);
                String categoria = rs.getString(3);
                int estoque = rs.getInt(4);
                double precoCusto = rs.getDouble(5);
                double precoVenda = rs.getDouble(6);
                // instancia um novo produto e insere na lista
                lista.add(new Produto(codigo,nome,categoria,estoque,precoCusto,precoVenda));
            }
            return lista;
        }catch(SQLException sqlException){
            throw new Exception("Erro ao consultar dados: " +
                    sqlException.getMessage());
        }finally{
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
    }

    // método para consultar produtos através do código
    public List listaCodigo(int codigo) throws Exception{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = this.conn.prepareStatement("SELECT * FROM produtos WHERE codigo=?");
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            List<Produto> lista = new ArrayList<Produto>();
            while(rs.next()){
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt(1));
                produto.setNome(rs.getString(2));
                produto.setCategoria(rs.getString(3));
                produto.setEstoque(rs.getInt(4));
                produto.setPrecoCusto(rs.getDouble(5));
                produto.setPrecoVenda(rs.getDouble(6));
                lista.add(produto);
            }
            return lista;
        }catch(SQLException sqlException){
            throw new Exception("Erro ao consultar dados: " +
                    sqlException);
        }finally{
            ConnectionFactory.closeConnection(conn, ps, rs);
        }

    }

    // método para consultar produtos através do nome
    public List listaNome(String nome) throws Exception{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String SQL = "SELECT * FROM produtos WHERE lower(nome) like lower('" + nome + "%')";
            ps = this.conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<Produto> lista = new ArrayList<Produto>();
            while(rs.next()){
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt(1));
                produto.setNome(rs.getString(2));
                produto.setCategoria(rs.getString(3));
                produto.setEstoque(rs.getInt(4));
                produto.setPrecoCusto(rs.getDouble(5));
                produto.setPrecoVenda(rs.getDouble(6));
                lista.add(produto);
            }
            return lista;
        }catch(SQLException sqlException){
            throw new Exception("Erro ao consultar dados: " +
                    sqlException);
        }finally{
            ConnectionFactory.closeConnection(conn, ps, rs);
        }

    }

    public int getUltimoCodigo() throws Exception{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String SQL = "SELECT last_value FROM produtos_codigo_seq";
            ps = this.conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            int codigo = 0;
            if(rs.next()){
                codigo = rs.getInt(1);
            }
            return codigo;
        }catch(SQLException sqlException){
            throw new Exception("Erro ao consultar dados: " +
                    sqlException);
        }finally{
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
    }

 
}
