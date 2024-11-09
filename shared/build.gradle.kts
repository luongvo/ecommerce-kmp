plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    jvm("desktop"){
        compilations.all {
            kotlinOptions.jvmTarget = "17"
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            // Include a static library instead of a dynamic one into the framework.
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                // Ktor
                val ktorVersion = extra["ktor.version"] as String
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-logging:$ktorVersion")
                implementation("io.ktor:ktor-client-serialization:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

                // Serialization
                val serializationVersion = extra["serialization.version"] as String
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion")

                // Coroutines
                val coroutinesVersion = extra["coroutines.version"] as String
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")

                // Logger
                val napierVersion = extra["napier.version"] as String
                implementation("io.github.aakira:napier:$napierVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                val ktorVersion = extra["ktor.version"] as String
                implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by getting {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                val ktorVersion = extra["ktor.version"] as String
                implementation("io.ktor:ktor-client-darwin:$ktorVersion")
            }
        }
        val desktopMain by getting {
            dependencies {
                val ktorVersion = extra["ktor.version"] as String
                implementation("io.ktor:ktor-client-apache:$ktorVersion")
            }
        }
        val desktopTest by getting
    }
}

android {
    compileSdk = 34
    namespace = "vn.luongvo.kmp.ecommerce"
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
    }
}
