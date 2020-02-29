//
//  SessionViewController.swift
//  GREE TechCon
//
//  Created by Yuto Yazaki on 2020/02/23.
//

import Parchment
import SwiftUI
import UIKit

struct SessionViewController: UIViewControllerRepresentable {
  func makeUIViewController(context: UIViewControllerRepresentableContext<SessionViewController>) -> PagingViewController {
    let vc1 = UIHostingController(rootView: SessionListView())
    vc1.title = "Aトラック"
    let vc2 = UIViewController()
    vc2.title = "Bトラック"
    let vc3 = UIViewController()
    vc3.title = "ショートトラック"
    let pagingViewController = PagingViewController(viewControllers: [vc1, vc2, vc3])

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
