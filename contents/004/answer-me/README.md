[目次](../toc.md)
[前の問題](../003/README.md)　[次の問題](../005/README.md)

***
## 004：Javaの更新

* Java実行環境を最新版にアップデートせよ。アップデート後のjavaコマンドを使用して#001 のプログラムを実行せよ。



# Answer

- Ubuntu に複数のJDKをインストール方法は以下に記載されている
  - [Ubuntu 18.04 LTSに複数のJDKをインストールする方法](https://qiita.com/SUZUKI_Masaya/items/a4eb06e826bf56541537)



- [OpenJDKのページ](https://openjdk.java.net/install/) もインストール方法が書いてある
  - 最新バージョンはtar.gzで配布されているようだ
  - 現在の最新は[JDK 14 Early-Access Builds](https://jdk.java.net/14/)なのでこれをダウンロード
- 解凍 & 実行
  - 今後も開発でPCは使うのでパスは通さない

```
$  tar xvf openjdk-14-ea+7_linux-x64_bin.tar.gz 
$ ~/Downloads/jdk-14/bin/javac  -cp ./src -d classes/ src/Answer001.java 
$ ~/Downloads/jdk-14/bin/java -cp classes/ Answer001
```

