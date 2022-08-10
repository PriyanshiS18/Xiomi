package app.instabillpos.repository.di

import android.content.Context
import app.instabillpos.mProguard.shredPref.AppSharedPreferences
import app.instabillpos.repository.local.products.AppDatabase
import app.instabillpos.repository.local.products.ProductDao
import app.instabillpos.repository.remote.APIService
import app.instabillpos.repository.remote.mRemoteDataSource
import app.instabillpos.repository.repository.mRepository
import app.instabillpos.utils.Helper.BaseUrl
import app.instabillpos.utils.Helper.timeOutTime
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideRetrofit(@ApplicationContext appContext: Context, gson: Gson): Retrofit =
        Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(timeOutTime, TimeUnit.SECONDS)
                    .writeTimeout(timeOutTime, TimeUnit.SECONDS)
                    .readTimeout(timeOutTime, TimeUnit.SECONDS)
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()
            )
            .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideRetrofitService(retrofit: Retrofit): APIService = retrofit.create(
        APIService::class.java
    )

    @Singleton
    @Provides
    fun provideProductsRemoteDataSource(
        APIService: APIService,
        sharedPreferences: AppSharedPreferences
    ) =
        mRemoteDataSource(APIService, sharedPreferences)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        AppDatabase.getDatabase(appContext)


    @Singleton
    @Provides
    fun provideSharedPref(@ApplicationContext appContext: Context) =
        AppSharedPreferences.getInstance(appContext)

    @Singleton
    @Provides
    fun provideProductsDao(db: AppDatabase) = db.productDao()

    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: mRemoteDataSource,
        localDataSource: ProductDao
    ) =
        mRepository(remoteDataSource, localDataSource)
}

/*http://e-startup.co/api/*/
/*https://instabill.co/api/*/