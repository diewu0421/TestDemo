import com.android.build.gradle.BaseExtension
import com.android.build.gradle.internal.api.ApkVariantOutputImpl
plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

infix fun BaseExtension.complie(version: Int) {
    compileSdkVersion(version)
}
fun getApkVersionName(): String {

    val stout = org.apache.commons.io.output.ByteArrayOutputStream()
    exec {
        commandLine(listOf("git","describe","--abbrev=0","--tags"))
        standardOutput = stout
    }
    println("apkverisonname = ${stout.toString()}")

    return stout.toString().replace("\n", "", false) + "zlw"
}

fun Any?.printObject() {
    println("${this?.javaClass?.simpleName} = $this")
}

android {
    //    compileSdkVersion Z(28)
    complie(28)
    defaultConfig {
        applicationId = "com.example.testdemo"
        minSdkVersion(15)
        targetSdkVersion(28)
        versionCode = 1
        versionName = getApkVersionName()
        resConfigs("zh","xxxhdpi")
    }

    lintOptions {

        isAbortOnError = false
    }

    buildTypes {
        create("tx") {
            manifestPlaceholders.put("name","zlw")
        }
    }

    adbOptions {
        installOptions("-r","-d","-t")
    }

    flavorDimensions("zlw")

    productFlavors {

        create("hw") {

            manifestPlaceholders.put("name", "hw")
            setDimension("zlw")

            resValue("string", "yj_found_chinese", "我是华为")
            buildTypes.getByName("release") {
                resValue("string", "yj_found_chinese", "我是华为release")
                println("\n------------------------------------------------\nhw buildtypes is ${this}")
            }

            buildTypes.getByName("debug") {
                resValue("string", "yj_found_chinese", "我是华为debug")
                println("\n------------------------------------------------\nhw buildtypes is ${this}")

                //配置混淆
                isMinifyEnabled = true
                isShrinkResources = true
                proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),"proguard-rules.pro")
            }

        }

        create("xiaomi") {
            setDimension("zlw")
            manifestPlaceholders["name"] = "xiaomi"
            resValue("string", "yj_found_chinese", "我是小米")
        }
    }


    productFlavors.all {
        println("productFlavors = $this")
    }

    buildTypes.all {
        println("buildtype = $this")
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

}

repositories {
    flatDir {
        dirs("libs")
        println("默认的保存路径为: $dirs")
    }
}

dependencies {

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


    //引入aar
//    implementation("", name = "mylibrary-1.0.0", ext = "aar")

    implementation("com.yunji.library:mylibrary:1.0.3")
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
