package mobi.araz.kotlinstoringdatabasic

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import mobi.araz.kotlinstoringdatabasic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    var ageFromPreferences :Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = this.getSharedPreferences("mobi.araz.kotlinstoringdatabasic",
            Context.MODE_PRIVATE)

        ageFromPreferences = sharedPreferences.getInt("age",-1)

        if(ageFromPreferences==-1){
            binding.textView.text = "Age: "
        }else{
            binding.textView.text = "Age: ${ageFromPreferences}"
        }

    }
    fun save(view: View){
        val myAge = binding.editText.text.toString().toIntOrNull()

        if (myAge!=null){
            binding.textView.text = "Age: ${myAge}"
            sharedPreferences.edit().putInt("age",myAge).apply()
        }
    }

    fun delete(view: View){
        ageFromPreferences = sharedPreferences.getInt("age", -1)
        if(ageFromPreferences != -1){
            sharedPreferences.edit().remove("age").apply()
            binding.textView.text = "Age: "
        }
    }

    fun goActivity2(view: View){
        val intent  = Intent(applicationContext,MainActivity2::class.java)
        intent.putExtra("name1",binding.txtName1.text.toString())
        intent.putExtra("name2",binding.txtName2.text.toString())
        intent.putExtra("name3",binding.txtName3.text.toString())
        intent.putExtra("name4",binding.txtName4.text.toString())
        startActivity(intent)
    }


}