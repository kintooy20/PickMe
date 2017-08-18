package kent.gimenez.com.pickmee;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static final int RESULT_GALLERY = 1;
    ImageView imageView;
    Button btnshare;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       imageView = (ImageView) findViewById(R.id.iv1);
        btnshare = (Button) findViewById(R.id.btnshare);
    }


    public void Pick(View view) {


        Intent i = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_GALLERY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_GALLERY && resultCode == RESULT_OK && data != null && data.getData() != null) {

            uri = data.getData();
            imageView.setImageURI(uri);
            btnshare.setVisibility(View.VISIBLE);

        }
    }

    public void Share(View view) {

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("image/*");
        i.setData(uri);
        i.putExtra(Intent.EXTRA_STREAM, uri);

        startActivity(Intent.createChooser(i, getString(R.string.app_name)));

    }
}
