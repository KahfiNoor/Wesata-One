package com.example.wesataone.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wesataone.databinding.ActivitySignInBinding
import com.example.wesataone.model.customview.EmailEditText
import com.example.wesataone.model.customview.PasswordEditText
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var emailEditText: EmailEditText
    private lateinit var passwordEditText: PasswordEditText
//    private lateinit var mGoogleSignInCLient: GoogleSignInClient
//    private lateinit var gso: GoogleSignInOptions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        auth = Firebase.auth
        emailEditText = binding.emailEditText
        passwordEditText = binding.passEditText
        login()

        binding.signupTv.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun login() {
        binding.signInButton.setOnClickListener{
            val email = binding.emailEditText.text.toString()
            val pass = binding.passEditText.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {

                auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }
        }
    }


    override fun onStart() {
        super.onStart()

        if(auth.currentUser != null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

//    companion object {
//        private const val TAG = "LoginActivity"
//    }
}