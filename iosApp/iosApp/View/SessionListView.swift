//
//  SessionListView.swift
//  iosApp
//
//  Created by Yazaki Yuto on 2020/01/06.
//

import SwiftUI
import common

struct SessionListView: View {
    @ObservedObject(initialValue: SessionListViewModel()) private var vm: SessionListViewModel

    var body: some View {
        NavigationView {
            List(vm.sessionListItems, id: \.id) { session in
                SessionRowView(session: session)
            }
            .navigationBarTitle("セッション", displayMode: .inline)
        }
    }
}
