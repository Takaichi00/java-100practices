[目次](../toc.md)
[前の問題](../006/README.md)　[次の問題](../008/README.md)

***
## 007：クラスパス

* 自作のJavaプログラムをコンパイルしてできるclassファイルが`~/java/classes`ディレクトリにあり、そのプログラムを動作させるのに必要なライブラリ(jarファイル)が`~/java/lib`ディレクトリに複数存在する場合に、この自作のJavaプログラムを実行するためのコマンドラインを提示せよ。



## Answer

- 以下のようにディレクトリとファイルを作成

```
.
├── classes
│   └── Hello.class
├── lib
│   └── commons-lang3-3.9.jar
└── src
    └── Hello.java
```

- Hello.java は以下

```java

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Hello {
    public static void main(String args[]) {
        List<String> list = new ArrayList<>();
        if (isNull(list)) {
            throw new RuntimeException();
        }
        System.out.println("hello");
    }
}
```

- javac コマンドでコンパイル

```
javac -cp ./lib/*  -d ./classes src/Hello.java
```



- 実行

```
java -cp classes/:lib/*  Hello
```



### まとめ

- 実行するとき、-cp が複数あるときは":" でつなげる