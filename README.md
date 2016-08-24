# Java 100本ノック

***
# Java 100本ノックとは

プログラミング言語 Java に関するスキル向上を目的とした問題集です。
具体的には、運用環境で安定稼働でき、かつ、保守性・拡張性に優れたコードがより多く生産できるようになることを目指しています。

***
# ルール

* コーディング規約は、Oracle社が公開している [Code Conventions for the Java Programming Language](http://www.oracle.com/technetwork/articles/javase/codeconvtoc-136057.html) に従うものとします。
* 特に断り書きがない限り、JavaコアAPIおよびJavaEEと、JDK標準のコマンドのみを使用することとします。

***
# リポジトリ構成
## ディレクトリ構造

以下のディレクトリ構造とします。

```
/
├ README.md                         README(本書)
├ eula.txt                          使用許諾契約
│
└ contents/                         100本ノック設問および回答
  ├ toc.md                          問題の目次
  │
  └ nnn/                            設問番号(001～100)
    ├ README.md                     問題
    ├ (問題のREADME.mdから参照される画像など；imagesなどディレクトリを作成してもOK)
    │
    ├ answer/                       回答例(このディレクトリ配下はREADME.md以外自由)
    │├ README.md                   回答の説明
    │├ answernnn.bat               例：回答プログラム実行用batファイル(nnnは設問番号)
    │├ answernnn.sh                例：回答プログラム実行用shファイル(nnnは設問番号)
    │├ pom.xml                     例：Maven用定義ファイル
    │├ src/                        例：ソース
    │├ conf/                       例：コンフィグファイル
    │：
    │
    └ test/                         回答が正しいことを確認するテスト(README.md以外自由)
      ├ README.md                   テストの説明
      ├ testnnn.bat                 例：テスト実行用batファイル(nnnは設問番号)
      ├ testnnn.sh                  例：テスト実行用shファイル(nnnは設問番号)
      ├ pom.xml                     例：Maven用定義ファイル
      ├ src/                        例：ソース
      ├ conf/                       例：コンフィグファイル
      ：
```

## 各ファイル共通の規定
* ファイルの文字コードは UTF-8 とします。
* 問題や回答に関係のない内容は含めないようにします。
* .mdファイル のフォーマットは、 [GitHub Flavored Markdown](https://guides.github.com/features/mastering-markdown/) 形式とします。

## 問題ファイルの規定

* Webブラウザで問題を巡回して参照できるように、以下の3つのリンクを設けることとします。
    1. [問題の目次](contents/toc.md) へのリンク
    2. 前の問題 へのリンク ([001](contents/001/README.md)ではリンクなし)
    3. 次の問題 へのリンク ([100](contents/100/README.md)ではリンクなし)

## 回答ファイルの規定

* `README.md` に回答文書を記載します。
    * プログラムを実行するものについては実行方法をなるべく詳細に記述します。
    * 冒頭に 問題 へのリンクを設けることとします。
* Javaコードのpackageはデフォルトとします。

***
# ご利用条件
以下の利用条件は、株式会社ジャストシステム（以下、「弊社」といいます）が、本リポジトリ(https://github.com/JustSystems/java-100practices) で公開されるすべてのファイル、プログラム、および情報（以下、これらを総称して「本公開情報」といいいます）の取扱いに関し定めたものです。本公開情報を本リポジトリ上に公開する者（以下「開示者」といいます）及び本公開情報を利用する者（以下「利用者」といいます）は、本公開情報の公開及び利用に関し、以下の内容に同意のうえ本リポジトリをご利用いただくものとします。なお、本リポジトリの公開は予告なく終了する場合があります。

記

1. 本公開情報は開示者から現状有姿で提供され、その品質および機能が完全であることおよび利用者の使用目的に適合することを保証するものではなく、開示者は本公開情報についての瑕疵担保責任および保証責任を一切負いません。本公開情報の利用は利用者の責任で行うものとし、本公開情報の利用およびその結果についても同様とします。
2. 開示者は、本公開情報の使用または使用不能から生ずる直接的または間接的損害については一切責任を負いません。
3. 利用者に対し、本公開情報に関するサポートは一切提供されません。
4.弊社は、利用者から受領する本公開情報の評価結果、不具合、ご意見、ご要望、改修内容等（以下、これらを総称して「報告内容」といいます）を、以下の各号に従い取り扱うものとします。

    (1) 弊社が運営する本公開情報のコミュニティにおいて、報告内容をお受けします。

    (2) 弊社は、すべての報告内容に対する不具合の是正又はご意見、ご要望、改修内容の反映を保証するものではありません。

    (3) 受領した報告内容は、本公開情報の一部として公開され、弊社および利用者が無償で利用できるものとします。

以上
