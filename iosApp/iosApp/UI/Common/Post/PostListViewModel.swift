//
//  PostListViewModel.swift
//  iosApp
//
//  Created by 清水亮 on 2025/02/24.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import Shared

@MainActor
class PostListViewModel: ObservableObject {
    private let tag: PostTag

    @Published var posts: [Post] = []
    @Published var isLoading: Bool = false
    @Published var isRefreshing: Bool = false
    @Published var error: Error? = nil

    private let LIMIT = 20
    private var offset = 0
    private var hasNext = true

    init(tag: PostTag) {
        self.tag = tag
    }

    func fetchPosts() async {
        if !hasNext || isLoading { return }

        let repository = ThumblrRepository()

        let params = [
            "offset": "\(offset)",
            "limit": "\(LIMIT)",
            "tag": "\(tag)",
        ]

        do {
            defer {
                isLoading = false
            }
            isLoading = true
            let response = try await repository.getPosts(params: params)

            posts.append(contentsOf: response.posts)
            offset += LIMIT
            hasNext = response.totalPosts > posts.count
        } catch {
            self.error = error
            hasNext = false
        }
    }

    func refresh() async {
        isRefreshing = true

        posts = []
        offset = 0
        hasNext = true

        await fetchPosts()

        isRefreshing = false
    }
}
