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
public class ArbolDecision {
    private NodoArbol raiz;
    private TablaHash nodos = new TablaHash();
    
    public ArbolDecision(){
        this.buscar = false;
    
    public void insertar(String etiqueta) {
        insertar(etiqueta, null, null);
    }
    
    public boolean estaVacio() {
        return raiz == null;
    }
    
    public void insertar(String etiqueta, String padre, Decision decision) {
        insertar(new NodoArbol(etiqueta), padre, decision);
    }
    
    private void insertar(NodoArbol nuevoNodo, String padre, Decision decision) {
        if (padre == null) {
            // primera inserción
            nodos.insertar(nuevoNodo.getEtiqueta(), nuevoNodo);
            raiz = nuevoNodo;
            return;
        }
        NodoArbol nodoPadre = nodos.buscar(padre);
        if (nodoPadre != null) {
            nodos.insertar(nuevoNodo.getEtiqueta(), nuevoNodo);
            switch (decision) {
                case SI:
                    if (null != nodoPadre.getSi()) {
                        NodoArbol temp = nodoPadre.getSi();
                        insertar(temp, nuevoNodo.getEtiqueta(), nuevoNodo.getNo() == null ? Decision.NO : Decision.SI);
                    }
                    nodoPadre.setSi(nuevoNodo);
                    break;
                case NO:
                    if (null != nodoPadre.getNo()) {
                        NodoArbol temp = nodoPadre.getNo();
                        insertar(temp, nuevoNodo.getEtiqueta(), nuevoNodo.getSi() == null ? Decision.SI : Decision.NO);
                    }
                    nodoPadre.setNo(nuevoNodo);
                    break;
            }
        }
    }
    
    public static ArbolDecision desdeCsv(String csv) {
        ArbolDecision a = new ArbolDecision();
        String[] lineas = csv.trim().split("\n");
        for (String linea: lineas) {
            String[] componentes = linea.trim().split(", ?");
            String nuevoNodo = componentes[0].trim();
            String nodoNo = componentes[1].trim();
            String nodoSi = componentes[2].trim();
            if (a.estaVacio()) {
                a.insertar(nuevoNodo);
            }
            a.insertar(nodoSi, nuevoNodo, Decision.SI);
            a.insertar(nodoNo, nuevoNodo, Decision.NO);
        }
        return a;
    }

    public boolean buscar(String etiqueta) {
        return buscar;
    }
    
    public void setbuscar(boolean buscar) {
        this.buscar = buscar;
    }
    
    public NodoArbol getRaiz() {
        return raiz;
    }
}
