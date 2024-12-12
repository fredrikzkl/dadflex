package com.example.dadflex

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform