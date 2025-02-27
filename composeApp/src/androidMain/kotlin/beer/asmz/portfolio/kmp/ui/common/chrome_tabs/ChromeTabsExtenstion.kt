package beer.asmz.portfolio.kmp.ui.common.chrome_tabs

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent

fun Context.launchCustomTabs(url: String?) {
    if (url == null) return

    CustomTabsIntent.Builder()
        .build()
        .launchUrl(this, Uri.parse(url))
}
