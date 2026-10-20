package ar.edu.unlu.poo.labo2.estrategias;

import ar.edu.unlu.poo.labo2.artefactos.Artefacto;

public class EstrategiaCompuesta implements EstrategiaDeMejora{

    private final EstrategiaDeMejora[] estrategias;

    public EstrategiaCompuesta(EstrategiaDeMejora ... estrategias)
    {
        if(estrategias == null) throw new IllegalArgumentException("Las estrategias no pueden ser NULL");
        this.estrategias = estrategias;
    }

    @Override
    public void mejorar(Artefacto artefacto) {
        for(EstrategiaDeMejora e : estrategias) {
            e.mejorar(artefacto);
        }

    }
}
