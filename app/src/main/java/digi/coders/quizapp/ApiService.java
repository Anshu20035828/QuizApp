package digi.coders.quizapp;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiService {

    @GET("questions")
    Call<JsonArray> getQuiz(
            @Header("X-Api-Key") String XApiKey
    );
}
