package com.jucelinux.weatherapp.data.server

import com.jucelinux.weatherapp.data.db.ForecastDb
import com.jucelinux.weatherapp.domain.datasource.ForecastDataSource
import com.jucelinux.weatherapp.domain.model.Forecast
import com.jucelinux.weatherapp.domain.model.ForecastList
import java.lang.UnsupportedOperationException

class ForecastServer(private val dataMapper: ServerDataMapper = ServerDataMapper(),
                     private val forecastDb: ForecastDb = ForecastDb()
) : ForecastDataSource {

    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode, result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode, date)
    }

    override fun requestDayForecast(id: Long) = throw UnsupportedOperationException()
}