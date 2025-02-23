//
//  AccountList.swift
//  iosApp
//
//  Created by 清水亮 on 2025/02/23.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct AccountList: View {
    let data = ["a", "b", "c", "b", "c", "b", "c", "b", "c"]

    var body: some View {
        VStack {
            ForEach(data, id: \.self) { text in
                AccountItem(name: text)
            }
            .padding(.horizontal, 32)
            .padding(.vertical, 4)
        }
        .padding(.bottom, 30)
    }
}

#Preview {
    AccountList()
}
