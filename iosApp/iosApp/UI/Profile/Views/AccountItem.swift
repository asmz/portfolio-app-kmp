//
//  AccountItem.swift
//  iosApp
//
//  Created by 清水亮 on 2025/02/23.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct AccountItem: View {
    let name: String
    let onPress: () -> Void = {
        print("onPress!!!!")
    }

    var body: some View {
        Button(action: onPress) {
            HStack {
                HStack(spacing: 16) {
                    Image(.twitter)
                        .resizable()
                        .frame(width: 32, height: 32)
                        .scaledToFit()
                    Text(name).foregroundColor(Color(.text))
                }
                Image(systemName: "arrow.up.forward.app")
                    .foregroundColor(Color(.subText))
                    .frame(maxWidth: /*@START_MENU_TOKEN@*/ .infinity/*@END_MENU_TOKEN@*/, alignment: .trailing)
            }
            .frame(maxWidth: /*@START_MENU_TOKEN@*/ .infinity/*@END_MENU_TOKEN@*/, alignment: .leading)
            .frame(height: 54)
            .padding(.horizontal, 16)
            .background(Color(.blurGray))
            .cornerRadius(15)
        }
    }
}

#Preview {
    AccountItem(name: "twitter")
}
