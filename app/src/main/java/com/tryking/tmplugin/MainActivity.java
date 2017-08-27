package com.tryking.tmplugin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.tryking.tmplugin.utils.Constant;
import com.tryking.tmplugin.utils.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loadFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        init();
    }

    private void init() {
        loadFile = (Button) findViewById(R.id.load_file);
        loadFile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.load_file:
                if (!FileUtil.isExternalStorageAvailable()) {
                    Toast.makeText(this, "当前存储卡不可用", Toast.LENGTH_SHORT).show();
                } else {
                    List<String> strings = new ArrayList<>();
                    List<String> fileNames = FileUtil.getFileNames(strings);
                    for (int i = 0; i < fileNames.size(); i++) {
                        Toast.makeText(this, fileNames.get(i).toString(), Toast.LENGTH_SHORT).show();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            default:
                break;
        }
    }
}
