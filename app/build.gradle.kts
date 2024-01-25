plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

apply {
    from("$rootDir/buildoptions.gradle")
    from("$rootDir/base.gradle")
}

android {
    namespace = "com.biggerthannull.marvelheroes"
}

dependencies {
    implementation(project(":data:comics"))
    implementation(project(":domain:comics"))
    implementation(project(":feature:feed"))

    // Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.48")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
    kapt("com.google.dagger:hilt-android-compiler:2.48.1")

    // Jetpack Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")
}