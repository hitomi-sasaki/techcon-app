//
//  SessionListViewModel.swift
//  iosApp
//
//  Created by Yuto Yazaki on 2020/02/23.
//

import common

class SessionListViewModel: ObservableObject {
    @Published var sessionListItems: [SessionListItem] = []

    init(sessionListService: SessionListService = SessionListService()) {
        sessionListService.sessions.watch { [weak self] sessionListItems in
            guard let items = sessionListItems as? [SessionListItem] else { return }
            self?.sessionListItems = items
        }
    }
}
