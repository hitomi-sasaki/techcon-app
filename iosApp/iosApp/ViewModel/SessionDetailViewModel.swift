//
//  SessionDetailViewModel.swift
//  GREE TechCon
//
//  Created by Yuto Yazaki on 2020/02/29.
//

import common

class SessionDetailViewModel: ObservableObject {
  @Published var session: Session?
  private let sessionId: Int
  private let sessionDetailService: SessionDetailService

  init(sessionId: Int, sessionDetailService: SessionDetailService = SessionDetailService()) {
    self.sessionId = sessionId
    self.sessionDetailService = sessionDetailService
    get()
  }

  func get() {
    sessionDetailService.get(sessionId: Int64(sessionId)).watch { [weak self] session in
      self?.session = session
    }
  }
}
