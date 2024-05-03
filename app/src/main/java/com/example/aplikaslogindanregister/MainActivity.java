package com.example.aplikaslogindanregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {  // Class block start

    TextView etUsername, etName;
    SessionManager sessionManager;
    String username, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {  // onCreate method block start
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sessionManager = new SessionManager(MainActivity.this);
        if (!sessionManager.isLoggedIn()){  // If block start
            moveToLogin();
        }  // If block end

        etUsername = findViewById(R.id.etMainUsername);
        etName = findViewById(R.id.etMainName);

        username = sessionManager.getUserDetail().get(sessionManager.USERNAME);
        name = sessionManager.getUserDetail().get(sessionManager.NAME);

        etUsername.setText(username);
        etName.setText(name);

    }  // onCreate method block end

    private void moveToLogin() {  // moveToLogin method block start
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }  // moveToLogin method block end

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {  // onCreateOptionsMenu method block start
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }  // onCreateOptionsMenu method block end

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {  // onOptionsItemSelected method block start
        switch (item.getItemId()){  // Switch block start
            case R.id.actionLogout:
                sessionManager.logoutSession();
                moveToLogin();
                break;
        }  // Switch block end
        return super.onOptionsItemSelected(item);
    }  // onOptionsItemSelected method block end

}  // Class block end
