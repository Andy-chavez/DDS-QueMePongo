package services;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitClimaService {
	
    @GET("/data/2.5/weather?") 
    /*Aparentemente lo que se agrega luego del weather son diferentes predicados que deben ser verdaderos
     * para que se pueda ejecutar el call correctamente, sin importar el orden.
     */
    Call<ResponseClimaApiOWM> getClimaByOwm
    (@Query("id") String idCity,@Query("units") String unidades,@Query("appid") String appid);
    /*Al parecer el @Query funciona de la siguiente manera: mete al final del string de la url
     * el valor del String, y ademas si ya habia algo antes te lo pone de la siguiente forma:
     *urlbase/data/2.5/weather?<predicado1>&id=<idcity>
     *Si antes no había nada, no te pone el "&"
     *
     *Se usa @Query para agregar valores parametrizados que se encuentran luego de un "?"(en éste caso, todo lo que quería
     *parametrizar estaba después del weather?).
     *Se usa el @Path para agregar valores parametrizados que se encuentran justo luego de un "/",(por ejemplo, cuando }
     *hicimos lo de reqres.in/user/{id}, para pasarle un valor a ese id usabammos el @Path (ésta info la saque de 
     *google y stackoverflow.
     */
    @GET("/currentconditions/v1/3433955?apikey=Eg4khLSVsRLu4RyXDcYgkmHWO0vJUUud")
    Call<List<ResponseClimaApiAccuweather>> getClimaByAccuweather();
}
