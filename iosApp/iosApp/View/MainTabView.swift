//
//  MainTabView.swift
//  iosApp
//
//  Created by Yazaki Yuto on 2020/01/06.
//

import SwiftUI

struct MainTabView: View {
    init() {
        let coloredAppearance = UINavigationBarAppearance()
        coloredAppearance.configureWithOpaqueBackground()
        coloredAppearance.backgroundColor = .white
        coloredAppearance.titleTextAttributes = [.foregroundColor: UIColor.darkGray]
        coloredAppearance.largeTitleTextAttributes = [.foregroundColor: UIColor.darkGray]

        UINavigationBar.appearance().standardAppearance = coloredAppearance
        UINavigationBar.appearance().scrollEdgeAppearance = coloredAppearance
        UITableView.appearance().separatorStyle = .none
    }

    var body: some View {
        TabView {
            NoticeListView()
                .tabItem { Text("お知らせ") }
                .tag(0)
            NavigationView { SessionViewController().navigationBarTitle("セッション", displayMode: .inline) }
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
