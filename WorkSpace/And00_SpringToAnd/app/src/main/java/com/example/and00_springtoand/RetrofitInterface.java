package com.example.and00_springtoand;



//public interface GitHubService {
//    @GET("users/{user}/repos")
//    Call<List<Repo>> listRepos(@Path("user") String user);
//}

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {
    // Retrofit으로 return 받는 모든 것들은 Call<클래스타입> 형태를 띄고있다 (규칙)

    @GET("list.cu")
    Call<String> getCuList();

    @GET("obj.cu")
    Call<String> getCu();

}
