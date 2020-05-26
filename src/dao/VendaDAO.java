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
import java.util.Date;
import java.util.List;
import model.Venda;
import util.ConnectionFactory;

/**
 *
 * @author Professor
 */
public class VendaDAO {

    // declaração de variável de instância
    private Connection conn;

    // construtor
    public VendaDAO() throws Exception {
        try{
            this.conn = ConnectionFactory.getConnection();
        }catch(Exception exception){
            throw new Exception(exception.getMessage());
        }
    }

    // método para salvar os dados do objeto Venda
    public void salvar(Venda venda) throws Exception{
        // variável para armazenar referência do PreparedStatement
        PreparedStatement ps = null;
        // verifica se venda é null
        if(venda == null){
            throw new Exception("Erro: venda não pode ser nulo.");
        }
        try{
            String SQL = "INSERT INTO vendas(data, codigoCliente, codigoProduto, quantidade, valorTotal) " +
                    "values(?,?,?,?,?)";
            // obtém instância de um objeto PreparedStatement
            ps = this.conn.prepareStatement(SQL);
            // configura a conexão
            ps.setDate(1, new java.sql.Date(venda.getData().getTime()));
            ps.setInt(2, venda.getCodigoCliente());
            ps.setInt(3, venda.getCodigoProduto());
            ps.setInt(4, venda.getQuantidade());
            ps.setDouble(5, venda.getValorTotal());
            // executa a instrução
            ps.executeUpdate();
        }catch(SQLException sqlException){
            throw new Exception("Erro ao inserir dados: " +
                    sqlException.getMessage());
        }finally{
            ConnectionFactory.closeConnection(conn, ps);
        }
    }

    // método para atualizar dados do Venda
    public void atualizar(Venda venda) throws Exception{
        // variável para armazenar a referência de PreparedStatement
        PreparedStatement ps = null;
        // verifica se venda é nulo
        if(venda == null){
            throw new Exception("Erro: venda não pode ser nulo.");
        }
        try{
            String SQL = "UPDATE vendas SET data=?," +
                    "codigoCliente=?," +
                    "codigoProduto=?," +
                    "quantidade=?" +
                    "valorTotal=?" +
                    " WHERE numero=?";
            // obtém instância de PreparedStatement
            ps = this.conn.prepareStatement(SQL);
            // configura a instrução
            ps.setDate(1, new java.sql.Date(venda.getData().getTime()));
            ps.setInt(2, venda.getCodigoCliente());
            ps.setInt(3, venda.getCodigoProduto());
            ps.setInt(4, venda.getQuantidade());
            ps.setDouble(5, venda.getValorTotal());
            // executa a instrução
            ps.executeUpdate();
        }catch(SQLException sqlException){
            throw new Exception("Erro ao atualizar dados: " +
                    sqlException.getMessage());
        }finally{
            ConnectionFactory.closeConnection(conn, ps);
        }
    }

    // método para excluir dados de Venda
    public void excluir(Venda venda) throws Exception{
        // variável para armazenar a referência de PreparedStatement
        PreparedStatement ps = null;
        // verifica se venda é nulo
        if(venda == null){
            throw new Exception("Erro: venda não pode ser nulo.");
        }
        try{
            // obtém instância de PreparedStatement
            ps = this.conn.prepareStatement("DELETE FROM vendas " +
                    "WHERE numero=?");
            // configura a instrução
            ps.setInt(1, venda.getNumero());
            // executa a instrução
            ps.executeUpdate();
        }catch(SQLException sqlException){
            throw new Exception("Erro ao excluir dados: " +
                    sqlException.getMessage());
        }finally{
            ConnectionFactory.closeConnection(conn, ps);
        }
    }

    // método para listar os dados de todos Vendas
    public List todosVendas() throws Exception{
        // variável para armazenar a referência de PreparedStatement
        PreparedStatement ps = null;
        // variável para armazenar a referência de ResultSet
        ResultSet rs = null;
        try{
            // obtém instância e configura o PreparedStatement
            ps = this.conn.prepareStatement("SELECT * FROM vendas");
            // executa a instrução e armazena o resultado em ResultSet
            rs = ps.executeQuery();
            List<Venda> lista = new ArrayList<Venda>();
            while(rs.next()){
                Integer numero = rs.getInt(1);
                Date data = rs.getDate(2);
                Integer codigoCliente = rs.getInt(3);
                Integer codigoProduto = rs.getInt(4);
                int quantidade = rs.getInt(5);
                double valorTotal = rs.getDouble(6);
                // instancia um novo venda e insere na lista
                lista.add(new Venda(numero,data,codigoCliente,
                        codigoProduto, quantidade, valorTotal));
            }
            return lista;
        }catch(SQLException sqlException){
            throw new Exception("Erro ao consultar dados: " +
                    sqlException.getMessage());
        }finally{
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
    }

    // método para consultar vendas através do código
    public List listaNumero(int numero) throws Exception{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = this.conn.prepareStatement("SELECT * FROM vendas WHERE numero=?");
            ps.setInt(1, numero);
            rs = ps.executeQuery();
            List<Venda> lista = new ArrayList<Venda>();
            while(rs.next()){
                Venda venda = new Venda();
                venda.setNumero(rs.getInt(1));
                venda.setData(rs.getDate(2));
                venda.setCodigoCliente(rs.getInt(3));
                venda.setCodigoProduto(rs.getInt(4));
                venda.setQuantidade(rs.getInt(5));
                venda.setValorTotal(rs.getDouble(6));
                lista.add(venda);
            }
            return lista;
        }catch(SQLException sqlException){
            throw new Exception("Erro ao consultar dados: " +
                    sqlException);
        }finally{
            ConnectionFactory.closeConnection(conn, ps, rs);
        }

    }

    // método para consultar vendas através da data
    public List listaData(Date data) throws Exception{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String SQL = "SELECT * FROM vendas WHERE data=?";
            ps = this.conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<Venda> lista = new ArrayList<Venda>();
            while(rs.next()){
                Venda venda = new Venda();
                venda.setNumero(rs.getInt(1));
                venda.setData(rs.getDate(2));
                venda.setCodigoCliente(rs.getInt(3));
                venda.setCodigoProduto(rs.getInt(4));
                venda.setQuantidade(rs.getInt(5));
                venda.setValorTotal(rs.getDouble(6));
                lista.add(venda);
            }
            return lista;
        }catch(SQLException sqlException){
            throw new Exception("Erro ao consultar dados: " +
                    sqlException);
        }finally{
            ConnectionFactory.closeConnection(conn, ps, rs);
        }

    }

    public int getUltimoNumero() throws Exception{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String SQL = "SELECT last_value FROM vendas_numero_seq";
            ps = this.conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            int numero = 0;
            if(rs.next()){
                numero = rs.getInt(1);
            }
            return numero;
        }catch(SQLException sqlException){
            throw new Exception("Erro ao consultar dados: " +
                    sqlException);
        }finally{
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
    }
}
