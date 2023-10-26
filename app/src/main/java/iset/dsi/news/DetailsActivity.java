package iset.dsi.news;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String title = getIntent().getStringExtra("title");
        int image = getIntent().getIntExtra("image",0);
        String date = getIntent().getStringExtra("date");
        String descrption = getIntent().getStringExtra("description");

        TextView titled = findViewById(R.id.title);
        TextView dated = findViewById(R.id.datenews);
        TextView descri = findViewById(R.id.detailsnews);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ImageView img = findViewById(R.id.detailsimage);
        ImageButton share = findViewById(R.id.share);

        if (img != null) {
            img.setImageResource(image);
        }


        titled.setText(title);
        dated.setText(date);
        descri.setText(descrption);
        img.setImageResource(image);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:"));

                i.putExtra(Intent.EXTRA_SUBJECT, " News Share");

                String newsDescription = getIntent().getStringExtra("description");
                if (newsDescription != null) {
                    // Add the news description to the email body
                    i.putExtra(Intent.EXTRA_TEXT, newsDescription);
                }



                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivity(i);
                } else {

                    Toast.makeText(getApplicationContext(), "No email app installed", Toast.LENGTH_SHORT).show();

                }}});


    }
}