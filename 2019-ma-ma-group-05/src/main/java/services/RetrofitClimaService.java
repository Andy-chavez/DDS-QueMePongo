package services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitClimaService {
    @GET("/data/2.5/weather?") 
    Call<ResponseClimaApiOWM> getClimaByOwm
    (@Query("id") String idCity,@Query("units") String unidades,@Query("appid") String appid);
   
    @GET("/forecast/{appid}/{latitud},{longitud}")
    Call<ResponseClimaApiDarkSky> getClimaByDarkSky
    (@Path("appid") String appid,@Path("latitud") String latitud,@Path("longitud") String longitud
    ,@Query("units") String units);
}
