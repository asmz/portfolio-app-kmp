//
//  AccountList.swift
//  iosApp
//
//  Created by 清水亮 on 2025/02/23.
//  Copyright © 2025 orgName. All rights reserved.
//

import Shared
import SwiftUI

struct AccountList: View {
    let accounts = Account.companion.getAccountList()

    var body: some View {
        VStack {
            ForEach(accounts, id: \.self) { account in
                AccountItem(account: account)
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
