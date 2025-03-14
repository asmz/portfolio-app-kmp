//
//  PostItem.swift
//  iosApp
//
//  Created by 清水亮 on 2025/02/24.
//  Copyright © 2025 orgName. All rights reserved.
//

import Shared
import SwiftUI

struct PostItem: View {
    let post: Post
    let onPressItem: ((_ post: Post) -> Void)?

    var content: PostContent {
        post.content[0]
    }

    var poster: PostContentPoster? {
        content.poster?[0]
    }

    var hostname: String {
        if let url = content.url {
            return URL(string: url)?.host ?? ""
        } else {
            return ""
        }
    }

    var formattedDate: String {
        let unixtime = Double(post.timestamp)
        let date = Date(timeIntervalSince1970: unixtime)
        return formatter.string(from: date)
    }

    private let formatter = DateFormatter()
    @State private var safariOpenUrl: URL? = nil

    init(post: Post, onPressItem: ((_ post: Post) -> Void)? = nil) {
        self.post = post
        self.onPressItem = onPressItem
        formatter.dateFormat = "yyyy/MM/dd"
        formatter.locale = Locale(identifier: "ja_JP")
    }

    var body: some View {
        Button(action: {
            if let onPressItem {
                onPressItem(post)
                return
            }
            safariOpenUrl = URL(string: content.url ?? "")
        }) {
            VStack(alignment: .leading) {
                HStack {
                    if let imageUrl = poster?.url {
                        AsyncImage(url: URL(string: imageUrl)) { image in
                            image.resizable()
                                .scaledToFit()
                        } placeholder: {
                            ProgressView()
                        }
                        .frame(width: 112, height: 88)
                    } else {
                        Image(.noimage)
                            .resizable()
                            .frame(width: 112, height: 88)
                    }
                    VStack(alignment: .leading) {
                        Text(content.title ?? "")
                            .font(.system(size: 20))
                            .bold()
                            .foregroundColor(Color(.text))
                            .lineLimit(nil)
                            .padding(.bottom, 16)
                        Text(hostname)
                            .font(.body)
                            .foregroundColor(Color(.subText))
                    }
                    .frame(alignment: .top)
                }
                HStack {
                    ForEach(post.tags, id: \.self) { tag in
                        Text("#\(tag)")
                            .padding(.vertical, 4)
                            .padding(.horizontal, 8)
                            .foregroundColor(Color(.text))
                            .background(Color(.lightGray))
                            .cornerRadius(5)
                    }
                }
                Divider()
                    .padding(.vertical, 16)
                Text(formattedDate)
                    .foregroundColor(Color(.subText))
            }
            .frame(maxWidth: .infinity, alignment: .leading)
            .padding(.horizontal, 16)
            .padding(.vertical, 32)
            .background(Color(.blurGray))
            .cornerRadius(15)
            .background(Color.clear)
        }
        .openSafariView(url: safariOpenUrl) {
            safariOpenUrl = nil
        }
    }
}

#Preview {
    let post = Post(
        idString: "111",
        timestamp: 1480134638,
        tags: ["blog", "contribution"],
        content: [
            PostContent(
                type: "link",
                description: "test description",
                title: "test title abc def ghi jkl mno pqr stu vwx yz - 123 456 789 0",
                url: "https://asmz.beer",
                poster: [
                    PostContentPoster(url: "https://static.tumblr.com/nibuxm5/Q0yo2heyn/beer.jpg")
                ]
            )
        ]
    )

    return PostItem(post: post)
}
