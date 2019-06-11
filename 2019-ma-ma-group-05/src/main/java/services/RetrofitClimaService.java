package services;

import dtoClases.ResponseClimaApiDarkSkyDto;
import dtoClases.ResponseClimaApiOwmDto;
import dtoClases.ResponsePronosticoApiOwmDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitClimaService {
    @GET("/data/2.5/weather?") 
    Call<ResponseClimaApiOwmDto> getClimaActualByOwm
    (@Query("id") String idCity,@Query("units") String unidades,@Query("appid") String appid);
   
    @GET("/forecast/{appid}/{latitud},{longitud}")
    Call<ResponseClimaApiDarkSkyDto> getClimaByDarkSky
    (@Path("appid") String appid,@Path("latitud") String latitud,@Path("longitud") String longitud
    ,@Query("units") String units,@Query("exclude") String exclude);
    
    @GET("/data/2.5/forecast?")
    Call<ResponsePronosticoApiOwmDto> getPronosticoByOwm
    (@Query("id") String idCity,@Query("units") String unidades,@Query("appid") String appid);
    
}
