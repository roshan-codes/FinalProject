package apps.roshan.com.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthSettings
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val tag = javaClass.canonicalName
    private lateinit var db: FirebaseFirestore
    private lateinit var firebaseAuthString: FirebaseAuthSettings
    private var from = "EMAIL"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()
        firebaseAuthString = auth.firebaseAuthSettings

        if (from == "EMAIL") {
            etPassword.visibility = View.VISIBLE
            etEmail.visibility = View.VISIBLE
        } else {
            etPassword.visibility = View.GONE
            etEmail.visibility = View.GONE
        }

        btnRegister.setOnClickListener {
            if (validation()) {
                registerWithEmail()
            }
        }
    }

    private fun validation(): Boolean {

        when (from) {
            "EMAIL" -> {
                return when {
                    etEmail.text.toString().isEmpty() -> {
                        toast("Enter Email")
                        false
                    }
                    etPassword.text.toString().isEmpty() -> {
                        toast("Enter Password")
                        false
                    }
                    etName.text.toString().isEmpty() -> {
                        toast("Enter Name")
                        false
                    }
                    etMobile.text.toString().isEmpty() -> {
                        toast("Enter Mobile number")
                        false
                    }
                    else -> {
                        true
                    }
                }
            }
            else -> {
                return true
            }
        }
    }

    private fun registerWithEmail() {
        auth.createUserWithEmailAndPassword(
            etEmail.text.toString(),
            etPassword.text.toString()
        )
            .addOnCompleteListener(this) { task ->
                Log.e(tag, "Email: ${etEmail.text}")
                if (task.isSuccessful) {
                    Log.e(tag, "Insert")
                    toast("Check mail for verify email")
                    finish()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.e(
                        tag,
                        "createUserWithEmail:failure " + task.exception?.message.orEmpty()
                    )
                    Toast.makeText(
                        baseContext, task.exception?.message.orEmpty(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}
