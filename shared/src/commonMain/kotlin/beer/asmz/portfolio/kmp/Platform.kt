package beer.asmz.portfolio.kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform