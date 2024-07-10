plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.effectivemobileapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.effectivemobileapplication"
        minSdk = 26
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
    buildFeatures {
        viewBinding = true
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


    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation("com.google.dagger:dagger:2.51.1")
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(project(":shared:tickets:core"))
    implementation(project(":feature:tickets:musicaltickets"))
    implementation(project(":feature:tickets:searchtickets"))
    implementation(project(":feature:tickets:showtickets"))
    implementation(project(":feature:tickets:ticketstocountry"))
    implementation(project(":feature:screens:screenhotels"))
    implementation(project(":feature:screens:screengps"))
    implementation(project(":feature:screens:screenprofile"))
    implementation(project(":feature:screens:screensubscribers"))

    implementation(project(":feature:tickets:weekends"))
    implementation(project(":feature:tickets:firetickets"))
    implementation(project(":feature:tickets:anywheretickets"))


    kapt("com.google.dagger:dagger-android-processor:2.51.1")
    kapt("com.google.dagger:dagger-compiler:2.51.1")

    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.0")

    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation(libs.logging.interceptor)

    implementation("com.github.terrakok:cicerone:7.1")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}