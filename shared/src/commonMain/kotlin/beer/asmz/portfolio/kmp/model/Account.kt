package beer.asmz.portfolio.kmp.model

data class Account(
    val service: String,
    val name: String,
    val url: String,
) {
    companion object {
        fun getAccountList(): List<Account> {
            return listOf(
                Account("twitter", "_asmz", "https://x.com/_asmz"),
                Account("facebook", "asmz0", "https://www.facebook.com/asmz0"),
                Account("github", "asmz", "https://github.com/asmz"),
                Account("note", "asmz", "https://note.mu/asmz"),
                Account("speakerdeck", "asmz", "https://speakerdeck.com/asmz"),
                Account("hatenablog", "asmz0", "https://asmz.hatenablog.jp/"),
            )
        }
    }
}