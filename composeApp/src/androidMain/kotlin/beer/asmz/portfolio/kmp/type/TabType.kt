package beer.asmz.portfolio.kmp.type

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CoPresent
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

enum class TabType(
    val id: String,
    val icon: ImageVector,
    val label: String
) {
    Profile(
        id = "base/profile",
        icon = Icons.Default.Person,
        label = "Profile"
    ),
    Blog(
        id = "base/blog",
        icon = Icons.Default.EditNote,
        label = "Blog"
    ),
    Slide(
        id = "base/slide",
        icon = Icons.Default.CoPresent,
        label = "Slide"
    )
}