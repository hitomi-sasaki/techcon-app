//
//  LoungeRowView.swift
//  GREE TechCon
//
//  Created by Yuto Yazaki on 2020/03/09.
//

import common
import SwiftUI

struct LoungeRowView: View {
  let index: Int
  let booth: Booth

  var body: some View {
    VStack(alignment: .leading, spacing: 16.0) {
      HStack(alignment: .center, spacing: 8.0) {
        Text("\(index).")
          .font(.system(size: 20.0, weight: .bold))
          .foregroundColor(.primary)
        Text(booth.title)
          .font(.system(size: 18.0))
          .foregroundColor(.primary)
        Spacer()
      }
      Text(booth.descriptionText)
        .font(.system(size: 14.0))
        .foregroundColor(.secondary)
        .lineSpacing(6.0)
    }
    .padding(EdgeInsets(top: 12.0, leading: 0, bottom: 12.0, trailing: 0))
  }
}

struct LoungeRowView_Previews: PreviewProvider {
  static var previews: some View {
    LoungeRowView(index: 1, booth: Booth(id: 0, title: "{title}", description: "{description}"))
  }
}
