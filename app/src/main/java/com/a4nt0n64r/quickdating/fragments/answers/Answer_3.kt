import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.a4nt0n64r.quickdating.MainActivity
import com.a4nt0n64r.quickdating.R
import kotlinx.android.synthetic.main.a_1.back_arrow
import kotlinx.android.synthetic.main.a_3.*

class Answer_3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.a_3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        back_arrow.setOnClickListener {
            val activity = this.activity as MainActivity
            activity.supportFragmentManager.popBackStack()
        }

        white_iv.setOnClickListener {
            val activity = this.activity as MainActivity
            activity.setFragment(MainActivity.LOADING)
        }

    }
}
