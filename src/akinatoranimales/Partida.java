/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akinatoranimales;

import akinatoranimales.estructuras.ArbolDecision;
import akinatoranimales.estructuras.Decision;
import akinatoranimales.estructuras.NodoArbol;

/**
 *
 * @author dayan
 */
public class Partida {
    private ArbolDecision baseConocimientos;
    private NodoArbol preguntaActual;
    private NodoArbol preguntaAnterior;
    private Decision decisionAnterior;
    private Decision decisionActual;
    private boolean iniciada = false;
    private boolean finalizada = false;
    private boolean victoria = false;

    public Partida(ArbolDecision baseConocimientos) {
        this.baseConocimientos = baseConocimientos;
    }
    
    
    
    public void iniciar() {
        iniciada = true;
        preguntaAnterior = null;
        decisionAnterior = null;
        decisionActual = null;
        preguntaActual = baseConocimientos.getRaiz();
    }
    
    public boolean getFinalizada() {
        return finalizada;
    }
    
    public boolean getVictoria() {
        return victoria;
    }
    
    public void responder(Decision decision) {
        if (!iniciada) {
            return;
        }
        if (!hayPreguntas()) {
            finalizada = true;
        }
        switch (decision) {
            case SI:
                if (finalizada) {
                    victoria = true;
                } else {
                    preguntaAnterior = preguntaActual;
                    preguntaActual = preguntaActual.getSi();
                }
                break;
            case NO:
                if (finalizada) {
                    victoria = false;
                } else {
                    preguntaAnterior = preguntaActual;
                    preguntaActual = preguntaActual.getNo();
                }
        }
        decisionAnterior = decisionActual;
        decisionActual = decision;
    }
    
    public String getSiguientePregunta() {
        return preguntaActual != null ? preguntaActual.getEtiqueta() : "";
    }
    
    public String getPreguntaAnterior() {
        return preguntaAnterior != null ? preguntaAnterior.getEtiqueta() : "";
    }

    public Decision getDecisionAnterior() {
        return decisionAnterior;
    }
    
    public boolean hayPreguntas() {
        if (preguntaActual == null) {
            return false;
        }
        return preguntaActual.getNo() != null || preguntaActual.getSi() != null;
    }
}
