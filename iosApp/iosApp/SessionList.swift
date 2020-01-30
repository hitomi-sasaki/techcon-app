//
//  SessionList.swift
//  iosApp
//
//  Created by Yazaki Yuto on 2020/01/06.
//

import SwiftUI
import common

struct SessionList: View {
  @ObservedObject(initialValue: SessionListViewModel()) private var vm: SessionListViewModel

  var body: some View {
    NavigationView {
      List(vm.sessionListItems, id: \.id) { session in
        SessionRow(session: session)
      }
      .navigationBarTitle("セッション", displayMode: .large)
    }
  }
}

fileprivate class SessionListViewModel: ObservableObject {
  @Published var sessionListItems: [SessionListItem] = []
    
    init(sessionListService: SessionListService = SessionListService()) {
        sessionListService.sessions.watch { [weak self] (sessionListItems) in
            guard let items = sessionListItems as? [SessionListItem] else { return }
            self?.sessionListItems = items
        }
    }
}
