package br.ufes.model;

import exception.EstoqueIndisponivelException;
import java.text.DecimalFormat;

public final class ItemPedido {

    protected double valorUnitario;
    protected Integer quantidade;
    protected double valorItem;
    protected Produto produto;

    public ItemPedido(Produto produto, Integer quantidadeAdquirida) {
        if (!produto.estoqueDisponivel(quantidadeAdquirida)) {
            throw new EstoqueIndisponivelException("Estoque indisponível para atender a quantidade solicitada (" + quantidadeAdquirida
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
        StringBuilder bld = new StringBuilder();
        bld.append(produto.getNome())
                .append(", valor Unitario: R$ ").append(valorUnitario)
                .append(", quantidade no pedido:").append(quantidade)
                .append(", valor Total: R$ ").append(df.format(getValorItem()));
        return bld.toString();
    }

}
