plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.paraglan.coulinary"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.paraglan.coulinary"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.play.services.cast.framework)
    implementation(libs.firebase.crashlytics.buildtools)
    implementation(libs.androidx.foundation.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //Compose navigation
    debugImplementation("androidx.navigation:navigation-compose:2.7.7")
    debugImplementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    implementation ("androidx.navigation:navigation-compose:2.8.0-alpha08")

    //Room
    implementation ("androidx.room:room-runtime:2.6.0")
    implementation ("androidx.room:room-ktx:2.6.0")
    ksp ("androidx.room:room-compiler:2.6.0")

    //
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")
    implementation ("androidx.compose.runtime:runtime:1.6.7")

    //StatusBarColor
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.19.0")
    implementation ("com.google.accompanist:accompanist-pager:0.30.1")
    implementation ("com.google.accompanist:accompanist-pager-indicators:0.30.1")
    implementation ("com.google.accompanist:accompanist-permissions:0.30.1")
    implementation ("com.google.accompanist:accompanist-insets:0.28.0")

    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

    //Coil
    implementation("io.coil-kt:coil-compose:2.2.2")
    implementation ("io.coil-kt:coil-gif:2.1.0")

// CameraX
    val camerax_version = ("1.0.1")
    //noinspection GradleDependency
    implementation ("androidx.camera:camera-camera2:$camerax_version")
    //noinspection GradleDependency
    implementation ("androidx.camera:camera-lifecycle:$camerax_version")
    implementation ("androidx.camera:camera-view:1.4.0-beta02")

    //Video
    implementation("androidx.media:media:1.6.0")
    //Glide
    implementation (libs.glide)
    annotationProcessor (libs.compiler)

    implementation("org.jsoup:jsoup:1.17.2")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    implementation("androidx.core:core-ktx:1.12.0")
}