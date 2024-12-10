package org.example.dadflex

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform