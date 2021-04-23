package ua.devserhii.testaplication.activity.fragments

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
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

        val cats = arrayOf(
            380123456789,
            380123456788,
            380123456777,
            380123456666,
            380123455555,
            380123444444,
            380123333333,
            380122222222,
            380111111111
        )

        val adapter = ArrayAdapter(
            this.context!!, android.R.layout.simple_dropdown_item_1line, cats
        )
        et_number.setAdapter(adapter)
        et_number.threshold = 2

        et_number.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                et_number.showDropDown()
            }
        }

        b_start.setOnClickListener {
            val name = et_name.text.toString()
            val number =
                if (et_number.text.isNotEmpty()) et_number.text.toString().toLong() else null
            val email = et_email.text.toString()
            val newUser = User(
                dataBase.key!!,
                name,
                number,
                email
            )
            if (et_name.text.isNotEmpty())
                dataBase.push().setValue(newUser)

            (activity as ShowingInterface).showWebView()
        }
    }
}
