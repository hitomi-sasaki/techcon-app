//
//  SessionDetailView.swift
//  GREE TechCon
//
//  Created by Yuto Yazaki on 2020/02/28.
//

import common
import SwiftUI

struct SessionDetailView: View {
  @ObservedObject fileprivate var viewModel: SessionDetailViewModel

  var body: some View {
    guard let session = viewModel.session else {
      return AnyView(EmptyView())
    }
    return AnyView(List {
      VStack(alignment: .leading) {
        Group {
          HStack(alignment: .center, spacing: 6.0) {
            Text("A-1 ／")
              .font(.system(size: 18.0, weight: .bold))
              .foregroundColor(.secondary)
            Text("13:45 - 14:15")
              .font(.system(size: 18.0))
              .foregroundColor(.primary)
            Spacer()
            Image("bookmarkOff")
          }
          Spacer().frame(height: 24.0)
          Text(session.title)
            .font(.system(size: 20.0, weight: .bold))
            .lineSpacing(8.0)
            .foregroundColor(.primary)
          Spacer().frame(height: 16.0)
          Text(session.tagList.map { "#\($0)" }.joined(separator: " "))
            .font(.system(size: 14.0))
            .lineSpacing(6.0)
            .foregroundColor(.secondary)
          Spacer().frame(height: 24.0)
          Text(session.descriptionText)
            .font(.system(size: 14.0))
            .lineSpacing(6.0)
            .foregroundColor(.primary)
          Spacer().frame(height: 24.0)
        }
        ForEach(0 ..< session.name.count) {
          self.speakerView(from: session.name[$0])
        }
        Spacer().frame(height: 24.0)
        HStack {
          Spacer()
          Button(
            action: {
              print("tapped")
            }, label: {
              HStack(alignment: .center, spacing: 8.0) {
                Image("bookmarkOff")
                  .foregroundColor(.primary)
                Text("マイスケジュールに追加")
                  .font(.system(size: 12.0, weight: .bold))
                  .foregroundColor(.primary)
              }
              .frame(width: 215.0, height: 44.0)
              .overlay(RoundedRectangle(cornerRadius: 4.0).stroke(Color.secondary, lineWidth: 1.0))
            }
          )
          Spacer()
        }
        Spacer().frame(height: 24.0)
      }
      .padding(16.0)
      .listRowInsets(EdgeInsets())
    }.buttonStyle(PlainButtonStyle()))
  }

  init(sessionId: Int) {
    viewModel = SessionDetailViewModel(sessionId: sessionId)
  }

  private func speakerView(from speaker: Speaker) -> some View {
    VStack(alignment: .leading, spacing: 16.0) {
      HStack(alignment: .center, spacing: 16.0) {
        Image("")
          .frame(width: 64.0, height: 64.0, alignment: .center)
          .scaledToFill()
          .background(Color.gray)
        VStack(alignment: .leading, spacing: 8.0) {
          Text(speaker.name)
            .font(.system(size: 18.0))
            .foregroundColor(.primary)
          Text(speaker.title)
            .font(.system(size: 11.0))
            .foregroundColor(.secondary)
        }
        Spacer()
      }
      Text(speaker.descriptionText)
        .font(.system(size: 11.0))
        .lineSpacing(5.0)
        .foregroundColor(.primary)
        .fixedSize(horizontal: false, vertical: true)
    }
    .padding(20.0)
    .background(Color(red: 247 / 255, green: 247 / 255, blue: 247 / 255))
  }
}

struct SessionDetailView_Previews: PreviewProvider {
  static var previews: some View {
    let view = SessionDetailView(sessionId: 0)
    view.viewModel.session = Session.Companion().getSample()
    return view
  }
}
