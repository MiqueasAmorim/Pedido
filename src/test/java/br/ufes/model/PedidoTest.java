/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;

import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Miqueas
 */
public class PedidoTest {
    
    public PedidoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /* Exceção com a mensagem "Informe um cliente válido" deve ser lançada quando 
    / é tentado criar um pedido sem um cliente válido (null) */
    @Test
    public void CT01() {
        Produto produto = new Produto("Lápis", 1.5, 10);
        Exception e = Assert.assertThrows(RuntimeException.class, () -> new Pedido(null, produto, 5, LocalDate.now()));
        assertEquals(e.getMessage(), "Informe um cliente válido");
    }
}
