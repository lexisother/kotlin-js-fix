plugins {
    `kotlin-dsl`
    id("com.gradle.plugin-publish") version "1.2.1"
}

repositories {
    gradlePluginPortal()
}

kotlin {
    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.1.10")
    }
}

group = "me.nathanfallet.kotlinjsfix"
version = "1.0.2"

gradlePlugin {
    website = "https://github.com/nathanfallet/kotlin-js-fix"
    vcsUrl = "https://github.com/nathanfallet/kotlin-js-fix.git"

    plugins {
        create("kotlin-js-fix-gradle-plugin") {
            id = "me.nathanfallet.kotlinjsfix"
            implementationClass = "me.nathanfallet.kotlinjsfix.KotlinJsFix"
            displayName = "A fix for Kotlin/JS compiler"
            description =
                "Allows to temporarily fix Kotlin/JS compiler, like export interfaces to JS and use them in TypeScript without __doNotUseOrImplementIt"
            tags = listOf("kotlin", "js", "interface", "fix")
        }
    }
}

publishing {
    repositories {
        mavenLocal()
        maven {
            name = "GithubPackages"
            url = uri("https://maven.pkg.github.com/lexisother/kotlin-js-fix")
            credentials {
                username = System.getenv("USERNAME")
                password = System.getenv("TOKEN")
            }
        }
    }
}
