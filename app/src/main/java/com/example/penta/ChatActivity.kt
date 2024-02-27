package com.example.penta

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val webView: WebView = findViewById(R.id.webView)
        webView.loadUrl("<script>(function(a,m,o,c,r,m){a[m]={id:\"403490\",hash:\"2356f5139be5a7bf220e488215381131323b1d9c2487e7114f2015bf445c2175\",locale:\"ru\",inline:true,setMeta:function(p){this.params=(this.params||[]).concat([p])}};a[o]=a[o]||function(){(a[o].q=a[o].q||[]).push(arguments)};a[o+'Config']=a[o+'Config']||{};a[o+'Config'].hidden=!0;var d=a.document,s=d.createElement('script');s.async=true;s.id=m+'_script';s.src='https://gso.amocrm.ru/js/button.js';d.head&&d.head.appendChild(s)}(window,0,'amoSocialButton',0,0,'amo_social_button'));</script>")

        val intent = Intent(this, ChatActivity::class.java)
        startActivity(intent)
    }

}