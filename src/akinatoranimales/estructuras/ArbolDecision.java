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
    private int grado = -1;
    
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
                    nodoPadre.setSi(nuevoNodo);
                    break;
                case NO:
                    nodoPadre.setNo(nuevoNodo);
                    break;
            }
            grado = -1;
        }
    }
    
    public static ArbolDecision desdeCsv(String csv) {
        ArbolDecision a = new ArbolDecision();
        String[] lineas = csv.trim().split("\n");
        for (String linea: lineas) {
            if (linea.toLowerCase().startsWith("pregunta")) {
                continue;
            }
            String[] componentes = linea.trim().split(", ?");
            String nuevoNodo = componentes[0].trim().toLowerCase();
            String nodoNo = componentes[1].trim().toLowerCase();
            String nodoSi = componentes[2].trim().toLowerCase();
            if (a.estaVacio()) {
                a.insertar(nuevoNodo);
            }
            a.insertar(nodoSi, nuevoNodo, Decision.SI);
            a.insertar(nodoNo, nuevoNodo, Decision.NO);
        }
        return a;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public boolean buscar(String nuevoAnimal) {
        return nodos.existe(nuevoAnimal);
    }
    
    public int grado() {
        if (grado != -1) {
            return grado;
        }
        return grado = grado(raiz);
    }
    
    private int grado(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        }
        
        return 1 + grado(nodo.getSi()) + grado(nodo.getNo());
    }
    
    public int profundidad(String etiqueta) {
        return profundidad(etiqueta, raiz, 1);
    }
    
    private int profundidad(String etiqueta, NodoArbol nodo, int nivel) {
        if (nodo == null) {
            return 0;
        }
        
        if (nodo.getEtiqueta().equals(etiqueta)) {
            return nivel;
        }
        
        int nivelIzquierda = profundidad(etiqueta, nodo.getNo(), nivel + 1);
        if (nivelIzquierda > 0) {
            return nivelIzquierda;
        }
        
        return profundidad(etiqueta, nodo.getSi(), nivel + 1);
    }

    public void vaciar() {
        raiz = null;
        nodos.vaciar();
    }
}
