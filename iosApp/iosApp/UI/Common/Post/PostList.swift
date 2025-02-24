//
//  PostList.swift
//  iosApp
//
//  Created by 清水亮 on 2025/02/24.
//  Copyright © 2025 orgName. All rights reserved.
//

import Shared
import SwiftUI

struct PostList: View {
    @ObservedObject var viewModel: PostListViewModel
    var onPress: ((_ post: Post) -> Void)? = nil

    var body: some View {
        List(viewModel.posts, id: \.self) { post in
            PostItem(post: post, onPress: onPress)
        }
        .task {
            await viewModel.fetchPosts()
        }
    }
}

#Preview {
    PostList(
        viewModel: PostListViewModel(tag: .blog)
    )
}
