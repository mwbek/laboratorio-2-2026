package ar.edu.unlu.poo.labo2.artefactos;

import ar.edu.unlu.poo.labo2.estrategias.EstrategiaDeMejora;

public class ForjadorDeRunas implements EstrategiaDeMejora {
    @Override
    public void mejorar(Artefacto artefacto) {
        //si el artefacto es de tipo "Varita", incrementa su poder en +15.
        if(artefacto.esDeTipo("Varita")){
            artefacto.incrementarPoder(15);
        }
    }
}
