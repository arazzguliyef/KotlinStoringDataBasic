package mobi.araz.kotlinstoringdatabasic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import mobi.araz.kotlinstoringdatabasic.databinding.ActivityMain2Binding
import mobi.araz.kotlinstoringdatabasic.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent
        val name1 = intent.getStringExtra("name1")
        val name2  = intent.getStringExtra("name2")
        val name3 =  intent.getStringExtra("name3")
        val name4 = intent.getStringExtra("name4")

        binding.txtName1.text = name1
        binding.txtName2.text = name2
        binding.txtName3.text = name3
        binding.txtName4.text = name4

    }

    fun Back(view : View){
        val intent  = Intent(applicationContext,MainActivity::class.java)
        startActivity(intent)
    }

    fun Next (view :View) {
        Toast.makeText(applicationContext,"Sorry, but you could not pass this screen", Toast.LENGTH_LONG).show()

        val alert = AlertDialog.Builder(this)
        alert.setTitle("Not Next")
        alert.setMessage("You Can not pass sorry")
        alert.setPositiveButton("Okay"){dialog, which->
            Toast.makeText(applicationContext,"Thank YOU!!!",Toast.LENGTH_LONG).show()
        }
        alert.setNegativeButton("Hmm"){dialog, which->
            Toast.makeText(applicationContext,"Thank YOU!!!",Toast.LENGTH_LONG).show()
        }
        alert.show()
    }

}