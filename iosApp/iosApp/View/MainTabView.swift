//
//  MainTabView.swift
//  iosApp
//
//  Created by Yazaki Yuto on 2020/01/06.
//

import SwiftUI

struct MainTabView: View {
    var body: some View {
        TabView {
            NoticeListView()
                .tabItem { Text("お知らせ") }
                .tag(0)
            SessionListView()
                .tabItem { Text("セッション") }
                .tag(1)
            BookmarkListView()
                .tabItem { Text("スケジュール") }
                .tag(2)
            LoungeView()
                .tabItem { Text("ラウンジ") }
                .tag(3)
        }
    }
}
