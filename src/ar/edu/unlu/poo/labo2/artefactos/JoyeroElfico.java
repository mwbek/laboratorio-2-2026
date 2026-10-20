package ar.edu.unlu.poo.labo2.artefactos;

import ar.edu.unlu.poo.labo2.estrategias.EstrategiaDeMejora;

public class JoyeroElfico implements EstrategiaDeMejora {
    @Override
    public void mejorar(Artefacto artefacto) {
        //si es "Amuleto", duplica el poder si es <50 o lo incrementa un 25% si es >=50
        if(artefacto.esDeTipo("Amuleto"))
        {
            if(artefacto.getNivelDePoder() < 50) artefacto.duplicarPoder();
            else artefacto.incrementarPoderPorcentual(0.25);
        }
    }
}
