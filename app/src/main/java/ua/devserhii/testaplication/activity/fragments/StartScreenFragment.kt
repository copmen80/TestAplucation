package ua.devserhii.testaplication.activity.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.start_screen_fragment.*
import ua.devserhii.testaplication.Constants.USER_KEY
import ua.devserhii.testaplication.R
import ua.devserhii.testaplication.ShowingInterface
import ua.devserhii.testaplication.User


class StartScreenFragment : Fragment(R.layout.start_screen_fragment) {
    private lateinit var dataBase: DatabaseReference
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBase =
            FirebaseDatabase.getInstance().getReference(USER_KEY)

        b_start.setOnClickListener {
            val newUser = User(
                dataBase.key!!,
                et_name.text.toString(),
                et_number.text.toString().toInt(),
                et_email.text.toString()
            )
            if (et_name.text.isNotEmpty())
                dataBase.push().setValue(newUser)

            (activity as ShowingInterface).showWebView()
        }
    }
}
