package com.example.volumeballok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edt_panjang:EditText
    private lateinit var edt_lebar:EditText
    private lateinit var edt_tinggi:EditText
    private lateinit var tbl_hitung:Button
    private lateinit var tv_Result:TextView

    companion object{
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edt_panjang = findViewById(R.id.edt_panjang)
        edt_lebar = findViewById(R.id.edt_lebar)
        edt_tinggi = findViewById(R.id.edt_tinggi)
        tbl_hitung = findViewById(R.id.tbl_hitung)
        tv_Result = findViewById(R.id.tv_result)
        tbl_hitung.setOnClickListener(this)

        if (savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            tv_Result.text = result
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT,tv_Result.text.toString())
    }
    override fun onClick(v: View?) {
        if (v?.id == R.id.tbl_hitung){
            val input_panjang = edt_panjang.text.toString().trim()
            val input_lebar = edt_lebar.text.toString().trim()
            val input_tinggi = edt_tinggi.text.toString().trim()
            var isEmtyField = false
            if (input_panjang.isEmpty()){
                isEmtyField =true
                edt_panjang.error = "field tidak boleh kosong "
            }
            if (input_lebar.isEmpty()){
                isEmtyField = true
                edt_lebar.error = "field tidak boleh kosong"
            }
            if (input_lebar.isEmpty()){
                isEmtyField = true
                edt_tinggi.error = "field tidak boleh kosong"
            }
            if (!isEmtyField){
                val volume = input_panjang.toDouble() * input_lebar.toDouble() * input_tinggi.toDouble()
                tv_Result.text = volume.toString()
            }

        }
    }
}