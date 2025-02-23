//
//  AccountItem.swift
//  iosApp
//
//  Created by 清水亮 on 2025/02/23.
//  Copyright © 2025 orgName. All rights reserved.
//

import Shared
import SwiftUI

struct AccountItem: View {
    @Environment(\.openURL) private var openURL
    let account: Account

    var body: some View {
        Button(action: {
            openURL(URL(string: account.url)!)
        }) {
            HStack {
                HStack(spacing: 16) {
                    Image("\(account.service)")
                        .resizable()
                        .frame(width: 32, height: 32)
                        .scaledToFit()
                    Text(account.name).foregroundColor(Color(.text))
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
    AccountItem(account: Account(service: "twitter", name: "_asmz", url: "https://x.com/_asmz"))
}
