/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaCadastroProdutos.java
 *
 * Created on 13/06/2011, 17:19:16
 */
package view;

import controller.ProdutoController;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Produto;

/**
 *
 * @author Professor
 */
public class TelaCadastroProdutos extends javax.swing.JFrame {

    private ProdutoController controlador = new ProdutoController();
    private int indiceAtual = 0;

    /**
     * Creates new form TelaCadastroProdutos
     */
    public TelaCadastroProdutos() {
        initComponents();
        // chamada do método para carregar os registros já
        // cadastrados no BD
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldPrecoVenda = new javax.swing.JTextField();
        jButtonVoltar = new javax.swing.JButton();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabelEstoque = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelPrecoCusto = new javax.swing.JLabel();
        jTextFieldEstoque = new javax.swing.JTextField();
        jLabelPrecoVenda = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JButton();
        jTextFieldPrecoCusto = new javax.swing.JTextField();
        jLabelCategoria = new javax.swing.JLabel();
        jTextFieldCategoria = new javax.swing.JTextField();
        jButtonCancelar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelCodigo.setText("Código:");

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jLabelNome.setText("Nome:");

        jTextFieldCodigo.setEditable(false);

        jLabelEstoque.setText("Estoque:");

        jLabelPrecoCusto.setText("Preço de Custo:");

        jLabelPrecoVenda.setText("Preço de Venda:");

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jLabelCategoria.setText("Categoria:");

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonVoltar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelCodigo)
                            .addComponent(jLabelNome)
                            .addComponent(jLabelCategoria)
                            .addComponent(jLabelEstoque)
                            .addComponent(jLabelPrecoCusto)
                            .addComponent(jLabelPrecoVenda))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNome)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextFieldPrecoVenda, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldPrecoCusto, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldEstoque, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 50, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCategoria)
                    .addComponent(jTextFieldCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEstoque)
                    .addComponent(jTextFieldEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrecoCusto)
                    .addComponent(jTextFieldPrecoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrecoVenda)
                    .addComponent(jTextFieldPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonCancelar1)
                    .addComponent(jButtonVoltar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        // torna a TelaPrincipal invisível e instancia a
        // TelaCadastroClientes
        setVisible(false);
        TelaCadastro tela = new TelaCadastro();
        tela.setVisible(true);
}//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // grava os dados no produto no BD
        Produto produto = new Produto();
        produto.setCodigo(Integer.parseInt(jTextFieldCodigo.getText()));
        produto.setNome(jTextFieldNome.getText());
        produto.setCategoria(jTextFieldCategoria.getText());
        produto.setEstoque(Integer.parseInt(jTextFieldEstoque.getText()));
        produto.setPrecoCusto(Double.parseDouble(jTextFieldPrecoCusto.getText()));
        produto.setPrecoVenda(Double.parseDouble(jTextFieldPrecoVenda.getText()));
        try {
            controlador.cadastrar(produto);
            // imprime mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Operação realizada"
                    + " com sucesso!", "Cadastro de Produtos",
                    JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Erro: " + sqlException,
                    "Cadastro de Produtos",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Erro: " + exception,
                    "Cadastro de Produtos",
                    JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelar1ActionPerformed
    }//GEN-LAST:event_jButtonCancelar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroProdutos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar1;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelEstoque;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPrecoCusto;
    private javax.swing.JLabel jLabelPrecoVenda;
    private javax.swing.JTextField jTextFieldCategoria;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldEstoque;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPrecoCusto;
    private javax.swing.JTextField jTextFieldPrecoVenda;
    // End of variables declaration//GEN-END:variables
}
