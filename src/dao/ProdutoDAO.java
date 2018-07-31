
package dao;

import model.ObjProduto;

public class ProdutoDAO {
    public static void inserir (ObjProduto pro){
        String sql= "INSERT INTO produtos"
                + "(nome, codCategoria, codFornecedor, quantidade, custo, precodevenda, refrigerado, comentario)"
                + "VALUES ("
                + " '"+pro.getNome()                  +"',"
                + "  "+pro.getCategoria().getCodigo() +" ,"
                + "  "+pro.getFornecedor().getCodigo()+" ,"
                + "  "+pro.getQuantidade()            +" ,"
                + "  "+pro.getCusto()                 +" ,"
                + "  "+pro.getPrecoDeVenda()          +" ,"
                + "  "+pro.isRefrigerado()            +" ,"
                + " '"+pro.getComentario()            +"');";
    }
}
