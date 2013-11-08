package pmm.spiner.actividad1spiner;

import android.R.anim;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Spinner1 extends Activity {
	private EditText et1, et2;
	private TextView tv;
	private Spinner esp;
	private String [] datos = new String[] {"Suma","Resta","Multiplicacion","Dividir"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spinner1);
		esp = (Spinner)findViewById(R.id.miSpinner);
		tv = (TextView)findViewById(R.id.miTView1);
		et1 = (EditText)findViewById(R.id.miEtext1);
		et2 = (EditText)findViewById(R.id.miEtext2);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);
//		Indicamos el tipo de Spinner dropdown
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		esp.setAdapter(adapter);
		esp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, android.view.View v,int position, long id) {
				//Hacemos lo que sea al seleccionar una opción
				String seleccion =  parent.getItemAtPosition(position).toString();
				int result = 0, num1, num2;
				num1 = Integer.valueOf((et1.getText().toString()));
				num2 = Integer.valueOf((et2.getText().toString()));
				switch(position){
				case 0:
					result = num1 + num2;
					break;
				case 1:
					result = num1 - num2;
					break;
				case 2:
					result = num1 * num2;
					break;
				case 3:
					result = num1 / num2;
					break;
				}
				tv.setText("ha seleccionado: "+String.valueOf(result));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				//Hacemos lo que sea cuando no hay datos o cuando no se selecciona nada.
				//En este tipo de componentes siempre se selecciona una opción por lo
				//que no se verá este evento. Por ejemplo vamos a limpiar la etiqueta
				//si no se seleccionada nada.
				tv.setText("Resultado");
				
			}
		} );

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.spinner1, menu);
		return true;
	}

}
