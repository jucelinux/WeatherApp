package com.jucelinux.weatherapp.domain.commands

import com.jucelinux.weatherapp.data.ForecastRequest
import com.jucelinux.weatherapp.domain.mappers.ForecastDataMapper
import com.jucelinux.weatherapp.domain.model.ForecastList

class RequestForecastCommand(private val zipCode: String) :
    Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}