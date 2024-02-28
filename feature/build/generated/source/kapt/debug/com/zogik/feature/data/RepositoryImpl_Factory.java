package com.zogik.feature.data;

import com.zogik.feature.data.source.ApiClient;
import com.zogik.network.room.DatabaseApp;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class RepositoryImpl_Factory implements Factory<RepositoryImpl> {
  private final Provider<ApiClient> apiProvider;

  private final Provider<DatabaseApp> localProvider;

  public RepositoryImpl_Factory(Provider<ApiClient> apiProvider,
      Provider<DatabaseApp> localProvider) {
    this.apiProvider = apiProvider;
    this.localProvider = localProvider;
  }

  @Override
  public RepositoryImpl get() {
    return newInstance(apiProvider.get(), localProvider.get());
  }

  public static RepositoryImpl_Factory create(Provider<ApiClient> apiProvider,
      Provider<DatabaseApp> localProvider) {
    return new RepositoryImpl_Factory(apiProvider, localProvider);
  }

  public static RepositoryImpl newInstance(ApiClient api, DatabaseApp local) {
    return new RepositoryImpl(api, local);
  }
}
