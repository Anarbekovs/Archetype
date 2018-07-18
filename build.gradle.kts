// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    //TODO: Bad style, should search better approach
    val androidPluginVersion = "3.2.0-alpha15"
    val kotlinVersion = "1.2.51"
    val smugglerVersion = "0.14.0"

    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:$androidPluginVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("io.mironov.smuggler:smuggler-plugin:$smugglerVersion")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}

//TODO: Note! The block of code below must be reviewed
configurations.all {
    resolutionStrategy {
        eachDependency {
            val group = this.requested.group
            if (group == "com.android.databinding" && this.requested.name == "compiler") {
                this.useVersion("3.2.0-alpha14")
            }
        }
        failOnVersionConflict()
    }
}
