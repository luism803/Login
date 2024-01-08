package edu.paggiluis.login.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import edu.paggiluis.login.SharedApp
import edu.paggiluis.login.data.FacturAppDataSource
import edu.paggiluis.login.data.FacturAppRepository
import edu.paggiluis.login.databinding.ActivityLoginBinding
import edu.paggiluis.login.domain.model.LoginRequest
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        startActivity(Intent(this@LoginActivity, MainActivity::class.java))

        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvUsername.setText(SharedApp.preferences.username)

        val facturAppDataSource = FacturAppDataSource()
        val facturAppRepository = FacturAppRepository(facturAppDataSource)

        binding.btnLogin.setOnClickListener{
            lifecycleScope.launch {
                try {
                    val response = facturAppRepository.login(
                        LoginRequest(
                            binding.tvUsername.text.toString(),
                            binding.tvPassword.text.toString()
                        )
                    )
                    if(response.isSuccessful){
                        response.body()?.let {
                            SharedApp.preferences.username = binding.tvUsername.text.toString()
                            SharedApp.preferences.token = response.body()!!.token
                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        }
                    }else {
                        SharedApp.preferences.deleteToken()
                        Log.e("LoginActivity", "Request failed with status code: ${response.code()}")
                    }
                }catch (e: Exception){
                    Log.e("LoginActivity", e.message.toString())
                }
            }
        }
    }
}