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
    private let tag: TagType

    @Published var posts: [Post] = []
    @Published var totalPosts: Int32 = 0
    @Published var isLoading: Bool = false

    private let LIMIT = 20

    init(tag: TagType) {
        self.tag = tag
    }

    func fetchPosts() async {
        let repository = ThumblrRepository()

        let params = [
            "offset": "0",
            "limit": "\(LIMIT)",
            "tag": "\(tag)",
        ]

        do {
            self.isLoading = true
            let result = try await repository.getPosts(params: params)

            self.posts = result.posts
            self.totalPosts = result.totalPosts
            self.isLoading = false
        } catch {
            print(error)
        }
    }
}
