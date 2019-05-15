package services;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitClimaService {
    @GET("/data/2.5/weather?appid=9cac08e3c5cce6b0d463cacddcaadee2")
    Call<ResponseClima> getClimaByCityId(@Query("id") int id);
}
