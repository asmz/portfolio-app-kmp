//
//  ApiErrorAlert.swift
//  iosApp
//
//  Created by 清水亮 on 2025/02/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct ApiErrorAlert: ViewModifier {
    let error: Error?
    let onDismiss: () -> Void

    private var isPresented: Binding<Bool> {
        Binding(
            get: { error != nil },
            set: { _ in }
        )
    }

    func body(content: Content) -> some View {
        content.alert("Error", isPresented: isPresented) {
            Button("OK") {
                onDismiss()
            }
        } message: {
            Text(error?.localizedDescription ?? "Unknown Error.")
        }
    }
}

extension View {
    func apiErrorAlert(error: Error?, onDismiss: @escaping () -> Void) -> some View {
        modifier(ApiErrorAlert(error: error, onDismiss: onDismiss))
    }
}
