package jp.techacademy.satoko.abiko.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import jp.techacademy.satoko.abiko.calcapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
// 四則演算ボタンのいずれか押下
        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
        binding.button4.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        // 入力値Ａ、入力値Ｂ、計算結果の初期化
//        var numA = 0.0
//        var numB = 0.0
        var sum  = 0.0
        //　入力値を数値に変換
        var numA = binding.editText1.text.toString().toDouble()
        var numB = binding.editText2.text.toString().toDouble()
        if (v.id == R.id.button1) {
            //   加算処理
            sum = numA + numB
        } else if (v.id == R.id.button2) {
            //   減算処理
            sum = numA - numB
        } else if (v.id == R.id.button3) {
            //   乗算処理
             sum = numA * numB
        } else if (v.id == R.id.button4) {
            //   除算処理
            try {
               sum = numA / numB
            }
            //   ０で割った場合、エラーとしない
             catch (e: Exception) {
                 sum = 0.0
             }
        }
        val intent = Intent(this, SecondActivity::class.java)
        //   回答をサブ画面へ引き渡す
        intent.putExtra("sum", sum )
        startActivity(intent)

    }
}
