/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Professor
 */
public class Produto {

    private int codigo;
    private String nome;
    private String categoria;
    private int estoque;
    private double precoCusto;
    private double precoVenda;

    public Produto(int codigo, String nome, String categoria, int estoque, double precoCusto, double precoVenda) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.estoque = estoque;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
    }

    public Produto() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return nome;
    }

    

}
