## 003：javaコマンド

- ヒープサイズを1GBとるようにして #001 のプログラムを実行するjavaコマンドを実行せよ。



## Answer

- Answer001 のソースを取得する
- コンパイルと実行を確認

```
mkdir classes
javac -cp ./src -d ./classes src/Answer001.java
java -cp classes/ Answer001 
```



- java コマンド起動時にヒープサイズを指定するには...
- -Xms1024m を実行時に指定する
- 常に1GBであれば-Xmxも指定する

```
java -cp classes/ Answer001 -Xms1024m -Xmx1024m
Hello, World!
```

