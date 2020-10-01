package br.ufes.model;

public final class Produto {

    private String nome;
    private double valorUnitario;
    private double valorUltimaCompra;
    private Integer quantidade;

    public Produto(String nome, double valorUnitario, Integer quantidade) {
        setNome(nome);
        setValorUnitario(valorUnitario);
        setQuantidade(quantidade);
    }

    public boolean estoqueDisponivel(double quantidadeNecessaria) {
        return this.quantidade >= quantidadeNecessaria;
    }

    public String getNome() {
        return nome;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public double getValorUltimaCompra() {
        return valorUltimaCompra;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setNome(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException("Nome inválido: " + nome);
        }
        this.nome = nome;
    }

    public void setValorUnitario(double valorUnitario) {
        if (valorUnitario <= 0) {
            throw new IllegalArgumentException("Valor inválido: " + valorUnitario);
        }
        this.valorUltimaCompra = this.valorUnitario;
        this.valorUnitario = valorUnitario;
    }
    
    public void setQuantidade(Integer quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Valor de quantidade inválido: " + quantidade);
        }
        this.quantidade = quantidade;
    }
    
    @Override
    public String toString() {
        return "Produto: " + nome
                + ", valor unitario: R$" + valorUnitario
                + ", valor da ultima compra: R$" + valorUltimaCompra
                + ", quantidade em estoque: " + quantidade;
    }

}
