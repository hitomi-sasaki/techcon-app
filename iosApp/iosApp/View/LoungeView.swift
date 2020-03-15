//
//  LoungeView.swift
//  iosApp
//
//  Created by Yuto Yazaki on 2020/02/23.
//

import SwiftUI

struct LoungeView: View {
  @ObservedObject(initialValue: LoungeViewModel()) private var viewModel: LoungeViewModel

  var body: some View {
    NavigationView {
      List {
        Text("ブースやフリーコーヒー、電源などを準備しています。休憩や、交流の場所としてご利用ください。")
          .font(.system(size: 14.0))
          .foregroundColor(.primary)
          .lineSpacing(6.0)
          .listRowInsets(EdgeInsets(top: 24.0, leading: 0, bottom: 12.0, trailing: 0))
        HStack {
          Spacer()
          Image("loungeMap")
          Spacer()
        }
        .listRowInsets(EdgeInsets(top: 12.0, leading: 0, bottom: 12.0, trailing: 0))
        ForEach(viewModel.booths.indices) { index in
          LoungeRowView(index: index + 1, booth: self.viewModel.booths[index])
            .listRowInsets(EdgeInsets(top: 0, leading: 0, bottom: 0, trailing: 0))
        }
      }
      .padding(EdgeInsets(top: 0.0, leading: 16.0, bottom: 0.0, trailing: 16.0))
      .navigationBarTitle("ラウンジ", displayMode: .inline)
    }
  }
}

struct LoungeView_Previews: PreviewProvider {
  static var previews: some View {
    LoungeView()
  }
}
