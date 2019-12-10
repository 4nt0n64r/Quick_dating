import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.a4nt0n64r.quickdating.MainActivity
import com.a4nt0n64r.quickdating.R
import kotlinx.android.synthetic.main.a_1.*

class Loading : Fragment() {

    val timerSeconds = 5
    lateinit var timer: CountDownTimer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.loading_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = this.activity as MainActivity

        timer = object : CountDownTimer((timerSeconds * 1000).toLong(), 1000) {

            override fun onTick(l: Long) {
            }

            override fun onFinish() {
                activity.setFragment(MainActivity.FIND)
            }
        }.start()

        back_arrow.setOnClickListener {
            activity.supportFragmentManager.popBackStack()
            timer.cancel()
        }
    }

    override fun onDetach() {
        super.onDetach()
        if (timer != null) {
            timer.cancel()
        }
    }
}
