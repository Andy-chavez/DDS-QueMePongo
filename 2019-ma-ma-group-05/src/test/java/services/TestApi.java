package services;

import dtoClases.ClimaDto;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import services.ResponseClima;
import services.RetrofitClimaService;

public class TestApi {

	public static void main(String[] args) {
		Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
		
        RetrofitClimaService service = retrofit.create(RetrofitClimaService.class);

        Call<ResponseClima> call = service.getClimaByCityId(2172797);
        try{
            Response<ResponseClima> response = call.execute();
            ClimaDto clima = response.body().main;

            System.out.print(clima.temperatura());
        }
        catch (Exception ex){
            System.out.print(ex.getMessage());
        }

	}

}
