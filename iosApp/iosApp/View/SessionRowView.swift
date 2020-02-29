//
//  SessionRowView.swift
//  iosApp
//
//  Created by Yazaki Yuto on 2020/01/06.
//

import common
import SwiftUI

struct SessionRowView: View {
  let session: SessionListItem

  var body: some View {
    VStack(alignment: .leading, spacing: 8.0) {
      Text(session.dateText)
        .font(.system(size: 20.0))
        .foregroundColor(.primary)
      VStack(alignment: .leading, spacing: 0.0) {
        HStack {
          Text(session.trackName)
            .font(.system(size: 14.0, weight: .bold))
            .foregroundColor(.secondary)
          Spacer()
          Image(session.isBookmarked ? "bookmarkOn" : "bookmarkOff")
        }
        Text(session.title)
          .foregroundColor(.primary)
          .padding(.bottom, 16.0)
          .padding(.top, 12.0)
        Text(session.tags)
          .font(.system(size: 14.0))
          .lineSpacing(6.0)
          .foregroundColor(.secondary)
          .padding(.bottom, 16.0)
        HStack {
          Image("")
            .frame(width: 48.0, height: 48.0, alignment: .center)
            .scaledToFill()
            .background(Color.gray)
            .cornerRadius(40.0)
          VStack(alignment: .leading) {
            Text(session.speaker.name)
              .font(.system(size: 14.0))
              .foregroundColor(.primary)
            Text(session.speaker.title)
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
    .background(Color(red: 247 / 255, green: 247 / 255, blue: 247 / 255))
  }
}

struct SessionRowView_Previews: PreviewProvider {
  static var previews: some View {
    let speaker = Speaker(name: "{speaker.name}", title: "{speaker.title}", githubId: "{speaker.github_id}", twitterId: "{speaker.twitter_id}", description: "{speaker.description}")
    let item = SessionListItem(id: 0, name: "{session_name}", tags: "{tags}", dateText: "{date_text}", title: "{title}", trackName: "{track_name}", speaker: speaker, isBookmarked: true)
    return SessionRowView(session: item)
  }
}
