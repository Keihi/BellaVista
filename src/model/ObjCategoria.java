
package model;

public class ObjCategoria {
    private int codigo;
    private String nome;

    public ObjCategoria() {
        
    }
    
    public ObjCategoria(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return nome; //To change body of generated methods, choose Tools | Templates.
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   }
