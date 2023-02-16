buildscript {
    apply(from = "../buildDependencies/feature.gradle")
}

dependencies {
    implementation(project(":domain"))
}