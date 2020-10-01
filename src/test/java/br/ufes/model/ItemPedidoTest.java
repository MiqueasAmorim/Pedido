/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Miqueas
 */
public class ItemPedidoTest {
    
    public ItemPedidoTest() {
    }
    
    
    // Não deve ser possível criar um ItemPedido cuja quantidade solicitada do produto não há em estoque
    @Test
    public void CT01() {
        Produto produto = new Produto("Caneta", 1.50, 10);
        RuntimeException e = assertThrows(RuntimeException.class, () -> new ItemPedido(produto, 12));
        assertEquals(e.getMessage(), 
            "Estoque indisponível para atender a quantidade solicitada (12) para o produto Caneta, restam 10 em estoque.");
    }
}
