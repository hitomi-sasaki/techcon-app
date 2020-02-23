//
//  NoticeListView.swift
//  iosApp
//
//  Created by Yuto Yazaki on 2020/02/23.
//

import SwiftUI

struct NoticeListView: View {
    var body: some View {
        NavigationView {
            Text("お知らせ")
                .navigationBarTitle("お知らせ", displayMode: .inline)
        }
    }
}

struct NoticeListView_Previews: PreviewProvider {
    static var previews: some View {
        NoticeListView()
    }
}
