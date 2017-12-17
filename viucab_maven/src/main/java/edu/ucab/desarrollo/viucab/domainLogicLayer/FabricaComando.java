package edu.ucab.desarrollo.viucab.domainLogicLayer;

import edu.ucab.desarrollo.viucab.domainLogicLayer.M09_Sugerencias.GetSugerenciasLikeComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M09_Sugerencias.GetSugerenciasPreferenciasComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M09_Sugerencias.GetSugerenciasSuscripcionesComando;

public class FabricaComando {
    public static GetSugerenciasLikeComando FabricarComando1(){ return new GetSugerenciasLikeComando();}
   // public static GetSugerenciasPreferenciasComandoComando FabricarComando2(){ return new GetSugerenciasPreferenciasComando();}
    public static GetSugerenciasSuscripcionesComando FabricarComando3(){ return new GetSugerenciasSuscripcionesComando();}
}
