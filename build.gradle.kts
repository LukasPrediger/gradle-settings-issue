@file:Suppress("UnstableApiUsage")

plugins {
    java
    `jvm-test-suite`
}

repositories {
    mavenCentral()
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter()
            dependencies {
                implementation(gradleTestKit())
            }
        }
    }
}

// Required as per issue: https://github.com/gradle/gradle/issues/18647
tasks.test {
    jvmArgs(
        "--add-opens",
        "java.base/java.lang=ALL-UNNAMED",
        "--add-opens",
        "java.base/java.util=ALL-UNNAMED",
    )
}
