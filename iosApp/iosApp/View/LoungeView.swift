//
//  LoungeView.swift
//  iosApp
//
//  Created by Yuto Yazaki on 2020/02/23.
//

import SwiftUI

struct LoungeView: View {
    var body: some View {
        NavigationView {
            Text("ラウンジ")
                .navigationBarTitle("ラウンジ", displayMode: .inline)
        }
    }
}

struct LoungeView_Previews: PreviewProvider {
    static var previews: some View {
        LoungeView()
    }
}
