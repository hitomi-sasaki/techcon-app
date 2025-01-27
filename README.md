# techcon-app
GREE Tech Conference 2020公式アプリです。

https://techcon.gree.jp/

## Android

* Kotlin 1.3.6x
* min SDK: 24 (Android7)
* Android Studio 4.0 (preview版)
* Jetpack Compose

### Jetpack Compose
* どういうコンポーネントがあるか、使い方は公式サンプルを見ると良さそう
  * https://github.com/android/compose-samples
* 実際のアプリへの組み込みはこれが参考になりそう 
  * https://github.com/sys1yagi/jetpack-compose-github-app

### ViewBinding
* 一応使ってますがSingle Activity + 個々のFragmentはJetpack Composeになるはずなので無くても良さそう

## iOS

* Kotlin 1.3.6x
* Xcode 11.3.1
* CocoaPods

```
$ cd iosApp
$ pod install
```

## Server

* Ktor

```
$ ./gradlew server:run
$ curl http://localhost:8080

```

Androidエミュレータでの動作確認時は http://10.0.2.2:8080 を使う

開発系はdocker-composeで環境構築しています。
init.shでDBにテーブルが作られ、テストデータが挿入されます。

```
$ docker-compose up -d
$ ./init.sh
```

また、次のコマンドでdocker-composeで立てたDBに接続できます。

```
$ docker exec -it techcon-mysql mysql -uroot -proot --default-character-set=utf8mb4
```

## Infrastructure
GKEで構築します。
deployはSpinker or Istioのどちらかになる予定です。

## Multiplatform

* Kotlin 1.3.6x
* IntelliJ
* commonモジュールがあって、本体となるandroid、server、iosがそれぞれライブラリとして活用する形

### Multiplatform is 何
https://speakerdeck.com/aakira/introduction-kotlin-mpp

### 参考
* MPP全般: https://github.com/JetBrains/kotlinconf-app
* MPPのプロジェクト構成: https://github.com/AAkira/mpp-example
* 罠情報はKotlin Slackで共有されてないか調べるといいかも: https://surveys.jetbrains.com/s3/kotlin-slack-sign-up?_ga=2.79217427.684413600.1574677408-468773269.1532429498
* アーキテクチャ（Android）: https://github.com/sanogueralorenzo/Android-Kotlin-Clean-Architecture
* アーキテクチャ（Android）: https://developer.android.com/jetpack/docs/guide
