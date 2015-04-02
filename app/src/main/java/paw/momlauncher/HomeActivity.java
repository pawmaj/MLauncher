package paw.momlauncher;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by paweł on 2015-03-24.
 */
public class HomeActivity extends Activity implements View.OnClickListener {
    private PackageManager manager;
    private List<AppDetail> apps;
    private ListView list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageView appsLogo = (ImageView) findViewById(R.id.appslogo);
        ImageView youtube = (ImageView) findViewById(R.id.ytlogo);
        ImageView vimeo=(ImageView)findViewById(R.id.vimeologo);
        ImageView internet=(ImageView)findViewById(R.id.internetlogo);
        appsLogo.setOnClickListener(this);
        youtube.setOnClickListener(this);
        vimeo.setOnClickListener(this);
        internet.setOnClickListener(this);

    }

    public void showApps(View v) {
        switch(v.getId()){
            case R.id.appslogo:
                Intent i = new Intent(this, AppsListActivity.class);
                startActivity(i);
                break;
            case R.id.ytlogo:
                String url ="https://www.youtube.com/user/niezaleznatelewizja";
                Intent intent=null;
                try {
                    intent =new Intent(Intent.ACTION_VIEW);
                    intent.setPackage("com.google.android.youtube");
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }
                break;
            case R.id.vimeologo:
                String url1 = "https://vimeo.com/ntv1/videos";
                Intent k = new Intent(Intent.ACTION_VIEW);
                k.setData(Uri.parse(url1));
                startActivity(k);
                break;
            case R.id.internetlogo:

                String url2 = "http://google.com";
                Intent l = new Intent(Intent.ACTION_VIEW);
                l.setData(Uri.parse(url2));
                startActivity(l);

                break;
        }

    }


    @Override
    public void onClick(View v) {
        showApps(v);
    }
}

