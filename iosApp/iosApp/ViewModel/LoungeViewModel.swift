//
//  LoungeViewModel.swift
//  GREE TechCon
//
//  Created by Yuto Yazaki on 2020/03/09.
//

import common

class LoungeViewModel: ObservableObject {
  @Published var booths: [Booth] = []

  init(loungeService: LoungeService = LoungeService()) {
    loungeService.get().watch { [weak self] booths in
      guard let booths = booths as? [Booth] else { return }
      self?.booths = booths
    }
  }
}
