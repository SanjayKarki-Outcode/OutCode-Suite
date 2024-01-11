package com.outcodesoftware.outcodesuite.framework

class AppResult<T> {
    var status: Status
    var response: T?
    var error: String?
    var progressStat: ProgressStat? = null

    constructor(status: Status, data: T? = null, error: String?){
        this.status = status
        this.response = data
        this.error = error
    }

    constructor(status: Status, data: T? = null, error: String?, progressStat: ProgressStat){
        this.status = status
        this.response = data
        this.error = error
        this.progressStat = progressStat
    }

    enum class Status {
        INIT, LOADING, LOADING_FINISHED, SUCCESS, ERROR, NO_INTERNET_AVAILABLE, TOKEN_EXPIRED, IN_PROGRESS, USER_NOT_VERIFIED,EMPTY,EXCEPTION,SAVEONDB
    }

    companion object {

        fun <T> init(): AppResult<T> {
            return AppResult<T>(Status.INIT, null, null)
        }

        fun <T> success(data: T): AppResult<T> {
            return AppResult(Status.SUCCESS, data, null)
        }



        fun <T> saveonDB(data: T): AppResult<T> {
            return AppResult(Status.SAVEONDB, data, null)
        }

        fun <T> error(error: String?): AppResult<T> {
            return AppResult(Status.ERROR, null, error)
        }

        fun <T> tokenExpired(error: String?): AppResult<T> {
            return AppResult(Status.TOKEN_EXPIRED, null, error)
        }

        fun <T> onException(error: String?): AppResult<T> {
            return AppResult(Status.EXCEPTION, null, error)
        }


        fun <T> userNotVerified(error: String?): AppResult<T> {
            return AppResult(Status.USER_NOT_VERIFIED, null, error)
        }

        fun <T> inProgress(data: ProgressStat): AppResult<T> {
            return AppResult(Status.IN_PROGRESS, null, null, data)
        }

        fun <T> loading(): AppResult<T> {
            return AppResult<T>(Status.LOADING, null, null)
        }

        fun <T> empty(message: String?): AppResult<T> {
            return AppResult(Status.EMPTY, null, message)
        }

        fun <T> loadingFinished(): AppResult<T> {
            return AppResult(Status.LOADING_FINISHED, null, null)
        }

        fun <T> noInternetAvailable(): AppResult<T> {
            return AppResult(Status.NO_INTERNET_AVAILABLE, null, "No internet connection found")
        }
    }


    class ProgressStat {
        var message: String = ""
        var percent: Double = 0.0
        var totalFileCount: Int = 0
        var totalUploadFileCountTillNow = 0
        var totalUploadFileTillNowInMb = 0.0
        var totalSizeFileInMb = 0.0
    }


}