package com.example.android.gitapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class DevelopersActivity extends AppCompatActivity {

    public static String userName;
    public static String avatarUrl;
    public static String htmlUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);

        updateUi();
    }


    public void shareUrl(View view){
        TextView html=(TextView) findViewById(R.id.user_html);

        String message="Check out this awesome developer @ "+userName+" "+ html.getText();
        Intent intents=new Intent(Intent.ACTION_SEND);
        intents.setType("text/plain");
        intents.putExtra(Intent.EXTRA_TEXT,message);
        Intent chooseIntent=Intent.createChooser(intents,"Share");
        startActivity(chooseIntent);



    }

    public void updateUi(){
        userName=getIntent().getStringExtra("userId");
        avatarUrl=getIntent().getStringExtra("avatarId");
        htmlUrl=getIntent().getStringExtra("htmlId");
        CircleImageView imageView=(CircleImageView) findViewById(R.id.userAvatarId);
        Picasso.with(getBaseContext()).load(avatarUrl).placeholder(R.drawable.avatar).resize(80,80).into(imageView);
        TextView nameView =(TextView) findViewById(R.id.user_name);


        nameView.setText(userName);

        TextView htmlView=(TextView) findViewById(R.id.user_html);


        htmlView.setText(htmlUrl);


    }
}
