
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ObjCategoria;
import model.ObjFornecedor;
import model.ObjProduto;

public class ProdutoDAO {
    public static void inserir (ObjProduto pro){
        String sql= "INSERT INTO produtos"
                + "(nome, codCategoria, codFornecedor, quantidade, custo, precodevenda, refrigerado, comentario)"
                + "VALUES ("
                + " '"+pro.getNome()                  +"', "
                + "  "+pro.getCategoria().getCodigo() +" , "
                + "  "+pro.getFornecedor().getCodigo()+" , "
                + "  "+pro.getQuantidade()            +" , "
                + "  "+pro.getCusto()                 +" , "
                + "  "+pro.getPrecoDeVenda()          +" , "
                + "  "+pro.isRefrigerado()            +" , "
                + " '"+pro.getComentario()            +"');";
        Conexao.executar(sql);
    }
    
    public static void editar ( ObjProduto pro ){
        String sql = "UPDATE produtos SET "
                + "nome =         '"+pro.getNome()                  +"' "
                + "codCategoria  = "+pro.getCategoria().getCodigo() +"  "
                + "codFornecedor = "+pro.getFornecedor().getCodigo()+"  "
                + "quantidade    = "+pro.getQuantidade()            +"  "
                + "custo         = "+pro.getCusto()                 +"  "
                + "precodevenda  = "+pro.getPrecoDeVenda()          +"  "
                + "refrigerado   = "+pro.isRefrigerado()            +"  "
                + "comentario    ='"+pro.getComentario()            +"' "
                + "WHERE codigo  = "+pro.getCodigo();
        Conexao.executar(sql);
    }
    
    public static void excluir ( ObjProduto pro){
        String sql = "DELETE FROM produtos "
                + " WHERE codigo = "+pro.getCodigo();
        Conexao.executar(sql);
        
    }
    
    public static List<ObjProduto> getProdutos(){
        List<ObjProduto> lista = new ArrayList<>();
        String sql = "SELECT c.codigo, d.codigo, e.codigo,                  "
                + "c.nome, d.nome, e.nome, c.quantidade,                    "
                + "c.custo, c.precodevenda, c.refrigerado,                  "
                + "c.comentario                                             "
                + "FROM produtos c                                          "
                + "INNER JOIN categoria d ON c.codCategoria = d.codigo      "
                + "INNER JOIN fornecedores e ON c.codFornecedores = e.codigo"
                + "ORDER BY c.nome";
        ResultSet rs = Conexao.consultar(sql);
        if (rs != null){
            try{
                while ( rs.next()){
                    ObjProduto pro = new ObjProduto();
                    pro.setCodigo( rs.getInt( 1 ));
                    pro.setNome( rs.getString( 4 ));
                    ObjCategoria cat = new ObjCategoria();
                    cat.setCodigo( rs.getInt( 2 ));
                    cat.setNome( rs.getString( 5 ));
                    pro.setCategoria(cat);
                    ObjFornecedor forn = new ObjFornecedor();
                    forn.setCodigo( rs.getInt( 3 ));
                    forn.setNome( rs.getString( 6 ));
                    pro.setFornecedor(forn);
                    pro.setQuantidade( rs.getInt( 7 ));
                    pro.setCusto( rs.getFloat( 8 ));
                    pro.setPrecoDeVenda( rs.getFloat( 9 ));
                    pro.setRefrigerado( true );
                    pro.setComentario( rs.getString( 11 ));
                    lista.add(pro);
                }
            }catch(Exception  e){
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        return lista;
    }
    
    public static ObjProduto getProdutosByCodigo(int codigo){
        ObjProduto produto = new ObjProduto();
        
        String sql = "SELECT c.codigo, d.codigo, e.codigo,"
                + "c.nome, d.nome, e.nome, c.quantidade, c.custo,"
                + "c.precodevenda, c.refrigerado, c.comentario"
                + "WHERE produtos = "+codigo;
        ResultSet rs = Conexao.consultar(sql);
        try{
            rs.first();
            produto.setCodigo(rs.getInt( 1 ));
            produto.setNome(rs.getString( 4 ));
            ObjCategoria categoria = new ObjCategoria();
            categoria.setCodigo(rs.getInt( 2 ));
            categoria.setNome(rs.getString( 5 ));
            produto.setCategoria(categoria);
            ObjFornecedor fornecedor = new ObjFornecedor();
            fornecedor.setCodigo(rs.getInt( 3 ));
            fornecedor.setNome(rs.getString( 6 ));
            produto.setFornecedor(fornecedor);
            produto.setQuantidade(rs.getInt( 7 ));
            produto.setCusto(rs.getFloat( 8 ));
            produto.setPrecoDeVenda(rs.getFloat( 9 ));
            produto.setRefrigerado(true);
            produto.setComentario(rs.getString(11));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return produto;
    }
    
    
}
