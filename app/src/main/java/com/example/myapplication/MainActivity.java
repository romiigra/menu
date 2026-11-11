package com.example.myapplication;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_login) {
            showLoginDialog();
            return true;
        } else if (id == R.id.menu_register) {
            showRegisterDialog();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showLoginDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_login);
        dialog.setCancelable(true);

        EditText etUsername = dialog.findViewById(R.id.etLoginUsername);
        EditText etPassword = dialog.findViewById(R.id.etLoginPassword);
        Button btnSubmit = dialog.findViewById(R.id.btnLoginSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "נא למלא את כל השדות", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "התחברת בהצלחה: " + username, Toast.LENGTH_SHORT).show();
                    dialog.dismiss(); // סגירת הדיאלוג
                }
            }
        });

        dialog.show();
    }

    private void showRegisterDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_register);
        dialog.setCancelable(true);

        EditText etUsername = dialog.findViewById(R.id.etRegisterUsername);
        EditText etPassword = dialog.findViewById(R.id.etRegisterPassword);
        EditText etFirstName = dialog.findViewById(R.id.etRegisterFirstName);
        EditText etAge = dialog.findViewById(R.id.etRegisterAge);
        Button btnSubmit = dialog.findViewById(R.id.btnRegisterSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String firstName = etFirstName.getText().toString().trim();
                String age = etAge.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty() || firstName.isEmpty() || age.isEmpty()) {
                    Toast.makeText(MainActivity.this, "נא למלא את כל השדות", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "נרשמת בהצלחה: " + firstName, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });

        dialog.show();
    }
}