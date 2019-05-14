package services;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitClimaService {
    @GET("/data/2.5/weather?id={id}&appid=9cac08e3c5cce6b0d463cacddcaadee2")
    Call<ResponseClima> getClimaByCityId(@Path("id") int id);
	
}
