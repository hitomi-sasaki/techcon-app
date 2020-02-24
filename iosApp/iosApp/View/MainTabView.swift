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
                .tabItem {
                    Text("お知らせ")
                    Image("naviIcon01")
                }
            NavigationView { SessionViewController().navigationBarTitle("セッション", displayMode: .inline) }
                .tabItem {
                    Text("セッション")
                    Image("naviIcon02")
                }
            BookmarkListView()
                .tabItem {
                    Text("スケジュール")
                    Image("naviIcon03")
                }
            LoungeView()
                .tabItem {
                    Text("ラウンジ")
                    Image("naviIcon04")
                }
        }
    }
}
