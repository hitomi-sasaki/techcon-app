//
//  SessionView.swift
//  GREE TechCon
//
//  Created by Yuto Yazaki on 2020/03/08.
//

import SwiftUI

struct SessionView: View {
  @ObservedObject(initialValue: SessionViewModel()) private var viewModel: SessionViewModel

  var body: some View {
    NavigationView {
      contentBody.navigationBarTitle("セッション", displayMode: .inline)
    }
  }

  private var contentBody: some View {
    if let sessionList = viewModel.sessionListState {
      return AnyView(SessionViewController(tracks: sessionList.tracks))
    } else {
      return AnyView(Text("loading"))
    }
  }
}
