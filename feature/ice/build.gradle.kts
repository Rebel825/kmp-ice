plugins {
    alias(libs.plugins.featureModule)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.dataCore.network)

            implementation(libs.ktor.core)

            implementation(libs.kotlinx.serialization.json)

            implementation(libs.kotlinx.datetime)

            implementation(libs.androidx.paging.common)
            implementation(libs.androidx.paging.compose)

            implementation(libs.coil)
            implementation(libs.coil.ktor)

            implementation(libs.haze)
            implementation(libs.haze.materials)
        }
    }
}

android {
    namespace = "com.reach.kmp.feature.ice"
}


