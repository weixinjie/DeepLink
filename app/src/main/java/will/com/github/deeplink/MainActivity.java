package will.com.github.deeplink;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    WebView web_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web_main = (WebView) findViewById(R.id.web_main);

        web_main.loadUrl("file:///android_asset/h5.html");

        web_main.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                if (url.startsWith("will://")) {
                    Uri uri = Uri.parse(url);
                    Log.e("---------scheme: ", uri.getScheme() + "host: " + uri.getHost() + "Id: " + uri.getPathSegments().get(0));
                    Toast.makeText(MainActivity.this, "打开新的页面", Toast.LENGTH_LONG).show();
                    return true; //返回true，代表要拦截这个url
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }
}
