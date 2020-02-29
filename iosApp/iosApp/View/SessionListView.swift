//
//  SessionListView.swift
//  iosApp
//
//  Created by Yazaki Yuto on 2020/01/06.
//

import common
import SwiftUI

struct SessionListView: View {
    @ObservedObject(initialValue: SessionListViewModel()) private var vm: SessionListViewModel

    var body: some View {
        List {
            ForEach(vm.sessionListItems, id: \.id) { session in
                SessionRowView(session: session)
                    .listRowInsets(EdgeInsets())
            }
        }
    }
}
