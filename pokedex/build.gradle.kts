buildscript {
    apply(from = "../buildDependencies/feature.gradle")
}

dependencies {
    implementation(project(":resource"))
    implementation(project(":common-utils"))
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":core"))
}