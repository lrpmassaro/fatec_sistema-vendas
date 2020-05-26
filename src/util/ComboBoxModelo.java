/*
 * Classe para criar o modelo da Combox.
 */

package util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import model.Cliente;
import model.Produto;


public class ComboBoxModelo implements ComboBoxModel{
    ArrayList<String> dados = new ArrayList();
    String selected_item = null;

    public ComboBoxModelo(List lista){
        try{
            int i = 0;

            while(i < lista.size()){
                Object objeto = lista.get(i);
                if(objeto instanceof Cliente){
                    Cliente cliente = (Cliente)objeto;
                    dados.add(cliente.getNome());
                }
                if(objeto instanceof Produto){
                    Produto produto = (Produto)objeto;
                    dados.add(produto.getNome());
                }
                i++;
            }

            try{
                //tenta selecionar o primeiro item do array

                selected_item = dados.get(0);
            }catch(Exception ex){
                ex.printStackTrace();
            }

        }catch(Exception e){
            e.printStackTrace();

            //trate sua exeção
        }
    }

    public void setSelectedItem(Object anItem) {
        selected_item = dados.get(dados.indexOf(anItem));
    }

    public Object getSelectedItem() {
       return selected_item;
    }

    public int getSize() {
        return dados.size();
    }

    public Object getElementAt(int index) {
        return dados.get(index);
    }

    public void addListDataListener(ListDataListener l) {
        //TO DO NOTHING
    }

    public void removeListDataListener(ListDataListener l) {
        //TO DO NOTHING
    }

}
