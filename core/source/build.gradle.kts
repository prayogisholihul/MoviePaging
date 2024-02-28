@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.hilt.plugin)
    kotlin("kapt")
}
android {
    namespace = "com.zogik.network"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        android.buildFeatures.buildConfig = true

        buildConfigField(
            "String",
            "API_KEY",
            "\"eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiODQyMmEwMmNmYjE2MzQ0NDZiNzQ3ZmVjY2ViOGQ1MyIsInN1YiI6IjYxZTc4YmRiNDFlZWUxMDA2YzE4OGZmNSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.z46pKUr5bGLv44hhCvi89CTjmQxotd9mLuaMvsOdK0s\"",
        )

        buildConfigField(
            "String",
            "BASE_URL",
            "\"https://api.themoviedb.org/3/\"",
        )
        buildConfigField(
            "String",
            "IMAGE_URL",
            "\"https://image.tmdb.org/t/p/original/\"",
        )
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":core:model"))

    // hilt
    implementation(libs.hilt)
    implementation(libs.hilt.compose)
    kapt(libs.hilt.kapt)

    // room
    implementation(libs.room)
    implementation(libs.room.ktx)
    kapt(libs.room.compiler)

    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.logging.interceptor)
    implementation(libs.gson)
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
