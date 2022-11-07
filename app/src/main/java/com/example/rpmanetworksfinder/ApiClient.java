package com.example.rpmanetworksfinder;


import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;


public class ApiClient {
    private static Retrofit retrofit = null;

    public static final String BASE_URL = "https://api.open-meteo.com/v1/";
   /* private  static HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    private static Interceptor logging = interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

    private static Retrofit retrofit = null;

    private  static OkHttpClient httpClient =new OkHttpClient.Builder()
            .readTimeout(1000, TimeUnit.MILLISECONDS)
            .addInterceptor(logging)
            .build();
*/
    //public static <S> S createService(Class<S> ServiceClass)


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
