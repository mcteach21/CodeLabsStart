package mchou.apps.codelabs

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.view.forEach
import kotlinx.android.synthetic.main.activity_main.*
import mchou.apps.codelabs.tools.Util


class MainActivity :BaseActivity(R.layout.activity_main) , View.OnClickListener {
    private var actions  = mutableMapOf<Int,Class<*>>()
    init {
        /*
        actions[R.id.btn_start_1]=NotifyActivity::class.java
        actions[R.id.btn_start_2]=BroadcastActivity::class.java
        actions[R.id.btn_start_3]=ScannerActivity::class.java
        actions[R.id.btn_start_4]=BarcodeScannerActivity::class.java
        actions[R.id.btn_start_more]=SettingsActivity::class.java
        */
    }
    override fun onClick(view: View?) =
        if(actions[view!!.id]!=null) Util.start(applicationContext, actions[view.id]!!)
        else Toast.makeText(applicationContext,"No action yet!",Toast.LENGTH_SHORT).show()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar!!.hide()

        setListeners()
        anim()
    }

    private fun setListeners() {
        var view = window.decorView.findViewById<View>(android.R.id.content)
        val container = (view as ViewGroup).getChildAt(0)  as ViewGroup
        log("container? : ${container.javaClass.simpleName}")

        container.forEach {
           log("child? : ${it.javaClass.simpleName}")
           if(it.javaClass.simpleName=="AppCompatButton")
               (it as Button).setOnClickListener(this)
        }

      /*  btn_start_1.setOnClickListener(this)
        btn_start_2.setOnClickListener(this)*/
    }

    private fun anim() {
        Util.fadeIn(logo,true)
      /*  logo.alpha=0f
        var anim = AnimationUtils.loadAnimation(applicationContext,R.anim.fade_in)
        anim.fillAfter=true
        logo.startAnimation(anim)*/

        /*logo.alpha = 0.2f
        logo.animate().apply {
            interpolator = LinearInterpolator()
            duration = 1500
            alpha(1f)
            startDelay = 500
            start()
        }*/
    }

}
