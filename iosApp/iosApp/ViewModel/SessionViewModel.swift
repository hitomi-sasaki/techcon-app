//
//  SessionViewModel.swift
//  iosApp
//
//  Created by Yuto Yazaki on 2020/02/23.
//

import common

class SessionViewModel: ObservableObject {
  @Published var sessionListState: SessionListState?

  init(sessionListService: SessionListService = SessionListService()) {
    sessionListService.state.watch { [weak self] sessionListState in
      self?.sessionListState = sessionListState
    }
  }
}
