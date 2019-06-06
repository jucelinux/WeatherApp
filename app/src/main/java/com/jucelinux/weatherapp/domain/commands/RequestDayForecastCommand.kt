package com.jucelinux.weatherapp.domain.commands

import com.jucelinux.weatherapp.domain.datasource.ForecastProvider
import com.jucelinux.weatherapp.domain.model.Forecast

class RequestDayForecastCommand(
    val id: Long,
    private val forecastProvider: ForecastProvider = ForecastProvider()) :
    Command<Forecast> {

    override fun execute() = forecastProvider.requestForecast(id)
}