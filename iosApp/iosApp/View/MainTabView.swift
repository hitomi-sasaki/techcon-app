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
      SessionListView()
        .tabItem { Text("セッション") }
        .tag(0)
      SessionListView()
        .tabItem { Text("セッション") }
        .tag(0)
    }
  }
}
