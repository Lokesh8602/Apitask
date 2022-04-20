package com.example.assetlogin


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.assetlogin.api.RetrofitService
import com.example.assetlogin.repository.LoginRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: LoginViewModel
    private val retrofitService = RetrofitService.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLoginButton.setOnClickListener {
            validateForm()
            Observe()
        }
        viewModel = ViewModelProvider(this, LoginFactory(LoginRepository(retrofitService))).get(LoginViewModel::class.java)
    }
    private fun Observe(){

        viewModel.loginLiveData.observe(this, Observer {
            Toast.makeText(this@MainActivity , "Login Succeessful", Toast.LENGTH_LONG).show()
          /*  val intent = Intent(this@MainActivity,::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
*/
          /*  AppPreferences.AppAdminLoggedIn = true
            var userId = it.data?.data?.id
            AppPreferences.LoggedInUserId = userId
            AppPreferences.LoggedInGuestUserId = userId
            val preferences = PreferenceManager.getDefaultSharedPreferences(context as Context)
            val editor = preferences.edit()
            editor.putString("Name", it.data?.data?.roleName)
            editor.putString("EmailId", it.data?.data?.emailId)

            editor.commit()
            editor.apply()
            AppPreferences.AuthToken = it.data?.data?.token*/
        })
        viewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this@MainActivity, "UnSuccessful", Toast.LENGTH_LONG).show()
        })
    }

    private fun validateForm(){
        if(!userNameValidate() or !passWordValidate()){
            return
        }else{
            userLogin()
        }
    }
    private fun userLogin() {
        viewModel.getlogin(
            txtInputUserName.editText?.text.toString(),
            txtInputPassword.editText?.text.toString()
        )
    }
    private fun userNameValidate():Boolean{
        if(txtInputUserName.editText?.text.toString().isEmpty()){
            txtInputUserName.apply{

                error= "Filed Can't be blank"
                isExpandedHintEnabled = false
                requestFocus()
            }
            return false
        }
        else{
            txtInputUserName.apply{
                error = null
                isExpandedHintEnabled = true
            }
            txtInputUserName.requestFocus()
            return true
        }

    }
    private fun passWordValidate():Boolean{
        if(txtInputPassword.editText?.text.toString().isEmpty()){
            txtInputPassword.apply {
                error = "field can't be blank"
                isExpandedHintEnabled = false
                requestFocus()
            }
            return false
        }
        else{
            txtInputPassword.apply {
                error = null
                isExpandedHintEnabled = true
            }
            txtInputUserName.requestFocus()
            return true

        }
    }
}