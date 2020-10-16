package `in`.gsrathoreniks.databinding_basics

import `in`.gsrathoreniks.databinding_basics.databinding.ActivityMainBinding
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil

/**
 * Main Activity of the DataBinding-Basics app.
 * Read comments for better understanding the concept and working:
 *
 * This is basic DataBinding-Basics
 */

class MainActivity : AppCompatActivity() {

//  Create a binding object in the main activity
    private lateinit var binding: ActivityMainBinding

//  Assign the variable an instance of the Learning data class, passing in the name.
    private val devName: Learning = Learning("Hi!, I'm Gajendra Singh")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Binding view to the Binding object that we created above
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        setting up onClickListener for done button
        binding.doneButton.setOnClickListener {

//            function showTopic is called
            showTopic(it)

        }

        binding.learning = devName
    }
    /**
     * Click handler for the Done button.
     */
    private fun showTopic(view: View) {

        binding.apply {
            devName?.topic = learningEdit.text.toString()
            invalidateAll()
            learningEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            topicText.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}