package poltavets.ua.com.summary.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.util.concurrent.TimeUnit


class SplashActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TimeUnit.SECONDS.sleep(1)
        jump()
    }

    private fun jump(){
        if(isFinishing) return
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
}