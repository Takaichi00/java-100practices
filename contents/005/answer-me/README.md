[目次](../toc.md)
[前の問題](../004/README.md)　[次の問題](../006/README.md)

***
## 005：システムプロパティ

* Javaプログラムが利用するプロキシサーバとして、`proxy.example.com:80`を使用するように指定して #001 のプログラムを実行するjavaコマンドを実行せよ。ただし、`*.noproxy.example.com`へのアクセスはプロキシサーバを利用せず直接接続するようにすること。



# Answer

- Oracle のJavaSE のページに記載がある
  - [Java ネットワークとプロキシ](https://docs.oracle.com/javase/jp/7/technotes/guides/net/proxies.html)

```
2.1) HTTP
HTTP プロトコルハンドラが使用するプロキシを指定するため、次の 3 つのプロパティーを設定できます。

http.proxyHost: プロキシサーバーのホスト名
http.proxyPort: ポート番号 (デフォルト値は 80)。
http.nonProxyHosts: プロキシを省略して、直接到達するホストのリスト。これは、「|」で区切られたパターンのリストです。パターンは、ワイルドカードを表す「*」ではじまるか終わることがあります。これらのいずれかのパターンに一致するすべてのホストに対して、プロキシを経由せずに接続が直接実行されます。
```

```
$ java -cp classes/ Answer001 -Dhttp.proxyHost=proxy.example.com -Dhttp.nonProxyHosts=*.noproxy.example.com 
```

