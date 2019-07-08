import com.android.build.gradle.BaseExtension
import com.android.build.gradle.internal.api.ApkVariantOutputImpl
import com.android.build.gradle.internal.dsl.DataBindingOptions
import org.gradle.internal.impldep.com.amazonaws.PredefinedClientConfigurations.defaultConfig

//apply plugin: 'com.android.application'

//apply plugin: 'kotlin-android'

//apply plugin: 'kotlin-android-extensions'
plugins {
    //    id("com.android.application")
//    id("kotlin-android")
//    id("kotlin-android-extensions")

//    id("com.android.application" )
//    id("kotlin-android")
//    id("kotlin-andorid-extensions")

    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

infix fun BaseExtension.complie(version: Int) {
    compileSdkVersion(version)
}
android {
    //    compileSdkVersion (28)
    complie(28)
    defaultConfig {
        applicationId = "com.example.testdemo"
        minSdkVersion(15)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
    }

    lintOptions {

        isAbortOnError = false
    }

    buildTypes {
        //        create("release") {
//
//            isJniDebuggable = true
//            isMinifyEnabled = false
//            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-pro.txt")
//        }
    }

    dataBinding {
        isEnabled = true
    }


    android.applicationVariants.all {
        println("**********************" + this.outputs)
        outputs.all {
            if (this is ApkVariantOutputImpl) {
                outputFileName = "Nihasf.apk"
            }
        }
    }

//    android.applicationVariants.all {
//        outputs.forEach {
//
//            (it as? ApkVariantOutputImpl)?.outputFileName = "zllllllllllllll.ipa"
//
//        }
//
//    }
}

dependencies {
    //    implementation (fileTree(org.gradle.internal.impldep.bsh.commands.dir =  'libs', include= ['*.jar']))
//    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version")
//    implementation('androidx.appcompat:appcompat:1.0.2')
//    implementation ('androidx.core:core-ktx:1.0.2')
//    implementation ('androidx.constraintlayout:constraintlayout:1.1.3')
//    implementation ('com.github.bumptech.glide:glide:4.9.0')
//    annotationProcessor ('com.github.bumptech.glide:compiler:4.9.0')
//    implementation fileTree(include: ['*.jar'], dir: 'libs')

    implementation(fileTree("include" to "['*.jar']", "dir" to "libs"))
    implementation(
        group = "org.jetbrains.kotlin",
        name = "kotlin-stdlib-jdk7",
        version = rootProject.properties["kotlin_version"].toString()
    )

    implementation("androidx.appcompat:appcompat:1.0.2")
    implementation("androidx.core:core-ktx:1.0.2")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("com.github.bumptech.glide:glide:4.9.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.9.0")
}


//apply from : "variant.gradle.kts"

//
//android {
//    compileSdkVersion 28
//    defaultConfig {
//        applicationId "com.example.testdemo"
//        minSdkVersion 15
//        targetSdkVersion 28
//        versionCode 1
//        versionName "1.0"
//    }
//    lintOptions {
//        abortOnError false
//    }
//    buildTypes {
//        release {
//            jniDebuggable
//            minifyEnabled false
//            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
//        }
//    }
//
//    dataBinding {
//        enabled true
//    }
//
//
//
//}
//
//dependencies {
//    implementation fileTree(org.gradle.internal.impldep.bsh.commands.dir: 'libs', include: ['*.jar'])
//    implementation"org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
//    implementation 'androidx.appcompat:appcompat:1.0.2'
//    implementation 'androidx.core:core-ktx:1.0.2'
//    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
//
//    implementation 'com.github.bumptech.glide:glide:4.9.0'
//    annotationProcessor 'com.github.bumptech.glide:compiler:4.9.0'
//}
