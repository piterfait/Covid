/**
 * CONSULTA PARA OBTENER LOS NODOS RELACIONADOS
 *
 * @author  Peter Fight (el negro de la capa de datos -roja y con una S fosforita-)
 * @version 0.007
 * @return sweet peace
 * @see <a href="https://www.youtube.com/watch?v=grQgC-mK2_g&list=PLvrWACVuHe6rImJAkWvF03xoGjwZkfYYo&index=2">SIXTO ROCKS!!!!</a>
 *
 */


package es.uned.master.java.Users.DAL;

import java.util.HashMap;
import java.util.Map;

public class GetSelectAllRelated {
    public Map<String, Object> getParametros() {
        return parametros;
    }

    public void setParametros(Map<String, Object> parametros) {
        this.parametros = parametros;
    }

    Map<String,Object> parametros;

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    String consulta = "MATCH ($entidadOrigen:$entidadOrigen)-[:$nombreRelacion]->($entidadRelacionada:$entidadRelacionada) " +
            "where Id($entidadOrigen) = $idEntidadOrigen RETURN $entidadRelacionada;";
    public GetSelectAllRelated(String entidadOrigen, int idEntidadOrigen, String nombreRelacion, String entidadRelacionada){
        parametros = new HashMap<>();
        //Tócate un pie, los selectores no pueden ponerse como parámetros. Cuidadín.
        consulta = consulta.replaceAll("\\$entidadOrigen", entidadOrigen);
        consulta = consulta.replaceAll("\\$idEntidadOrigen", ""+idEntidadOrigen);
        consulta = consulta.replaceAll("\\$nombreRelacion", ""+nombreRelacion);
        consulta = consulta.replaceAll("\\$entidadRelacionada", ""+entidadRelacionada);
    }
}
