package net.nakama.layout.test.testlayout1;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private String[] bang;
	private String[] history;
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        bang = new String[] {"!g", "!gi", "!w", "!mdn"};
        history = new String[] {"hello", "android", "meteo", "bob"};
        
        ArrayAdapter<String> bangAdaptater = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, bang);
        ArrayAdapter<String> histAdaptater = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, history);
        
        ListView bangLstV = (ListView) findViewById(R.id.lst_bang);
        ListView histLstV = (ListView) findViewById(R.id.lst_history);
        
        bangLstV.setAdapter(bangAdaptater);
        histLstV.setAdapter(histAdaptater);
        
        bangLstV.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                EditText ed = (EditText) findViewById(R.id.edit_search);
                Editable editable = ed.getText();
                
                TextView t = (TextView) v;
                String selected = t.getText().toString();
                
                editable.append(selected + " ");
                
            }
        });
        
        histLstV.setOnItemClickListener(new OnItemClickListener() {
        	public void onItemClick(AdapterView parent, View v, int position, long id) {
        		EditText ed = (EditText) findViewById(R.id.edit_search);
        		
                
                TextView t = (TextView) v;
                String selected = t.getText().toString();
                
                ed.setText(selected);
        	}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
