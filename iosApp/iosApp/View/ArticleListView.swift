//
//  ArticleListView.swift
//  GREE TechCon
//
//  Created by Yuto Yazaki on 2020/02/27.
//

import SwiftUI

struct ArticleListView: View {
    @ObservedObject(initialValue: ArticleListViewModel()) private var vm: ArticleListViewModel

    var body: some View {
        NavigationView {
            List {
                // FIXME: this `id` should be artilce id
                ForEach(vm.articleListItems, id: \.title) { article in
                    ArticleRowView(article: article)
                        .listRowInsets(EdgeInsets(top: 0, leading: 0, bottom: 0, trailing: 0))
                }
            }
            .navigationBarTitle("お知らせ", displayMode: .inline)
        }
    }
}
