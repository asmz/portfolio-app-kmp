//
//  Nameplate.swift
//  iosApp
//
//  Created by 清水亮 on 2025/02/23.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct Nameplate: View {
    var body: some View {
        VStack(spacing: 36) {
            VStack(spacing: 16) {
                Image(.avatar)
                    .resizable()
                    .scaledToFit()
                    .frame(width: /*@START_MENU_TOKEN@*/100/*@END_MENU_TOKEN@*/)
                    .clipShape(Circle())
                Text("asmz")
                    .font(.title3)
                    .bold()
                    .foregroundColor(Color(.text))
                Text("Akira Shimizu")
                    .font(.body)
                    .foregroundColor(Color(.text))
            }
            Text("純東北産麦芽系エンジニア")
                .font(.body)
                .foregroundColor(Color(.text))
        }
        .padding(.top, 150)
        .padding(.bottom, 50)
    }
}

#Preview {
    Nameplate()
}
