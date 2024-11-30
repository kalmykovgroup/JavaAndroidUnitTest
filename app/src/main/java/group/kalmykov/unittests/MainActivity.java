package group.kalmykov.unittests;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ItemAdapter adapter;
    private RecyclerView recyclerView;
    private EditText searchEditText;

    private final String[] items = {
            "Apple", "Banana", "Orange", "Grape", "Watermelon",
            "Cherry", "Strawberry", "Mango", "Pineapple", "Lemon"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        // Инициализация элементов UI
        searchEditText = findViewById(R.id.searchEditText);
        recyclerView = findViewById(R.id.itemsRecyclerView);

        // Настройка RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ItemAdapter(Arrays.asList(items));
        recyclerView.setAdapter(adapter);

        // Обработчик изменения текста в строке поиска
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // Не требуется
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                adapter.filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Не требуется
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}