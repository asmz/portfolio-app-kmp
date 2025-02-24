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
    var onPress: ((_ post: Post) -> Void)? = nil

    var body: some View {
        Button(action: {
            onPress?(post)
        }) {
            HStack {
                Text(post.content[0].title!).foregroundColor(Color(.text))
            }
            .frame(maxWidth: /*@START_MENU_TOKEN@*/ .infinity/*@END_MENU_TOKEN@*/, alignment: .leading)
            .frame(height: 54)
            .padding(.horizontal, 16)
            .background(Color(.blurGray))
            .cornerRadius(15)
        }
    }
}

/*
 #Preview {
 PostItem()
 }
 */
