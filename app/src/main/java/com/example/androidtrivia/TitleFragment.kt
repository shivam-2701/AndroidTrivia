package com.example.androidtrivia

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.androidtrivia.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {


        // Inflate the layout for this fragment
        val binding : FragmentTitleBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_title, container, false)

//The complete onClickListener with Navigation
    binding.playButton.setOnClickListener { v:View ->
         v.findNavController().navigate(
             TitleFragmentDirections.actionTitleFragment2ToGameFragment4()
         )
    }
       setHasOptionsMenu(true)
    return binding.root
   }



 @Deprecated("Deprecated in Java")
 override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
     super.onCreateOptionsMenu(menu, inflater)
     inflater.inflate(R.menu.overflow_menu, menu)
 }


 @Deprecated("Deprecated in Java")
 override fun onOptionsItemSelected(item: MenuItem): Boolean {
     return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
             || super.onOptionsItemSelected(item)


 }

}