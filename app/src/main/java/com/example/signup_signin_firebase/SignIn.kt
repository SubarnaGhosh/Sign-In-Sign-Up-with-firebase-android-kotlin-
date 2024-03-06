package com.example.signup_signin_firebase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


lateinit var databaseref : DatabaseReference
class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signn_in)

        val number = findViewById<TextView>(R.id.tvSignIn)
        val password = findViewById<TextView>(R.id.tvPass)
        val buttonSignin = findViewById<Button>(R.id.btnSignin)

        buttonSignin.setOnClickListener {

            val uniq = number.text.toString()
            val pass = password.text.toString()

            if(uniq.isNotEmpty() && pass.isNotEmpty()){
                readData(uniq, pass)
            }
            else{
                Toast.makeText(this,"Please fill the above box properly",Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun readData(uniqId : String, password : String){
        databaseref = FirebaseDatabase.getInstance().getReference("Users")
        databaseref.child(uniqId).get().addOnSuccessListener {
        databaseref.child(password).get().addOnSuccessListener {
            val third = Intent(this, Thirdact::class.java)
            startActivity(third)
        }
        }.addOnFailureListener{
            Toast.makeText(this, "No user found",Toast.LENGTH_SHORT).show()
        }
    }
}