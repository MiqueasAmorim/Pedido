/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;

import java.time.LocalDate;
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
        Exception e = Assert.assertThrows(RuntimeException.class, () -> new Pedido(null, produto, 5, LocalDate.now()));
        assertEquals(e.getMessage(), "Informe um cliente válido");
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
        
        assertEquals(e.getMessage(), "Produto já existe! Remova-o ou altere a quantidade");
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
        
        assertEquals(ultimoProdutoDoPedido, produtoBorracha);
        
    }
}
