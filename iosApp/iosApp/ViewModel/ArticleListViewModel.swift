//
//  ArticleListViewModel.swift
//  GREE TechCon
//
//  Created by Yuto Yazaki on 2020/02/27.
//

import common

class ArticleListViewModel: ObservableObject {
  @Published var articleListItems: [ArticleListItem] = []

  init(articleListService: ArticleListService = ArticleListService()) {
    articleListService.articles.watch { [weak self] articleListItems in
      guard let items = articleListItems as? [ArticleListItem] else { return }
      self?.articleListItems = items
    }
  }
}
