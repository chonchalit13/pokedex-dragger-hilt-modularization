package th.co.toei.core.base

sealed class Resource<out R> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val exception: String) : Resource<Nothing>()
}