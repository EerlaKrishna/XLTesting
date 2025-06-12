plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.xltesting"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.xltesting"
        minSdk = 29
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    packaging {
        resources {
            excludes += "META-INF/INDEX.LIST"
            excludes += "META-INF/io.netty.versions.properties"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Testing dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Selenium & Appium (latest versions)
    implementation("org.seleniumhq.selenium:selenium-java:4.10.0")
    implementation("io.appium:java-client:8.3.0")

    // Netty dependencies explicitly added to avoid missing class errors
    implementation("io.netty:netty-handler:4.1.92.Final")
    implementation("io.netty:netty-handler-proxy:4.1.92.Final")
    implementation("io.netty:netty-codec-http:4.1.92.Final")
    implementation("io.netty:netty-transport:4.1.92.Final")
    implementation("io.netty:netty-transport-native-unix-common:4.1.92.Final")
    implementation("io.netty:netty-common:4.1.92.Final")
    implementation("io.netty:netty-buffer:4.1.92.Final")
    implementation("io.netty:netty-resolver:4.1.92.Final")
    implementation("io.netty:netty-codec:4.1.92.Final")
    implementation("io.netty:netty-transport-native-epoll:4.1.92.Final")
    implementation("io.netty:netty-transport-native-kqueue:4.1.92.Final")

    // TestNG
    testImplementation("org.testng:testng:7.4.0")

    // Recommended logging framework (SLF4J)
    implementation("org.slf4j:slf4j-api:1.7.30")
    implementation("org.slf4j:slf4j-simple:1.7.30")
}

configurations.all {
    resolutionStrategy.force("io.netty:netty-handler:4.1.92.Final")
    resolutionStrategy.force("io.netty:netty-codec-http:4.1.92.Final")
}
