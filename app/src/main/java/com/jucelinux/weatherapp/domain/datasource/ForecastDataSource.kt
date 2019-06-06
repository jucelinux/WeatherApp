package com.jucelinux.weatherapp.domain.datasource

import com.jucelinux.weatherapp.domain.model.Forecast
import com.jucelinux.weatherapp.domain.model.ForecastList

interface ForecastDataSource {

    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

    fun requestDayForecast(id: Long): Forecast?
}
