package com.example.androidtrivia

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.androidtrivia.databinding.ActivityGameWonFragmentBinding

class GameWonFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding: ActivityGameWonFragmentBinding= DataBindingUtil.inflate(
            inflater, R.layout.activity_game_won_fragment, container, false)

        binding.nextMatchButton.setOnClickListener { v: View ->
            v.findNavController().navigate(GameWonFragmentDirections.actionGameWonFragmentToGameFragment())

    }


        //Toast.makeText(context, "NumCorrect: ${args.numCorrect}, NumQuestions: ${args.numQuestions}", Toast.LENGTH_LONG).show()
        setHasOptionsMenu(true)
        return binding.root
    }

//    // Showing the Share Menu Item Dynamically
//    @SuppressLint("QueryPermissionsNeeded")
//    fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
//        if (inflater != null) {
//            if (menu != null) {
//                super.onCreateOptionsMenu(menu, inflater)
//
//        }
//        inflater?.inflate(R.menu.winner_menu, menu)
//        // check if the activity resolves
//        if (null == getShareIntent().resolveActivity(requireActivity().packageManager)) {
//            // hide the menu item if it doesn't resolve
//            menu?.findItem(R.id.share)?.setVisible(false)
//        }
//    }
    // Creating our Share Intent
//    var args = arguments?.let { GameWonFragmentArgs.fromBundle(it) }
////        val shareIntent = Intent(Intent.ACTION_SEND)
////    shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT,getString(R.string.share_success_text, args.numCorrect, args.numQuestions))
////    return shareIntent
//    if (args != null) {
//        return activity?.let {
//            ShareCompat.IntentBuilder.from(it)

    private fun getShareIntent(): Intent {
                    val args = GameWonFragmentArgs.fromBundle(requireArguments())
                    return ShareCompat.IntentBuilder.from(requireActivity())
                .setText(getString(R.string.share_success_text, args.numCorrect, args.numQuestions))
                .setType("text/plain")
                .intent
        }



    // Starting an Activity with our new Intent
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

  @Deprecated("Deprecated in Java")
  @SuppressLint("QueryPermissionsNeeded")
  override  fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
      super.onCreateOptionsMenu(menu,inflater)
      inflater.inflate(R.menu.winner_menu,menu)
      if (null == getShareIntent().resolveActivity(requireActivity().packageManager)) {
            // hide the menu item if it doesn't resolve
            menu.findItem(R.id.share)?.isVisible = false
        }
  }
    // Sharing from the Menu
    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
        R.id.share -> shareSuccess()
    }
    return super.onOptionsItemSelected(item)

}

}
