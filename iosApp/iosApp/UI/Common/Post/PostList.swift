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
        List {
            ForEach(viewModel.posts, id: \.self) { post in
                PostItem(post: post, onPress: onPress)
                    .listRowSeparator(.hidden)
                    .task {
                        if viewModel.posts.last == post {
                            await viewModel.fetchPosts()
                        }
                    }
            }
            HStack(alignment: .center) {
                if viewModel.isLoading && !viewModel.isRefreshing {
                    ProgressView()
                        .progressViewStyle(.circular)
                        .tint(Color(.accent))
                        .scaleEffect(x: 1.2, y: 1.2, anchor: .center)
                        .padding(.vertical, 24)
                }
            }
            .frame(maxWidth: .infinity)
            .listRowSeparator(.hidden)
        }
        .listStyle(.plain)
        .refreshable {
            await viewModel.refresh()
        }
        .task {
            if viewModel.posts.isEmpty {
                await viewModel.fetchPosts()
            }
        }
        .onAppear {
            UIRefreshControl.appearance().tintColor = UIColor(Color(.accent))
        }
        .apiErrorAlert(error: viewModel.error) {
            viewModel.error = nil
        }
    }
}

#Preview {
    PostList(
        viewModel: PostListViewModel(tag: .blog)
    )
}
