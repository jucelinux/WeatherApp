package com.jucelinux.weatherapp.domain.commands

interface Command<out T> {
    fun execute(): T
}