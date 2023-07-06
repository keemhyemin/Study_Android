package com.example.and00_springtoand;


//public interface GitHubService {
//    @GET("users/{user}/repos")
//    Call<List<Repo>> listRepos(@Path("user") String user);
//}

import java.util.HashMap;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface RetrofitInterface {
    // Retrofit으로 return 받는 모든 것들은 Call<클래스타입> 형태를 띄고있다 (규칙)
    // @Query("param") String param <- 파라메터 하나일 때, 재사용이 힘들다.
    @GET("{mapping}")
    Call<String> clientGetMethod(@Path("mapping") String mapping, @QueryMap HashMap<String, Object> paramMap);

    @FormUrlEncoded
    @POST
    Call<String> clientPostMethod(@Url String url, @FieldMap HashMap<String, Object> paramMap);

    // 재사용이 불편하다는 단점이 있음. 메소드의 이름이 어떤 데이터를 가져오는지가 명확해서 재사용시 혼동이 별로 없음.
//    @GET("list.cu")
//    Call<String> getCuList();
//
//    @GET("obj.cu")
//    Call<String> getCu();

}
