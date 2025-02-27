//
//  ProfileView.swift
//  iosApp
//
//  Created by 清水亮 on 2025/02/23.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct ProfileView: View {
    var body: some View {
        VStack {
            ScrollView {
                Nameplate()
                AccountList()
            }
        }
        .background(Image(.beer))
    }
}

#Preview {
    ProfileView()
}
