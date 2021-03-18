package com.tugcenurdaglar.ucakmodu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private UcakModuAlici ucakModuAlici;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ucakModuAlici = new UcakModuAlici(); //nesne oluşturuldu
    }

    @Override
    protected void onResume() { //uygulama açıldığında..
        super.onResume();

        //receiver ın neye göre çalışacağını filtrele
        IntentFilter intentFilter = new IntentFilter(); //filtre oluşturduk
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE"); //bu filtre AIRPLANE_MODE a göre bir çalışma yapacak,
        // yakalamak istenilen değişiklik, buraya yazılır

        registerReceiver(ucakModuAlici, intentFilter); //iki parametre istiyor receiverın kendisi ve filtrelemesi
    }

    @Override
    protected void onStop() { //uygulama arkaplana gittiğinde duran metod
        super.onStop();

        //kapandığı anda
        unregisterReceiver(ucakModuAlici);
    }
}