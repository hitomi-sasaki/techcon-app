//
//  ArticleRowView.swift
//  GREE TechCon
//
//  Created by Yuto Yazaki on 2020/02/27.
//

import common
import SwiftUI

struct ArticleRowView: View {
    let article: ArticleListItem
    
    var body: some View {
        VStack(alignment: .leading, spacing: 16.0) {
            Text(article.dateText)
                .font(.system(size: 18.0, weight: .bold))
                .foregroundColor(.primary)
            Text(article.title)
                .font(.system(size: 18.0))
                .lineSpacing(6.0)
                .foregroundColor(.primary)
            // FIXME: `.description` property name collide with NSObjectProtocol
            Text(article.description())
                .font(.system(size: 14.0))
                .lineSpacing(6.0)
                .foregroundColor(.secondary)
            Text(article.timeText)
                .font(.system(size: 14.0))
                .foregroundColor(.secondary)
            Divider()
                .padding(.top, 16.0)
        }
        .padding(EdgeInsets(top: 32.0, leading: 16.0, bottom: 0.0, trailing: 16.0))
    }
}

struct ArticleRowView_Previews: PreviewProvider {
    static var previews: some View {
        let article = ArticleListItem(title: "{title}", description: "{description}", timeText: "{time_text}", dateText: "{date_text")
        return ArticleRowView(article: article)
    }
}
