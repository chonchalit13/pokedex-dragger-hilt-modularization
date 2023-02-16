buildscript {
    apply(from = "../buildDependencies/feature.gradle")
}

dependencies {
    implementation(project(":common-utils"))
    implementation(project(":data"))
}