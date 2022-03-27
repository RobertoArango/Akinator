/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akinatoranimales.estructuras;

import java.util.Objects;

/**
 *
 * @author dayan
 */
public class NodoArbol {
    
    private String etiqueta;
    private NodoArbol si; // derecha
    private NodoArbol no; // izquierda

    NodoArbol(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }
    
    public NodoArbol getSi() {
        return si;
    }

    public void setSi(NodoArbol si) {
        this.si = si;
    }

    public NodoArbol getNo() {
        return no;
    }

    public void setNo(NodoArbol no) {
        this.no = no;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.etiqueta);
        hash = 13 * hash + Objects.hashCode(this.si);
        hash = 13 * hash + Objects.hashCode(this.no);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NodoArbol other = (NodoArbol) obj;
        if (!Objects.equals(this.etiqueta, other.etiqueta)) {
            return false;
        }
        return true;
    }
    
}
