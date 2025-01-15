package sg.motion.tutorialnetworking.data.data_source.remote.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    // TODO: Define Base url here !
    // to create new base url look https://beeceptor.com/crud-api/ and add base path /api/notes
    private const val BASE_URL = "https://ca8584f8ee7ca4a20fc2.free.beeceptor.com"

    // TODO: Define Retrofit here ! don't forget add logger with okhttp
    val apiService : ApiService by lazy {
        val httpClient = OkHttpClient.Builder()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(interceptor)
//        httpClient.addInterceptor { chain ->
//            chain.proceed(
//                chain.request()
//                    .newBuilder()
//                    //add headers to the request builder
//                    .also {
//                        it.addHeader("api_key", "value_1")
//                        it.addHeader("Header_2", "value_2")
//                    }
//                    .build()
//            )
//        }

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()

        return@lazy retrofit.create<ApiService>(ApiService::class.java)
    }

}