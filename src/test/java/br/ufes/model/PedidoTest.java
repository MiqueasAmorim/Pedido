/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;

import java.time.LocalDate;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Miqueas
 */
public class PedidoTest {

    public PedidoTest() {
    }

    /* Exceção com a mensagem "Informe um cliente válido" deve ser lançada quando 
    / é tentado criar um pedido sem um cliente válido (null) */
    @Test
    public void CT01() {
        Produto produto = new Produto("Lápis", 1.5, 10);
        LocalDate date = LocalDate.now();
        Exception e = Assert.assertThrows(RuntimeException.class, () -> new Pedido(null, produto, 5, date));
        assertEquals("Informe um cliente válido", e.getMessage());
    }

    // Não deve ser possível adicionar o mesmo produto no pedido
    @Test
    public void CT02() {
        Produto produto = new Produto("Caneta", 1.5, 8);

        Cliente cliente = new Cliente("Fulano", "123.456.789-01");

        Pedido pedido = new Pedido(cliente,
                produto, 5,
                LocalDate.now()
        );

        RuntimeException e = assertThrows(RuntimeException.class, () -> pedido.addItem(produto, 1));

        assertEquals("Produto já existe! Remova-o ou altere a quantidade", e.getMessage());
    }

    // Deve ser possível adicionar um novo produto no pedido
    @Test
    public void CT03() {
        Produto produtoCaneta = new Produto("Caneta", 1.5, 8);

        Cliente cliente = new Cliente("Fulano", "123.456.789-01");

        Pedido pedido = new Pedido(cliente,
                produtoCaneta, 5,
                LocalDate.now()
        );

        Produto produtoBorracha = new Produto("Borracha", 0.5, 5);

        pedido.addItem(produtoBorracha, 2);

        Produto ultimoProdutoDoPedido = pedido.getItens().get(1).getProduto();

        assertEquals(produtoBorracha, ultimoProdutoDoPedido);

    }

    // Deve ser possível remover um item de pedido
    @Test
    public void CT04() {
        Pedido pedido = new Pedido(
                new Cliente("Fulano", "123.456.789-01"),
                new Produto("Caneta", 1.5, 8), 5,
                LocalDate.now()
        );

        pedido.addItem(new Produto("Borracha", 0.5, 5), 2);
        pedido.addItem(new Produto("Lápis", 1.0, 10), 2);
      
        pedido.removerItem("Borracha");
        
        Optional<ItemPedido> optional = pedido.getItemPorNome("Borracha");
        
        boolean hasBorracha = optional.isPresent();
        
        assertFalse(hasBorracha);
    }
    
    // Valor final a pagar deve ter um desconto de 5%
    @Test
    public void CT05() {
        Pedido pedido = new Pedido(
                new Cliente("Fulano", "123.456.789-01"),
                new Produto("Caneta", 1.5, 20), 10,
                LocalDate.now()
        );

        pedido.addItem(new Produto("Lápis", 1.0, 10), 5);
        
        assertEquals(19.0, pedido.getValorAPagar(), 0.001);
        
    }
}
