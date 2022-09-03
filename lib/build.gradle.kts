import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "com.kotrols"
version = "1.0-SNAPSHOT"

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        withJava()
    }
    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(compose.foundation)
            }
        }
        named("jvmMain") {
            dependencies {
                implementation("com.mayakapps.compose:window-styler:0.3.2")
            }
        }
    }
}
