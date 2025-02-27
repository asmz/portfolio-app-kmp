//
//  SafariViewModifier.swift
//  iosApp
//
//  Created by 清水亮 on 2025/02/26.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct SafariViewModifier: ViewModifier {
    let url: URL?
    let onDismiss: (() -> Void)?

    private var isPresented: Binding<Bool> {
        Binding(
            get: { url != nil },
            set: { _ in }
        )
    }

    func body(content: Content) -> some View {
        content.fullScreenCover(isPresented: isPresented) {
            if let url {
                SafariView(url: url, onDismiss: onDismiss)
                    .edgesIgnoringSafeArea(.all)
            }
        }
    }
}

extension View {
    func openSafariView(url: URL?, onDismiss: (() -> Void)? = nil) -> some View {
        return modifier(SafariViewModifier(url: url, onDismiss: onDismiss))
    }
}
