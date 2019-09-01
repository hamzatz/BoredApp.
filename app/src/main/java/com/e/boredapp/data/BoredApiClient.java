package com.e.boredapp.data;

import com.e.boredapp.App;
import com.e.boredapp.model.BoredAction;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class BoredApiClient extends App implements IBoredApiClient{

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://www.boredapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    BoredNetworkClient client = retrofit.create(BoredNetworkClient.class);

    @Override
    public void getBoredAction(final BoredActionCallback callback) {
        Call<BoredAction> call= client.getBoredAction();
        call.enqueue(new Callback<BoredAction>() {
            @Override
            public void onResponse(Call<BoredAction> call, Response<BoredAction> response) {
                if(response.isSuccessful()){
                   if(response.body() !=null) {
                       callback.onSuccess(response.body());
                   } else {
                       callback.onFailure(new Exception("Body is null"));
                   }
                }else {
                    callback.onFailure(new Exception("Responde code " + response.code()));


              }

            }

            @Override
            public void onFailure(Call<BoredAction> call, Throwable t) {

            }
        });

    }
    public interface BoredNetworkClient {
        @GET("/api/activity/")
        Call<BoredAction> getBoredAction();
    }
}
