package will.com.github.deeplink;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class DeepLinkActivity extends AppCompatActivity {

    String scheme;
    String host;
    List<String> params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_link);

        getDataFromBrowser();
    }

    /**
     * 从deep link中获取数据
     */
    private void getDataFromBrowser() {
        Uri data = getIntent().getData();
        try {
            scheme = data.getScheme(); // "will"
            host = data.getHost(); // "share"
            params = data.getPathSegments();
            String testId = params.get(0); // "uuid"
            Toast.makeText(DeepLinkActivity.this, "the data from deeplink is " + testId, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
