package com.example.androidem.router

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

class AppRouter(
    private val fragmentContainer: Int,
    private val activity: FragmentActivity
) : Router {
    private val fragmentManager = activity.supportFragmentManager

    override fun navigateTo(fragment: Fragment, addToBackStack: Boolean, tag: String?) {
        val transaction = fragmentManager.beginTransaction()
            .replace(fragmentContainer, fragment, tag)

        if (addToBackStack) {
            transaction.addToBackStack(tag)
        }

        transaction.commit()
    }

    override fun goBack() {
        if (fragmentManager.backStackEntryCount > 1) {
            fragmentManager.popBackStack()
        } else {
            activity.finish()
        }
    }

    override fun backTo(tag: String) {
        fragmentManager.popBackStack(tag, 0)
    }

    override fun clearBackStack() {
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
}