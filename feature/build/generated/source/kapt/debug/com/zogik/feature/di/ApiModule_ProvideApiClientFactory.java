package com.zogik.feature.di;

import com.zogik.feature.data.source.ApiClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ApiModule_ProvideApiClientFactory implements Factory<ApiClient> {
  private final Provider<Retrofit> retrofitProvider;

  public ApiModule_ProvideApiClientFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public ApiClient get() {
    return provideApiClient(retrofitProvider.get());
  }

  public static ApiModule_ProvideApiClientFactory create(Provider<Retrofit> retrofitProvider) {
    return new ApiModule_ProvideApiClientFactory(retrofitProvider);
  }

  public static ApiClient provideApiClient(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(ApiModule.INSTANCE.provideApiClient(retrofit));
  }
}
