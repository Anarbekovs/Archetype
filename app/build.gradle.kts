//TODO: Bad style, should search better approach
val kotlin_version = "1.2.51"
val supportLibVersion = "27.1.1"
val glideVersion = "3.7.0"
val glideOkHttp = "1.5.0"
val lastAdapterVersion = "2.3.0"
val okhttpVersion = "3.6.0"
val retrofitVersion = "2.2.0"

plugins {
    id("com.android.application")
    id("io.mironov.smuggler")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(27)
    buildToolsVersion("27.0.3")
    defaultConfig {
        applicationId = "com.stepango.archetype"
        minSdkVersion(21)
        targetSdkVersion(27)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    dataBinding {
        isEnabled = true
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version")
    implementation("io.reactivex.rxjava2:rxjava:2.1.10")
    implementation("io.reactivex.rxjava2:rxandroid:2.0.2")
    implementation("com.stepango.koptional:koptional:1.2.0")

    implementation("com.android.support:recyclerview-v7:$supportLibVersion") {
        exclude(group = "com.android.support", module = "support-v4")
    }

    implementation("com.stepango.rxdatabindings:rxdatabindings:1.2.1@aar") {
        exclude(group = "com.android.databinding", module = "library")
        exclude(group = "com.android.databinding", module = "baseLibrary")
        exclude(group = "com.android.databinding", module = "adapters")
    }

    implementation("com.github.nitrico.lastadapter:lastadapter:$lastAdapterVersion") {
        exclude(group = "com.android.databinding", module = "library")
        exclude(group = "com.android.databinding", module = "baseLibrary")
        exclude(group = "com.android.databinding", module = "adapters")
    }

//    compile("com.android.databinding:library:$dataBinding") {
//        exclude group: "com.android.support", module: "support-v4"
//    }

    //TODO: remove it and solve version clash problem
    implementation("com.android.support:support-v4:$supportLibVersion")

    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
    testImplementation("com.squareup.okhttp3:mockwebserver:$okhttpVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$okhttpVersion")
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-simplexml:$retrofitVersion") {
        exclude(module = "stax")
        exclude(module = "stax-api")
        exclude(module = "xpp3")
    }
    implementation("com.trello.navi2:navi:2.0")

    implementation("com.github.bumptech.glide:glide:$glideVersion")
    implementation("com.github.bumptech.glide:okhttp3-integration:$glideOkHttp@aar")

    testImplementation("junit:junit:4.12")
    testImplementation("org.jetbrains.kotlin:kotlin-reflect:$kotlin_version")
    testImplementation("com.nhaarman:mockito-kotlin:1.5.0")
    testImplementation("org.mockito:mockito-core:2.13.0")

}

kapt {
    generateStubs = true
}
