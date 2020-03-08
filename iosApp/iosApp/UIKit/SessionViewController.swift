//
//  SessionViewController.swift
//  GREE TechCon
//
//  Created by Yuto Yazaki on 2020/02/23.
//

import common
import Parchment
import SwiftUI
import UIKit

struct SessionViewController: UIViewControllerRepresentable {
  let tracks: [SessionListTrack]

  func makeUIViewController(context: UIViewControllerRepresentableContext<SessionViewController>) -> PagingViewController {
    let viewControllers: [UIViewController] = tracks.map {
      let vc = UIHostingController(rootView: SessionListView(sessions: $0.sessions))
      vc.title = $0.name
      return vc
    }

    let pagingViewController = PagingViewController(viewControllers: viewControllers)
    pagingViewController.register(SessionPagingCell.self, for: PagingIndexItem.self)
    pagingViewController.menuItemSize = .sizeToFit(minWidth: 50.0, height: 48.0)
    pagingViewController.menuInsets = UIEdgeInsets.zero
    pagingViewController.indicatorColor = .darkGray
    pagingViewController.indicatorOptions = .visible(height: 2.0, zIndex: Int.max, spacing: .zero, insets: .zero)
    pagingViewController.borderOptions = .visible(height: 1.0, zIndex: Int.max - 1, insets: .zero)
    return pagingViewController
  }

  func updateUIViewController(_ uiViewController: PagingViewController,
                              context: UIViewControllerRepresentableContext<SessionViewController>) {
    // TODO: ナビゲーションバーの下線を消す。多分TabViewをUITabBarControllerに置き換えたほうが早い。
//        uiViewController.navigationBar.shadowImage = UIImage()
//        uiViewController.navigationBar.setBackgroundImage(UIImage(), for: .default)
  }
}
