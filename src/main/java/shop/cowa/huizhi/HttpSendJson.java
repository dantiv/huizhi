package shop.cowa.huizhi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpSendJson {
    private static Logger logger = LoggerFactory.getLogger(HttpSendJson.class);
    /**
     * JSON文字列の送信
     *
     * @param strPostUrl 送信先URL
     * @param JSON       送信するJSON文字列
     * @return String
     */
    public static String callPostJson(String strPostUrl, String JSON) {

        HttpURLConnection con = null;
        StringBuffer result = new StringBuffer();
        try {

            URL url = new URL(strPostUrl);
            con = (HttpURLConnection) url.openConnection();
            // HTTPリクエストコード
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Accept-Language", "zh");
            // データがJSONであること、エンコードを指定する
            con.setRequestProperty("Content-Type", "application/JSON; charset=utf-8");
            // POSTデータの長さを設定
            con.setRequestProperty("Content-Length", String.valueOf(JSON.length()));
            // リクエストのbodyにJSON文字列を書き込む
            OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
            out.write(JSON);
            out.flush();
            con.connect();

            // HTTPレスポンスコード
            final int status = con.getResponseCode();
            if (status == HttpURLConnection.HTTP_OK) {
                // 通信に成功した
                // テキストを取得する
                final InputStream in = con.getInputStream();
                String encoding = con.getContentEncoding();
                if (null == encoding) {
                    encoding = "UTF-8";
                }
                final InputStreamReader inReader = new InputStreamReader(in, encoding);
                final BufferedReader bufReader = new BufferedReader(inReader);
                String line = null;
                // 1行ずつテキストを読み込む
                while ((line = bufReader.readLine()) != null) {
                    result.append(line);
                }
                logger.info("SUCCESS : CBT ORDER LIST <--- " + status);
                bufReader.close();
                inReader.close();
                in.close();
            } else {
                // 通信が失敗した場合のレスポンスコードを表示
                System.out.println(status);
                logger.info("ERROR : CBT ORDER LIST <--- " + status);
            }

        } catch (Exception e1) {
            e1.printStackTrace();
            logger.info("SUCCESS : CBT ORDER LIST <--- " + e1.getMessage());
        } finally {
            if (con != null) {
                // コネクションを切断
                con.disconnect();
            }
        }
        return result.toString();
    }

    public static String callPostForm(String strPostUrl, String strPost) {

        HttpURLConnection con = null;
        StringBuffer result = new StringBuffer();
        try {
            logger.info("CBT ORDER LIST : Start to post");
            URL url = new URL(strPostUrl);
            con = (HttpURLConnection) url.openConnection();
            // HTTP请求代码
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Accept-Language", "zh");
            // encode and type
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            // POST数据长度
            con.setRequestProperty("Content-Length", String.valueOf(strPost.length()));
            //  写入
            OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
            out.write(strPost);
            out.flush();
            con.connect();

            // HTTP响应
            final int status = con.getResponseCode();
            if (status == HttpURLConnection.HTTP_OK) {
                // 通讯成功
                // 获取文本
                final InputStream in = con.getInputStream();
                String encoding = con.getContentEncoding();
                if (null == encoding) {
                    encoding = "UTF-8";
                }
                final InputStreamReader inReader = new InputStreamReader(in, encoding);
                final BufferedReader bufReader = new BufferedReader(inReader);
                String line = null;
                // 逐行读取
                while ((line = bufReader.readLine()) != null) {
                    result.append(line);
                }

                bufReader.close();
                inReader.close();
                in.close();
                logger.info("SUCCESS : CBT ORDER LIST <--- " + status);
            } else {
                // 通讯失败
                logger.info("ERROR : CBT ORDER LIST <--- " + status);

            }

        } catch (Exception e1) {
            e1.printStackTrace();
            logger.info("ERROR : CBT ORDER LIST <--- " + e1.getMessage());
        } finally {
            if (con != null) {
                // 断开
                con.disconnect();
            }
        }
        return result.toString();
    }
}
