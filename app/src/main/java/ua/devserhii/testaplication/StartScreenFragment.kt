package ua.devserhii.testaplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.start_screen_fragment.*

/**
 * Created by Vladislav Boiko on 19.04.2021.
 */
class StartScreenFragment : Fragment(R.layout.start_screen_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        b_start.setOnClickListener {
            (activity as ShowingInterface).showWebView()
        }
    }

}
