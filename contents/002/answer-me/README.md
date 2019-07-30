[目次](../toc.md)
[前の問題](../001/README.md)　[次の問題](../003/README.md)

***
## 002：javacコマンド
* javacコマンドが使用するJavaのバージョンを出力するコマンドを実行せよ。



### Answer

```
$ javac -help
... 省略
 -Akey[=value]              注釈プロセッサに渡されるオプション
  -X                         非標準オプションの概要を出力する
  -J<flag>                   <flag>を実行システムに直接渡す
  -Werror                    警告が発生した場合にコンパイルを終了する
  @<filename>                ファイルからの読取りオプションおよびファイル名

```

- `-J`オプションを使えば、java コマンドにflagを直接渡すことができる
- よって、`java -version`を実行したい場合は、以下のコマンドを実行することで解決する

```
$ javac -J-version
openjdk version "1.8.0_212"
OpenJDK Runtime Environment (build 1.8.0_212-8u212-b03-0ubuntu1.18.04.1-b03)
OpenJDK 64-Bit Server VM (build 25.212-b03, mixed mode)

```

