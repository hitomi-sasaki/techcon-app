//
//  SessionListView.swift
//  iosApp
//
//  Created by Yazaki Yuto on 2020/01/06.
//

import common
import SwiftUI

struct SessionListView: View {
  let sessions: [SessionListItem]

  var body: some View {
    List {
      ForEach(sessions, id: \.id) { session in
        ZStack {
          SessionRowView(session: session)
          NavigationLink(destination: SessionDetailView(sessionId: Int(session.id))) {
            EmptyView()
          }.buttonStyle(PlainButtonStyle())
        }.listRowInsets(EdgeInsets())
      }
    }
  }
}
