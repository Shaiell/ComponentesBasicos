package br.ici.treinamento.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText campoProduto;
    private TextView resultado;
    private CheckBox cbPreto;
    private CheckBox cbBranco;
    private CheckBox cbAzul;
    List<String>cores = new ArrayList<String>();
    private RadioGroup rgEstoque;
    private String rgresultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoProduto = (TextInputEditText) findViewById(R.id.editTextNomeProduto);
        resultado = (TextView) findViewById(R.id.textViewResultado);
        cbPreto = (CheckBox) findViewById(R.id.checkBoxPreto);
        cbBranco = (CheckBox) findViewById(R.id.checkBoxBranco);
        cbAzul = (CheckBox) findViewById(R.id.checkBoxAzul);
        rgEstoque = (RadioGroup)findViewById(R.id.rgEstoque);
        verificaRadioButton();
    }

    public void botaoEnviar(View view){

        verificaCheck();
        String nomeProduto = campoProduto.getText().toString();
        resultado.setText("Nome do produto: "+nomeProduto+"\nCores: "+cores.toString()+"\nEstoque: "+rgresultado);

    }

    public void verificaCheck(){
        cores.clear();

        if (cbPreto.isChecked()){
            cores.add(cbPreto.getText().toString());
        }
        if (cbBranco.isChecked()){
            cores.add(cbBranco.getText().toString());
        }
        if (cbAzul.isChecked()){
            cores.add(cbAzul.getText().toString());
        }
    }

    public void verificaRadioButton(){

        rgEstoque.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.radioButtonSim){
                    rgresultado = "Sim";
                }
                else if(i == R.id.radioButtonNao){
                    rgresultado = "Não";
                }
            }
        });
    }
}
