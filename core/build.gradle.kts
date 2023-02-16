buildscript {
    apply(from = "../buildDependencies/feature.gradle")
}

dependencies {
    api(project(":common-utils"))
    api(project(":data"))
}