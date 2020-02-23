//
//  BookmarkListView.swift
//  iosApp
//
//  Created by Yuto Yazaki on 2020/02/23.
//

import SwiftUI

struct BookmarkListView: View {
    var body: some View {
        NavigationView {
            Text("スケジュール")
                .navigationBarTitle("マイ スケジュール", displayMode: .inline)
        }
    }
}

struct BookmarkListView_Previews: PreviewProvider {
    static var previews: some View {
        BookmarkListView()
    }
}
