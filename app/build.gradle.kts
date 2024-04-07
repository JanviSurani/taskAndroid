plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    id("com.google.gms.google-services")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
//    id("com.google.firebase.crashlytics")


}

android {
    namespace = "com.example.taskandroid"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.taskandroid"
        minSdk = 30
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
        viewBinding=true
        dataBinding=true

    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    kapt {
        correctErrorTypes = true
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.test.ext:junit-ktx:1.1.5")
    implementation("androidx.media3:media3-session:1.2.1")
    implementation("com.google.android.gms:play-services-auth:20.3.0")
    androidTestImplementation("org.testng:testng:6.9.6")
    testImplementation("junit:junit:4.13.2")
    implementation("androidx.test:monitor:1.6.1")
    implementation ("com.android.support:multidex:1.0.3")
    implementation("androidx.work:work-runtime-ktx:2.7.0")
    implementation ("androidx.work:work-runtime:2.9.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.5")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.databinding:databinding-runtime:8.2.1")
    implementation( "androidx.activity:activity-ktx:1.2.0-alpha06")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
    implementation("de.hdodenhof:circleimageview:3.1.0")

    // CAMERA /EXOPLAYER
    implementation("androidx.camera:camera-lifecycle:1.3.1")
    implementation("androidx.camera:camera-camera2:1.3.1")
    implementation("androidx.camera:camera-view:1.3.1")
    implementation( "androidx.camera:camera-view:1.0.0-alpha13")
    implementation("androidx.camera:camera-core:1.3.1")
    implementation("com.google.android.exoplayer:exoplayer:2.16.1")

    // GOOGLE MAP / LOCATION
    implementation("com.google.android.gms:play-services-location:21.0.1")
    implementation("com.google.android.gms:play-services-maps:18.2.0")
    implementation("com.google.maps.android:android-maps-utils:2.3.0")
    implementation("com.google.android.gms:play-services-maps-license:12.0.1")

    // FIREBASE
    implementation(platform("com.google.firebase:firebase-bom:32.7.1"))
    implementation("com.google.firebase:firebase-storage")
    implementation("com.google.firebase:firebase-messaging:23.4.0")
    implementation("com.google.firebase:firebase-auth-ktx:22.3.1")
    implementation("com.google.firebase:firebase-database-ktx:20.3.0")
    implementation("com.google.firebase:firebase-firestore:24.10.1")
//    implementation("com.google.firebase:firebase-crashlytics")
//    implementation("com.google.firebase:firebase-analytics")

    // SERIALIZATION
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
    implementation ("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")

    // RETROFIT API/ DAGGER / HILT / MVVM  / RECYCLERVIEW
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.google.code.gson:gson:2.8.5")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.11.0")
    implementation ("com.google.dagger:dagger:2.40")
    kapt( "com.google.dagger:dagger-compiler:2.40")
    implementation ("com.google.dagger:hilt-android:2.48")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    kapt ("com.google.dagger:hilt-android-compiler:2.48")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation ("androidx.recyclerview:recyclerview:1.1.0")
    implementation ("androidx.recyclerview:recyclerview:1.4.0-alpha01")

    // ROOM DATABASE
    implementation("androidx.room:room-ktx:2.6.1")
    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")

    // REFRESH / SLIDING PANEL
    implementation ("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("androidx.slidingpanelayout:slidingpanelayout:1.2.0")
    implementation ("com.sothree.slidinguppanel:library:3.4.0")

    // PHOTO LOAD
//    implementation ("com.github.bumptech.glide:glide:4.12.0")
    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation("com.squareup.picasso:picasso:2.71828")
}