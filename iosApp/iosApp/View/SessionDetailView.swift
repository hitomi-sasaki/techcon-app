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
        NavigationView {
            VStack(alignment: .leading) {
                HStack {
                    Text("A-1 ／")
                    Text("13:45 - 14:15")
                    Spacer()
                    Image("bookmarkOn")
                }
                Spacer().frame(height: 24.0)
                Text("はじめてのクラウド環境構築〜VM からコンテナまで〜")
                Spacer().frame(height: 16.0)
                Text("#Security  #AWS  #Audit")
                Spacer().frame(height: 24.0)
                Text("本セッションでは、Compute Engine によってクラウド上のサーバーを活用する方法、Kubenetes を利用して簡単にスケーラブルなシステムを構築する方法を、実際のハンズオンを通して学習していただきます。")
                Spacer().frame(height: 24.0)
                VStack {
                    HStack(spacing: 16.0) {
                        Image("")
                            .frame(width: 64.0, height: 64.0, alignment: .center)
                            .scaledToFill()
                            .background(Color.gray)
                        VStack(alignment: .leading, spacing: 8.0) {
                            Text("森 槙悟")
                            Text("セキュリティエンジニア")
                        }
                        Spacer()
                    }
                }
                .padding(20.0)
                .background(Color(red: 247/255, green: 247/255, blue: 247/255))
                Spacer().frame(height: 24.0)
            }
            .padding(16.0)
        }
    }
}

struct SessionDetailView_Previews: PreviewProvider {
    static var previews: some View {
        SessionDetailView()
    }
}
