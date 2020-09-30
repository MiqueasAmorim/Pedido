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
public class ClienteTest {
    
    public ClienteTest() {
    }
    
    @Test
    public void CT01() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Cliente(null, "123.456.789-01"));
        assertEquals(e.getMessage(), "Nome inválido");
    }
}
