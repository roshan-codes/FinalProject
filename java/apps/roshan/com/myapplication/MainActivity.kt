package apps.roshan.com.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.fb)
        val button2 = findViewById<Button>(R.id.instagram)
        val button3 = findViewById<Button>(R.id.twitter)



        button1.setOnClickListener{
            val intent = Intent(this, Web::class.java)
            intent.putExtra("Url", "https://www.facebook.com/")
            startActivity(intent)
        }
        button2.setOnClickListener{
            val intent = Intent(this, Web::class.java)
            intent.putExtra("Url", "https://www.instagram.com/")
            startActivity(intent)
        }
        button3.setOnClickListener{
            val intent = Intent(this, Web::class.java)
            intent.putExtra("Url", "https://www.twitter.com/")
            startActivity(intent)
        }


    }
}
