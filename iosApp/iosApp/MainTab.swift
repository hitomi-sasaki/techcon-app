//
//  MainTab.swift
//  iosApp
//
//  Created by Yazaki Yuto on 2020/01/06.
//

import SwiftUI

struct MainTab: View {
  var body: some View {
    TabView {
      SessionList()
        .tabItem { Text("セッション") }
        .tag(0)
      SessionList()
        .tabItem { Text("セッション") }
        .tag(0)
    }
  }
}
