

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    kotlin("plugin.serialization") version "1.9.10"
}

kotlin {

    val ktorVersion = "2.3.4"

    androidTarget()
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
            export("dev.icerock.moko:mvvm-core:0.16.1")

        }

    }

    val voyagerVersion = "1.0.0-rc07"

    sourceSets {
        val commonMain by getting {
            dependencies {




                //put your multiplatform dependencies here
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
                implementation(compose.animation)




                // opting below code to use moko resource as below api is experimental and causes crash
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)

                implementation("cafe.adriel.voyager:voyager-navigator:$voyagerVersion")




                // serialization
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")

                // ktor
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
                implementation("io.ktor:ktor-client-logging:$ktorVersion")

                api("io.github.qdsfdhvh:image-loader:1.6.4")

                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")

            }
        }

        val androidMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation("io.ktor:ktor-client-android:$ktorVersion")


            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation("io.ktor:ktor-client-darwin:$ktorVersion")

            }
        }


        val commonTest by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "com.outcodesoftware.outcodesuite"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}



dependencies {
    implementation("androidx.core:core:1.12.0")
    commonMainApi("dev.icerock.moko:mvvm-core:0.16.1")
    commonMainApi("dev.icerock.moko:mvvm-compose:0.16.1")
    commonMainApi("dev.icerock.moko:mvvm-flow:0.16.1")
    commonMainApi("dev.icerock.moko:mvvm-flow-compose:0.16.1")
//    commonMainApi("dev.icerock.moko:resources:0.23.0")
//    commonMainApi("dev.icerock.moko:resources-compose:0.23.0")
    commonMainImplementation("io.github.epicarchitect:calendar-compose-basis:1.0.4")
    commonMainImplementation("io.github.epicarchitect:calendar-compose-ranges:1.0.4") // includes basis
    commonMainImplementation("io.github.epicarchitect:calendar-compose-pager:1.0.4")
    commonMainImplementation("io.github.epicarchitect:calendar-compose-datepicker:1.0.4")
}

