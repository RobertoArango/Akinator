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
public class TablaHash {
    private Nodo[] nodos = new Nodo[100];
    
    public void insertar(String etiqueta, NodoArbol nodoArbol) {
        if (existe(etiqueta)) {
            return;
        }
        Nodo nodo = new Nodo(etiqueta, nodoArbol);
        int indice = funcionHash(etiqueta);
        if (nodos[indice] == null) {
            nodos[indice] = nodo;
        } else {
            Nodo tmp = nodos[indice];
            while (tmp.siguiente != null) {
                tmp = tmp.siguiente;
            }
            tmp.siguiente = nodo;
        }
        if (nodoArbol.getNo() != null) {
            insertar(nodoArbol.getNo().getEtiqueta(), nodoArbol.getNo());
        }
        
        if (nodoArbol.getSi() != null) {
            insertar(nodoArbol.getSi().getEtiqueta(), nodoArbol.getSi());
        }
    }
    
    public boolean existe(String etiqueta) {
        return buscar(etiqueta) != null;
    }
    
    public NodoArbol buscar(String etiqueta) {
        int indice = funcionHash(etiqueta);
        if (nodos[indice] == null) {
            return null;
        }
        Nodo tmp = nodos[indice];
        while (tmp.siguiente != null) {
            if (tmp.clave.equals(etiqueta)) {
                return tmp.valor;
            }
            tmp = tmp.siguiente;
        }
        return tmp.clave.equals(etiqueta) ? tmp.valor : null;
    }
    
    public void vaciar() {
        nodos = new Nodo[100];
    }
    
    private int funcionHash(String etiqueta) {
        return etiqueta.hashCode() & (nodos.length-1);
    }
    
    private class Nodo {
        String clave;
        NodoArbol valor;
        Nodo siguiente;
        
        Nodo(String clave, NodoArbol etiqueta) {
            this.clave = clave;
            this.valor = etiqueta;
        }
    }
}
