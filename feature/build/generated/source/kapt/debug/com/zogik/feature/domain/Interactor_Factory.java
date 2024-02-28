package com.zogik.feature.domain;

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
public final class Interactor_Factory implements Factory<Interactor> {
  private final Provider<Repository> repoProvider;

  public Interactor_Factory(Provider<Repository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public Interactor get() {
    return newInstance(repoProvider.get());
  }

  public static Interactor_Factory create(Provider<Repository> repoProvider) {
    return new Interactor_Factory(repoProvider);
  }

  public static Interactor newInstance(Repository repo) {
    return new Interactor(repo);
  }
}
