/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaCadastroVendas.java
 *
 * Created on 13/06/2011, 18:30:01
 */
package view;

import controller.ClienteController;
import controller.ProdutoController;
import controller.VendaController;
import dao.ClienteDAO;
import dao.ProdutoDAO;
import dao.VendaDAO;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Produto;
import model.Venda;

/**
 *
 * @author Professor
 */
public class TelaCadastroVendas extends javax.swing.JFrame {

    private int indiceAtual = 0;
    private ClienteController controladorCliente = new ClienteController();
    private ProdutoController controladorProduto = new ProdutoController();
    private VendaController controladorVendas = new VendaController();

    /**
     * Creates new form TelaCadastroVendas
     */
    public TelaCadastroVendas() {
        initComponents();
        carregaComBox();
        // chamada do método para carregar os registros já
        // cadastrados no BD
        inicializa(indiceAtual);
    }

    public final void carregaComBox() {
        try {
            List<Cliente> listaClientes = controladorCliente.getTodosClientes();
            List<Produto> listaProdutos = controladorProduto.getTodosProdutos();
            for (Cliente cliente : listaClientes) {
                jComboBoxCliente.addItem(cliente);
            }
            for (Produto produto : listaProdutos) {
                jComboBoxProduto.addItem(produto);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e,
                    "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // método para carregar os registros do BD
    public final void inicializa(int indiceAtual) {
        try {
            VendaDAO vendaDAO = new VendaDAO();
            List<Venda> lista = vendaDAO.todosVendas();
            if (lista.size() > 0) {
                Venda venda = lista.get(indiceAtual);
                List<Cliente> listaCliente = controladorCliente.pesquisar(venda.getCodigoCliente());
                Cliente cliente = listaCliente.get(0);
                List<Produto> listaProduto = controladorProduto.pesquisar(venda.getCodigoProduto());
                Produto produto = listaProduto.get(0);
                jTextFieldId.setText(String.valueOf(
                        venda.getNumero()));
                jFormattedTextFieldData.setText(String.valueOf(venda.getData()));
                jTextFieldCodigoCli.setText(String.valueOf(venda.getCodigoCliente()));
                jComboBoxCliente.setSelectedItem(cliente.getNome());
                jComboBoxCliente.setEnabled(false);
                jTextFieldCodigoPro.setText(String.valueOf(venda.getCodigoProduto()));
                jComboBoxProduto.setSelectedItem(produto.getNome());
                jComboBoxProduto.setEnabled(false);
                jTextFieldQuantidade.setText(String.valueOf(venda.getQuantidade()));
                jTextFieldPreco.setText(String.valueOf(produto.getPrecoVenda()));
                jTextFieldValorTotal.setText(String.valueOf(venda.getValorTotal()));
            } else {
                jTextFieldId.setText("");
                jFormattedTextFieldData.setText("");
                jTextFieldCodigoCli.setText("");
                jTextFieldCodigoPro.setText("");
                jTextFieldQuantidade.setText("");
                jTextFieldValorTotal.setText("");
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro: " + sqle,
                    "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Erro: " + exception,
                    "Cadastro de Vendas", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelId = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabelCodigoCli = new javax.swing.JLabel();
        jTextFieldCodigoCli = new javax.swing.JTextField();
        jLabelNomeCli = new javax.swing.JLabel();
        jComboBoxCliente = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabelCodigoPro = new javax.swing.JLabel();
        jTextFieldCodigoPro = new javax.swing.JTextField();
        jLabelDescricao = new javax.swing.JLabel();
        jComboBoxProduto = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jLabelPreco = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();
        jTextFieldValorTotal = new javax.swing.JTextField();
        jLabelPreco1 = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jButtonCancelar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Vendas");

        jLabelId.setText("Número:");

        jTextFieldId.setEditable(false);

        jLabel1.setText("Data:");

        try {
            jFormattedTextFieldData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Cliente:"));

        jLabelCodigoCli.setText("Código:");

        jTextFieldCodigoCli.setEditable(false);

        jLabelNomeCli.setText("Nome:");

        jComboBoxCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxClienteItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCodigoCli)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCodigoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabelNomeCli)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigoCli)
                    .addComponent(jTextFieldCodigoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomeCli)
                    .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Produto:"));

        jLabelCodigoPro.setText("Código:");

        jTextFieldCodigoPro.setEditable(false);

        jLabelDescricao.setText("Nome:");

        jComboBoxProduto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxProdutoItemStateChanged(evt);
            }
        });

        jLabel2.setText("Quantidade:");

        jTextFieldQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldQuantidadeFocusLost(evt);
            }
        });

        jLabelPreco.setText("Preço:");

        jTextFieldPreco.setEditable(false);

        jTextFieldValorTotal.setEditable(false);
        jTextFieldValorTotal.setForeground(new java.awt.Color(204, 0, 0));

        jLabelPreco1.setText("Total:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelPreco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelPreco1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldValorTotal))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelCodigoPro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCodigoPro, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabelDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDescricao)
                    .addComponent(jLabelCodigoPro)
                    .addComponent(jTextFieldCodigoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelPreco)
                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPreco1)
                    .addComponent(jTextFieldValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButtonCancelar1.setText("Cancelar");
        jButtonCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabelId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCancelar1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonVoltar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelId)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonCancelar1)
                    .addComponent(jButtonVoltar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // mÃ©todo para converter uma String em Date
    public Date stringToDate(String data) throws Exception {
        if (data == null) {
            return null;
        }
        Date dataFormat = null;
        try {
            DateFormat dataFormatada =
                    new SimpleDateFormat("dd/MM/yyyy");
            long timestamp = dataFormatada.parse(data).getTime();
            dataFormat = new Date(timestamp);
        } catch (ParseException pe) {
            throw pe;
        }
        return dataFormat;
    }

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed

        try {
            // grava os dados no venda no BD
            Venda venda = new Venda();
            venda.setNumero(Integer.parseInt(jTextFieldId.getText()));
            venda.setData(stringToDate(jFormattedTextFieldData.getText()));
            venda.setCodigoCliente(Integer.parseInt(jTextFieldCodigoCli.getText()));
            venda.setCodigoProduto(Integer.parseInt(jTextFieldCodigoPro.getText()));
            venda.setQuantidade(Integer.parseInt(jTextFieldQuantidade.getText()));
            venda.setValorTotal(Double.parseDouble(jTextFieldValorTotal.getText()));
            Produto produto = (Produto) jComboBoxProduto.getSelectedItem();
            int quantidadeAtual = produto.getEstoque();
            int quantidadeVendida = Integer.parseInt(jTextFieldQuantidade.getText());
            if (quantidadeAtual >= quantidadeVendida) {
                produto.setEstoque(quantidadeAtual - quantidadeVendida);
                controladorProduto.alterar(produto);
                controladorVendas.cadastrar(venda);
                inicializa(indiceAtual);
                // imprime mensagem de sucesso
                JOptionPane.showMessageDialog(null, "Operação realizada"
                        + " com sucesso!", "Cadastro de Vendas",
                        JOptionPane.PLAIN_MESSAGE);
            } else {
                // imprime mensagem de sucesso
                JOptionPane.showMessageDialog(null, "Quantidade insuficiente. Estoque = (" + quantidadeAtual + ")", "Cadastro de Vendas",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Erro: " + sqlException,
                    "Cadastro de Vendas",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Erro: " + exception,
                    "Cadastro de Vendas",
                    JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        // torna a TelaPrincipal invisível e instancia a
        // TelaCadastroClientes
        setVisible(false);
        TelaCadastro tela = new TelaCadastro();
        tela.setVisible(true);
}//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jComboBoxClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxClienteItemStateChanged
        Cliente cliente = (Cliente) jComboBoxCliente.getSelectedItem();
        jTextFieldCodigoCli.setText(String.valueOf(cliente.getCodigo()));

    }//GEN-LAST:event_jComboBoxClienteItemStateChanged

    private void jComboBoxProdutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxProdutoItemStateChanged
        Produto produto = (Produto) jComboBoxProduto.getSelectedItem();
        jTextFieldCodigoPro.setText(String.valueOf(produto.getCodigo()));
        jTextFieldPreco.setText(String.valueOf(produto.getPrecoVenda()));

    }//GEN-LAST:event_jComboBoxProdutoItemStateChanged

    private void jTextFieldQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldQuantidadeFocusLost
        int quantidade = Integer.parseInt(jTextFieldQuantidade.getText());
        double preco = Double.parseDouble(jTextFieldPreco.getText());
        jTextFieldValorTotal.setText(String.valueOf(quantidade * preco));
    }//GEN-LAST:event_jTextFieldQuantidadeFocusLost

    private void jButtonCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelar1ActionPerformed
    }//GEN-LAST:event_jButtonCancelar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TelaCadastroVendas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar1;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox jComboBoxCliente;
    private javax.swing.JComboBox jComboBoxProduto;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCodigoCli;
    private javax.swing.JLabel jLabelCodigoPro;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelNomeCli;
    private javax.swing.JLabel jLabelPreco;
    private javax.swing.JLabel jLabelPreco1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldCodigoCli;
    private javax.swing.JTextField jTextFieldCodigoPro;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldPreco;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldValorTotal;
    // End of variables declaration//GEN-END:variables
}
