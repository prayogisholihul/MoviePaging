package com.zogik.feature.presentation;

import com.zogik.feature.domain.UseCase;
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
public final class MainViewModel_Factory implements Factory<MainViewModel> {
  private final Provider<UseCase> useCaseProvider;

  public MainViewModel_Factory(Provider<UseCase> useCaseProvider) {
    this.useCaseProvider = useCaseProvider;
  }

  @Override
  public MainViewModel get() {
    return newInstance(useCaseProvider.get());
  }

  public static MainViewModel_Factory create(Provider<UseCase> useCaseProvider) {
    return new MainViewModel_Factory(useCaseProvider);
  }

  public static MainViewModel newInstance(UseCase useCase) {
    return new MainViewModel(useCase);
  }
}
