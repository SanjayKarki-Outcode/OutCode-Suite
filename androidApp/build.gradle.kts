plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.compose")
}

android {
    namespace = "com.outcodesoftware.outcodesuite.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.outcodesoftware.outcodesuite.android"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

val composeVersion = "1.5.3"

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.compose.foundation:foundation:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.activity:activity-compose:1.8.1")

}