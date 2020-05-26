/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Date;

/**
 *
 * @author Professor
 */
public class Venda {

    private int numero;
    private Date data;
    private int codigoCliente;
    private int codigoProduto;
    private int quantidade;
    private double valorTotal;

    public Venda(int numero, Date data, int codigoCliente, int codigoProduto, int quantidade, double valorTotal) {
        this.numero = numero;
        this.data = data;
        this.codigoCliente = codigoCliente;
        this.codigoProduto = codigoProduto;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    public Venda() {
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
