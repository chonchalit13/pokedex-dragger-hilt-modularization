buildscript {
    apply(from = "../buildDependencies/feature.gradle")
}

dependencies {
    implementation(project(":resource"))
    api(project(":core"))
}