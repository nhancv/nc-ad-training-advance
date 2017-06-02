# Android Component Programming

`mvp | dagger | event bus | router`

**This** is a example project around using some useful android component programming

- **mvp** - abbreviated from Model-View-Presenter which is modern android architecture.
- **dagger** -  is a fully static, compile-time dependency injection framework for both Java and Android.
- **event bus** - an Eventbus is a mechanism that allows different components to communicate with each other without knowing about each other.
- **router** - ui navigation flow.

----------


## Integrate libs

### Retrolambda
At top in `app/build.gradle`
```gradle
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'me.tatarka:gradle-retrolambda:3.2.2'
    }
}

apply plugin: 'com.android.application'
apply plugin: 'me.tatarka.retrolambda'
```
Continue in `android` block in `app/build.gradle`
```gradle
android {
	
	....
	
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }

    packagingOptions {
        exclude 'META-INF/LICENSE.txt'
        exclude 'META-INF/NOTICE.txt'
    }
}
```

### Android annotations
At top in `app/build.gradle`
```gradle
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'me.tatarka:gradle-retrolambda:3.2.2'
        classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
    }
}

apply plugin: 'com.android.application'
apply plugin: 'me.tatarka.retrolambda'
apply plugin: 'android-apt'
```

Continue add dependencies
```gradle
    //android annotation
    apt "org.androidannotations:androidannotations:4.1.0"
    compile "org.androidannotations:androidannotations-api:4.1.0"
```

### Multi dex
At end of root `build.gradle` file
```gradle
subprojects {
    project.plugins.whenPluginAdded { plugin ->
        if ("com.android.build.gradle.AppPlugin".equals(plugin.class.name)) {
            project.android.dexOptions.preDexLibraries = false
        } else if ("com.android.build.gradle.LibraryPlugin".equals(plugin.class.name)) {
            project.android.dexOptions.preDexLibraries = false
        }
    }
}
```
In `app/build.gradle` file
```gradle
defaultConfig {
        ...
        multiDexEnabled true
    }
```

Add below block above `dependencies`
```gradle
apt {
    arguments {
        androidManifestFile variant.outputs[0]?.processResources?.manifestFile
        resourcePackageName android.defaultConfig.applicationId
    }
}

afterEvaluate {
    tasks.matching {
        it.name.startsWith('dex')
    }.each { dx ->
        if (dx.additionalParameters == null) {
            dx.additionalParameters = ['--multi-dex']
        } else {
            dx.additionalParameters += '--multi-dex'
        }
    }
}
```

Add dependence
```
    compile 'com.android.support:multidex:1.0.1'
```
Create class called `MainApplication`
```java
import org.androidannotations.annotations.EApplication;

@EApplication
public class MainApplication extends MultiDexApplication {
}
```

Declare in manifest
```
<application
        android:name=".MainApplication_"
        >
```

### Dagger
In `app/build.gradle`
```gradle
    //dagger
    apt 'com.google.dagger:dagger-compiler:2.8'
    compile 'com.google.dagger:dagger:2.8'
    provided 'javax.annotation:jsr250-api:1.0'
```

### Mosby
In `app/build.gradle`
```gradle
    //mosby mvp lib
    compile 'com.hannesdorfmann.mosby:mvp:2.0.1'
    compile 'com.hannesdorfmann.mosby:viewstate:2.0.1'
```
### Rxjava/rxandroid
In `app/build.gradle`
```gradle
    //Async
    compile 'io.reactivex:rxandroid:1.2.0'
    compile 'io.reactivex:rxjava:1.1.5'
```
### Retrofit, gson, eventbus, cicerone
In `app/build.gradle`
```gradle
    //retrofit
    compile 'com.squareup.retrofit2:retrofit:2.1.0'
    compile 'com.squareup.retrofit2:converter-gson:2.1.0'
    compile 'com.google.code.gson:gson:2.7'
    //event bus
    compile 'org.greenrobot:eventbus:3.0.0'
    //cicerone
    compile 'ru.terrakok.cicerone:cicerone:1.2.1'
```
