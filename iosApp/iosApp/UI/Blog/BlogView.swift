//
//  BlogView.swift
//  iosApp
//
//  Created by 清水亮 on 2025/02/23.
//  Copyright © 2025 orgName. All rights reserved.
//

import Shared
import SwiftUI

struct BlogView: View {
    let onPress: ((_ post: Post) -> Void)? = { post in
        print("============ from BlogView: \(post)")
    }

    var body: some View {
        NavigationStack {
            PostList(viewModel: PostListViewModel(tag: .blog), onPress: onPress)
                .navigationTitle("Blog")
        }
    }
}

struct BlogView_Previews: PreviewProvider {
    static var previews: some View {
        BlogView()
    }
}
