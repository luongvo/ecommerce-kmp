plugins{
    kotlin("multiplatform") apply false
    kotlin("plugin.compose") apply false
    kotlin("android") apply false
    id("com.android.application") apply false
    id("com.android.library") apply false
    id("org.jetbrains.compose") apply false
    kotlin("plugin.serialization") apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
