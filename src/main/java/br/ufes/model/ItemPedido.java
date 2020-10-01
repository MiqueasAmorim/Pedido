package br.ufes.model;

import java.text.DecimalFormat;

public final class ItemPedido {

    protected double valorUnitario;
    protected Integer quantidade;
    protected double valorItem;
    protected Produto produto;

    public ItemPedido(Produto produto, Integer quantidadeAdquirida) {
        if (!produto.estoqueDisponivel(quantidadeAdquirida)) {
                throw new RuntimeException("Estoque indisponível para atender a quantidade solicitada (" + quantidadeAdquirida
                    + ") para o produto " + produto.getNome()
                    + ", restam " + produto.getQuantidade() + " em estoque.");
        }
        this.produto = produto;
        this.quantidade = quantidadeAdquirida;
        this.valorUnitario = produto.getValorUnitario();
        calculaValorItem();
    }

    private void calculaValorItem() {
        this.valorItem = valorUnitario * quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public double getValorItem() {
        calculaValorItem();
        return valorItem;
    }

    public Produto getProduto() {
        return produto;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return produto.getNome()
                + ", valor Unitario: R$ " + valorUnitario
                + ", quantidade no pedido:" + quantidade
                + ", valor Total: R$ " + df.format(getValorItem());
    }

}
