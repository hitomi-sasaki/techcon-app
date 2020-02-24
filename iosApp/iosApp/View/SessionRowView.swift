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
    VStack(alignment: .leading, spacing: 8.0) {
        Text(session.dateText)
            .font(.system(size: 20.0, weight: .regular))
            .foregroundColor(.primary)
        VStack(alignment: .leading, spacing: 0.0) {
            HStack {
                Text("{セッション番号}")
                    .font(.system(size: 14.0, weight: .bold))
                    .foregroundColor(.secondary)
                Spacer()
                Text("{is_bookmarked}")
            }
            Text(session.title)
                .foregroundColor(.primary)
                .padding(.bottom, 16.0)
                .padding(.top, 12.0)
            HStack {
                Image("")
                    .frame(width: 48.0, height: 48.0, alignment: .center)
                    .scaledToFill()
                    .background(Color.gray)
                    .cornerRadius(40.0)
                VStack(alignment: .leading) {
                    Text(session.names)
                        .font(.system(size: 14.0))
                        .foregroundColor(.primary)
                    Text("{肩書}")
                        .font(.system(size: 11.0))
                        .foregroundColor(.secondary)
                }

            }
        }
        .padding(EdgeInsets(top: 15.0, leading: 16.0, bottom: 18.0, trailing: 20.0))
        .background(Color.white)
        .cornerRadius(4.0)
        .shadow(color: Color.black.opacity(0.2), radius: 3.0, x: 0.0, y: 1.0)
    }
    .padding(EdgeInsets(top: 10.0, leading: 16.0, bottom: 10.0, trailing: 16.0))
    .background(Color(red: 247/255, green: 247/255, blue: 247/255))
  }
}

struct SessionRowView_Previews: PreviewProvider {
    static var previews: some View {
        let item = SessionListItem(id: 0, names: "藤本 真樹", dateText: "13:00 - 13:30", title: "Keynote", isBookmarked: false)
        return SessionRowView(session: item)
    }
}
