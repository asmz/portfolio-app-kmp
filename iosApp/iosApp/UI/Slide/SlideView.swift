//
//  SlideView.swift
//  iosApp
//
//  Created by 清水亮 on 2025/02/23.
//  Copyright © 2025 orgName. All rights reserved.
//

import Shared
import SwiftUI

struct SlideView: View {
    let onPress: ((_ post: Post) -> Void)? = { post in
        print("============ from Slide: \(post)")
    }

    var body: some View {
        NavigationStack {
            PostList(viewModel: PostListViewModel(tag: .slide), onPress: onPress)
                .navigationTitle("Slide")
        }
    }
}

struct SlideView_Previews: PreviewProvider {
    static var previews: some View {
        SlideView()
    }
}
