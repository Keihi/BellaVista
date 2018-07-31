
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ObjCategoria;

public class CategoriaDAO {
    public static void inserir (ObjCategoria cat){
        String sql = "INSERT INTO categoria "
                + "( nome ) VALUES"
                + "( '"+cat.getNome()+"' ) ;";
        Conexao.executar(sql);
        
    }
     public static void editar (ObjCategoria cat){
         String sql = "UPDATE categoria SET"
                 + " nome = '"+cat.getNome()+"'"
                 + "WHERE codigo = "+cat.getCodigo();
         Conexao.executar(sql);
         
     }
     
     public static void excluir (ObjCategoria cat){
         String sql = "DELETE FROM categoria "
                 + " WHERE codigo = "+cat.getCodigo();
         Conexao.executar(sql);
     }
     
     public static List<ObjCategoria> getCategorias(){
         List<ObjCategoria> lista = new ArrayList<>();
         String sql = "SELECT * FROM categoria ORDER BY nome";
         ResultSet rs = Conexao.consultar(sql);
         if(rs != null){
             try{
                 while(rs.next()){
                     ObjCategoria cat = new ObjCategoria();
                     cat.setCodigo( rs.getInt(1));
                     cat.setNome(rs.getString(2));
                     lista.add(cat);
                 }
             }catch(Exception e){
                 JOptionPane.showMessageDialog(null, e.toString());
             }
         }
         return lista;
     }
     
     public static ObjCategoria getCidadeByCodigo(int codigo){
         ObjCategoria categoria = new ObjCategoria();
         
         String sql = "SELECT codigo, nome FROM categoria "
                 + "WHERE codigo =  "+codigo;
         ResultSet rs = Conexao.consultar(sql);
         try{
             rs.first();
             categoria.setCodigo(rs.getInt(1));
             categoria.setNome(rs.getString(2));
         }catch(Exception e){
             JOptionPane.showMessageDialog(null, e.toString());
         }
         return categoria;
     }
}
