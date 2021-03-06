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
    
    // Nome não pode ser null
    @Test
    public void CT01() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Cliente(null, "123.456.789-01"));
        assertEquals("Nome inválido", e.getMessage());
    }
    
    // CNPJ/CPF não pode ser null
    @Test
    public void CT02() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Cliente("Fulano", null));
        assertEquals("CNPJ/CPF inválido", e.getMessage());
    }
    
    // Deve retornar o nome corretamente
    @Test
    public void CT03() {
        Cliente cliente = new Cliente("Fulano", "145.856.466-56");
        assertEquals("Fulano", cliente.getNome());
    }
    
    // Deve retornar o cpf/cnpj corretamente
    @Test
    public void CT04() {
        Cliente cliente = new Cliente("Fulano", "145.856.466-56");
        assertEquals("145.856.466-56", cliente.getCnpjOuCpf());
    }
}
