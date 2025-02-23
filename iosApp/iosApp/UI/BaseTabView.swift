//
//  BaseTabView.swift
//  iosApp
//
//  Created by 清水亮 on 2025/02/23.
//  Copyright © 2025 orgName. All rights reserved.
//

import Shared
import SwiftUI

struct BaseTabView: View {
    @State var selection: TabType = .profile

    var body: some View {
        TabView {
            ProfileView().body.tabItem {
                Label("Profile", systemImage: "person.fill")
            }
            .tag(TabType.profile)

            BlogView().body.tabItem {
                Label("Blog", systemImage: "square.and.pencil")
            }
            .tag(TabType.blog)

            SlideView().body.tabItem {
                Label("Slide", systemImage: "rectangle.inset.filled.and.person.filled")
            }
            .tag(TabType.slide)
        }
        .accentColor(Color(.accent))
    }
}

struct BaseTabView_Previews: PreviewProvider {
    static var previews: some View {
        BaseTabView()
    }
}
