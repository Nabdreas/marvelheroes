plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

apply {
    from("$rootDir/buildoptions.gradle")
    from("$rootDir/base.gradle")
}

android {
    namespace = "com.biggerthannull.marvelheroes.data.comics"
    defaultConfig {
        buildConfigField("String", "MARVEL_TS", "\"${project.property("ts")}\"")
        buildConfigField("String", "MARVEL_HAS", "\"${project.property("hash")}\"")
        buildConfigField("String", "MARVEL_API_KEY", "\"${project.property("apiKey")}\"")
    }

}

dependencies {

    implementation(project(":domain:comics"))

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    // Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.48")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
    kapt("com.google.dagger:hilt-android-compiler:2.48.1")

    // Unit testing
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("io.mockk:mockk:1.13.9")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.12.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}