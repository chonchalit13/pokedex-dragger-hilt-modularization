buildscript {
    apply(from = "../buildDependencies/feature.gradle")
}

dependencies {
    api(project(":domain"))
}