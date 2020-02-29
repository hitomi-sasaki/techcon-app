//
//  SessionDetailView.swift
//  GREE TechCon
//
//  Created by Yuto Yazaki on 2020/02/28.
//

import common
import SwiftUI

struct SessionDetailView: View {
  var body: some View {
    List {
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
          Text("はじめてのクラウド環境構築〜VM からコンテナまで〜")
            .font(.system(size: 20.0, weight: .bold))
            .lineSpacing(8.0)
            .foregroundColor(.primary)
          Spacer().frame(height: 16.0)
          Text("#Security  #AWS  #Audit")
            .font(.system(size: 14.0))
            .lineSpacing(6.0)
            .foregroundColor(.secondary)
          Spacer().frame(height: 24.0)
          Text("本セッションでは、Compute Engine によってクラウド上のサーバーを活用する方法、Kubenetes を利用して簡単にスケーラブルなシステムを構築する方法を、実際のハンズオンを通して学習していただきます。")
            .font(.system(size: 14.0))
            .lineSpacing(6.0)
            .foregroundColor(.primary)
          Spacer().frame(height: 24.0)
        }
        VStack(alignment: .leading, spacing: 16.0) {
          HStack(alignment: .center, spacing: 16.0) {
            Image("")
              .frame(width: 64.0, height: 64.0, alignment: .center)
              .scaledToFill()
              .background(Color.gray)
            VStack(alignment: .leading, spacing: 8.0) {
              Text("森 槙悟")
                .font(.system(size: 18.0))
                .foregroundColor(.primary)
              Text("セキュリティエンジニア")
                .font(.system(size: 11.0))
                .foregroundColor(.secondary)
            }
            Spacer()
          }
          Text("Java プログラミングをはじめ、ネットワーク、セキュリティ、OS（Linux）など幅広い分野で豊富な教育の実施と研修設計、コンテンツ開発の豊富な実績がある。")
            .font(.system(size: 11.0))
            .lineSpacing(5.0)
            .foregroundColor(.primary)
            .fixedSize(horizontal: false, vertical: true)
        }
        .padding(20.0)
        .background(Color(red: 247 / 255, green: 247 / 255, blue: 247 / 255))
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
    }.buttonStyle(PlainButtonStyle())
  }
}

struct SessionDetailView_Previews: PreviewProvider {
  static var previews: some View {
    SessionDetailView()
  }
}
