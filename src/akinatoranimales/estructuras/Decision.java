/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akinatoranimales.estructuras;

/**
 *
 * @author dayan
 */
public enum Decision {
    SI,
    NO;
    
    public Decision negado() {
        if (this.equals(SI)) {
            return NO;
        }
        return SI;
    }

    
}
