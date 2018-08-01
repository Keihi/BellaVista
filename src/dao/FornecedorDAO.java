
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ObjFornecedor;

public class FornecedorDAO {
    public static void  inserir (ObjFornecedor forn){
        String sql = "INSERT INTO fornecedores"
                + "( nome, telefone)"
                + "VALUES ("
                + " '"+forn.getNome()+    "' , "
                + " '"+forn.getTelefone()+"'); ";
        Conexao.executar(sql);
    }
    
    public static void editar(ObjFornecedor forn){
        String sql = "UPDATE fornecedores SET"
                + " nome =     '"+forn.getNome()+    "' , "
                + " telefone = '"+forn.getTelefone()+"'   "
                + " WHERE codigo = "+forn.getCodigo();
        Conexao.executar(sql);
    }
    
    public static void excluir (ObjFornecedor forn){
     String sql = "DELETE FROM fornecedores "
             + " WHERE codigo = "+forn.getCodigo();
     Conexao.executar(sql);
    }
    
    public static List<ObjFornecedor>  getFornecedores(){
        List<ObjFornecedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM fornecedores ORDER BY nome";
        ResultSet rs = Conexao.consultar(sql);
        if(rs!= null){
            try{
                while(rs.next()){
                    ObjFornecedor forn = new ObjFornecedor();
                    forn.setCodigo(rs.getInt(1));
                    forn.setNome(rs.getString(2));
                    forn.setTelefone(rs.getString(3));
                    lista.add(forn);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        return lista;
    }
    
    public static ObjFornecedor getFornecedorByCodigo(int codigo){
        ObjFornecedor fornecedor = new ObjFornecedor();
        
        String sql = "SELECT codigo, nome, telefone FROM fornecedores "
                + "WHERE codigo = "+codigo;
        ResultSet rs = Conexao.consultar(sql);
        try{
            rs.first();
            fornecedor.setCodigo(rs.getInt(1));
            fornecedor.setNome(rs.getString(2));
            fornecedor.setTelefone(rs.getString(3));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return fornecedor;
    }
}
