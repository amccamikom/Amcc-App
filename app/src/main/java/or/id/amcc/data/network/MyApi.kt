package or.id.amcc.data.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import or.id.amcc.AmccAmikomApplication
import or.id.amcc.BuildConfig
import or.id.amcc.data.network.responses.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

interface MyApi {

    @FormUrlEncoded
    @POST("login")
    suspend fun userLogin(
        @Field("nim") nim: String,
        @Field("password") password: String
    ): Response<UserLoginResponse>

    @GET("history")
    suspend fun getHistory(): Response<HistoryResponse>

    @GET("visionmision")
    suspend fun getVisionMision(): Response<VisionMisionResponse>

    @GET("management")
    suspend fun getManagement(): Response<ManagementResponse>

    @GET("division")
    suspend fun getDivision(): Response<DivisionResponse>

    @GET("category")
    suspend fun getCategory(): Response<CategoryResponse>

    companion object {
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ): MyApi {

            val okkHttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()

            return Retrofit.Builder()
                .client(getOkHttpClient())
                .baseUrl("https://amcc-test.amcc.or.id/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }

        private fun getOkHttpClient(): OkHttpClient {
            val timeOut = 60L
            return OkHttpClient.Builder()
                .connectTimeout(timeOut, TimeUnit.SECONDS)
                .readTimeout(timeOut, TimeUnit.SECONDS)
                .writeTimeout(timeOut, TimeUnit.SECONDS)
                .addInterceptor(getInterceptor())
                .addInterceptor {
                    val req = it.request()
                        .newBuilder()
                        .addHeader(
                            "Authorization",
                            "Bearer " + AmccAmikomApplication.prefManager.spToken
                        )
                        .build()
                    return@addInterceptor it.proceed(req)
                }
                .build()
        }

        private fun getInterceptor(): Interceptor {
            return HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            }
        }
    }
}