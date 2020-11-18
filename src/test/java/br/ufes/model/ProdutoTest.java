/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;

import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Miqueas
 */
public class ProdutoTest {
    
    public ProdutoTest() {
    }

    // O valor unitário do produto não pode ser 0
    @Test 
    public void CT01() {
        IllegalArgumentException e = Assert.assertThrows(IllegalArgumentException.class, () -> new Produto("Borracha", 0, 10));
        assertEquals("Valor inválido: 0.0", e.getMessage());
    }
    
    // O valor unitário do produto não pode ser negativo
    @Test 
    public void CT02() {
        IllegalArgumentException e = Assert.assertThrows(IllegalArgumentException.class, () -> new Produto("Borracha", -1.5, 10));
        assertEquals("Valor inválido: -1.5", e.getMessage());
    }
    
    // O nome do produto não pode ser null
    @Test 
    public void CT03() {
        IllegalArgumentException e = Assert.assertThrows(IllegalArgumentException.class, () -> new Produto(null, 5.0, 10));
        assertEquals("Nome inválido: null", e.getMessage());
    }
    
    // O valor da quantidade do produto não pode ser negativo
    @Test 
    public void CT04() {
        IllegalArgumentException e = Assert.assertThrows(IllegalArgumentException.class, () -> new Produto("Borracha", 5.0, -6));
        assertEquals("Valor de quantidade inválido: -6", e.getMessage());
    }
    
    // Valor da última compra deve ser retornado corretamente
    @Test
    public void CT05() {
        Produto produto = new Produto("Borracha Preta", 1.5, 10);
        assertEquals(1.5, produto.getValorUltimaCompra(), 0.01 );
    }
}
