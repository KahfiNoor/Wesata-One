plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
//    id("com.google.devtools.ksp")
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.wesataone"
    compileSdk = 34

    defaultConfig {
//        buildConfigField("String", "BASE_URL", "\"https://story-api.dicoding.dev/v1/\"")
        applicationId = "com.example.wesataone"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            buildConfigField("String", "BASE_URL", "\"https://story-api.dicoding.dev/v1/\"")
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
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.auth)
    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.fragment.ktx)
    testImplementation(libs.junit)
//    implementation ("androidx.core:core-ktx:1.8.0")
//    implementation ("androidx.appcompat:appcompat:1.5.0")
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.androidx.navigation.fragment.ktx)//
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.retrofit)
    implementation(libs.retrofit2.converter.gson)
    implementation(libs.logging.interceptor)// apiconfig
    implementation(libs.androidx.lifecycle.runtime.ktx) // untuk lifecycleScope
    implementation(libs.androidx.room.runtime)
    implementation (libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx) //viewModelScope
    implementation(libs.androidx.lifecycle.livedata.ktx) //liveData
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.datastore.preferences) //data store preferences
//    ksp(libs.room.compiler)
    implementation(libs.play.services.auth)//login google
    // Import the BoM for the Firebase platform
//    implementation (platform(libs.google.firebase.bom))
//    implementation(libs.gson)
//    implementation(libs.dom4j)
    implementation (libs.firebase.auth)
    implementation (libs.firebase.core)
    //credential manager
//    implementation(libs.androidx.credentials)
//    implementation (libs.googleid)
//    implementation(libs.androidx.credentials.play.services.auth)
}