/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Miqueas
 */
public class EstoqueIndisponivelException extends RuntimeException {
    
    public EstoqueIndisponivelException(String message) {
        super(message);
    }
    
}
