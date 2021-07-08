package com.mercedes_benz.model

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class FragmentFunctions {
    companion object {
        fun replaceFragment(fragment: Fragment, parentContainer: Int, activity: AppCompatActivity) {
            val transaction = activity.supportFragmentManager.beginTransaction()
            transaction.replace(parentContainer, fragment)
            transaction.commit()
        }
    }
}