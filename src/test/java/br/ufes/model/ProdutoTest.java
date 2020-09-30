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
        Exception e = Assert.assertThrows(RuntimeException.class, () -> new Produto("Borracha", 0, 10));
        assertEquals(e.getMessage(), "Valor inválido: 0.0");
    }
    
    // O valor unitário do produto não pode ser negativo
    @Test 
    public void CT02() {
        RuntimeException e = Assert.assertThrows(RuntimeException.class, () -> new Produto("Borracha", -1.5, 10));
        assertEquals(e.getMessage(), "Valor inválido: -1.5");
    }
    
    // O nome do produto não pode ser null
    @Test 
    public void CT03() {
        RuntimeException e = Assert.assertThrows(RuntimeException.class, () -> new Produto(null, 5.0, 10));
        assertEquals(e.getMessage(), "Nome inválido: null");
    }
}
