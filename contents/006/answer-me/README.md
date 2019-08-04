[目次](../toc.md)
[前の問題](../005/README.md)　[次の問題](../007/README.md)

***
## 006：環境変数

* Linuxにて、実行時のタイムゾーンを東京にするように明示するための方法を提示せよ。



# Answer

- [Oracle の公式ドキュメント](https://docs.oracle.com/javase/jp/9/troubleshoot/time-zone-settings-jre.htm)
  - 方法は2つありそうだ
    - JREがデフォルトタイムゾーンを設定するために読み取るOSのタイムゾーン設定を変更する
    - -Duser.timezoneシステム・プロパティ を設定する



### Linux のタイムゾーン設定を変更する

- 設定されているtimezone を確認

```
$ less  /etc/timezone 
$ timedatectl
```

- タイムゾーンを設定する

```
# timedatectl set-timezone Asia/Tokyo
```



## -Duser.timezoneシステム・プロパティ

- java コマンド実行時に以下のシステムプロパティの設定を加える

```
-Duser.timezone=Asia/Tokyo
```

