# きっかけ

- 新卒でシステムエンジニアとして業務を行い現在2年目になりますが、この度自分が携わったJavaEEのWebアプリケーションシステムが商用リリースされることになりました。

- システムのリリースあたっては、性能試験等で「Heapのold領域が~」とか「Metaspace使用率が~」という話が出てくるようになりました。そこでもう一度「どうやってJavaって動いているんだ？」というのを再確認したいと思い、JJUG CCC 2018 Springに参加した際に紹介されていた[Java100本ノック](https://www.slideshare.net/JSUXDesign/java100)をやってみることにしました。

# [Java100本ノックについて](https://www.slideshare.net/JSUXDesign/java100)

- こちらはジャストシステムさんが作成されたJavaの問題集です。初心者~中級者をターゲットにしており、運用環境で安定稼働でき、かつ、保守性・拡張性に優れたコード がより多く生産できるようになることを目指して作成されたそうです。
- 応用力をつけるためにもこういった基礎は反復して定着させていきたいと思い、一本目を解いてみたものの...思った以上に自分がJavaについて全然理解していないことに気づいてしまいました。以下に1本目を解いた時のメモを記載します。

## 1本目

- shell scriptによってTestが実装されている... 
  - [こちらのサイト](https://shellscript.sunone.me/tutorial.html)を参考に読み解く
- JDKについてはインストールされているので割愛
- src配下にAnswer.javaを作成(eclipse等のIDEは使わない!)

- コンパイル... javac オプションは?

  - [oracleの公式ドキュメント](https://docs.oracle.com/javase/jp/6/technotes/tools/windows/javac.html)

  - クラスパスを指定
    - -cp ./src
  - エンコーディング指定
    - -encoding
  - 「コマンド行引数ファイル」というのがあって、javac のコマンド行を短くしたり簡潔にしたりするために、javac コマンドに対する引数 (-J オプションを除く) を含む 1 つ以上のファイルを指定することができます。この方法を使うと、どのオペレーティングシステム上でも、任意の長さの javac コマンドを作成できます。

### コンパイル

```
javac -cp ./src -encoding UTF-8 ./src/Answer001.java
```

### 実行

- javaコマンドのオプションは[こちら](https://docs.oracle.com/javase/jp/1.3/tooldocs/win32/java.html)
  - Java Runtime Environment を起動したあと、指定されたクラスをロードし、このクラスの **main** メソッドを呼び出して Java アプリケーションを起動します。

```
java -cp src/ Answer001
```

- -cp→ classpath これを指定しないとクラスファイルの指定箇所がカレントディレクトリになってしまう。



### 修正

- クラスファイルは classesディレクトリを作るのが慣例? なんだろうか。よって修正してみる。

```
javac -cp ./src -d ./classes src/Answer001.java
java -cp classes/ Answer001
```

- javac の-dオプションはディレクトリを作らないので、作成する必要がある



### テスト実行

- test.shを見ながら

  - content/lib 配下にjunit.jarとhamcrest.jarが必要っぽいのでダウンロードして入手
    
- [こちらから](https://junit.org/junit4/)
    
- junit.jarとhamcrest-core.jarのバージョンの組み合わせがうまくいか無いと
  
  - ```
    java.lang.NoClassDefFoundError: org/hamcrest/SelfDescribing
  ```
  
  が発生
  
  - junit 4.12 & hamcrest 1.3の組み合わせだとうまく行った

### バイトコードを見てみる

- Javaの鉄則を読んで、時々バイトコードからコードの良し悪しを考察する場面が何度かあった。バイトコードを見てみよう。最もポピュラーな例はStringとStringBufferの文字列加算だろう

- javapコマンドを使用、[ドキュメントはこちら](https://docs.oracle.com/javase/jp/6/technotes/tools/windows/javap.html)
  - 「クラスファイルを逆アセンブルします。」とある。
  - -c オプションを使うことでバイトコードの命令を見ることができる。
    - 「クラスの各メソッドのために逆アセンブルされるコード、すなわち Java バイトコードから成る命令を表示します。これらは[「Java Virtual Machine Specification」](http://java.sun.com/docs/books/vmspec/)にドキュメント化されています。」
      - とても膨大なページ数だ...

```
javap -c answer/classes/Answer001.class > Answer001-bytecode.txt
```

```
Compiled from "Answer001.java"
public class Answer001 {
  public Answer001();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #3                  // String Hello, World!
       5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: return
}
```

- 以上のバイトコードの生成に成功
  - invokespecial … メソッドを呼びだす。special handling for superclass, private,and instance initialization method invocations
    - デフォルトコンストラクタを呼び出している
  - ldc... Push item from run-time constant pool (ランタイムの定数プールに"Hello, World!"をpushする)
  - invokevirtual... はインスタンスのメソッドを呼び出します。 最初にインスタンス自体をスタックに積んだ後、引数を順に積んでから、INVOKEVIRTUALで呼び出します。
    - http://jou4.hateblo.jp/entry/2015/10/17/103250
    - 要するにスタックに積んだ"Hello, World!"をinvokevirtualでprintlnメソッドの引数にとっていると解釈した


# 感想や考察
- メモからも分かる通り、javac、java、クラスパスなどを必死に調べながら解いていることがわかります。（晒すのめっちゃ恥ずかしい）
- しかし自分はこれからJavaのアプリケーションを世間に出してしまおうとしている人間です。そんな人間がJavaをコンパイルして実行するのすらままならないとは...実はすごい世の中になっているのではと感じました。IDE、フレームワークの力、おそるべし。。。
    - 食材を切ったり下味をつけたりする方法を知らなくても、レンチンすれば暖かくて美味しいご飯が食べれる食の世界に起きていることが、システム開発においてもおきているのだなあと思った瞬間でした。
- しかし私はシステムエンジニアです。食の世界で言えば料理人です。料理人と名乗っておいて、実態はコンビニで買ってきた弁当をレンチンで出しているなんて言うのは考えさせられるものがあります。少なくとも自分ははそんな料理食べたくありません。
    - 料理の世界で、シェフに「この食材はとうやって調理しているの?」「この味を少し変えてほしいのだけれど」といって料理人が対応できるように、自分が作ったシステムを使ってくれた人に「これはどうやって動いているの？」、「ここの動作少し変えてほしいんだけど」といったことに自分は答えられるようになりたいなあと思いました。
- 最近では勉強会でも「難しいことはいいから動かしてみる ~ 」とか「初心者が1日でwebアプリケーションを~」というタイトルのものが増えてきている気がします。それだけコンピュータサイエンスに対する敷居は下がってきているということの現れだと思います。15年戦士のエンジニアの方に聞くと、そもそも昔はIDE自体がとても高額で、企業にいなければまともなシステム開発などできなかったようなのです。
    - しかしいくら無料で簡単にシステムが作れるようになっても、元となる技術が簡単になっているわけではありません。とても頭のいい方たちが難しい部分を隠蔽化して使いやすくしているだけなのです。しかしその人たちの好意に甘えてばかりいると、「性能に問題が~」といった場合に何もできない人になってしまいます。システムを届ける身として、もっと下地の部分の仕組みを理解して上質なシステムを届けていきたいなあと思いました。