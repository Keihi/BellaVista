
package model;

public class ObjProduto {
    private int codigo, quantidade, estoqueMinimo;
    private float custo, precoDeVenda;
    private String nome, comentario;
    private boolean refrigerado;
    private ObjCategoria categoria;
    private ObjFornecedor fornecedor;
    

    public ObjProduto() {
    }

    public ObjProduto(int codigo, int quantidade, int quantidadeMinima, float custo, float precoDeVenda, String nome, String comentario, boolean refrigerado, ObjCategoria categoria, ObjFornecedor fornecedor) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.estoqueMinimo = quantidadeMinima;
        this.custo = custo;
        this.precoDeVenda = precoDeVenda;
        this.nome = nome;
        this.comentario = comentario;
        this.refrigerado = refrigerado;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    

    public int getCodigo() {
        return codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public float getCusto() {
        return custo;
    }

    public float getPrecoDeVenda() {
        return precoDeVenda;
    }

    public String getNome() {
        return nome;
    }

    public String getComentario() {
        return comentario;
    }

    public boolean isRefrigerado() {
        return refrigerado;
    }

    public ObjCategoria getCategoria() {
        return categoria;
    }

    public ObjFornecedor getFornecedor() {
        return fornecedor;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public void setPrecoDeVenda(float precoDeVenda) {
        this.precoDeVenda = precoDeVenda;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setRefrigerado(boolean refrigerado) {
        this.refrigerado = refrigerado;
    }

    public void setCategoria(ObjCategoria categoria) {
        this.categoria = categoria;
    }

    public void setFornecedor(ObjFornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    
    
    
}
