import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementation(depName: String) {
    add("implementation", depName)
}

fun DependencyHandler.implementationPlatform(depName: String) {
    add("implementation", platform(depName))
}

fun DependencyHandler.debugImplementation(depName: String) {
    add("debugImplementation", depName)
}

fun DependencyHandler.releaseImplementation(depName: String) {
    add("releaseImplementation", depName)
}

internal fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}

internal fun DependencyHandler.compileOnly(depName: String) {
    add("compileOnly", depName)
}

internal fun DependencyHandler.testImpl(depName: String) {
    add("testImplementation", depName)
}

internal fun DependencyHandler.androidTestImpl(depName: String) {
    add("androidTestImplementation", depName)
}

internal fun DependencyHandler.api(depName: String) {
    add("api", depName)
}

internal fun DependencyHandler.classPath(depName: String) {
    add("classpath", depName)
}