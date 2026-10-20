package ar.edu.unlu.poo.labo2.artefactos;

import ar.edu.unlu.poo.labo2.estrategias.EstrategiaDeMejora;

import java.util.*;

public class CatalogoArtefactos {

    private final Set<Artefacto> artefactos;

    //Aplico inversion de contol
    private final EstrategiaDeMejora estrategiaDeMejora;

    // Constructor por defecto (Compatibilidad Labo 1)
    public CatalogoArtefactos() {

        this.artefactos = new HashSet<>();
        this.estrategiaDeMejora = null;
    }

    public CatalogoArtefactos(EstrategiaDeMejora estrategiaMejora) {

        this.artefactos = new HashSet<>();
        if(estrategiaMejora == null) throw new IllegalArgumentException("Estrategia de mejora no puede ser NULL");
        this.estrategiaDeMejora = estrategiaMejora;
    }
    // =========================================================================
    // Métodos del Laboratorio 1 (Colecciones)
    // =========================================================================

    public void agregarArtefacto(Artefacto artefacto) {
        if (artefacto != null) {
            this.artefactos.add(artefacto);
        }
    }

    public Set<Artefacto> obtenerArtefactosUnicos() {
        return Collections.unmodifiableSet(this.artefactos);
    }

    public List<Artefacto> buscarArtefactosPorTipo(String tipo) {
        List<Artefacto> resultado = new ArrayList<>();
        for (Artefacto a : this.artefactos) {
            if (a.esDeTipo(tipo)) {
                resultado.add(a);
            }
        }
        // Ordenar de mayor a menor poder
        resultado.sort((a1, a2) -> Integer.compare(a2.getNivelDePoder(), a1.getNivelDePoder()));
        return resultado;
    }

    public Map<String, Integer> contarArtefactosPorTipo() {
        Map<String, Integer> conteo = new HashMap<>();
        for (Artefacto a : this.artefactos) {
            conteo.put(a.getTipo(), conteo.getOrDefault(a.getTipo(), 0) + 1);
        }
        return conteo;
    }

    public Artefacto obtenerArtefactoMasPoderoso() {
        if (this.artefactos.isEmpty()) {
            return null;
        }
        Artefacto max = null;
        for (Artefacto a : this.artefactos) {
            if (max == null || a.getNivelDePoder() > max.getNivelDePoder()) {
                max = a;
            }
        }
        return max;
    }

//Debe recorrer todos los artefactos del catálogo y delegar la mejora en la estrategia inyectada.
    public void aplicarMejoras()
    {
        if(estrategiaDeMejora == null) throw new IllegalArgumentException("Estrategia de mejora no puede ser null");
        for(Artefacto artefacto : artefactos) {
            estrategiaDeMejora.mejorar(artefacto);
        }
    }



}