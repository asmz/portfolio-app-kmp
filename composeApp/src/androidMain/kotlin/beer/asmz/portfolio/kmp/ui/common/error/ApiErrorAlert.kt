package beer.asmz.portfolio.kmp.ui.common.error

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import beer.asmz.portfolio.kmp.ui.AppTheme

@Composable
fun ApiErrorAlert(error: Throwable, onDismiss: (() -> Unit)) {
    AlertDialog(
        onDismissRequest = {
            onDismiss()
        },
        title = {
            Text("Error")
        },
        text = {
            Text(error.message ?: "Unknown Error.")
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onDismiss()
                }
            ) {
                Text("OK")
            }
        },
        dismissButton = null
    )
}

@Preview
@Composable
fun ApiErrorAlertPreview() {
    AppTheme {
        ApiErrorAlert(Error("test"), onDismiss = {})
    }
}
