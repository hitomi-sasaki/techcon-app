//
//  SessionRowView.swift
//  iosApp
//
//  Created by Yazaki Yuto on 2020/01/06.
//

import SwiftUI
import common

struct SessionRowView: View {
  let session: SessionListItem

  var body: some View {
    VStack(alignment: .leading) {
      Text(session.title)
        .font(.title)
        .bold()
        .layoutPriority(999)
      Text(session.names)
        .font(.body)
      HStack {
        Spacer()
        Text(session.dateText)
          .font(.caption)
      }
    }
  }
}
