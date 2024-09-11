plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("kotlin-parcelize")
    id("com.google.devtools.ksp")
    id ("kotlin-kapt")
   id ("androidx.navigation.safeargs.kotlin")
    



}

android {
    buildFeatures{
        viewBinding=true
        dataBinding=true
    }
    namespace = "com.example.doapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.doapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.crashlytics.buildtools)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation (libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    // Coroutines
    implementation(libs.kotlinx.coroutines.android)
    implementation (libs.androidx.room.ktx)
    // Navigation
    val navVersion = "2.7.5"
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    // Life Cycle Arch
    val lifecycleVersion = "2.6.2"
    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    // LiveData
    implementation(libs.androidx.lifecycle.livedata.ktx)
    // Annotation processor
    annotationProcessor(libs.androidx.lifecycle.compiler)
    implementation(kotlin("script-runtime"))
    testImplementation(libs.androidx.room.testing)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.room.runtime.v261)
    kapt(libs.androidx.room.compiler.v261)

}