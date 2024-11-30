plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "group.kalmykov.unittests"
    compileSdk = 34

    defaultConfig {
        applicationId = "group.kalmykov.unittests"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)


    // Инструментальные тесты
  /*  testImplementation("androidx.test.ext:junit:1.1.5")
    testImplementation("androidx.test.espresso:espresso-core:3.5.1")*/

   /* // JUnit для тестов
    testImplementation 'junit:junit:4.13.2'

    // Mockito для создания моков
    testImplementation 'org.mockito:mockito-core:4.11.0'

    // AssertJ для дополнительных удобств при проверке утверждений (опционально)
    testImplementation 'org.assertj:assertj-core:3.24.2'

    // Для проверки многопоточных операций
    testImplementation 'org.awaitility:awaitility:4.2.0'*/
}