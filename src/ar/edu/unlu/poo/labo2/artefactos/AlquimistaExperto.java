package ar.edu.unlu.poo.labo2.artefactos;

import ar.edu.unlu.poo.labo2.estrategias.EstrategiaDeMejora;

public class AlquimistaExperto implements EstrategiaDeMejora {

    @Override
    public void mejorar(Artefacto artefacto) {
        //si el artefacto es de tipo "Poción", incrementa su poder en +20, con un tope máximo estricto de 100
        if(artefacto.esDeTipo("Poción")){
            artefacto.incrementarPoder(20);
            artefacto.limitarPoderMaximo(100);
        }

    }
}
